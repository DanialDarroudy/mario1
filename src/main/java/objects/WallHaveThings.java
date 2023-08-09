package objects;

import characters.Character;

import javax.swing.*;
import java.awt.*;

public class WallHaveThings {
    public boolean hit = false;
    int x;
    int y;
    int width = 50;
    int height = 50;
    public static Image image = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\WallHaveThings.png").getImage();
    public WallHaveThings(int x , int y){
        this.x = x;
        this.y = y;
    }
    //------------------------------------------------methods---------------------------------------------------------//
    public void collision(Character character){
        if (theWallHaveThings().intersects(character.getCharacter())){
            character.setVy(0);
            character.setVx(0);
        }
    }
    public Rectangle theWallHaveThings(){
        return new Rectangle(x , y , width , height);
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

    public boolean isHit() {
        return hit;
    }
    //------------------------------------------------setters---------------------------------------------------------//


    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
