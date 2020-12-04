import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P5_14_15_16
{
    public P5_14_15_16()
    {
        //unused
    }

    //store frequencies rounded to the nearest whole number
    // String for the name
    public static HashMap<BigInteger, String> spectrum = new HashMap<BigInteger, String>();
    public static BigInteger radio = new BigInteger("2900000000");
    public static BigInteger micro = new BigInteger("3000000000");
    public static BigInteger infrared = new BigInteger("300000000000");
    public static BigInteger visible = new BigInteger("400000000000000");
    public static BigInteger ultraviolet = new BigInteger("750000000000000");
    public static BigInteger xray = new BigInteger("30000000000000000");
    public static BigInteger gamma = new BigInteger("30000000000000000000");

    public static String menu = "MENU";

    /**
     * initializes the hashmap of BigIntegers
     */
    public void initLHM()
    {
        spectrum.put(radio, "Radio Waves");
        spectrum.put(micro, "Microwaves");
        spectrum.put(infrared, "Infrared");
        spectrum.put(visible, "Visible Light");
        spectrum.put(ultraviolet, "Ultraviolet");
        spectrum.put(xray, "X - ray");
        spectrum.put(gamma, "Gamma Rays");
    }

    /**
     * runs the command line menu interface
     */
    public static void runMenu()
    {
        Scanner stdin = new Scanner(System.in);
        boolean b = false;
        while(!b)
        {
            System.out.println("Enter a choice exactly as shown on the list.");
            System.out.printf("Choices:\nRadio Waves\nMicrowaves\nInfrared\nVisible Light\nUltraviolet\nX-rays\nGamma rays\n");
            String buffer = stdin.next();
            for(Map.Entry<BigInteger, String> entry : spectrum.entrySet())
            {
                String value = entry.getValue();
                //System.out.println("buffer: "+buffer + " Value: " + value);
                if(buffer.equals(value))
                {
                    System.out.println("Hz: " + entry.getKey());
                    b = true;
                }//else{System.out.println("buffer: "+buffer + " Value: " + value);}
            }
            if(!b)
            {
                System.out.println("Invalid input!");
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        P5_14_15_16 w = new P5_14_15_16();
        w.initLHM();
        //there is an extremely large range in frequencies so we must simplify it
        //like millions of possible numbers
        System.out.println("To see a frequency of a specific wavelength, enter MENU to see the list.");
        String choice = stdin.next();
        if(choice.equals(menu)) //dedicate function to running a menu?
        {
            runMenu();
            System.out.println("Program End!");
            System.exit(2);
        }
        System.out.println("You you chose to manually enter the frequencies!");
        boolean b = false;
        while(!b)
        {
            try
            {
                System.out.println("Please enter the lowest frequency in Hz rounded down to the whole number for the wavelength you want.");
                System.out.println("Such as for Radio Waves: (3 * 10^9) = 2900000000");
                BigInteger buffer;
                buffer = stdin.nextBigInteger();
                String s = spectrum.get(buffer);
                System.out.printf("The wavelength is: %s\n" , s);
                b = true;
            }catch(Exception e)
            {
                System.out.println("ERROR Invalid Frequency!");
            }
        }
        System.out.println("Program End!");
        System.exit(1);
    }
}
