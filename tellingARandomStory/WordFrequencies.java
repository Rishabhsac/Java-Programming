
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class WordFrequencies {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies () {
    
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique () {
    
        myWords.clear();
        myFreqs.clear();
         
        
        FileResource fr = new FileResource();
            
        for (String s : fr.words()) {
                
            int index = myWords.indexOf(s.toLowerCase());
            
            if (index == -1) {
                myWords.add(s.toLowerCase());
                myFreqs.add(1);
            }
            else {
                int value = myFreqs.get(index);
                myFreqs.set (index, value + 1);
            }
        }
    }
    
    public int findIndexOfMax () {
    
        int maxIndex = 0;
        
        for (int k = 0; k < myFreqs.size(); k++) {
        
            if (myFreqs.get (maxIndex) < myFreqs.get (k)) {
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    public void tester () {
    
        findUnique();
        int index = findIndexOfMax();
        
        for (int k = 0; k < myWords.size(); k++) {
        
            System.out.println (myFreqs.get(k) + " occurrances of " + myWords.get(k));
        }
        System.out.println ("no of unique words " + myWords.size());
        System.out.println ("word having maximum occurrances is  " + myWords.get(index) + "=" + myFreqs.get(index));
    }
}
