import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Write a description of class Reading here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reading
{
    public static void main (String [] args) throws FileNotFoundException
    {
        int words=0;
        int lines=0;
        int characters=0;
       
        Scanner scan= new Scanner(System.in);
        System.out.println("Please provide the file: ");
        File inputFile= new File(scan.nextLine());
        Scanner s1= new Scanner(inputFile);
        Scanner s2= new Scanner(inputFile);
        s1.useDelimiter(" ");
        while (s1.hasNext())
        {
            words+=1;        
            s1.next();
        }
        
        while (s2.hasNextLine())
        {
            lines+=1;
            s2.nextLine();
        }
        System.out.println("This file has "+ words+ " word(s)"+"\n"+" And"+lines+"Lines");
       
    }
}
