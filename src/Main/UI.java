package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {

    GamePanel gp;
    Font arial_40, arial_80B;
    BufferedImage keyImage; // CREATING KEY IMAGE
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00"); // DISPLAYING HOW MANY DECIMALS

    public UI(GamePanel gp) {

        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40); // FONT, NORMAL (ITALIC or BOLD etc), AND SIZE
        arial_80B = new Font("Arial", Font.BOLD, 80);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        if (gameFinished == true) { // FROM PLAYER CLASS CASE IF CHEST IS INTERACTED WITH

            g2.setFont(arial_40);
            g2.setColor(Color.white); // COLOR OF TEXT

            String text;
            int textLength;
            int x;
            int y;

            text = "You found the treasure!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // RETURNS LENGTH OF TEXT

            x = gp.screenWidth/2 - textLength/2; // SO TEXT WILL BE ALIGNED TO CENTER
            y = gp.screenHeight/2 - (gp.tileSize*3); // Making the text go a bit higher

            g2.drawString(text, x, y);

            text = "Your time is: "+ dFormat.format(playTime) + " !";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // RETURNS LENGTH OF TEXT

            x = gp.screenWidth/2 - textLength/2; // SO TEXT WILL BE ALIGNED TO CENTER
            y = gp.screenHeight/2 + (gp.tileSize*4); // Making the text go a bit higher
            g2.drawString(text, x, y);

            g2.setFont(arial_80B); // changing the font and color
            g2.setColor(Color.yellow);

            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // RETURNS LENGTH OF TEXT

            x = gp.screenWidth/2 - textLength/2; // SO TEXT WILL BE ALIGNED TO CENTER
            y = gp.screenHeight/2 + (gp.tileSize*2); // Making the text go a bit lower

            g2.drawString(text, x, y);

            gp.gameThread = null; // PAUSING THE GAME by PAUSING THE THREAD



        } else {


            g2.setFont(arial_40);
            g2.setColor(Color.white); // COLOR OF TEXT
            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null); // (image, x, y, width, height)
            g2.drawString("x " + gp.player.hasKey, 74, 65); // WHAT IS WRITTEN AND ITS POSITION

            // TIME
            playTime += (double)1/60;
            g2.drawString("Time: "+ dFormat.format(playTime), gp.tileSize*11, 65);


            // MESSAGE
            if (messageOn == true) {

                g2.setFont(g2.getFont().deriveFont(30F)); // CHANGING FONT SIZE
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5); // ONLY IF MESSAGEON IS TRUE PRINT MESSAGE FROM KEY CASE IN PLAYER
                // (message, x position, y position)

                messageCounter++;
                if (messageCounter > 120) { // AFTER 120 FRAMES, MESSAGE IS DELETED OR MESSAGEON = FALSE
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }

    }
}
