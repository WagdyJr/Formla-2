package drift.entities.creature;

import drift.Handler;
import drift.entities.Entity;
    public abstract class Creature extends Entity {
    public static final float DEFAULT_SPEED = 4;
    public static final int DEFAULT_WIDTH = 64;
    public static final int DEFAULT_HEIGHT = 64;
    protected float speed;
    protected float xMove;
    protected float yMove;
    public static String arr[]=new String[6];
    public static int count = 0;
    private int nitro =1;
    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        speed = DEFAULT_SPEED;
    }
    public void move(int n) {
        if(n == 1)
        {
          moveX();
          moveY();
        }    
        else{
            moveE();
            moveEy();
        }
    }

    private void moveX() {
      
    if (xMove > 0) {
  
        
        x += xMove;

        if(y >= 220 &&y <= 280){
            if(x >= 1950 && x < 2000){

                speed = 0.1f;
                if(x>=1960)
                {
                    speed=5.2f;
                }
            }
        }
        if(y >= 320 &&y <= 380){
            if(x >= 3950 && x < 4000){
                
                speed = 0.1f;
                if(x>=3960)
                {
                    speed=5.2f;
                }
            }
        }
        if(y >= 170 &&y <= 240){
            if(x >= 4950 && x < 5000){
                
                speed = 0.1f;
                if(x>=4960)
                {
                    speed=5.2f;
                }
            }
        }
        if(y >= 270 &&y <= 330){
            if(x >= 5950 && x < 6000){
                speed = 0.1f;   
                if(x>=5960)
                {
                    speed=5.2f;
                }
            }
        }
        if(y >= 290 &&y <= 350){
            if(x >= 4950 && x < 5000){
                
                speed = 0.1f;
                if(x>=4960)
                {
                    speed=5.2f;
                }
            }
        }
        if(y >= 120 && y <= 170){
            if(x >= 3200 && x < 3300){
                speed = 6;
            }
        }
        if(x>=4000&& nitro==1)
        {
            speed=5.2f;
        nitro++;
        }
        if(y >= 490 && y <= 570){
            if(x >= 6000 && x < 6100){
                speed = 6;
            }
        }
        if(x>=6800)
                speed=5.2f;
                   if(y<=100)
                {
                     this.y=120;
              
                }
                 if(y>=550)
                 {
                     this.y=540;
                 }
                 if(x>=7790)
                {
                     while(speed!=0)
                    {
                        System.out.println((count+1) +" "+ this.getName());
                        arr[count]=this.getName();
                        count++;
                        speed=0;       
                    }
                }
        }
    }

    private void moveY() {
        if (yMove < 0) {
            
                y += yMove;
             if(y<=100)
                {
                    
                     this.y=120;
              
                }
                 if(y>=550)
                 {
                     this.y=540;
                 }

        }
        else if (yMove > 0) {
                y += yMove;
             if(y<=100)
                {       
                     this.y=120;
                }
                 if(y>=550)
                 {
                     this.y=540;
                 }
        }
    }
   private void moveE()
   {   
                if(y<=100)
                {
                    this.y=120;
                }
                  if(y>=550)
                 {
                     this.y=540;
                 }
                if(x==(x+xMove))
                {
                    for(int i = 0 ; i<100;i++)
                    {
                        y += yMove;
                        x += xMove;
                    }
                   for(int i = 0 ; i<100;i++)
                    {
                        y -= yMove;
                        x += xMove;
                    }
                }
                else
                     x += xMove;
                   if(x>=7790)
                {
                    while(speed!=0)
                    {
                        System.out.println((count+1)+" "+ this.getName());
                        arr[count]=this.getName();
                        count++;
                        speed=0;
                    }   
                }            
   }
   
    private void moveEy()
    {
                for(int i=0 ; i < 5 ; i ++)
                y += yMove;
            
    }

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }
}