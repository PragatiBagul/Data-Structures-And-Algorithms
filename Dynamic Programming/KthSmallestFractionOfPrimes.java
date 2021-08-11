//You have a sorted list of prime numbers including 1. 
//For every p < q , in the list we define fractions of primes as p/q. 
//Find the kth smallest fraction.

import java.util.*;

public class KthSmallestFractionOfPrimes {
    
    private static class Fraction
    {
        double value;
        int numerator;
        int denominator;

        Fraction(double value,int numerator,int denominator)
        {
            this.denominator = denominator;
            this.numerator = numerator;
            this.value = value; 
        }
    }

    public static Fraction kthSmallestFraction(int[] primes,int k) {
        PriorityQueue<Fraction> pq = new PriorityQueue<Fraction>();
        for (int i = 0; i < primes.length - 1; i++)
        {
            int numerator = primes[i];
            int denominator = primes[primes.length - 1];
            pq.add(new Fraction((double)numerator/denominator, numerator, denominator));
        }
        while (k > 1)
        {
            --k;
            Fraction t = pq.remove();
            t.denominator = t.denominator - 1;
            pq.add(new Fraction((double)t.numerator/t.denominator, t.numerator, t.denominator));
        }
        return pq.remove();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] primes = new int[N];
        for(int i=0;i<N;i++)
        {
            primes[i] = sc.nextInt();
        }

        Fraction ans = kthSmallestFraction(primes,K);
        System.out.println("Numerator :  "+ans.numerator+"Denominator :  "+ans.denominator+"Answer :  "+ans.value);
    }
}
