
/**
 * Write a description of CCDecrypt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CCDecrypt {
    
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
    
    public String decrypt (String encrypted) {
        
        CaserCipher cc = new CaserCipher();
        int [] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - 4;
        if (maxDex < 4) {
            dKey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26-dKey);
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
    
    public String decryptTwoKeys (String encrypted) {
    
        String message1 = halfOfString (encrypted, 0);
        String message2 = halfOfString (encrypted, 1);
        
        System.out.println (message1);
        System.out.println (message2);
        
        /*int [] freqs = countLetters(message1);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - 20;
        if (maxDex < 20) {
            dKey = 26 - (20 - maxDex);
        }*/
        
        int dex1 = getKey (message1);
        int dex2 = getKey (message2);
        System.out.println ("The two keys are " + dex1 + " " + dex2);
        CaserCipher cc = new CaserCipher();
        return cc.encryptTwoKeys(encrypted, 24, 6);
    }
    
    public void  testDecrypt () {
        
        String message = "Abxo Ltbk Kl jxqqbo texq vlr jxv exsb ebxoa  qebob fp kl zxhb fk qeb zlkcbobkzb ollj   Qeb zxhb fp x ifb   Mibxpb hbbm tlohfkd lk Zlropbox sfablp  Qexkhp Aobt";
        System.out.println ("message to be decrypted is : " + message);
        System.out.println ("decypted message is : " + decrypt (message));
    }
    
    public void testHalfOfString () {
    
        System.out.println ("message is : " + halfOfString ("Qbkm Zgis", 0));
        System.out.println ("message is : " + halfOfString ("Qbkm Zgis", 1));
    }
    
    public void testDecryptTwoKeys () {
    
        FileResource fr = new FileResource ();
        String message = fr.asString();
        System.out.println ("message to be decrypted is : " + message);
        System.out.println ("decypted message is : " + decryptTwoKeys (message));
    }
}
