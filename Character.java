import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class character here.
 * 
 * @KatieXing & AmyKim
 * @Version1 may4 
 */
public class Character extends Actor
{
    private int jumpheight = 13;
    private int walksp = 5;
    private double fallsp = 0.4;
    
    private boolean inTheAir = false;
    private double deX = 0;
    private double deY = 0;
    private int groundHeight = getImage().getHeight()/2;
    private int sideWidth = getImage().getWidth()/2;
    private World myWorld;
    int worldHeight;
    int worldWidth;
    int counter = 0;
    
    public void addedToWorld(World myWorld)
    {
        this.myWorld = myWorld;
        this.worldHeight = myWorld.getHeight();
        this.worldWidth = myWorld.getWidth();
    }
    
    /**
     * Act - do whatever the character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(inTheAir)
        {
            fall();
        } else {
            getCommand();
        }
        move();
        hititem();
        
    }    
    
    private void run (String direction)
    {
        if(direction=="left")
            deX = walksp*-1;
        else
            deX = walksp;
    }

    private void stop ()
    {
        deX = 0;
    }
    
    private void jump()
    {
        deY += jumpheight;
        inTheAir = true;
    }

    /*
     * fall() will be called whenever character is in the air. Decreases the deltaY by 1, creating
     * gravity.
     */
    private void fall()
    {
        deY -= fallsp;
    }

    private void move()
    {
        double newX = getX() + deX;
        double newY = getY() - deY;

        Actor platformBelow = getOneObjectAtOffset(0, groundHeight + 5, Platform.class);
        Actor platformAbove = getOneObjectAtOffset(0, -(groundHeight + 5), Platform.class);
        Actor platformToRight = getOneObjectAtOffset(sideWidth+5, 0, Platform.class);
        Actor platformToLeft = getOneObjectAtOffset(-(sideWidth+5), 0, Platform.class);
        
        if(platformBelow!=null)
        {
            if(deY<0)
            {
                deY = 0;
                inTheAir = false;
                GreenfootImage platformImage = platformBelow.getImage();
                int topOfPlatform = platformBelow.getY() - platformImage.getHeight()/2;
                newY = topOfPlatform - groundHeight;
            }
        }else if(getY() >= worldHeight - groundHeight) {
            if(deY < 0)
            {
                deY = 0;
                inTheAir = false;
                newY = worldHeight - groundHeight;
            }
        } else {
            inTheAir = true;
        }
        if(platformAbove != null)
        {
            if(deY>0)
            {
                deY=0;
                
                GreenfootImage platformImage = platformAbove.getImage();
                int bottomOfPlatform = platformAbove.getY() + platformImage.getHeight()/2;
                newY = bottomOfPlatform + groundHeight;
            }
        }
        if(getX()<=sideWidth)
        {
            deX = Math.abs(deX);
        }
        if(getX()>=worldWidth-sideWidth)
        {
            deX = Math.abs(deX) * -1;
        }
        if(platformToRight!=null)
        {
            deX = Math.abs(deX) * -1;
        }
        if(platformToLeft!=null)
        {
            deX = Math.abs(deX);
        }
        setLocation((int)newX,(int)newY);
        
    }
    
     public void hititem()
    {
        Actor Food = getOneIntersectingObject(Food.class);
        Actor Foood = getOneIntersectingObject(Foood.class);
        World myWorld = getWorld();

        if (Food != null)
         {
             myWorld.removeObject(Food);
         }
        if (Foood != null)
         {
             myWorld.removeObject(Foood);
         }
         
        Gameoverletters gameoverletters = new Gameoverletters();
        
   } 
    
   private void getCommand()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            run("left");
        } else if (Greenfoot.isKeyDown("right"))
        {
            run("right");
        } else 
        {
            stop();
        }

        if(Greenfoot.isKeyDown("up"))
        {
            jump();
        }
        
    }
}
