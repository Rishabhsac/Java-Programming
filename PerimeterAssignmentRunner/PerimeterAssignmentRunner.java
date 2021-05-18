import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
        
        for (Point pt : s.getPoints())
        {
            count++;
        }
        
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double averageLength = (getPerimeter(s)/getNumPoints(s));
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double maxLength = 0.0;
        Point prevPt = s.getLastPoint();
        
        for (Point currPt : s.getPoints()) {
            double currDt = prevPt.distance(currPt);
            
            if (currDt > maxLength)
            {
                maxLength = currDt;
            }
            
            prevPt = currPt;
        }
        
        return maxLength;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double x =0.0;
        
        for (Point currPt : s.getPoints()) {
            
            double ax = currPt.getX();
            
            if (x < ax){
                x = ax;
            }
        }
        return x;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double lastPerim = 0.0;
        
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double prevPerim = getPerimeter(s);
            
            if (prevPerim > lastPerim)
            {
                lastPerim = prevPerim;
            }
        }
        return lastPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double lastPerim = 0.0;
        File ff = null;
        
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double prevPerim = getPerimeter(s);
            
            if (prevPerim > lastPerim)
            {
                lastPerim = prevPerim;
                ff = f;
            }
        }
        return ff.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("No of points = " + getNumPoints(s));
        System.out.println("Average length = " + getAverageLength(s));
        System.out.println("Largest Side = " + getLargestSide(s));
        System.out.println("Largest X Coordinate = " + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("\nLargest Perimeter = " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("\nFile having Largest Perimeter = " + getFileWithLargestPerimeter());
    }
    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("\nperimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
