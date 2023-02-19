package drift.inputs;

import drift.Handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager extends Thread implements KeyListener {
    public boolean up, down, left, right;
    private boolean[] keys;
    private final int KEYS_NUMBER = 256;
    private Handler handler;

    public KeyManager(Handler handler) {
        this.handler = handler;
        keys = new boolean[KEYS_NUMBER];
    }

    public void tick() {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        right = keys[KeyEvent.VK_D];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        System.out.println("Released!");
    }

    @Override
    public void run() {
        int fps = 60;
        double timePerTick = 1000 / fps;
        while (handler.getGame().isRunning()) {
            tick();
            try {
                sleep((long)timePerTick);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
