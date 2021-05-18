
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class part2 {

    public double cgRatio (String dna) {
        int Count = 0;
        int i = 0;
        char gg = ' ';
        
            while(i < dna.length()) {
                gg = dna.charAt(i);
                if (gg == 'c' || gg == 'C' || gg == 'g' || gg == 'G') {
                    Count += 1;
                }
                i++;
            }
        return (double)Count/dna.length();
    }

    public int countCTG (String dna) {
        
        int Count = 0;
        int i = 0;
        int index = 0;
        while (index < dna.length()) {
            if (index == dna.indexOf("CTG", index)) {
                Count += 1;
            }
            index += 1;
        }
        return Count;
    }
    
    
    public void testcgRatiocountCTG (String dna) {
        
        System.out.println("Testing getAlGenes on " + dna);
        System.out.println("ratio cg = " + cgRatio(dna));
        System.out.println("count ctg = " + countCTG(dna));
        
    }

}
