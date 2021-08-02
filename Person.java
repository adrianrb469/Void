import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person extends Actor
{
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
       
        // Add your action code here.
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY()+5);
        }
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-5);
        }
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+5,getY());
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-5,getY());
        }
       
        if(isAtEdge()== true){
            Greenfoot.stop();
        }
    }
}
