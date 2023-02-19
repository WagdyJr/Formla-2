package drift.entities.creature;

import drift.Handler;
import drift.gfx.Assests;
import java.util.Random;
import java.awt.*;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnemyCar extends Creature {
    Random rand = new Random();
    private int carColor;
    private String name;
    static int j=150;
    int r=0,ye=0,b=0,o=0;
    int G=0;
    int r2,ye2,b2,o2,G2;
    float tempSpeed;
    int Counter;
    String m,r1,ye1,b1,o1,G1 ="Player 1";
    public EnemyCar(Handler handler, float x, float y,float s,int m) {
        super(handler, x, y, 60, 60);
        this.speed = s ; 
        this.tempSpeed = s;
        this.carColor = m;
    }
    
    public void drawBoard3(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font("arial",Font.BOLD,30));
        if(Creature.arr[5]!=null)
        {
            g.drawString("1-"+Creature.arr[0],20,150);
            g.drawString("2-"+Creature.arr[1],20,200);
            g.drawString("3-"+Creature.arr[2],20,250);
            g.drawString("4-"+Creature.arr[3],20,300);
            g.drawString("5-"+Creature.arr[4],20,350);
            g.drawString("6-"+Creature.arr[5],20,400);
        }
    }
    
    public void drawBoard2(Graphics g)
    {
        m =this.getName();
  
        g.setColor(Color.BLACK);
        
        g.setFont(new Font("arial",Font.BOLD,30));
       
        if("Red".equals(m)&&r!=1)
        {
            r1 =this.getName();
            r=1;
            j=j+50;
            r2=j;
        }
       if("Green".equals(m)&&G!=1)
        {
            G1 =this.getName();
            G=1;
            j=j+50;
            G2=j;
        }
        if("Yellow".equals(m)&&ye!=1)
        {
            ye1 =this.getName();
            ye=1;
            j=j+50;
            ye2=j;
        }
        if("Blue".equals(m)&&b!=1)
        {
            b1 =this.getName();
            b=1;
             j=j+50;
            b2=j;
        }
        if("Orange".equals(m)&&o!=1)
        {
            o1 =this.getName();
            o=1;
            j=j+50;
            o2=j;        
        }
        g.drawString(""+o1,20,o2);
        g.drawString(""+b1,20,b2);
        g.drawString(""+r1,20,r2);
        g.drawString(""+G1,20,G2);
        g.drawString(""+ye1,20,ye2);
    }

    @Override
    public void tick() {
        getInput();
        move(0);
    }

    private void getInput () {
        xMove = 0;
        yMove = 0;

       xMove = +speed;
       if(y >= 220 &&y <= 280){
            if(x >= 1950 && x < 2000){
                speed = 0.1f;
                if(x>=1960)
                {
                    speed = tempSpeed;
                }
            }
        }
       
        if(y >= 320 &&y <= 380){
            if(x >= 3950 && x < 4000){
                speed = 0.1f;
                if(x>=3960)
                {
                    speed = tempSpeed;
                }
            }
        }
        
        if(y >= 170 &&y <= 240){
            if(x >= 4950 && x < 5000){
                speed = 0.1f;
                if(x>=4960)
                {
                    speed=tempSpeed;
                }
            }
        }
        
        if(y >= 270 &&y <= 330){
            if(x >= 5950 && x < 6000){
                speed = 0.1f;
                if(x>=5960)
                {
                    speed=tempSpeed;
                }
            }
        }
        
        if(y >= 290 &&y <= 350){
            if(x >= 4950 && x < 5000){
                speed = 0.1f;
                if(x>=4960)
                {
                    speed=tempSpeed;
                }
            }
        }
       //Y MOVE 
       int r = rand.nextInt(200);
       if(r==0)
        yMove = -speed;
       else if(r==2)
           yMove = +speed;
    }
    
    @Override
    public void render(Graphics g) {
       if (carColor==1)
           if(speed != 0.1f)
                g.drawImage(Assests.E1, (int)(x - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 60, 50, null);
            else
               g.drawImage(Assests.khabta, (int)((x) - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 80, 80, null);
       if (carColor==2)
           if(speed != 0.1f)
                g.drawImage(Assests.E2, (int)(x - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 60, 50, null);
            else
               g.drawImage(Assests.khabta, (int)((x) - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 80, 80, null);
       if (carColor==3)
           if(speed != 0.1f)
                g.drawImage(Assests.E3, (int)(x - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 60, 50, null);
            else
               g.drawImage(Assests.khabta, (int)((x) - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 80, 80, null);
       if (carColor==4)
           if(speed != 0.1f)
                g.drawImage(Assests.E4, (int)(x - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()),60, 50, null);
            else
               g.drawImage(Assests.khabta, (int)((x) - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 80, 80, null);
       if (carColor==5)
            if(speed != 0.1f)
                g.drawImage(Assests.E5, (int)(x - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 60, 50, null);
            else
               g.drawImage(Assests.khabta, (int)((x) - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 80, 80, null);
        
       drawBoard3(g);
    }
    

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        int fps = 60;
        double timePerTick = 1000 / fps;
        while (handler.getGame().isRunning()) {
            tick();
            try {
                sleep((long) timePerTick);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getBoundsWidth() {
        return bounds.width;
    }

    public int getBoundsHeight() {
        return bounds.height;
    }

    public int getBoundsX() {
        return bounds.x;
    }

    public int getBoundsY() {
        return bounds.y;
    } 
}