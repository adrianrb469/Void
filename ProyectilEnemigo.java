import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class ProyectilEnemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProyectilEnemigo extends Actor
{
    /**
     * Act - do whatever the ProyectilEnemigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed; 
    
    public ProyectilEnemigo(){
      setImage("bullet_2x.png");
        speed = -3; 
    }
    public ProyectilEnemigo(int speed){
        setImage("bullet_2x.png");
        this.speed = speed; 
    }
    
    public void act()
    {
        setLocation(getX(),getY()+speed);
        
        Player p = (Player) getOneIntersectingObject(Player.class);
        if( p != null){
            //
            //getWorld().removeObject(p);
            p.hurt();
            getWorld().removeObject(this); 
        }
        
        else if( isAtEdge() ){
            getWorld().removeObject(this);
        }
        else if (getWorld().getObjects(Player.class).isEmpty()) {  
        
            Greenfoot.stop(); 
        }
       
    }
}
