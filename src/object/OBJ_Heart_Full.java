package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class OBJ_Heart_Full extends SuperObject {

    GamePanel gp;

    public OBJ_Heart_Full(GamePanel gp) {

        name = "Heart_Full";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
            ;
        }
    }
}
