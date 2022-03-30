package com.headfirst.pacmanface;

import java.io.*;
import java.util.*;

public class GameCharacter implements Serializable{
    private String power;
    private String type;
    private String[] weapons;
    static boolean isTrue = true;

    public GameCharacter(String power, String type, String[] weapons){
        this.type = type;
        this.power = power;
        this.weapons = weapons;
    }

    @Override
    public java.lang.String toString() {
        return String.format("type is %s, power is %s, weapons is %s", type,power,Arrays.toString(weapons));
    }
}
