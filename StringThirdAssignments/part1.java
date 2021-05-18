
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class part1 {
    
    public int findStopCodon (String dna, int startIndex, String stopCodon) {
        
        int stopIndex = dna.indexOf(stopCodon, startIndex + 1);
        
        if (stopIndex == -1) {
            return -1;
        }
        
        int diff = stopIndex - startIndex;
        
        if (diff % 3 == 0) {
            return stopIndex;
        }
        
        return -1;
    }
    
    public String findGene (String dna , int where) {
        
        int startIndex = dna.indexOf("ATG", where);
        
        if (startIndex == -1) {
            return "";
        }
        
        int taaIndex = findStopCodon (dna, startIndex, "TAA");
        int tagIndex = findStopCodon (dna, startIndex, "TAG");
        int tgaIndex = findStopCodon (dna, startIndex, "TGA");
        
        int minIndex = 0; 
        if (taaIndex == -1 || (tagIndex != -1 && tagIndex < taaIndex)) {
            minIndex = tagIndex;
        }
        else {
            minIndex = taaIndex;
        }
        
        if (minIndex == -1 || (tgaIndex != -1 && tgaIndex < minIndex)) {
            minIndex = tgaIndex;
        }
        
        if (minIndex == -1) {
            return "";
        }
        
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public StorageResource getAllGenes (String dna) {
        
        int startIndex = 0;
        String currGene = "";
        
        StorageResource geneList = new StorageResource();
        
        while (true) {
            currGene = findGene (dna, startIndex);
            
            if (currGene.isEmpty()) {
                break;
            }
            geneList.add(currGene);
            startIndex = dna.indexOf(currGene,startIndex) + currGene.length();
        }
        return geneList;
    }
    
    public void testStorageResource (String dna) {
        
        StorageResource genes = new StorageResource();
        genes = getAllGenes(dna);
        for (String g : genes.data()) {
            System.out.println(g);
        }
        
      /*String dna;
      dna = "TCGTGCCTGGTACAT";
      System.out.println ("Dna is " + dna);
      System.out.println ("Dna is " + getAllGenes (dna));
      
      dna = "TCGATGCCGTAAGGTACAT";
      System.out.println ("Dna is " + dna);
      printAllGenes (dna);
      
      dna = "TCGATGCCGTAAATGGGCTAGAGCTGA";
      System.out.println ("Dna is " + dna);
      printAllGenes (dna);
      
      dna = "TCGATGCGTAAGCTAGACCTGAC";
      System.out.println ("Dna is " + dna);
      printAllGenes (dna);*/
    }

}

