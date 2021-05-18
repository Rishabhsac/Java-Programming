
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part4 {

    public String findLinks (String urlFile) {
        
        int urlIndex = urlFile.indexOf("youtube.com");
        
        if (urlIndex != -1) {
            
            int sIndex = urlFile.lastIndexOf("\"");
            int eIndex = urlFile.indexOf("\"" , urlIndex + 1);
            String link = urlFile.substring (sIndex , eIndex + 1);
            return link;
        }
    return "no links";
}
    
    public void testlink () {
        URLResource url = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        
        for (String words : url.words()) {
            System.out.println(words);
        }
    }
    
    public static void main(String[] args){
        Part4 ur = new Part4();
   
        ur.testlink();
    }
}
