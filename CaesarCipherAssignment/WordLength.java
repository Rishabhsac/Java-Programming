
/**
 * Write a description of WordLength here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLength {

        public void countWordLength (FileResource resource, int [] counts) {
            
            String[] words = new String[31];
            
            for (int i = 0; i < words.length; i++) {
            
                words[i] = "";
            }
            
            for (String s : resource.words()) {
                
                int length = 0;
                if (!Character.isLetter (s.charAt (0)) && !Character.isLetter (s.charAt (s.length() - 1))) {
                    length = s.length() - 2;
                    counts[length] += 1;
                    words [length] = words [length] + s.substring (0, length) + " " ;
                }
                else if(!Character.isLetter (s.charAt (0)) || !Character.isLetter (s.charAt (s.length() - 1))) {
                    length = s.length() - 1;
                    counts[length] += 1; 
                    words [length] = words [length] + s.substring (0, length) + " " ;
                }
                else{
                length = s.length();
                counts[length] += 1;
                words [length] = words [length] + s.substring (0, length) + " " ;
                }
            }
            
            for (int k = 1; k < counts.length; k++) {
                if (words[k] != "") {
                System.out.println (counts[k] + " words of length " + k + ":" + words[k]);
                }
            }
             System.out.println ("Index of max count " + indexOfMax (counts));
        }
        
        public int indexOfMax (int [] values) {
            
            int maxValue = 0;
            int maxIdx = 0;
            for (int k = 0; k < values.length; k++) {
            
                if (values[k] > maxValue) {
                    maxValue = values[k];
                    maxIdx = k;
                }
            }
            return maxIdx;
        }
        
        public void testCountWordLengths () {
            
            FileResource fr = new FileResource ();
            int [] count = new int [31];
            countWordLength (fr, count);
        }
}
