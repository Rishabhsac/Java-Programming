
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1;
    private int key2;
    private int decryptKey1;
    private int decryptKey2;
    
    public CaesarCipherTwo (int key1, int key2) {
    
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        key1 = key1;
        key2 = key2;
        decryptKey1 = 26 - key1;
        decryptKey2 = 26 - key2;
    }
    
    public char encryptChar (char ch, int key) {
    
        char currChar = ' ';
        int idx = 0;
        int flag = 0;
        char newChar = ' ';
        String shiftedAlphabet = "";
        if (key == key1) {
            shiftedAlphabet = shiftedAlphabet + shiftedAlphabet1;
        }
        else if (key == key2) {
            shiftedAlphabet = shiftedAlphabet + shiftedAlphabet2;
        }
        
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
    
    public String decrypt (String input) {
    
        CaesarCipherTwo cc = new CaesarCipherTwo(decryptKey1, decryptKey2);
        StringBuilder sb = new StringBuilder (input);
        
        for (int i = 0; i < sb.length(); i++) {
            
            if (Character.isLetter (sb.charAt(i))) {
                if (i % 2 == 1) {
                    sb.setCharAt (i, cc.encryptChar (sb.charAt(i), key2));
                }
                else {
                    sb.setCharAt (i, cc.encryptChar (sb.charAt(i), key1));
                }
            }
        }
        return sb.toString();
    }

}
