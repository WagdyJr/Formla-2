package drift.entities;
import drift.Handler;
import drift.entities.creature.Player;
import drift.rendering.Rendering;

import java.awt.*;

    public abstract class Entity extends Thread implements Rendering {
    public static final int DEFAULT_HEALTH = 10;
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected int health;
    protected boolean active;
    protected Rectangle bounds;
    
    public int gare ;
    public int HP;

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void tick();

    public Rectangle getCollisionBounds() {
        return new Rectangle((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

        public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
