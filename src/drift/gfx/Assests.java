package drift.gfx;
import java.awt.image.BufferedImage;

public class Assests {
    public static BufferedImage  khabta, E1,E2,E3,E4,E5,dirt,grass,rock,tree, Pup,RightN, Pdown, Pleft, Pright,bdaya,bdaya2,bdaya3,road,road2,road3,road4,road5,road6,road7,road8,road9,stone,stone2,nitro;
    public static BufferedImage[] tankRotate, fire, fireSpeed;
    private static final int WIDTH = 128, HEIGHT = 128;
    
    public static void init() {
        SpriteSheet right = new SpriteSheet(ImageLoader.loadImage("/textures/right.png"));        
        SpriteSheet Right = new SpriteSheet(ImageLoader.loadImage("/textures/gded.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/s_p.png"));
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet1.png"));
        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet_objects.png"));
        SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/stone.png"));
        SpriteSheet sheet5 = new SpriteSheet(ImageLoader.loadImage("/textures/E1.png"));
        SpriteSheet sheet6 = new SpriteSheet(ImageLoader.loadImage("/textures/E2.png"));
        SpriteSheet sheet7 = new SpriteSheet(ImageLoader.loadImage("/textures/E6.png"));
        SpriteSheet sheet8 = new SpriteSheet(ImageLoader.loadImage("/textures/E4.png"));
        SpriteSheet sheet9 = new SpriteSheet(ImageLoader.loadImage("/textures/E5.png"));
        SpriteSheet sheet10 = new SpriteSheet(ImageLoader.loadImage("/textures/5abta2.png"));
        SpriteSheet sheet11 = new SpriteSheet(ImageLoader.loadImage("/textures/nitro.png"));

        RightN= Right.crop(0, 0, 148, 46);
        Pright = right.crop(0, 0, 60, 30);
        bdaya=sheet2.crop(0, 910, 128, 128);
        bdaya2=sheet2.crop(0, 780, 128, 128);
        bdaya3=sheet2.crop(0, 650, 128, 128);
        road=sheet2.crop(0, 0, 128, 128);
        road2=sheet2.crop(520,1560, 128, 128);
        road3=sheet2.crop(390,1170, 128, 128);
        road4=sheet2.crop(520,1430, 128, 128);
        road5=sheet2.crop(0,0, 152, 128);
        road6=sheet2.crop(520,1690, 128, 128);
        road7=sheet2.crop(520,1690, 128, 150);
        road8=sheet2.crop(7,370,80,130);
        road9=sheet2.crop(430,1430,80,150);
        dirt = sheet.crop(32, 0, 32, 32);  
        rock = sheet.crop(96, 0, 32, 32);
        stone2=sheet3.crop(646, 934, 89, 72);
        stone=sheet4.crop(0, 0, 90, 65);
        E1=sheet5.crop(0,0,512,254);
        E2=sheet6.crop(0,0,800,397);
        E3=sheet7.crop(0,0,2400,1190);
        E4=sheet8.crop(0,0,800,397);
        E5=sheet9.crop(0,0,2400,1190);
        khabta=sheet10.crop(0, 180,90, 95);
        nitro=sheet11.crop(0, 0,512,512);
    }
}