import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNames
{
   public static final double LIMIT = 50;

   public static void main(String[] args) throws FileNotFoundException
   {  
      // 21,250,677 male births and 20,297,093 female births.
      Scanner scan= new Scanner (System.in);
      System.out.println("File name: ");
      File nameFile= new File(scan.nextLine());
      Scanner in = new Scanner(nameFile);
      int maleBirth= 21250677;
      int femaleBirth= 20297093;
      System.out.println("maleBirth: "+maleBirth+" femaleBirth: "+femaleBirth);
      RecordReader boys = new RecordReader(LIMIT, maleBirth);
      RecordReader girls = new RecordReader(LIMIT, femaleBirth);
      
//       while (boys.hasMore() || girls.hasMore())
//       {
//          int rank = in.nextInt();
//          System.out.print(rank + " ");
//          boys.process(in);
//          girls.process(in);
//          System.out.println();
//       }
   int count=0;
        while(count !=10)
        {
            System.out.println(in.nextLine());
            count++;
        }
      in.close();
   }
}   
