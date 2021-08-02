import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class label extends Actor
{
    /**
     * Act - do whatever the label wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public label(){
    setImage("health3.png");
    
    }
    public void act()
    {
        if(((MyWorld)getWorld()).hp == 2){
            setImage("health2.png");
        }
        if(((MyWorld)getWorld()).hp == 1){
            setImage("health1.png");
        }
        if(((MyWorld)getWorld()).hp == 0){
            setImage("health0.png");
        }
    }
}
