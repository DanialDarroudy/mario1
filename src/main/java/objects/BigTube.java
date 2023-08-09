package objects;

import characters.Character;

import javax.swing.*;
import java.awt.*;

public class BigTube {
    int x;
    int y;
    int width = 100;
    int height = 200;
    public static Image image = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\BigTube.png").getImage();

    public BigTube(int x , int y){
        this.x = x;
        this.y = y;
    }
    //------------------------------------------------methods---------------------------------------------------------//
    public void collision(Character character){
        if (theBigTube().intersects(character.getCharacter())){
            character.setVy(0);
            character.setVx(0);
        }
    }
    public Rectangle theBigTube(){
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
    //------------------------------------------------setters---------------------------------------------------------//

}
