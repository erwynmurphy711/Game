package Main;

import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Chest_Opened;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        gp.obj[0] = new OBJ_Key(); // NEW OBJECT
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 35 * gp.tileSize;

        gp.obj[2] = new OBJ_Door(); // NEW OBJECT
        gp.obj[2].worldX = 22 * gp.tileSize;
        gp.obj[2].worldY = 28 * gp.tileSize;

        gp.obj[3] = new OBJ_Boots();
        gp.obj[3].worldX = 22 * gp.tileSize;
        gp.obj[3].worldY = 25 * gp.tileSize;

        gp.obj[4] = new OBJ_Chest();
        gp.obj[4].worldX = 22 * gp.tileSize;
        gp.obj[4].worldY = 20 * gp.tileSize;

        gp.obj[5] = new OBJ_Chest_Opened();
       


    }
    
}
