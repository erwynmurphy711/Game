package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class OBJ_Lantern extends SuperObject {

    GamePanel gp;

    public OBJ_Lantern(GamePanel gp){


        name = "Lantern";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/lantern.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
