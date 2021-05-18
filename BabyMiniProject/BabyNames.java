
/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames {

    public int totalBirths (FileResource fr) {
        
        int totalGirlsBirth = 0;
        int totalBirth = 0;
        int prevRecord = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            
            totalBirth += 1;
            if (Integer.parseInt(record.get(2)) > prevRecord) {
                totalGirlsBirth = totalBirth - 1; 
            }
            prevRecord = Integer.parseInt(record.get(2));
        }
        int totalBoysBirth = totalBirth - totalGirlsBirth;
        
        /*System.out.println ("Total Births = " + totalBirth);
        System.out.println ("Total Girls Births = " + totalGirlsBirth);
        System.out.println ("Total Boys Births = " + totalBoysBirth);*/
        return totalGirlsBirth;
    }
    
    public int getRank (int year, String name, String gender) {
    
        FileResource fr = new FileResource ("yob"+year+"short.csv");
        int rank = 0;
        
        for (CSVRecord record : fr.getCSVParser()) {
            
            rank = rank + 1;
            
            if (record.get(0).equals(name) && record.get(1).equals(gender)) {
                rank = rank + 1;
                if (gender == "M") {
                    return rank - totalBirths (fr);
                }
                return rank;
            }
        }
        return -1;
    }
    
    public String getName(int year, int rank, String gender) {
        
        FileResource fr = new FileResource ("yob"+year+"short.csv");
        String name = "";
        int currRank = 1;
        int totalGirlsBirth = totalBirths (fr);
        for (CSVRecord record : fr.getCSVParser()) {
            
            currRank += 1;
            
            if (record.get(1).equals(gender)) {
                
                if (gender == "M") {
                    currRank  = currRank - totalGirlsBirth;
                    totalGirlsBirth = 0;
                    
                    if(currRank == rank) {
                        return record.get(0);
                    }
                }
                else {
                    if (currRank == rank) {
                        return record.get(0);
                    }
                }
            }
        }
        return "NO NAME";
    }
    
    public String whatIsNameInYear (String name, int year, int newYear, String gender) {
    
        //FileResource fr1 = new FileResource ("yob"+year+".csv");
        FileResource fr = new FileResource ("yob"+newYear+"short.csv");
        
        int prevRank = getRank (year, name, gender);
        String newName = getName (newYear, prevRank, gender);
        
        return newName;
    }
    
    public int yearOfHighestRank (String name, String gender) {
        
        int rank = 0;
        int maxRank = 0;
        int year = 0;
        int maxYear = 0;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
        
            FileResource fr = new FileResource(f);
            year = Integer.parseInt(f.getName().substring(3,7));
            rank = getRank (year, name, gender);
            
            if (maxRank == 0) {
                maxRank = rank;
                maxYear = year;
            }
            else if (rank < maxRank){
                maxRank = rank;
                maxYear = year;
            }
        }
        if (maxRank != -1) {
            return maxYear;
        }
        return -1;
    }
    
    public Double getAverageRank (String name, String gender) {
    
        double rank = 0;
        double currRank = 0;
        int year = 0;
        double noOfRanks = 0.0;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
        
            FileResource fr = new FileResource(f);
            year = Integer.parseInt(f.getName().substring(3,7));
            currRank = getRank (year, name, gender);
            rank += currRank;
            noOfRanks += 1;
        }
        
        return rank/noOfRanks;
    }
    
    public int getTotalBirthsRankedHigher (int year, String name, String gender) {
    
            FileResource fr = new FileResource ("yob"+year+"short.csv");
            int totalBirths = 0;
            
            for (CSVRecord record : fr.getCSVParser()) {
                
                if (gender == "M" && record.get(1).equals(gender)){
                    if(record.get(0).equals(name)) {
                        break;
                    }
                    totalBirths += Integer.parseInt(record.get(2));
                }
                else if (gender == "F" && record.get(1).equals(gender)) {
                    if(record.get(0).equals(name)) {
                        break;
                    }
                    totalBirths += Integer.parseInt(record.get(2));
                }
            }
            return totalBirths;
    }
    
    public void testTotalBirth () {
    
        FileResource fr = new FileResource();
        totalBirths (fr);
    }
    
    public void testGetRank () {
    
        System.out.println (getRank(1940, "Clearance", "M"));
    }
    
    public void testGetName () {
    
        System.out.println (getName(1940, 2000, "M"));
    }
    
    public void testWhatIsNameInYear () {
        
        String name = whatIsNameInYear ("Ethan", 2012, 2014, "M");
        System.out.println ("Ethan born in 2012 would be "+name+" if he was born in 2014.");
    }
    
    public void testYearOfHighestRank () {
    
        System.out.println (yearOfHighestRank("Mason", "M"));
    }
    
    public void testGetAverageRank () {
    
        System.out.println (getAverageRank("Jacob", "M"));
    }
    
    public void testGetTotalBirthsRankedHigher () {
    
        System.out.println (getTotalBirthsRankedHigher(2012, "Ethan", "M"));
    }
}
