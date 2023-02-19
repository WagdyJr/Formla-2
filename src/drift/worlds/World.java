package drift.worlds;

import drift.Handler;
import drift.rendering.Rendering;
import drift.tiles.Tile;
import drift.utils.Utils;

import java.awt.Graphics;

public class World extends Thread implements Rendering {
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    public World(Handler handler, String path) {
        this.handler = handler;
        loadWorld(path);
    }

    public void tick() {
    }
    

    @Override
    public void render(Graphics g) {
       
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                getTile(i, j).render(g,(int) (i * Tile.TILE_WIDTH - handler.getGame().getGameCamera().getxOffset()),(int) (j * Tile.TILE_HEIGHT - handler.getGame().getGameCamera().getyOffset()));        
    }

    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[ tiles[x][y] ];
        if (t == null)
            return Tile.dirtTile;
        return t;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        tiles = new int[width][height];

        int i = 0, j = 0;
        for (int index = 4; index < tokens.length; index++) {
            tiles[i++][j] = Utils.parseInt(tokens[index]);
            if (i == width) {
                i = 0;
                j++;
            }
        }
    }

    @Override
    public void run() {
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }
}
