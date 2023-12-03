package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class OBJ_Potion_Red extends SuperObject {

    GamePanel gp;

    public OBJ_Potion_Red(GamePanel gp) {

        name = "Potion_Red";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/potion_red.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
            ;
        }
    }
}
