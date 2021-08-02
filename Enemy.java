import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.TimerTask;
import java.util.Timer;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    long startTime = System.nanoTime();
    long estimatedTime; 
    SimpleTimer shotTimer = new SimpleTimer();
    private int firerate = 3500; 
    private int hp = 3;
    public Enemy(){
       setImage("alien_3x.png");
         
    }
    public Enemy(int firerate){
       setImage("alien_3x.png");
        this.firerate = firerate; 
    }
    public void act()
    {
        
        estimatedTime = System.nanoTime()-startTime;
        
        int segundos = (int) TimeUnit.SECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS);
       
        if((segundos%3)==0 ){
            setLocation(getX(),getY()+1);
        
            
        }
        
        
        if(shotTimer.millisElapsed()>firerate){
            shoot();
            shotTimer.mark();
            
        }
          
      
         
        if( getY() >  700 || hp<=0){
            Greenfoot.playSound("enemy_killed.wav");
            ((MyWorld)getWorld()).score += 50;
            getWorld().removeObject(this);
        }
    }
    public void hurt(){
        hp = hp-1;
    } 
    public void shoot(){
        ProyectilEnemigo p1 = new ProyectilEnemigo(2);
        getWorld().addObject(p1, getX(), getY());
        
    }
}
