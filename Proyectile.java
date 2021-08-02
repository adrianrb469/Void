import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Proyectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Proyectile extends Actor
{
    /**
     * Act - do whatever the Proyectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed; 
    private int hp = 3;
    
    public Proyectile(){
        setImage("bullet2_2x.png");
        speed = -3; 
        
    }
    public Proyectile(int speed){
          setImage("bullet2_2x.png");
        this.speed = speed; 
    }
    
    public void act()
    {
        setLocation(getX(),getY()+speed);
        
        Enemy e = (Enemy) getOneIntersectingObject(Enemy.class);
        Meteorite m = (Meteorite) getOneIntersectingObject(Meteorite.class);
        if( e != null ){
           
            
            e.hurt();
            
            //getWorld().removeObject(e);
            getWorld().removeObject(this);
                
            
            
            
        }
        
        
        else if(isAtEdge() ){
            getWorld().removeObject(this);
        }
        else if( m != null){
            getWorld().removeObject(m);
        }
       
    }
}
