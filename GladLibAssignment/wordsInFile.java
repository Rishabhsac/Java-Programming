
/**
 * Write a description of wordsInFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import java.io.*;

public class wordsInFile {
    
    private HashMap<String, ArrayList<String>> myMap;
    
    public wordsInFile () {
        
        myMap = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile (File f) {
    
        FileResource fr = new FileResource(f);
        String name = f.getName();
        
        for (String s : fr.words()) {
            
            if (!myMap.containsKey(s)) {
                ArrayList<String> list =new ArrayList<String>();
                list.add(name);
                myMap.put(s, list);
                //System.out.println(myMap);
            }
            else if (myMap.containsKey(s) && !myMap.get(s).contains(name)){
                ArrayList<String> list2 =myMap.get(s);
                list2.add(name);
                myMap.put (s, list2);
            }
            
            
        }
    }
    
    private void buildWordFileMap () {
    
        myMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File fr : dr.selectedFiles()) {
            
            addWordsFromFile (fr);
        }
    }
    
    private int maxNumber () {
    
        int count = 0;
        for (String s : myMap.keySet()) {
        
            if (count < myMap.get(s).size()){
                count++;
            }
        }
        return count;
    }
    
    private ArrayList<String> wordsInNumFiles (int number) {
    
        ArrayList<String> list = new ArrayList<String>();
        
        for (String s : myMap.keySet()) {
        
            if (myMap.get(s).size() == number) {
                list.add(s);
            }
        }
        return list;
    }
    
    private void printFilesIn (String word) {
    
        ArrayList<String> list = myMap.get(word);
        
        for (int k = 0; k < list.size(); k++) {
            
            System.out.println(list.get(k));
        }
    }
    
    public void tester (){
    
        buildWordFileMap();
        
        int value = maxNumber();
        ArrayList<String> list = wordsInNumFiles(5);
        
        /*System.out.println ("Files in which every word occurs are -:");
        for (int k = 0; k < list.size(); k++){
            printFilesIn(list.get(k));
        }*/
        System.out.println("no of words in 5 files "+ list.size());
        list = wordsInNumFiles(4);
        System.out.println ("no of words in 4 file " + list.size());
        System.out.println ("Files in which 'sad' word occurs are -:");
        printFilesIn("red");
    }
}
