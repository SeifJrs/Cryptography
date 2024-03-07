import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console=new Scanner(System.in);
        System.out.println("Enter TWO distinct upper limits for the two primes p,q");
        int upperlimit=1000;
        System.out.println("Upper limit for p:"+upperlimit);
        int upperlimit2=5000;
        System.out.println("Upper limit for q:"+upperlimit2);
        int p=997;
        int q=4999;
        System.out.println("P="+p);
        System.out.println("q="+q);
        int n=p*q;
        System.out.println("n="+n);
        int m=(p-1)*(q-1);
        System.out.println("m="+m);
        int e;
        for (e = 2; e < m; e++) {
            if (gcd(e, m) == 1) {
                break;
            }
        }                                                             //I Use BIGInteger and BigDecimal Because when i try
        System.out.println("e=" + e);                                 //to make the d power to any number
                                                                      // the result give me NaN
        int d = 0;                                                    //when I used them the result give me a real answer
        for (int k = 0; k <=100 ; k++) {
            int upper=(m*k)+1;
            if (upper%e==0) {
                d=upper/e;
                break;
            }
        }
        System.out.println("d="+d);
        System.out.print("Enter The Original message:");
        String s= console.next();
        BigInteger N=BigInteger.valueOf(n);
        ArrayList<BigInteger>cipher=new ArrayList<>();                         //Make array list to take the Cipher
                                                                               // message of each ascii code
        for (int i = 0; i <s.length() ; i++) {
            int ascii=s.charAt(i);
            BigInteger Plain=BigDecimal.valueOf(ascii).toBigInteger();
            BigInteger c=(Plain.pow(e).mod(N));                                 //uses pow and mod bec Math.pow can't
                                                                                // Take BigIntegers and % too
            cipher.add(c);
        }
        System.out.println("Cipher Message:"+cipher);
        System.out.print("Descryption Message:");
        for (int i = 0; i < cipher.size() ; i++) {
            BigInteger a=cipher.get(i);
            BigInteger descrypt=(a.pow(d).mod(N));
            int des=descrypt.intValue();                                     //intvalue to convert BigInteger to int
            char descryption= (char) des;                                   //Bec we cant get the char from BigInteger
            System.out.print(descryption);                                  //it must be int
        }
   }
    static int gcd(int e, int m)                       //a method to calculate gcf
    {
        if (e == 0)                                    //Note:It takes time to calculate the output
            return m;
        else
            return gcd(m % e, e);
    }
}