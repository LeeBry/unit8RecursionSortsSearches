public class Practice
{
    
    public static int factorial(int n)
    {
        if (n ==0)
        {
          return value;
        }
        else
        {
         int value =n*n;
         n--;
         factorial(n-1);
        }
    }
    public static void main (String[]args)
    {
        Practice.factorial(5);
     }
}