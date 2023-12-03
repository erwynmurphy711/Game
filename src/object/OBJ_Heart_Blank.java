package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class OBJ_Heart_Blank extends SuperObject {

    GamePanel gp;

    public OBJ_Heart_Blank(GamePanel gp) {

        name = "Heart_Blank";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
            ;
        }
    }
}
