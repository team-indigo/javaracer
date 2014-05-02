/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

package info.gridworld.actor;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

import javax.swing.JOptionPane;

/**
 * A <code>Car</code> is an actor that can move and turn. It drops walls as
 * it moves. <br />
 * The implementation of this class is testable on most non-toaster PCs and some toasters.
 */
public class cycle extends Actor
{
	
	private String name;
	private boolean stealth = true;

    public cycle(String n, Color color, ActorWorld grid, String keylayout)
    {
    	name = n;
    	
        setDirection(Location.EAST);
        setColor(color);

        ActorWorld world = grid;

        if(keylayout.equals("arrows")) {
            world.setArrows(this);
        } else if(keylayout.equals("wasd")) {
            world.setWASD(this);
        }
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
    	move(1);
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
    public void move(int x)
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection(), x);
        
        if(gr.isValid(next)) {
        	
        	Actor nextA = gr.get(next);
        	
        	if (nextA instanceof Flower) {
        		removeSelfFromGrid();
        		Rock rock = new Rock();
         	    rock.putSelfInGrid(gr, loc);
        		JOptionPane.showMessageDialog(null, name + " has lost!");
        		System.exit(0);
        	} if (nextA instanceof cycle) {
        		removeSelfFromGrid();
            	Rock rock = new Rock();
         	    rock.putSelfInGrid(gr, next);
         	    JOptionPane.showMessageDialog(null, "Tie! GG!");
            	System.exit(0);
        	} else {
                moveTo(next);
            }
        }
        
        if(!gr.isValid(next)) {
        	removeSelfFromGrid();
    		Rock rock = new Rock();
     	    rock.putSelfInGrid(gr, loc);
        	JOptionPane.showMessageDialog(null, name + " has lost!");
        	System.exit(0);
        }
        
        if (stealth == false)
        {
        	Flower flower = new Flower(getColor());
        	flower.putSelfInGrid(gr, loc);
        }
    }
    
    public void setStealth()
    {
    	if (stealth == false)
    	{
    		stealth = true;
    	}
    	else {stealth = false;}
    }
    
    public boolean getStealth()
    {
    	return stealth;
    }
    
    public void jump() {move(2);}
}

