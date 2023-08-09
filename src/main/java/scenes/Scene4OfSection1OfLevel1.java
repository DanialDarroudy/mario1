package scenes;

import characters.Character;
import objects.*;
import javax.swing.*;
import java.awt.*;

public class Scene4OfSection1OfLevel1 {
    public boolean finish = false;
    public static Image backGround = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\BackGround.png").getImage();
    public Hollow hollow = new Hollow(1200 , 800);
    public Wall wall1 =  new Wall(800, 500);
    public Wall wall2 = new Wall(850, 500);
    public Wall wall3 = new Wall(900, 500);
    public Wall wall4 = new Wall(950, 500);
    public Coin coin1 =new Coin(825, 450);
    public Coin coin2 = new Coin(875, 750);
    public Coin coin3 = new Coin(300, 750);
    public Coin coin4  = new Coin(1600, 750);

    public void drawImage(Graphics g){
        g.drawImage(this.backGround , 0 , 0 , null);
        g.drawImage(this.hollow.getImage() , 1200 , 790 , null);
        g.drawImage(this.wall1.getImage() , 800 , 500 , null);
        g.drawImage(this.wall2.getImage() , 850 , 500 , null);
        g.drawImage(this.wall3.getImage() , 900 , 500 , null);
        g.drawImage(this.wall4.getImage() , 950 , 500 , null);
        if (this.coin1.isShow()) {
            g.drawImage(this.coin1.getImage(), 825, 450, null);
        }
        if (this.coin2.isShow()) {
            g.drawImage(this.coin2.getImage(), 875, 750, null);
        }
        if (this.coin3.isShow()) {
            g.drawImage(this.coin3.getImage(), 300, 750, null);
        }
        if (this.coin4.isShow()) {
            g.drawImage(this.coin4.getImage(), 1600, 750, null);
        }
        g.fillRect(1750 , 600 , 50 , 200);
    }
    public boolean jump(Character character){
        if (this.finish){
            return false;
        }
        if (character.getY() == 725){
            return character.getX() < hollow.getX() || character.getX() > hollow.getX() + 150;
        }
        else return character.getY() == this.getWall1().getY() - 75 &&
                character.getX() >= this.getWall1().getX() - 50 &&
                character.getX() <= this.getWall4().getX() + 50;
    }
    //--------------------------------------------------getters-------------------------------------------------------//


    public boolean isFinish() {
        return finish;
    }

    public Image getBackGround() {
        return backGround;
    }

    public Hollow getHollow() {
        return hollow;
    }

    public Wall getWall1() {
        return wall1;
    }

    public Wall getWall2() {
        return wall2;
    }

    public Wall getWall3() {
        return wall3;
    }

    public Wall getWall4() {
        return wall4;
    }

    public Coin getCoin1() {
        return coin1;
    }

    public Coin getCoin2() {
        return coin2;
    }

    public Coin getCoin3() {
        return coin3;
    }

    public Coin getCoin4() {
        return coin4;
    }
    //--------------------------------------------------setters-------------------------------------------------------//


    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void setBackGround(Image backGround) {
        this.backGround = backGround;
    }

    public void setHollow(Hollow hollow) {
        this.hollow = hollow;
    }

    public void setWall1(Wall wall1) {
        this.wall1 = wall1;
    }

    public void setWall2(Wall wall2) {
        this.wall2 = wall2;
    }

    public void setWall3(Wall wall3) {
        this.wall3 = wall3;
    }

    public void setWall4(Wall wall4) {
        this.wall4 = wall4;
    }

    public void setCoin1(Coin coin1) {
        this.coin1 = coin1;
    }

    public void setCoin2(Coin coin2) {
        this.coin2 = coin2;
    }

    public void setCoin3(Coin coin3) {
        this.coin3 = coin3;
    }

    public void setCoin4(Coin coin4) {
        this.coin4 = coin4;
    }
}
