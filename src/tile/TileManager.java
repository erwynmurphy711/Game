package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.UtilityTool;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum [] [];

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[50]; //INITIALIZING NUMBER OF TILES
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/worldmap.01.txt"); //Which map its calling
    }

    public void getTileImage() {

            // SCALING IMAGE BEFORE DRAWING (Performance OPTIMIZATION) // TILES
            setup(0, "grass00", false);
            setup(1, "grass00", false);
            setup(2, "grass00", false);
            setup(3, "grass00", false);
            setup(4, "grass00", false);
            setup(5, "grass00", false);
            setup(6, "grass00", false);
            setup(7, "grass00", false);
            setup(8, "grass00", false);
            setup(9, "grass00", false);
            // PLACEHOLDERS


            // ACTUAL USED
            setup(10, "earth", false);
            setup(11, "floor01", false);
            setup(12, "grass00", false);
            setup(13, "grass01", false);
            setup(14, "hut", false);
            setup(15, "road00", false);
            setup(16, "road01", false);
            setup(17, "road02", false);
            setup(18, "road03", false);
            setup(19, "road04", false);
            setup(20, "road05", false);
            setup(21, "road06", false);
            setup(22, "road07", false);
            setup(23, "road08", false);
            setup(24, "road09", false);
            setup(25, "road10", false);
            setup(26, "road11", false);
            setup(27, "road12", false);
            setup(28, "table01", false);
            setup(29, "tree", true);
            setup(30, "wall", true);
            setup(31, "water00", true);
            setup(32, "water01", true);
            setup(33, "water02", true);
            setup(34, "water03", true);
            setup(35, "water04", true);
            setup(36, "water05", true);
            setup(37, "water06", true);
            setup(38, "water07", true);
            setup(39, "water08", true);
            setup(40, "water09", true);
            setup(41, "water10", true);
            setup(42, "water11", true);
            setup(43, "water12", true);
            setup(44, "water13", true);

            // PLACEHOLDER
            setup(45, "grass00", false);
            setup(46, "grass00", false);
            setup(47, "grass00", false);
            setup(48, "grass00", false);
            setup(49, "grass00", false);

        
            
    }

    public void setup(int index, String imageName, boolean collision){

        UtilityTool uTool = new UtilityTool();

        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+imageName+".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){

        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();

                while(col < gp.maxWorldCol){

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;

                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch(Exception e){

        }
    }
    public void draw(Graphics2D g2){
        

        int worldCol= 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX 
            && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                 
            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null); 
            
            }
            worldCol++;

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;

            }
        }
    }

}
