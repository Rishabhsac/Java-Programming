
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class CharactersInPlay {

    private ArrayList<String> characters;
    private ArrayList<Integer> counts;
    
    public CharactersInPlay() {
    
        characters = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    public void update (String person) {
    
        if (! characters.contains(person)) {
            characters.add(person);
            counts.add(1);
        }
        else {
            int index = characters.indexOf(person);
            int value = counts.get(index);
            counts.set(index, value + 1);
        }
    }
    
    public void findAllCharacters () {
        
        characters.clear();
        counts.clear();
        
        FileResource fr = new FileResource ();
        
        for (String s : fr.lines()) {
        
            if (s.contains(".")) {
                int index = s.indexOf(".");
                String person = s.substring(0, index);
                update (person);
            }
        }
    }
    
    public void charactersWithNumParts (int num1, int num2) {
    
        for (int k =0; k < characters.size(); k++) {
        
                if (counts.get(k) > num1 && counts.get(k) < num2) {
                    System.out.println (characters.get(k) + "  " + counts.get(k));
                }
        }
    }
    
    public void tester () {
    
        findAllCharacters();
        int k = 0;
        
        for (k = 0; k < characters.size(); k++) {
            
            if (counts.get(k) > 1) {
                System.out.println (characters.get(k) + "  " + counts.get(k));
            }
        }
        
        System.out.println ("\n\nCharacters having counts in between 5 to 20 are following");
        charactersWithNumParts (9, 15);
    }
}
