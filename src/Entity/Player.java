package Entity;
//import java.io.IOException;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public Player(GamePanel gp, KeyHandler keyH)
    {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        setDefaultValues ();
        getPlayerImage();

    }
    public void setDefaultValues()
    {
        worldX = gp.tileSize*23;
        worldY = gp.tileSize*21;
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }
    public void getPlayerImage() {
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream ( "New Piskel-1.png (1).png" ));
            up2 = ImageIO.read(getClass().getResourceAsStream ( "New Piskel-1.png (2).png" ));
            down1 = ImageIO.read(getClass().getResourceAsStream ( "New Piskel-1.png (3).png" ));
            down2 = ImageIO.read(getClass().getResourceAsStream ( "New Piskel-1.png (4).png" ));
            right1 = ImageIO.read(getClass().getResourceAsStream ( "New Piskel-1.png (5).png" ));
            right2 = ImageIO.read(getClass().getResourceAsStream ( "New Piskel-1.png (6).png" ));
            left1 = ImageIO.read(getClass().getResourceAsStream ( "New Piskel-1.png (7).png" ));
            left2 = ImageIO.read(getClass().getResourceAsStream ( "New Piskel-1.png (8).png" ));
            //up1 = ImageIO.read(getClass().getResourceAsStream ( "New Piskel-1.png (1).png" ));

        } catch (IOException e) {
            throw new RuntimeException ( e );
        }


    }

    public void update()
    {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed|| keyH.rightPressed)
        { if(keyH.upPressed)
        {
            direction = "up";
            worldY -= speed;}
        else if(keyH.downPressed)
        {
            direction = "down";
            worldY += speed;}
        else if(keyH.rightPressed)
        {
            direction = "right";
            worldX += speed;}
        else if(keyH.leftPressed)
        {
            direction = "left";
            worldX -= speed;}
        spriteCounter++;
        if(spriteCounter > 5)
        {
            if(spriteNum == 1)
                spriteNum = 2;
           else if(spriteNum == 2)
                spriteNum = 1;
           spriteCounter = 0;

        }}
    }

    public void draw(Graphics2D g2)
    {
//      g2.setColor ( Color.white);
//      g2.fillRect(x, y,gp.tileSize,gp.tileSize );
        //g2.drawImage(image, 5, 10, 100, 100, null );
        BufferedImage image  = null;
        switch(direction)
        {
            case "up":
               if(spriteNum == 1) image = up1;
                if(spriteNum == 2) image = up2;
                break;
            case "down":
                if(spriteNum == 1) image = down1;
                if(spriteNum == 2) image = down2;
                break;
            case "left":
                if(spriteNum == 1) image = left1;
                if(spriteNum == 2) image = left2;

                break;
            case "right":
                if(spriteNum == 1) image = right1;
                if(spriteNum == 2) image = right2;
                break;

        }

        g2.drawImage(image,screenX, screenY,100, 100, null );






    }



}
