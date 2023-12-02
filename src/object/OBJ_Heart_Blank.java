package object;

import java.io.IOException;

import javax.imageio.ImageIO;

    public class OBJ_Heart_Blank extends SuperObject {

    public OBJ_Heart_Blank(){


        name = "Heart_Blank";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
