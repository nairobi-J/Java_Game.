package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tiles[] tile;
    int mapTileNum[][];


    public TileManager ( GamePanel gp ) {
        this.gp = gp;
        tile = new Tiles[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage ();
        loadMap("world01.txt");
    }

    public void getTileImage ( ) {
        try {
            tile[0] = new Tiles ();
            tile[0].image = ImageIO.read ( getClass ().getResourceAsStream ( "grass01.png" ) );
            tile[1] = new Tiles ();
            tile[1].image = ImageIO.read ( getClass ().getResourceAsStream ( "wall.png" ) );
            tile[2] = new Tiles ();
            tile[2].image = ImageIO.read ( getClass ().getResourceAsStream ( "water01.png" ) );
            tile[3] = new Tiles ();
            tile[3].image = ImageIO.read ( getClass ().getResourceAsStream ( "earth.png" ) );
            tile[4] = new Tiles ();
            tile[4].image = ImageIO.read ( getClass ().getResourceAsStream ( "tree.png" ) );
            tile[5] = new Tiles ();
            tile[5].image = ImageIO.read ( getClass ().getResourceAsStream ( "sand.png" ) );

        } catch (IOException e) {
            throw new RuntimeException ( e );
        }
    }
    public void loadMap(String filePath)
    {
        try
        {
            InputStream is = getClass().getResourceAsStream ( filePath );
            BufferedReader br = new BufferedReader(new InputStreamReader(is) );
            int col = 0;
            int row = 0;
            while(col < gp.maxScreenCol && row < gp.maxScreenRow)
            {
                String line = br.readLine();
                while(col < gp.maxScreenCol)
                {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;

                }
                if(col == gp.maxScreenCol)
                {
                    col = 0;
                    row++;

                }
            }
            br.close();
        } catch (Exception e) {
            throw new RuntimeException ( e );
        }
    }

    public void draw ( Graphics g2 ) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            int tileNum = mapTileNum[col][row];
            g2.drawImage (tile[tileNum].image , x, y, gp.tileSize, gp.tileSize, null );
            col++;
            x += gp.tileSize;
            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }

        }


    }
}
