package Main;

import object.OBJ_Axe;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Chest_Opened;
import object.OBJ_Coin_Bronze;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Lantern;
import object.OBJ_Potion_Red;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        gp.obj[0] = new OBJ_Key(gp); // bottom key
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 38 * gp.tileSize;

        gp.obj[2] = new OBJ_Door(gp); // first door
        gp.obj[2].worldX = 16 * gp.tileSize;
        gp.obj[2].worldY = 29 * gp.tileSize;

        gp.obj[3] = new OBJ_Boots(gp); // boots in bush
        gp.obj[3].worldX = 31 * gp.tileSize;
        gp.obj[3].worldY = 31 * gp.tileSize;

        gp.obj[4] = new OBJ_Chest(gp); // at end
        gp.obj[4].worldX = 10 * gp.tileSize;
        gp.obj[4].worldY = 11 * gp.tileSize;

        gp.obj[5] = new OBJ_Chest_Opened(gp);

        gp.obj[6] = new OBJ_Lantern(gp);
        // gp.obj[6].worldX = 23 * gp.tileSize;
        // gp.obj[6].worldY = 20 * gp.tileSize;

        gp.obj[7] = new OBJ_Potion_Red(gp);
        // gp.obj[7].worldX = 25 * gp.tileSize;
        // gp.obj[7].worldY = 19 * gp.tileSize;

        gp.obj[8] = new OBJ_Key(gp); // at top right
        gp.obj[8].worldX = 38 * gp.tileSize;
        gp.obj[8].worldY = 9 * gp.tileSize;

        gp.obj[19] = new OBJ_Axe(gp);
        // gp.obj[19].worldX = 13 * gp.tileSize;
        // gp.obj[19].worldY = 34 * gp.tileSize;

        gp.obj[9] = new OBJ_Door(gp); // second door
        gp.obj[9].worldX = 13 * gp.tileSize;
        gp.obj[9].worldY = 34 * gp.tileSize;
        

        gp.obj[10] = new OBJ_Door(gp); // last door
        gp.obj[10].worldX = 10 * gp.tileSize;
        gp.obj[10].worldY = 13 * gp.tileSize;
        

        gp.obj[11] = new OBJ_Key(gp); // bottom right
        gp.obj[11].worldX = 37 * gp.tileSize;
        gp.obj[11].worldY = 37 * gp.tileSize;

        gp.obj[12] = new OBJ_Coin_Bronze(gp);
        // gp.obj[12].worldX = 18 * gp.tileSize;
        // gp.obj[12].worldY = 23 * gp.tileSize;



       


    }
    
}
