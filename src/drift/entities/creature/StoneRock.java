package drift.entities.creature;

import drift.Handler;
import drift.gfx.Assests;
import java.awt.*;

public class StoneRock extends Creature {
  
    public StoneRock(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_WIDTH / 2, Creature.DEFAULT_HEIGHT / 2);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 5;
       bounds.height = 10; 
    }

    @Override
    public void tick() {
    }
    public void run() {
      tick();}
    @Override
    public void render(Graphics g) {   
        g.drawImage(Assests.stone2,(int) (x - handler.getGame().getGameCamera().getxOffset()), (int) (y - handler.getGame().getGameCamera().getyOffset()), 50, 50, null);
    }
}