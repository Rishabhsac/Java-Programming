
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class part1 {
    
    public String countryInfo (CSVParser parser, String country) {
        
        String countryInfo = "";
        for (CSVRecord record : parser) {
            
            if (record.get("Country").contains(country)) {
                
                countryInfo = country + ": " + record.get ("Exports") + ": " + record.get ("Value (dollars)");
                return countryInfo;
            }
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2) {
        
        for (CSVRecord record : parser) {
            
            if (record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)) {
                
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters (CSVParser parser, String exportItem) {
        
        int count = 0;
        for (CSVRecord record : parser) {
            
            if (record.get("Exports").contains(exportItem)) {
                count += 1;
            }
        }
        return count;
    }
    
    public void bigExporters (CSVParser parser, String amount) {
        
        for (CSVRecord record : parser) {
            
            if (record.get("Value (dollars)").length() > amount.length()) {
                
                System.out.println (record.get("Country") + " " + record.get("Value (dollars)"));
            }

        }
    }
    
    public void tester () {
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser ();
        //System.out.println(countryInfo (parser, "Nauru"));
        //listExportersTwoProducts (parser, "fish", "nuts");
        //System.out.println(numberOfExporters (parser, "sugar"));
        bigExporters (parser, "$999,999,999,999");
    }
}
