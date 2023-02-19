/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drift.tiles;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
 public static Tile[] tiles = new Tile[256];
//    public static Tile grassTile = new GrassTile(0);    
    public static Tile dirtTile = new DirtTile(1);
    public static Tile rockTile = new RockTile(2);
    public static Tile road = new road(3);
    public static Tile road2 = new road2(7);
    public static Tile road3 = new road3(8);
    public static Tile road4 = new road4(9);
    public static Tile road5 = new road5(10);
    public static Tile road6 = new road6(11);
    public static Tile road7 = new road7(12);
    public static Tile road8 = new road8(13);
    public static Tile road9 = new road9(14);
    public static Tile bdaya = new bdaya(4);
    public static Tile bdaya2 = new bdaya2(5);
    public static Tile bdaya3 = new bdaya3(6);
//    public static Tile stone = new stone(20);

    public static final int TILE_WIDTH = 100, TILE_HEIGHT = 100;
    protected final int id;
    protected BufferedImage image;

    public Tile(BufferedImage image, int id) {
        this.image = image;
        this.id = id;
        tiles[id] = this;
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(image, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }


}
