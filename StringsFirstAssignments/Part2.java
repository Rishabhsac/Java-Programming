
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public String findSimpleGene (String dna , String startCodon , String stopCodon) {
        
        if (dna == dna.toLowerCase()) {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        else {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        }
        
        int startIndex = dna.indexOf(startCodon);
        
        if (startIndex == -1) {
            return "";
        }
        
        int endIndex = dna.indexOf(stopCodon , startIndex + 3);
        
        if (endIndex == -1) {
            return "";
        }
        
        String result = "";
        result = dna.substring(startIndex , endIndex + 3);
        
        String sub = result.substring(3 , result.indexOf(stopCodon , 3));
       
        if (sub.length() % 3 != 0) {
            return "";
        }
        
        return result;
    }
    
    public void testSimpleGene() {
        String dna = "CTGGACTAA";
        System.out.println ("DNA strand is "+ dna);
        String gene = findSimpleGene(dna , "ATG" , "TAA");
        System.out.println ("GENE is "+ gene);
        
        dna = "CATGGACTT";
        System.out.println ("DNA strand is "+ dna);
        gene = findSimpleGene(dna , "ATG" , "TAA");
        System.out.println ("GENE is "+ gene);
        
        dna = "CTGGACTT";
        System.out.println ("DNA strand is "+ dna);
        gene = findSimpleGene(dna , "ATG" , "TAA");
        System.out.println ("GENE is "+ gene);
        
        dna = "CTGATGCAATAATGC";
        System.out.println ("DNA strand is "+ dna);
        gene = findSimpleGene(dna , "atg" , "taa");
        System.out.println ("GENE is "+ gene);
        
        dna = "CTAGATGCTGGACTTGAGTAAGCT";
        System.out.println ("DNA strand is "+ dna);
        gene = findSimpleGene(dna , "ATG" , "TAA");
        System.out.println ("GENE is "+ gene);
    }

}
