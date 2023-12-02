package object;

import java.io.IOException;

import javax.imageio.ImageIO;

    public class OBJ_Heart_Half extends SuperObject {

    public OBJ_Heart_Half(){


        name = "Heart_Half";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
