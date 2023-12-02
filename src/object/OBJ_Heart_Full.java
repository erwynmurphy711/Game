package object;

import java.io.IOException;

import javax.imageio.ImageIO;

    public class OBJ_Heart_Full extends SuperObject {

    public OBJ_Heart_Full(){


        name = "Heart_Full";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
