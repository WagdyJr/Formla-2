package drift.states;

import drift.Handler;
import drift.entities.creature.EnemyCar;
import drift.entities.creature.Nitro;
import drift.entities.creature.Player;
import drift.entities.creature.StoneRock;
import drift.worlds.World;


public class GameState extends State {
    private Handler handler;
    private World world;
    private Player player;
    private EnemyCar E1,E2,E3,E4,E5;
    private StoneRock stone1,stone2,stone3,stone4,stone5;
    private Nitro nitro,nitro2;

    public GameState(Handler handler) {
        this.handler = handler;
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);
      
        player = new Player(handler, 450, 280);
        player.setName("Player 1");
        E1 = new EnemyCar(handler, 450, 200,5f,1);
        E1.setName("Green");
        E2 = new EnemyCar(handler, 450, 350,4.9f,2);
        E2.setName("Blue");
        E3 = new EnemyCar(handler, 450, 430,5f,3);
        E3.setName("Yellow");
        E4 = new EnemyCar(handler, 450, 490,4.7f,4);
        E4.setName("Red");
        E5 = new EnemyCar(handler, 450, 120,4.5f,5);
        E5.setName("Orange");

        stone1=new StoneRock(handler,2000,250);
        stone2=new StoneRock(handler,4000,350);
        stone3=new StoneRock(handler,5000,200);
        stone4=new StoneRock(handler,5000,320);
        stone5=new StoneRock(handler,6000,300);
         
        nitro=new Nitro(handler,3200,150);
        nitro2=new Nitro(handler,6000,520);
    }

    @Override
    public void startState() {
        handler.getGame().getRender().addObject(world);
        handler.getGame().getRender().addObject(stone1);
        handler.getGame().getRender().addObject(nitro);
        handler.getGame().getRender().addObject(nitro2);
        handler.getGame().getRender().addObject(stone2);
        handler.getGame().getRender().addObject(stone3);
        handler.getGame().getRender().addObject(stone4);
        handler.getGame().getRender().addObject(stone5);
        handler.getGame().getRender().addObject(E1);
        handler.getGame().getRender().addObject(E2);
        handler.getGame().getRender().addObject(E3);
        handler.getGame().getRender().addObject(E4);
        handler.getGame().getRender().addObject(E5);
        handler.getGame().getRender().addObject(player);
        world.start();
        player.start();
        E1.start();
        E2.start();
        E3.start();
        E4.start();
        E5.start(); 
        stone1.start();
        stone2.start();
        stone3.start();
        stone4.start();
        stone5.start();
        nitro.start();
        nitro2.start();
    }
}
