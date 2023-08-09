package objects;

import characters.Character;

import javax.swing.*;
import java.awt.*;

public class TubeHide {
    int x;
    int y;
    int width = 100;
    int height = 100;
    public static Image image = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\TubeHide.png").getImage();
    public TubeHide(int x , int y){
        this.x = x;
        this.y = y;
    }
    //------------------------------------------------methods---------------------------------------------------------//
    public void collision(Character character){
        if (theTubeHide().intersects(character.getCharacter())){
            if (character.getY() == y - 75 && character.getX() >= x && character.getX() <= x + 50){
                //go to hide level
            }
            else {
                character.setVy(0);
                character.setVx(0);
            }
        }
    }
    public Rectangle theTubeHide(){
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
