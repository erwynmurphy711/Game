package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class OBJ_Coin_Bronze extends SuperObject {

    GamePanel gp;

    public OBJ_Coin_Bronze(GamePanel gp) {

        name = "Coin_Bronze";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/coin_bronze.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
            ;
        }
    }
}
