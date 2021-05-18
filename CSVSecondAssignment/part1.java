
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class part1 {

    public CSVRecord coldestHourInFile (CSVParser parser) {
        
        CSVRecord smallestSoFar = null;
        
        for (CSVRecord currRow : parser) {
            smallestSoFar = smallestInTwo (currRow, smallestSoFar);
        }
        return smallestSoFar;
    }
    
    public String fileWithColdestTemperature () {
        
        CSVRecord smallestSoFar = null;
        CSVRecord currRow = null;
        File fileName = null;
        DirectoryResource dr = new DirectoryResource ();
        
        for (File f : dr.selectedFiles()) {
            
            FileResource fr = new FileResource (f);
            currRow = coldestHourInFile(fr.getCSVParser());
            smallestSoFar = smallestInTwo (currRow, smallestSoFar);
        }
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource (f);
            if (currRow == smallestSoFar) {
                fileName = f;
            }
        }
        return fileName.getName();
    }
    
    public CSVRecord lowestHumidityInFile (CSVParser parser) {
    
        CSVRecord lowestSoFar = null;
        
        for (CSVRecord currRow : parser) {
        
            lowestSoFar = lowestInTwo (currRow, lowestSoFar);
        }
        return lowestSoFar;
    }
    
    public CSVRecord lowestHumidityInManyFiles () {
    
        CSVRecord lowestSoFar = null;
        CSVRecord currRow = null;
        DirectoryResource dr = new DirectoryResource ();
        
        for (File f : dr.selectedFiles()) {
            
            FileResource fr = new FileResource (f);
            currRow = lowestHumidityInFile(fr.getCSVParser());
            lowestSoFar = lowestInTwo (currRow, lowestSoFar);
        }
        
        return lowestSoFar;
    }
    
    public Double averageTemperatureInFile (CSVParser parser) {
       
        double totalTemp = 0.0;
        
        for (CSVRecord record : parser) {
        
            totalTemp = totalTemp + Double.parseDouble(record.get ("TemperatureF"));
        }
        return totalTemp/24.0;
    }
    
    public Double averageTemperatureWithHighHumidityInFile (CSVParser parser, int value) {
        
        double totalTemp = 0.0;
        int noOfTemp = 0;
        int count = 0;
        
        for (CSVRecord record : parser) {
            
            if(Integer.parseInt(record.get("Humidity")) >= value) {
                totalTemp = totalTemp + Double.parseDouble(record.get ("TemperatureF"));
                noOfTemp = noOfTemp + 1;
                count = 1;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return totalTemp/noOfTemp;
    }
    
    public CSVRecord smallestInTwo (CSVRecord currRow , CSVRecord smallestSoFar) {
        
        double currTemp = 0.0;
        double smallestTemp = 0.0;
        if (smallestSoFar == null) {
            smallestSoFar = currRow;
        }
        else {
            if (currRow.get("TemperatureF") != "-9999" && smallestSoFar.get("TemperatureF") != "-9999") {
            currTemp = Double.parseDouble(currRow.get("TemperatureF"));
            smallestTemp = Double.parseDouble (smallestSoFar.get("TemperatureF"));
            }
            
            if (currTemp < smallestTemp) {
                smallestSoFar = currRow;
            }
        }
        return smallestSoFar;
    }
    
    public CSVRecord lowestInTwo (CSVRecord currRow , CSVRecord lowestSoFar) {
        
        int currHumidity = 0;
        int lowestHumidity = 0;
        if (lowestSoFar == null) {
            lowestSoFar = currRow;
        }
        else {
            if (currRow.get("Humidity").contains("N/A") && lowestSoFar.get("Humidity").contains("N/A")) {
            currHumidity = Integer.parseInt(currRow.get("Humidity"));
            lowestHumidity = Integer.parseInt(lowestSoFar.get("Humidity"));
            }
            
            if (currHumidity < lowestHumidity) {
                lowestSoFar = currRow;
            }
        }
        return lowestSoFar;
    } 
    
    public void testColdestHourInFile() {
        
        FileResource fr = new FileResource ();
        CSVRecord smallest =  coldestHourInFile(fr.getCSVParser());
        System.out.println (smallest.get("TemperatureF"));
    }
    
    public void testFileWithColdestTemperature() {
        
        String fileName = fileWithColdestTemperature ();
        FileResource fr = new FileResource (fileWithColdestTemperature ());
        CSVRecord smallest =  coldestHourInFile(fr.getCSVParser());
        System.out.println ("Coldest day was in file " + fileName);
        System.out.println ("Coldest temperature on that day was " + smallest.get("TemperatureF"));
        System.out.println ("All the Temperatures on the coldest day were:");
        
        for (CSVRecord record : fr.getCSVParser()) {
            
            System.out.println (record.get("DateUTC") + ": " + record.get ("TemperatureF"));
        }
        
    }
    
    public void testLowestHumidityInFile() {
    
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        
        System.out.println ("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    
    public void testLowestHumidityInManyFiles() {
    
        CSVRecord lowest = lowestHumidityInManyFiles ();
        System.out.println ("Lowest Humidity was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
    }
    
    public void testAverageTemperatureInFile() {
    
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Average Temperature in file is " + averageTemperatureInFile(parser));
    }
    
    public void testAverageTemperatureWithHighHumidityInFile() {
    
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avg = averageTemperatureWithHighHumidityInFile(parser, 80);
        
        if (avg == 0.0) {
            System.out.println ("No temperature with that humidity");
        }
        
        else {
        System.out.println("Average Temperature in file is " + avg);
        }
    }
}
