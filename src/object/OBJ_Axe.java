package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class OBJ_Axe extends SuperObject {

    GamePanel gp;
    
    public OBJ_Axe(GamePanel gp){


        name = "Axe";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/axe.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
