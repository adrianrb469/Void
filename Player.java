import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean shooting = false; 
    SimpleTimer enemyTimer = new SimpleTimer();
    private int d = 0;
    private int hp  = 3;  
    public Player(){
     
        setImage("player_ship3x.png");
    }
    public void act()
    {
      
        
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY()+6);
        }
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-6);
        }
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+6,getY());
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-6,getY());
        }
    
        if(Greenfoot.isKeyDown("space") != true){
            shooting = false; 
        }
         if(Greenfoot.isKeyDown("space") && shooting == false){
            shooting = true; 
            if (((MyWorld)getWorld()).score > 750){
                Greenfoot.playSound("shooting_player.wav");
                Proyectile p1 = new Proyectile();
                getWorld().addObject(p1,getX()-20,getY()-70);
                Proyectile p2 = new Proyectile();
                getWorld().addObject(p2,getX()+20,getY()-70);
            }
            else{
            Greenfoot.playSound("shooting_player.wav");
            Proyectile p1 = new Proyectile();
            getWorld().addObject(p1,getX(),getY()-70);
            }
        }
        
        //se encarga de añadir nuevos enemigos si han pasado 10 segundos o el jugador mata a todos los enemigos
          if(enemyTimer.millisElapsed()>10000 || getWorld().getObjects(Enemy.class).isEmpty()){
            ((MyWorld)getWorld()).enemies(0);
            d +=1; 
            //d es el nivel de dificultad
            if(d>=2 && d<4){
                ((MyWorld)getWorld()).enemies(1);
            }
            else if(d>=4){
                
               ((MyWorld)getWorld()).enemies(2);            
            }
            enemyTimer.mark();
        
        }
        if(isAtEdge()== true || hp <= 0){
            Greenfoot.playSound("player_killed.wav");
            getWorld().removeObject(this);
            Greenfoot.stop();
           
        }
    }
    public void hurt(){
        Greenfoot.playSound("player_hit.wav");
        ((MyWorld)getWorld()).hp -= 1;
        hp = hp-1;
        
    }
}
