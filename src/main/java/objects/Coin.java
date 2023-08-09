package objects;

import javax.swing.*;
import java.awt.*;

public class Coin {
    public boolean show = true;
    public int x;
    public int y;
    public int width = 50;
    public int height = 50;
    public static Image image = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\Coin.png").getImage();
    public Coin(int x , int y){
        this.x = x;
        this.y = y;
    }
    //------------------------------------------------getters---------------------------------------------------------//
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public boolean isShow() {
        return show;
    }
    //------------------------------------------------setters---------------------------------------------------------//
    public void setShow(boolean show) {
        this.show = show;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
