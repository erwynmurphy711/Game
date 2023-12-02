package object;

import java.io.IOException;

import javax.imageio.ImageIO;

    public class OBJ_Potion_Red extends SuperObject {

    public OBJ_Potion_Red(){


        name = "Potion_Red";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/potion_red.png"));
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
