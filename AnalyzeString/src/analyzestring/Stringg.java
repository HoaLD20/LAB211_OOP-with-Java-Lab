/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzestring;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Le Duc Hoa
 */
public class Stringg {
    private String string;
    private HashMap<String, ArrayList<Integer>> number;
    private HashMap<String,String> character;
    
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public HashMap<String, ArrayList<Integer>> getNumber() {
        return number;
    }

    public void setNumber(HashMap<String, ArrayList<Integer>> number) {
        this.number = number;
    }

    public HashMap<String, String> getCharacter() {
        return character;
    }

    public void setCharacter(HashMap<String, String> character) {
        this.character = character;
    }
    
    
}
