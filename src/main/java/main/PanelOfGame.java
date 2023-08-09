package main;

import characters.Boo;
import characters.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelOfGame extends JPanel {
    private Character selectedCharacter;
    private Game game;
    private int show;
    private User user;
    private String fromWay;

    public PanelOfGame(Game game , int show , User user , String fromWay){
        this.game = game;
        this.show = show;
        this.user = user;
        this.selectedCharacter = game.getSelectedCharacter();
        this.fromWay = fromWay;
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (game.checkJump()) {
                            selectedCharacter.setInitY(selectedCharacter.getY());
                            selectedCharacter.setVy(-10);
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (selectedCharacter instanceof Boo){
                            selectedCharacter.setVx(-7);
                        }
                        else {
                            selectedCharacter.setVx(-5);
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (selectedCharacter instanceof Boo){
                            selectedCharacter.setVx(7);
                        }
                        else {
                            selectedCharacter.setVx(5);
                        }
                        break;
                    default:
                        break;
                }
            }

            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        selectedCharacter.setVy(0);
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        selectedCharacter.setVx(0);
                        break;
                    default:
                        break;
                }
            }

            public void keyTyped(KeyEvent arg0) {
            }
        }); // for move
    }
    @Override
    public void paint(Graphics g){
        game.level1(g , show , user , fromWay);
        selectedCharacter.paint(g);
        game.paintInformation(g);
    }
}
