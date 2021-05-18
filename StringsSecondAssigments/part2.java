
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
    
    public int howMany (String stringa, String stringb) {
        
        int noOfOccurrences = 0;
        int startIndex = 0;
        int currOccurringIndex = 0;
        
        while (true) {
            
            currOccurringIndex = stringb.indexOf(stringa, startIndex);
            
            if (currOccurringIndex == -1) {
                return noOfOccurrences;
            }
            startIndex = currOccurringIndex + stringa.length();
            noOfOccurrences += 1;
        }
    }
    
    public void testHowMany () {
        
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        System.out.println ("\nString a is" + stringa);
        System.out.println ("String b is" + stringb);
        System.out.println ("Number of occurrence " + howMany (stringa, stringb));
        
        stringa = "AA";
        stringb = "ATAAAA";
        System.out.println ("\nString a is" + stringa);
        System.out.println ("String b is" + stringb);
        System.out.println ("Number of occurrence " + howMany (stringa, stringb));
        
        stringa = "BB";
        stringb = "ATAAAA";
        System.out.println ("\nString a is" + stringa);
        System.out.println ("String b is" + stringb);
        System.out.println ("Number of occurrence " + howMany (stringa, stringb));
    }

}
