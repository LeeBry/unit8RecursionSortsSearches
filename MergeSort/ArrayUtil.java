import java.util.Random;
import java.util.Arrays;

/**
   This class contains utility methods for array manipulation.
*/  
public class ArrayUtil
{ 
   private static Random generator = new Random();
   private static String list= "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
   /**
      Creates an array filled with random values.
      @param length the length of the array
      @param n the number of possible random values
      @return an array filled with length numbers between
      0 and n - 1
   */
   public static int[] randomIntArray(int length, int n)
   {  
      int[] a = new int[length];      
      for (int i = 0; i < a.length; i++)
      {
         a[i] = generator.nextInt(n);
      }
      
      return a;
   }

   /**
      Swaps two entries of an array.
      @param a the array
      @param i the first position to swap
      @param j the second position to swap
   */
   public static void swap(int[] a, int i, int j)
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
   
   public static String [] randomStringArray( int length, int numChars)
   {
       String[] list = new String[length];
       String word;
       Random gen= new Random();
       int randInt;
       for (int i=0; i<length; i++)
       {
           
           for(int j=0; j<numChars; j++)
           {
               randInt= gen.nextInt(list.length);
               //word+= 
           }
           //list[i]= word;
       }
       
       return list;
   }
    
   //private static String randomString(int numChars)
   //{
    //}
}
      
