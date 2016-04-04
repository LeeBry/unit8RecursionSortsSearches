import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Write a description of class Reading here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class moreR 
{

    public static void main (String [] args) throws FileNotFoundException
    {
        String fileName;
        File inputFile= new File("text.txt");
        Scanner s1= new Scanner(inputFile);
        int count=0;
        String word;
        while(s1.hasNext())
        {
            count++;
            word= s1.next();
            System.out.println(word);
        }

    }

}

