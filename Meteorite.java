import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteorite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meteorite extends Actor
{
    /**
     * Act - do whatever the Meteorite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int degrees; 
    private Player player; 
    Meteorite(Player player){
       // this.degrees=degrees;  
        setImage("octopus3x.png");
        this.player = player; 
         turnTowards(player.getX(), player.getY());
       //turn(degrees);
    }
   Meteorite(int degrees, Player player){
       setImage("octopus3x.png");
        this.degrees=degrees;  
        this.player = player; 
        turnTowards(player.getX(), player.getY());
        turn(degrees);
    }
    public void act()
    {
      
        Player p = (Player) getOneIntersectingObject(Player.class);
        move(4);
       
        
        if(this.isAtEdge()){
            getWorld().removeObject(this);
        }else if(p != null){
            Greenfoot.playSound("player_killed.wav");
            getWorld().removeObject(p);
            getWorld().removeObject(this);
        
        }
    }
}
