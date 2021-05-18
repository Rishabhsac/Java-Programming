
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class TestCaesarCipherTwo {
    
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
    
    
    public String halfOfString (String message, int start) {
        
        String half = "";
        
        if (start == 0) {
            for (int k = start; k < message.length(); k += 2) {
        
                half = half + message.charAt(k);
            }
            return half;
        }
        else if (start == 1) {
            for (int i = start; i < message.length(); i += 2) {
        
                half = half + message.charAt(i);
            }
            return half;
        }
        return "";
    }
    
    public int getKey (String s) {
    
        int [] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - 4;
        if (maxDex < 4) {
            dKey = 26 - (4 - maxDex);
        }
        return 26 - dKey;
    }
    
    public String breakCaesarCipher (String encrypted) {
    
        String message1 = halfOfString (encrypted, 0);
        String message2 = halfOfString (encrypted, 1);
        
        System.out.println (message1);
        System.out.println (message2);
   
        int dex1 = getKey (message1);
        int dex2 = getKey (message2);
        System.out.println ("The two keys are " + dex1 + " " + dex2);
        CaesarCipherTwo cc = new CaesarCipherTwo(dex1, dex2);
        return cc.encrypt(encrypted);
    }
    
    public void simpleTests () {
    
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(17, 3);
        
        String encrypted = cc.encrypt (message);
        String decrypted = cc.decrypt (encrypted);
        
        System.out.println (encrypted);
        System.out.println (decrypted);
        System.out.println (breakCaesarCipher (encrypted));
    }

}
