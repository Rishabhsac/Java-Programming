
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    
    public Boolean isVowel (char ch) {
    
        if (ch =='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u' ||
            ch =='A' || ch =='E' || ch =='I' || ch =='O' || ch =='U') {
            return true;
        }
        return false;
    }
    
    public String replaceVowels (String phrase, char ch) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < phrase.length(); i++) {
        
            if (isVowel(phrase.charAt(i))) {
                sb.insert(i, ch);
            }
            else {
                sb.insert(i, phrase.charAt(i));
            }
        }
        return sb.toString();
    }
    
    public String emphasize (String phrase, char ch) {
    
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < phrase.length(); i++) {
        
            if (phrase.charAt(i) == Character.toLowerCase(ch) || phrase.charAt(i) == Character.toUpperCase(ch)) {
                if ((i+1)%2 == 1) {
                    sb.insert (i, '*');
                }
                else {
                    sb.insert (i, '+');
                }
            }
            else {
                sb.insert (i, phrase.charAt(i));
            }
        }
        return sb.toString();
    }

    public void testisVowel () {
    
        System.out.println (isVowel ('a'));
    }
    
    public void testReplaceVowels () {
    
        System.out.println (replaceVowels("Hello World", '*'));
    }
    
    public void testEmphasize () {
    
        System.out.println (emphasize("Mary Bella Abracadabra", 'a'));
    }
}