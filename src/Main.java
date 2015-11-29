import java.util.Scanner;

public class Main
{
    private static int[] primeCandidates;
    private static int upperLimit;

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("This finds primes between 1 and n. Enter n:");

        try
        {
            upperLimit = input.nextInt();
            primeCandidates = new int[upperLimit];

            for (int i = 2; i <= upperLimit; i++)
            {
                primeCandidates[i - 2] = i;
            }

            for (int i = 0; i < Math.sqrt(upperLimit); i++)
            {
                if (primeCandidates[i] != 0)
                {
                    for (int j = i + primeCandidates[i]; j < upperLimit; j += primeCandidates[i])
                    {
                        primeCandidates[j] = 0;
                    }
                }
            }

            if (primeCandidates.length == 0)
            {
                System.out.println("No primes found between 1 and " + upperLimit + ".");
            }

            for (int prime : primeCandidates)
            {
                if (prime != 0)
                {
                    System.out.println(prime);
                }
            }
        }
        catch (Throwable e)
        {
            System.out.println("Invalid value for n.");
        }
    }
}
