package drift.rendering;

import drift.Handler;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Render extends Thread {
    private ArrayList<Rendering> objects;
    private Handler handler;
    private Graphics g;
    private BufferStrategy bs;

    public Render (Handler handler) {
        this.handler = handler;
        objects = new ArrayList<Rendering>();
    }

    public void addObject(Rendering object) {
        if (!objects.contains(object))
            objects.add(object);
    }

    public void removeObject(Rendering object) {
        objects.remove(object);
    }

    public void render() {
        bs = handler.getGame().getDisplay().getCanvas().getBufferStrategy();
        if (bs == null) {
            handler.getGame().getDisplay().getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        for (int i = 0; i < objects.size(); i++)
            if (objects.get(i) != null)
                objects.get(i).render(g);

        bs.show();
        g.dispose();
    }

    public ArrayList<Rendering> getObjects() {
        return objects;
    }

    @Override
    public void run() {
        int fps = 60;
        double timePerTick = 1000 / fps;
        while (handler.getGame().isRunning()) {

            render();
            try {
                sleep((long) timePerTick);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}