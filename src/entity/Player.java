package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle(8, 30, 32, 25); // BOUNDRY BOX FOR PLAYER
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 22; // X INITIAL PLAYER POSITION
        worldY = gp.tileSize * 33; // Y INITIAL PLAYER POSITION
        speed = 4; // SPEED OF PLAYER
        direction = "down";
    }

    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        int animation = 12;

        if (keyH.upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed == true) {


            if (keyH.upPressed == true) {
                direction = "up";
            } else if (keyH.downPressed == true) {
                direction = "down";
            } else if (keyH.leftPressed == true) {
                direction = "left";
            } else if (keyH.rightPressed == true) {
                direction = "right";
            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (collisionOn == false) {

                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > animation) { // HOW MUCH THE WALKING ANIMATION UPDATES
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void pickUpObject(int i) {
        if (i != 999) {

            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "Key": // WHICH THING ITS INTERACTING WITH
                    gp.playSE(1); // PLAYING SOUND
                    hasKey++; // HAS A KEY
                    gp.obj[i] =  null; // GETS RID OF OBJECT
                    gp.ui.showMessage("You got a key!"); // TEXT FROM SHOW MESSAGE METHOD IN UI
                    break;

                case "Door": // WHICH THING ITS INTERACTING WITH
                    if (hasKey > 0) {
                        gp.playSE(3); // PLAYING SOUND with index from soundURL in sound class
                        gp.obj[i] = null; // IF HAVE KEY, GET RID OF DOOR
                        hasKey--;  // GET RID OF KEY
                        gp.ui.showMessage("You opened the door!"); // TEXT FROM SHOW MESSAGE METHOD IN UI
                    
                    }
                    if (hasKey == 0){
                        gp.ui.showMessage("You need a key!"); // TEXT FROM SHOW MESSAGE METHOD IN UI
                    }
                    break;
                case "Boots":
                    gp.playSE(2); // PLAYING SOUND
                    speed += 2; // INCREASING SPEED
                    gp.obj[i] = null;
                    gp.ui.showMessage("Speed up!"); // TEXT FROM SHOW MESSAGE METHOD IN UI
                    break;
                case "Chest":
                    gp.playSE(3);
                    gp.obj[i] = null;
                    gp.obj[5].worldX = 22 * gp.tileSize;
                    gp.obj[5].worldY = 20 * gp.tileSize;
                    gp.ui.gameFinished = true;
                    gp.stopMusic();;
                    gp.playSE(4);
                    break;
                case "Axe":
                    if (gp.ui.damage == 1){
                        gp.obj[i] = null;
                        gp.ui.damage++;
                        gp.ui.gameFinished = true;
                        gp.stopMusic();
                    } else{
                    gp.obj[i] = null;
                    gp.playSE(6);
                    gp.ui.damage++;
                    gp.ui.showMessage("You took damage!");
                    }
                    break;
                case "Lantern":
                    if (gp.ui.damage == 1){
                        gp.obj[i] = null;
                        gp.ui.damage++;
                        gp.stopMusic();
                        gp.ui.gameFinished = true;
                    } else{
                    gp.obj[i] = null;
                    gp.playSE(6);
                    gp.ui.damage++;
                    gp.ui.showMessage("You took damage!");
                    }
                    break;
                    
                case "Coin_Bronze":
                    if(gp.ui.damage != 0){
                        gp.obj[i] = null;
                        gp.playSE(1);
                        gp.ui.damage--;
                        gp.ui.showMessage("Healed!");
                    } else{
                        gp.ui.showMessage("Your health is full!");
                    }
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {

        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }

                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }
}
