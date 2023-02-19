package drift.gfx;
import drift.Handler;
import drift.entities.Entity;
import drift.tiles.Tile;

public class GameCamera {
    private float xOffset,yOffset;
    private Handler handler;

    public GameCamera(Handler handler,float xOffset, float yOffset) {
        this.handler=handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    public void checkBlankSpace()
    {
        if(xOffset <0)
        {
         xOffset=0;   
        }
        else if(xOffset > handler.getWorld().getWidth()*Tile.TILE_WIDTH - handler.getGame().getWidth())
        {
            xOffset=handler.getWorld().getWidth()*Tile.TILE_WIDTH - handler.getGame().getWidth();
        }        
    }
    public void centerOnEntity(Entity e){
        xOffset=e.getX()-handler.getGame().getWidth()/2 + e.getWidth();
        checkBlankSpace();
    }
    
    public void move(float xAmt,float yAmt)
    {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }
    public float getxOffset() {
        return xOffset  ;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
    
}
