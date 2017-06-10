import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Startscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startscreen extends World
{
    /**
     * Constructor for objects of class Startscreen.
     * 
     */
    public Startscreen()
    {    
        super(900, 675, 1); 
        prepare();
        
        
    }

    private void prepare()
    {
        Startletters startletters = new Startletters();
        Input input = new Input();
        addObject(startletters,465,333);
        addObject(input,650,260);
    }
    
    public void act()
    {    
        if (Greenfoot.isKeyDown("enter"))
        Greenfoot.setWorld (new MyWorld());    
    }
}
