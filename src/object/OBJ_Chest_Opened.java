package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Chest_Opened extends SuperObject{

     public OBJ_Chest_Opened(){


        name = "Chest_Opened";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest_opened.png"));
        }catch (IOException e){
            e.printStackTrace();;
        }
        collision = true;
    }
}
