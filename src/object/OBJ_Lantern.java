package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Lantern extends SuperObject {

    public OBJ_Lantern(){


        name = "Lantern";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/lantern.png"));
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
