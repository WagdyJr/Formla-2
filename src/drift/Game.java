package drift;

import drift.display.Display;
import drift.gfx.Assests;
import drift.gfx.GameCamera;
import drift.inputs.KeyManager;
import drift.rendering.Render;
import drift.states.GameState;

public class Game extends Thread{
    private Display display;
    private String title;
    private int width, height;
    private boolean running;
    private Handler handler;
    private Render render;
    private GameState gameState;
    private KeyManager keyManager;
    private GameCamera gameCamera;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init() {
        handler = new Handler(this);
        display = new Display(title, width, height);
        Assests.init();
        render = new Render(handler);
        gameCamera =new GameCamera(handler,0,0);
        gameState = new GameState(handler);
        keyManager = new KeyManager(handler);
        display.getFrame().addKeyListener(keyManager);
        drift.states.State.setCurrentState(gameState);
    }

    @Override
    public void run() {
        init();
        render.start();
        keyManager.start();
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        super.start();
    }

    public synchronized void end() {
        if (!running)
            return;
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public Display getDisplay() {
        return display;
    }

    public Render getRender() {
        return render;
    }
 
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
    public GameCamera getGameCamera() {
        return gameCamera;
    }
}