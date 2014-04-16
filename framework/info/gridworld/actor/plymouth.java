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

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import javax.swing.JOptionPane;

import java.util.Scanner;
import java.awt.Color;

/**
 * A <code>Bug</code> is an actor that can move and turn. It drops flowers as
 * it moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class plymouth extends Actor
{
    /**
     * Constructs a car.
     */
    public plymouth(Color color, ActorWorld grid, String keylayout)
    {
        setDirection(Location.EAST);
        setColor(color);

        ActorWorld world = grid;

        if(keylayout.equals("arrows")) {
            world.setArrows(this);
        } else if(keylayout.equals("wasd")) {
            world.setWASD(this);
        }
    }


	public void act()
	{
		if (canMove() == 1) {
			move();
		} else if(canMove() == 2) {
			removeSelfFromGrid();
			JOptionPane.showMessageDialog(null, this.getClass().getName() + " has lost!");
			System.exit(0);
		}
	}

    /**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
    
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Actor neighbor = gr.get(next);
        if (neighbor instanceof Flower)
            removeSelfFromGrid();
        
        if (gr.isValid(next))
            moveTo(next);
        else  removeSelfFromGrid();
        
	    Flower flower = new Flower(getColor());
	    flower.putSelfInGrid(gr, loc);
    }
    
    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * @return true if this bug can move.
     */
    public int canMove()
    {
	    Grid<Actor> gr = getGrid();
	    if (gr == null)
		    return 0;
	    Location loc = getLocation();
	    Location next = loc.getAdjacentLocation(getDirection());
	    if (!gr.isValid(next))
		    return 2;
	    Actor neighbor = gr.get(next);
	    if(neighbor instanceof Flower) {
		    return 2;
	    }
	    return 1;
	    // ok to move into empty location or onto flower
	    // not ok to move onto any other actor
    }
}
    