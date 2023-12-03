package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

    public class OBJ_BlueHeart extends SuperObject {

    GamePanel gp;

    public OBJ_BlueHeart(GamePanel gp){


        name = "BlueHeart";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/blueheart.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
