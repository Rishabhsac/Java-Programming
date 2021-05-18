/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public String findSimpleGene (String dna) {
        
        int startIndex = dna.indexOf("ATG");
        
        if (startIndex == -1) {
            return "";
        }
        
        int endIndex = dna.indexOf("TAA" , startIndex + 3);
        
        if (endIndex == -1) {
            return "";
        }
        
        String result = "";
        result = dna.substring(startIndex , endIndex + 3);
        
        String sub = result.substring(3 , result.indexOf("TAA" , 3));
       
        if (sub.length() % 3 != 0) {
            return "";
        }
        
        return result;
    }
    
    public void testSimpleGene() {
        String dna = "CTGGACTAA";
        System.out.println ("DNA strand is "+ dna);
        String gene = findSimpleGene(dna);
        System.out.println ("GENE is "+ gene);
        
        dna = "CATGGACTT";
        System.out.println ("DNA strand is "+ dna);
        gene = findSimpleGene(dna);
        System.out.println ("GENE is "+ gene);
        
        dna = "CTGGACTT";
        System.out.println ("DNA strand is "+ dna);
        gene = findSimpleGene(dna);
        System.out.println ("GENE is "+ gene);
        
        dna = "CTAGATGCTGGACTCGTAAGCT";
        System.out.println ("DNA strand is "+ dna);
        gene = findSimpleGene(dna);
        System.out.println ("GENE is "+ gene);
        
        dna = "CTAGATGCTGGACTTGAGTAAGCT";
        System.out.println ("DNA strand is "+ dna);
        gene = findSimpleGene(dna);
        System.out.println ("GENE is "+ gene);
    }

}
