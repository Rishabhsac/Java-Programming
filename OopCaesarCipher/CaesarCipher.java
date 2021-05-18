
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    
    private String alphabet;
    private String shiftedAlphabet;
    private int key;
    private int decryptKey;
    
    public CaesarCipher (int key) {
    
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        key = key;
        decryptKey = 26 - key;
    }
    
    public char encryptChar (char ch) {
    
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
    
    public String encrypt (String input) {
    
        StringBuilder sb = new StringBuilder (input);
        
        for (int i = 0; i < sb.length(); i++) {
            
            if (Character.isLetter (sb.charAt(i))) {
                sb.setCharAt (i, encryptChar (sb.charAt(i)));
            }
        }
        return sb.toString();
    }
    
    public String decrypt (String input) {
        
        CaesarCipher cc = new CaesarCipher (decryptKey);
        StringBuilder sb = new StringBuilder (input);
        
        for (int i = 0; i < sb.length(); i++) {
            
            if (Character.isLetter (sb.charAt(i))) {
                sb.setCharAt (i, cc.encryptChar (sb.charAt(i)));
            }
        }
        return sb.toString();
    }

}
