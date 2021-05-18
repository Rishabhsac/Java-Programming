
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public Boolean twoOccurrences (String stringa , String stringb) {
        
        int lengtha = stringa.length();
        int firstOccurrence = stringb.indexOf(stringa);
        int secondOccurrence = stringb.indexOf(stringa , firstOccurrence + lengtha);
        
        if ((firstOccurrence + 1 == 0) || (secondOccurrence + 1 == 0)) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public String lastPart (String stringa , String stringb) {
        
        int firstOccurrence = stringb.indexOf(stringa);
        int lastindex = stringb.lastIndexOf(stringa);
        
        if (firstOccurrence + 1 == 0) {
            return stringb;
        }
        
        String last = stringb.substring(firstOccurrence + 1 , lastindex + 1);
        return last;
    }
    
    public void testing () {
        String a = "by";
        String b = "A story by Abby Long";
        Boolean var = twoOccurrences(a , b);
        System.out.println (var);
        
        a = "a";
        b = "banana";
        var = twoOccurrences(a , b);
        System.out.println (var);
        
        a = "atg";
        b = "ctgtatgta";
        var = twoOccurrences(a , b);
        System.out.println (var);
        
        a = "an";
        b = "banana";
        String var2 = lastPart(a , b);
        System.out.println (var2);
        
        a = "zoo";
        b = "forest";
        var2 = lastPart(a , b);
        System.out.println (var2);
    }

}
