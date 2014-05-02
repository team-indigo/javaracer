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

import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.cycle;

import javax.swing.JOptionPane;

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class CarRacing
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();

	    String p1n = JOptionPane.showInputDialog(null, "Enter Player 1 Name: ");
	    if (p1n == null || p1n.equals("")) {p1n = "Blue";}
	    //String p1k = JOptionPane.showInputDialog(null, "Enter Player 1 Key Config (wasd/arrows)");
	    //if (p1k == null || p1k.equals("")) {p1k = "wasd";}
	    String p2n = JOptionPane.showInputDialog(null, "Enter Player 2 Name: ");
	    
	    
	    
	    if (p2n == null || p2n.equals("")) {p2n = "Orange";}
	    //String p2k = JOptionPane.showInputDialog(null, "Enter Player 2 Key Config (wasd/arrows):");
	    //if (p2k == null || p2k.equals("")) {p2k = "arrows";}
	    
	    
        world.add(new cycle(p1n, new Color(0x33b5e5), world, "wasd"));
        world.add(new cycle(p2n, new Color(0xe56333), world, "arrows"));

        world.show();
    }
}