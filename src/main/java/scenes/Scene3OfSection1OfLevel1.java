package scenes;

import characters.Character;
import enemies.Plant;
import objects.BigTube;
import objects.Coin;
import objects.SmallTube;

import javax.swing.*;
import java.awt.*;

public class Scene3OfSection1OfLevel1 {
    public boolean finish = false;
    public static Image backGround = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\BackGround.png").getImage();
    public BigTube bigTube = new BigTube(1200, 600);
    public SmallTube smallTube = new SmallTube(600 , 700);
    public Coin coin1 =new Coin(625, 650);
    public Coin coin2 = new Coin(875, 750);
    public Coin coin3 = new Coin(300, 750);
    public Coin coin4  = new Coin(1400, 750);
    public Plant plant = new Plant(1240 , 550);

    public void drawImage(Graphics g){
        g.drawImage(this.getBackGround() , 0 , 0 , null);
        g.drawImage(this.getBigTube().getImage() , 1200, 600 , null);
        g.drawImage(this.smallTube.getImage() , 600 , 700 , null);
        if (this.getCoin1().isShow()) {
            g.drawImage(this.getCoin1().getImage(), 625, 650, null);
        }
        if (this.getCoin2().isShow()) {
            g.drawImage(this.getCoin2().getImage(), 875, 750, null);
        }
        if (this.getCoin3().isShow()) {
            g.drawImage(this.getCoin3().getImage(), 300, 750, null);
        }
        if (this.getCoin4().isShow()) {
            g.drawImage(this.getCoin4().getImage(), 1400, 750, null);
        }
        g.fillRect(1750 , 600 , 50 , 200);
        appearanceOfPlant(g);
    }
    public boolean jump(Character character){
        if (this.isFinish()){
            return false;
        }
        if (character.getY() == 725){
            return true;
        }
        if (character.getY() == this.getSmallTube().getY() - 75 &&
                character.getX() >= this.getSmallTube().getX() - 50 &&
                character.getX() <= this.getSmallTube().getX() + 100){
            return true;
        }
        return character.getY() == this.getBigTube().getY() - 75 &&
                character.getX() >= this.getBigTube().getX() - 50 &&
                character.getX() <= this.getBigTube().getX() + 100;
    }

    public void appearanceOfPlant(Graphics g){
        plant.setTime(plant.getTime() + 5);
        if (plant.getTime() >= 5000){
            plant.setTime(0);
            plant.setExist(!plant.isExist());
        }
        if (plant.isExist()) {
            g.drawImage(this.plant.getImage(), 1240, 550, null);
        }
    }
    //--------------------------------------------------getters-------------------------------------------------------//

    public Plant getPlant() {
        return plant;
    }

    public SmallTube getSmallTube() {
        return smallTube;
    }

    public Image getBackGround() {
        return backGround;
    }

    public BigTube getBigTube() {
        return bigTube;
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
        this.backGround = backGround;
    }

    public void setBigTube(BigTube bigTube) {
        this.bigTube = bigTube;
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
