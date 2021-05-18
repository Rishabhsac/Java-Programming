
/**
 * Write a description of CaserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaserCipher {
    
    public char encryptChar (char ch, int key) {
    
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        char currChar = ' ';
        int idx = 0;
        int flag = 0;
        char newChar = ' ';
        
            if (Character.isLowerCase(ch)) {
                currChar = Character.toUpperCase(ch);
                flag = 1;
            }
            else {
                currChar = ch;
            }
            
                idx = alphabet.indexOf(currChar);
                
            if (idx!= -1) {
                if (flag == 1) {
                    newChar = Character.toLowerCase(shiftedAlphabet.charAt(idx));
                }
                else {
                    newChar = Character.toUpperCase(shiftedAlphabet.charAt(idx));
                }
                //encrypted.setCharAt(i,newChar);
            }
        return newChar;
    }
    
    public String encrypt (String input, int key) {
    
        StringBuilder sb = new StringBuilder (input);
        
        for (int i = 0; i < sb.length(); i++) {
            
            if (Character.isLetter (sb.charAt(i))) {
                sb.setCharAt (i, encryptChar (sb.charAt(i), key));
            }
        }
        return sb.toString();
    }
    
    public String encryptTwoKeys (String input, int key1, int key2) {
    
        
        StringBuilder sb = new StringBuilder (input);
        
        for (int i = 0; i < sb.length(); i++) {
            
            if (Character.isLetter (sb.charAt(i))) {
                if (i % 2 == 1) {
                    sb.setCharAt (i, encryptChar (sb.charAt(i), key2));
                }
                else {
                    sb.setCharAt (i, encryptChar (sb.charAt(i), key1));
                }
            }
        }
        return sb.toString();
    }
    
    public void testCaesar () {
    
        System.out.println (encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        
    }
    
    public void testEncryptTwoKeys () {
    
        System.out.println (encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
    }
}
