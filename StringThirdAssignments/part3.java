
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.File;

public class part3 {
    
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
    
    public void processGenes (StorageResource sr) {
        
        int nineCount = 0;
        int cgCount = 0;
        int sixtyCount = 0;
        String longestGene = "";
        
        
        System.out.println ("Strings having length greater than 60 are -:");
        for (String g : sr.data()) {
            
            if (g.length() > 60) {
                
                System.out.println (g);
                sixtyCount += 1;
            }
        }
        System.out.println ("No of Strings having length greater than 60 are -:" + sixtyCount);
        
        System.out.println ("Strings having length greater than 9 are -:");
        for (String g : sr.data()) {
            
            if (g.length() > 9) {
                
                System.out.println (g);
                nineCount += 1;
            }
        }
        System.out.println ("No of Strings having length greater than 9 are -:" + nineCount);
        
        System.out.println ("Strings having CG ratio higher than than 0.35 are -:");
        for (String ge : sr.data()) {
            
            if (cgRatio(ge) > 0.35) {
                
                System.out.println (ge);
                cgCount += 1;
            }
            
            if (ge.length() > longestGene.length()) {
                
                longestGene = ge;
            }
        }
        System.out.println ("No of Strings having CG ratio higher than than 0.35 are -:" + cgCount);
        System.out.println ("Longest Gene is " + longestGene);
    }
    
    public void testProcessGenes () {
        
        StorageResource sr = new StorageResource();
        FileResource fr = new FileResource();
        String dna = fr.asString();
        dna = dna.toUpperCase();
        sr = getAllGenes (dna);
        processGenes(sr);
        
        /*dna = "cfgvjhgbgcgbbCGAATGCGTTAGCCAATGTGACGTfgyghnmvgf";
        sr = getAllGenes (dna);
        System.out.println ("\nDNA is " + dna);
        processGenes (sr);
        
        dna = "gfghfgjkhjgvCGTATGCCGCGTTAACGAATGGCvghCGTATGAGCgyfg";
        sr = getAllGenes (dna);
        System.out.println ("\nDNA is " + dna);
        processGenes (sr);
        
        dna = "TAGATGTATTAACGAATGTAACGT";
        sr = getAllGenes (dna);
        System.out.println ("\nDNA is " + dna);
        processGenes (sr);*/
        
        
    }

}
