package Main;

import object.OBJ_Axe;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Chest_Opened;
import object.OBJ_Coin_Bronze;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Lantern;

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

        gp.obj[6] = new OBJ_Lantern();
        gp.obj[6].worldX = 19 * gp.tileSize;
        gp.obj[6].worldY = 19 * gp.tileSize;

        gp.obj[7] = new OBJ_Coin_Bronze();
        gp.obj[7].worldX = 16 * gp.tileSize;
        gp.obj[7].worldY = 20 * gp.tileSize;

        gp.obj[8] = new OBJ_Axe();
        gp.obj[8].worldX = 13 * gp.tileSize;
        gp.obj[8].worldY = 20 * gp.tileSize;

        gp.obj[9] = new OBJ_Axe();
        gp.obj[9].worldX = 10 * gp.tileSize;
        gp.obj[9].worldY = 20 * gp.tileSize;




       


    }
    
}
