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
import info.gridworld.actor.BMW;
import info.gridworld.actor.plymouth;

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
        String player1 = JOptionPane.showInputDialog("Enter Player 1 Keylayout", "wasd/arrows");
    	String player2 = JOptionPane.showInputDialog("Enter Player 2 Keylayout", "wasd/arrows");
        
        ActorWorld world = new ActorWorld();
        
        Color bleu = new Color(0x33B5E5);
        Color me = new Color(0xE56333);

        world.add(new BMW(bleu, world, player1));
        world.add(new plymouth(me, world, player2));

        world.show();
    }
}
