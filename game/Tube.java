package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Tube spawn and draw class
 */
class Tube {
    private int pillarNum=6;
    private int[] xPos=new int[pillarNum];
    private int[] yPos=new int[pillarNum];
    private int gapDistance=120;
    private int offset=200;
    private BufferedImage pillar1=null;
    private BufferedImage pillar2=null;

    private int randY()
    {
        Random r = new Random();
        return r.nextInt(220)-280;
    }

    public Tube()
    {
        try {
            pillar1 = ImageIO.read(new File("assets/tube1.png"));
            pillar2 = ImageIO.read(new File("assets/tube2.png"));
        } catch (IOException UP) {
            System.out.println("Throws up!");
        }
        for(int i=0;i<pillarNum;i++)
        {
            xPos[i]=1024+i*offset;
            yPos[i]=randY();
        }
    }

    public void render(Graphics2D g) {
        for(int i=0;i<pillarNum;i++)
        {
            g.drawImage(pillar1, xPos[i], yPos[i], null);
            g.drawImage(pillar2, xPos[i], yPos[i] + pillar1.getHeight() + gapDistance, null);
        }
    }

    public void update() {

        for(int i=0;i<pillarNum;i++){
            xPos[i]-=7;
            if(xPos[i]<=-172)
            {
                xPos[i]=1024;
                yPos[i]=randY();
            }
        }

    }
}
