package drift.entities.creature;

import drift.Game;
import drift.Handler;
import drift.gfx.Assests;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javax.swing.JOptionPane;

public class Player extends Creature {
    private String Name;
    private int health;
    float m,n;
    int winner;
    
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 60;
        bounds.height = 60;
        speed = 5.2f;
        health = 3;
        winner = 1;
    }

    public void drawBoard(Graphics g)
    {
        g.setColor(Color.gray);
        g.fillRect(10, 10, 150, 80);
        g.setColor(Color.BLACK);
        String S=Integer.toString(health);
        g.setFont(new Font("arial",Font.BOLD,30));
        g.drawString("Health:"+S,20,40);
    }
    
    @Override
    public void tick() {
        getInput();
        move(1);
       handler.getGame().getGameCamera().centerOnEntity(this);
    }
    
    private void getInput () {
        xMove = 0;
        yMove = 0;

        if (handler.getGame().getKeyManager().up)
            yMove = -speed;
        else if (handler.getGame().getKeyManager().down)
            yMove = +speed;
        if (handler.getGame().getKeyManager().left)
           xMove = -speed;
        else if (handler.getGame().getKeyManager().right)
            xMove = +speed;
    }

    public void render(Graphics g) {
        drawBoard(g);
        if(speed == 6)
       {
            g.drawImage(Assests.RightN, (int)((x-43) - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 60, 50, null);
            g.drawImage(Assests.Pright, (int)(x - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 60, 50, null);         
       }
        else if(speed==0.1f)
       {
            if(x != m && x >= (m+40) && y!=n)
            {
                health--;
                if (health == 0)
                {
                    int choice = JOptionPane.showOptionDialog(null, "Game Over!\nRestart?", "Game Over!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (choice == JOptionPane.YES_OPTION) 
                    {
                        HP=0;
                        handler.getGame().end();
                        Platform.exit();
                        new Game("Drift", 1200, 700).start();
                    }

                    else if (choice == JOptionPane.NO_OPTION) {
                        HP=1;
                        System.exit(0);
                    }
                }
            }
            m=x;
            n=y;
            g.drawImage(Assests.khabta, (int)((x) - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 80, 80, null);
        }
        else if(this.speed==0)
            g.drawImage(Assests.Pright, (int)(x - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 60, 50, null);
        else
           g.drawImage(Assests.Pright, (int)(x - handler.getGame().getGameCamera().getxOffset()), (int)(y - handler.getGame().getGameCamera().getyOffset()), 60, 50, null);
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