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
        String word;
        String line;
        String fileName;
        Scanner scan= new Scanner(System.in); //Scanner
        System.out.println("Please provide the file: ");
        fileName= scan.nextLine();
        File inputFile= new File(fileName);
        Scanner s1= new Scanner(inputFile); //Scanner
        Scanner s2= new Scanner(inputFile);//Scanner
        Scanner s3= new Scanner(inputFile);
        //s1.useDelimiter(" ");
        while (s1.hasNext())
        {
            words++;  
            s1.next();
        }
        
        while (s2.hasNextLine())
        {
            lines++;
            s2.nextLine();
        }
        
        while (s3.hasNext())
        {
          s3.useDelimiter("");// Lines count as 2 charcters
          characters++;
          s3.next();
          
        }
        System.out.println("This file has "+ words+" Word(s)");
        System.out.println(lines+" Line(s)");
        System.out.println(characters+ " Character(s)");
       
    }
}
