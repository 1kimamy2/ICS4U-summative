import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class Input here.
 * 
 * Amy Kim, Katie Xing
 * June, 2017
 */

public class Input extends Actor
{
    /**
     * Act - do whatever the Input wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if (Greenfoot.mouseClicked(this))
       {
           String inputValue = JOptionPane.showInputDialog("Please Enter Your Name");
       }
    }    
}
