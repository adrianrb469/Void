import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    SimpleTimer enemyTimer = new SimpleTimer();
    Player player = new Player();
    public int score = 0;
    public int hp = 3;
    GifImage bg = new GifImage("gif_test.gif");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public void act(){
        showText("Score: " + score, 70,25);
        //showText("HP: " + hp, 1040,680);
        setBackground(bg.getCurrentImage());
        
      
    }
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 720, 1); 
        
        prepare();
    
        
    }


    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void enemies(int n){
       
        Enemy enemy1 = new Enemy();
        addObject(enemy1, 540,100);
        Enemy enemy2 = new Enemy();
        addObject(enemy2, 400,60);
        Enemy enemy3 = new Enemy();
        addObject(enemy3, 680,60);
        if (n==1){
            Enemy enemy4 = new Enemy(2500);
            addObject(enemy4, 300,60);
            Enemy enemy5 = new Enemy(2500);
            addObject(enemy5, 800,60);
            
        }
        else if(n==2){
            Enemy enemy4 = new Enemy(2500);
            addObject(enemy4, 300,60);
            Enemy enemy5 = new Enemy(2500);
            addObject(enemy5, 800,60);
            Enemy enemy6 = new Enemy(2500);
            addObject(enemy6, 300,130);
            Enemy enemy7 = new Enemy(2500);
            addObject(enemy7, 800,130);
        }
        Meteorite m1 = new Meteorite(120, player);
        addObject(m1, 1000, 100);
        Meteorite m2 = new Meteorite( player);
        addObject(m2, 0, 0); 
        
    
    
    }
    private void prepare()
    {
        label lab = new label();
        addObject(lab, 940,650);
        addObject(player, 540,360);
        Enemy enemy1 = new Enemy();
        addObject(enemy1, 540,100);
        Enemy enemy2 = new Enemy();
        addObject(enemy2, 400,60);
        Enemy enemy3 = new Enemy();
        addObject(enemy3, 680,60);
        Meteorite m1 = new Meteorite(120, player);
        addObject(m1, 1000, 100);
        Meteorite m2 = new Meteorite( player);
        addObject(m2, 0, 0);
       
    }
    public void lost(){
        setBackground("ant.png");
        
    
    }
}
