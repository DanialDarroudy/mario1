package scenes;

import characters.Character;
import objects.*;

import javax.swing.*;
import java.awt.*;

public class Scene1OfSection2OfLevel1 {
    public boolean finish = false;
    public static Image backGround = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\BackGround.png").getImage();
    public SmallTube smallTube = new SmallTube(100, 700);
    public BigTube bigTube = new BigTube(1200 , 600);
    public WallHaveThings wallHaveThings =  new WallHaveThings(125, 400);
    public Hollow hollow = new Hollow(700 , 800);
    public Coin coin1 = new Coin(300, 750);
    public Coin coin2 = new Coin(1225, 550);
    public Coin coin3 = new Coin(1000, 750);
    public Coin coin4  = new Coin(1500, 750);
    //------------------------------------------------methods---------------------------------------------------------//

    public void drawImage(Graphics g){
        g.drawImage(this.backGround , 0 , 0 , null);
        g.drawImage(this.smallTube.getImage() , 100, 700 , null);
        g.drawImage(this.bigTube.getImage() , 1200 , 600 , null);
        g.drawImage(this.wallHaveThings.getImage() , 125 , 400 , null);
        g.drawImage(this.hollow.getImage() , 700 , 790 , null);
        if (this.coin1.isShow()) {
            g.drawImage(this.getCoin1().getImage(), 300, 750, null);
        }
        if (this.coin2.isShow()) {
            g.drawImage(this.getCoin2().getImage(), 1225, 550, null);
        }
        if (this.coin3.isShow()) {
            g.drawImage(this.getCoin3().getImage(), 1000, 750, null);
        }
        if (this.coin4.isShow()) {
            g.drawImage(this.getCoin4().getImage(), 1500, 750, null);
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
        if (character.getY() == this.getWallHaveThings().getY() - 75 &&
                character.getX() >= this.getWallHaveThings().getX() - 50 &&
                character.getX() <= this.getWallHaveThings().getX() + 50){
            return true;
        }
        if (character.getY() == this.getBigTube().getY() - 75 &&
                character.getX() >= this.getBigTube().getX() - 50 &&
                character.getX() <= this.getBigTube().getX() + 100){
            return true;
        }
        return character.getY() == this.getSmallTube().getY() - 75 &&
                character.getX() >= this.getSmallTube().getX() - 50 &&
                character.getX() <= this.getSmallTube().getX() + 100;
    }
    //------------------------------------------------getters---------------------------------------------------------//

    public boolean isFinish() {
        return finish;
    }

    public Image getBackGround() {
        return backGround;
    }

    public SmallTube getSmallTube() {
        return smallTube;
    }

    public BigTube getBigTube() {
        return bigTube;
    }

    public WallHaveThings getWallHaveThings() {
        return wallHaveThings;
    }

    public Hollow getHollow() {
        return hollow;
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

    //------------------------------------------------setters---------------------------------------------------------//

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void setBackGround(Image backGround) {
        this.backGround = backGround;
    }

    public void setSmallTube(SmallTube smallTube) {
        this.smallTube = smallTube;
    }

    public void setBigTube(BigTube bigTube) {
        this.bigTube = bigTube;
    }

    public void setWallHaveThings(WallHaveThings wallHaveThings) {
        this.wallHaveThings = wallHaveThings;
    }

    public void setHollow(Hollow hollow) {
        this.hollow = hollow;
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
