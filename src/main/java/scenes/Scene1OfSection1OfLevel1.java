package scenes;

import characters.Character;
import objects.Coin;
import objects.SmallTube;
import objects.Wall;
import javax.swing.*;
import java.awt.*;

public class Scene1OfSection1OfLevel1 {
    public boolean finish = false;
    public static Image backGround = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\BackGround.png").getImage();
    public SmallTube smallTube = new SmallTube(800, 700);
    public Wall wall1 =  new Wall(400, 500);
    public Wall wall2 = new Wall(450, 500);
    public Wall wall3 = new Wall(500, 500);
    public Wall wall4 = new Wall(550, 500);
    public Coin coin1 =new Coin(425, 450);
    public Coin coin2 = new Coin(825, 650);
    public Coin coin3 = new Coin(1000, 750);
    public Coin coin4  = new Coin(1500, 750);

    public void drawImage(Graphics g){
        g.drawImage(this.getBackGround() , 0 , 0 , null);
        g.drawImage(this.getSmallTube().getImage() , 800, 700 , null);
        g.drawImage(this.getWall1().getImage() , 400 , 500 , null);
        g.drawImage(this.getWall2().getImage() , 450 , 500 , null);
        g.drawImage(this.getWall3().getImage() , 500 , 500 , null);
        g.drawImage(this.getWall4().getImage(), 550 , 500 , null);
        if (this.getCoin1().isShow()) {
            g.drawImage(this.getCoin1().getImage(), 425, 450, null);
        }
        if (this.getCoin2().isShow()) {
            g.drawImage(this.getCoin2().getImage(), 825, 650, null);
        }
        if (this.getCoin3().isShow()) {
            g.drawImage(this.getCoin3().getImage(), 1000, 750, null);
        }
        if (this.getCoin4().isShow()) {
            g.drawImage(this.getCoin4().getImage(), 1500, 750, null);
        }
        g.fillRect(1750 , 600 , 50 , 200);
    }
    public boolean jump(Character character){
        if (this.isFinish()){
            return false;
        }
        if (character.getY() == 725){
            return true;
        }
        if (character.getY() == this.getWall1().getY() - 75 &&
                character.getX() >= this.getWall1().getX() - 50 &&
                character.getX() <= this.getWall4().getX() + 50){
            return true;
        }
        return character.getY() == this.getSmallTube().getY() - 75 &&
                character.getX() >= this.getSmallTube().getX() - 50 &&
                character.getX() <= this.getSmallTube().getX() + 100;
    }


    //--------------------------------------------------getters-------------------------------------------------------//
    public Image getBackGround() {
        return backGround;
    }

    public SmallTube getSmallTube() {
        return smallTube;
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

    public boolean isFinish() {
        return finish;
    }
    //--------------------------------------------------setters-------------------------------------------------------//

    public void setBackGround(Image backGround) {
        Scene1OfSection1OfLevel1.backGround = backGround;
    }

    public void setSmallTube(SmallTube smallTube) {
        this.smallTube = smallTube;
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
    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
