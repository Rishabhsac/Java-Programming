
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class TestCaesarCipher {
    
    public int[] countLetters (String message){
        
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++) {
        
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1; 
            }
        }
        return counts;
    }
    
    public int maxIndex (int[] values) {
    
        int maxDex = 0;
        for (int k =0; k < values.length; k++) {
        
            if (values[k] > values[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public String breakCaesarCipher (String input) {
        
        int [] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - 4;
        if (maxDex < 4) {
            dKey = 26 - (4 - maxDex);
        }
        CaesarCipher cc = new CaesarCipher(26 - dKey);
        return cc.encrypt(input);
    }
    
    
    
    public void simpleTests () {
        
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher (18);
        String encrypted = cc.encrypt (message);
        
        //CaesarCipher cc1 = new CaesarCipher (26 - 18);
        String decrypted = cc.decrypt (encrypted);
        
        System.out.println (encrypted);
        System.out.println (decrypted);
        System.out.println (breakCaesarCipher (encrypted));
    }

}
