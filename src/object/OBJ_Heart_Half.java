package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class OBJ_Heart_Half extends SuperObject {

    GamePanel gp;

    public OBJ_Heart_Half(GamePanel gp){


        name = "Heart_Half";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
