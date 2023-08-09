package objects;

import characters.Character;

import javax.swing.*;
import java.awt.*;

public class SmallTube {
    int x;
    int y;
    int width = 100;
    int height = 100;
    public static Image image = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\SmallTube.png").getImage();
    public SmallTube(int x , int y){
        this.x = x;
        this.y = y;
    }
    //------------------------------------------------methods---------------------------------------------------------//
    public void collision(Character character){
        if (theSmallTube().intersects(character.getCharacter())){
            character.setVy(0);
            character.setVx(0);
        }
    }
    public Rectangle theSmallTube(){
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
