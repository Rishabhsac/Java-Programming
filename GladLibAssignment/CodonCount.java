
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class CodonCount {

    private HashMap<String, Integer> myMap;
    
    public CodonCount () {
    
        myMap = new HashMap<String, Integer>();
    }
    
    private void buildCodonMap (int start, String dna) {
        
        myMap.clear();
        int count = 0;
        
        for (int k = start; k < dna.length(); k += 3) {
            
            if (k + 3 < dna.length()) {
                String word = dna.substring (k, k + 3);
                if (myMap.containsKey(word)) {
                    myMap.put(word, myMap.get(word) + 1);
                }
                else {
                    myMap.put(word, 1);
                }
            }
        }
        System.out.println("Reading frame starting with " + start + " results in " + myMap.keySet().size() + " unique codons");
    }
    
    private String getMostCommonCodon () {
    
        String maxCount = "";
        int value = 0;
        
        for (String s : myMap.keySet()) {
            
            if (value < myMap.get(s)) {
                maxCount = s;
                value = myMap.get(s);
            }
        }
        return maxCount;
    }
    
    private void printCodonCounts (int start, int end) {
    
        for (String s : myMap.keySet()) {
        
            int value = myMap.get(s);
            if (value >= start && value <= end) {
                System.out.println (s + "  " + value);
            }
        }
    }
    
    public void tester () {
    
        FileResource fr = new FileResource();
        String dna = fr.asString().toUpperCase();
        
        for (int k = 0; k < 3; k++) {
        
            buildCodonMap (k, dna);
            String s = getMostCommonCodon();
            System.out.println ("and the most Common codon is " + s + " with count " + myMap.get(s));
            System.out.println ("counts of codons between 3 and 7 inclusive are :");
            printCodonCounts(3, 7);
            System.out.println("\n\n");
        }
    }
}
