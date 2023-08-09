package database;

import characters.*;
import characters.Character;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import main.*;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Files {
    public final static HashMap<String, User> users = new HashMap<>();
    public final static List<User> arrayUsers = new ArrayList<>();

    public static void saveUser(List<User> arrayOfUsers) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter("src/main/resources/Users.json");
            writer.write(gson.toJson(arrayOfUsers));
            writer.close();
        } catch (IOException ignored) {
        }
    }

    public static void loadUsers() {
        try {
            Gson g = new GsonBuilder().setPrettyPrinting().create();
            Reader r = java.nio.file.Files.newBufferedReader(Paths.get("src/main/resources/Users.json"));
            List<User> arrayOfUsers = g.fromJson(r, new TypeToken<List<User>>() {
            }.getType());
            r.close();
            arrayUsers.addAll(arrayOfUsers);
            for (User arrayUser : arrayUsers) {
                users.put(arrayUser.getUserName(), arrayUser);
            }
            initializeCharacter();
        } catch (IOException ignored) {
        }
    }
    public static void initializeCharacter(){
        Character helpCharacter;
        for (User arrayUser : arrayUsers) {
            if (arrayUser.getGame1() != null) {
                if (arrayUser.getGame1().getHelpSelectedCharacter().equals("Mario")) {
                    helpCharacter = new Mario();
                    helpCharacter.setX(arrayUser.getGame1().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame1().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame1().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame1().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame1().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame1().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame1().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame1().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame1().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame1().getSelectedCharacter().getInitY());
                    arrayUser.getGame1().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame1().getHelpSelectedCharacter().equals("Wario")) {
                    helpCharacter = new Wario();
                    helpCharacter.setX(arrayUser.getGame1().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame1().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame1().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame1().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame1().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame1().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame1().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame1().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame1().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame1().getSelectedCharacter().getInitY());
                    arrayUser.getGame1().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame1().getHelpSelectedCharacter().equals("Toad")) {
                    helpCharacter = new Toad();
                    helpCharacter.setX(arrayUser.getGame1().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame1().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame1().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame1().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame1().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame1().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame1().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame1().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame1().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame1().getSelectedCharacter().getInitY());
                    arrayUser.getGame1().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame1().getHelpSelectedCharacter().equals("Boo")) {
                    helpCharacter = new Boo();
                    helpCharacter.setX(arrayUser.getGame1().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame1().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame1().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame1().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame1().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame1().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame1().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame1().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame1().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame1().getSelectedCharacter().getInitY());
                    arrayUser.getGame1().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame1().getHelpSelectedCharacter().equals("Yoshi")) {
                    helpCharacter = new Yoshi();
                    helpCharacter.setX(arrayUser.getGame1().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame1().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame1().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame1().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame1().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame1().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame1().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame1().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame1().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame1().getSelectedCharacter().getInitY());
                    arrayUser.getGame1().setSelectedCharacter(helpCharacter);
                }
            }
            if (arrayUser.getGame2() != null) {
                if (arrayUser.getGame2().getHelpSelectedCharacter().equals("Mario")) {
                    helpCharacter = new Mario();
                    helpCharacter.setX(arrayUser.getGame2().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame2().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame2().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame2().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame2().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame2().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame2().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame2().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame2().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame2().getSelectedCharacter().getInitY());
                    arrayUser.getGame2().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame2().getHelpSelectedCharacter().equals("Wario")) {
                    helpCharacter = new Wario();
                    helpCharacter.setX(arrayUser.getGame2().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame2().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame2().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame2().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame2().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame2().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame2().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame2().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame2().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame2().getSelectedCharacter().getInitY());
                    arrayUser.getGame2().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame2().getHelpSelectedCharacter().equals("Toad")) {
                    helpCharacter = new Toad();
                    helpCharacter.setX(arrayUser.getGame2().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame2().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame2().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame2().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame2().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame2().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame2().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame2().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame2().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame2().getSelectedCharacter().getInitY());
                    arrayUser.getGame2().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame2().getHelpSelectedCharacter().equals("Boo")) {
                    helpCharacter = new Boo();
                    helpCharacter.setX(arrayUser.getGame2().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame2().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame2().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame2().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame2().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame2().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame2().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame2().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame2().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame2().getSelectedCharacter().getInitY());
                    arrayUser.getGame2().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame2().getHelpSelectedCharacter().equals("Yoshi")) {
                    helpCharacter = new Yoshi();
                    helpCharacter.setX(arrayUser.getGame2().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame2().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame2().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame2().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame2().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame2().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame2().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame2().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame2().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame2().getSelectedCharacter().getInitY());
                    arrayUser.getGame2().setSelectedCharacter(helpCharacter);
                }
            }
            if (arrayUser.getGame3() != null) {
                if (arrayUser.getGame3().getHelpSelectedCharacter().equals("Mario")) {
                    helpCharacter = new Mario();
                    helpCharacter.setX(arrayUser.getGame3().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame3().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame3().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame3().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame3().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame3().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame3().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame3().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame3().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame3().getSelectedCharacter().getInitY());
                    arrayUser.getGame3().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame3().getHelpSelectedCharacter().equals("Wario")) {
                    helpCharacter = new Wario();
                    helpCharacter.setX(arrayUser.getGame3().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame3().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame3().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame3().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame3().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame3().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame3().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame3().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame3().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame3().getSelectedCharacter().getInitY());
                    arrayUser.getGame3().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame3().getHelpSelectedCharacter().equals("Toad")) {
                    helpCharacter = new Toad();
                    helpCharacter.setX(arrayUser.getGame3().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame3().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame3().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame3().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame3().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame3().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame3().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame3().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame3().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame3().getSelectedCharacter().getInitY());
                    arrayUser.getGame3().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame3().getHelpSelectedCharacter().equals("Boo")) {
                    helpCharacter = new Boo();
                    helpCharacter.setX(arrayUser.getGame3().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame3().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame3().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame3().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame3().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame3().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame3().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame3().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame3().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame3().getSelectedCharacter().getInitY());
                    arrayUser.getGame3().setSelectedCharacter(helpCharacter);
                }
                if (arrayUser.getGame3().getHelpSelectedCharacter().equals("Yoshi")) {
                    helpCharacter = new Yoshi();
                    helpCharacter.setX(arrayUser.getGame3().getSelectedCharacter().getX());
                    helpCharacter.setY(arrayUser.getGame3().getSelectedCharacter().getY());
                    helpCharacter.setVx(arrayUser.getGame3().getSelectedCharacter().getVx());
                    helpCharacter.setVy(arrayUser.getGame3().getSelectedCharacter().getVy());
                    helpCharacter.setHeart(arrayUser.getGame3().getSelectedCharacter().getHeart());
                    helpCharacter.setStrongMan(arrayUser.getGame3().getSelectedCharacter().isStrongMan());
                    helpCharacter.setUseGun(arrayUser.getGame3().getSelectedCharacter().isUseGun());
                    helpCharacter.setDecreaseHeart(arrayUser.getGame3().getSelectedCharacter().isDecreaseHeart());
                    helpCharacter.setInitX(arrayUser.getGame3().getSelectedCharacter().getInitX());
                    helpCharacter.setInitY(arrayUser.getGame3().getSelectedCharacter().getInitY());
                    arrayUser.getGame3().setSelectedCharacter(helpCharacter);
                }
            }
        }
    }
}
