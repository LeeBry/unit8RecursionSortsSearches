import java.util.Scanner;

/**
This class processes baby name records.
 */
public class RecordReader
{
    private double total;
    private double limit;
    private double totalNames;
    private int current;
    /**
    Constructs a RecordReader with a zero total.
     */
    public RecordReader(double aLimit, double totalNames)
    {
        total = 0;
        current =0;
        limit = aLimit;
        totalNames= totalNames;
    }

    /**
    Reads an input record and prints the name if the current total is less 
    than the limit.
    @param in the input stream
     */
    public void process(Scanner in)
    {
        String line= in.nextLine();
        System.out.println(line);
//         String name = in.next();
//         int count = in.nextInt();
//         double percent = count/totalNames;
//         
//         if (total < limit) 
//         {
//             System.out.print(name + " ");
//         }
//         total = total + percent;
//         System.out.println("total: "+total);
    }

    /**
    Checks whether there are more inputs to process
    @return true if the limit has not yet been reached
     */
    public boolean hasMore()
    {
        return total < limit;
    }
}
