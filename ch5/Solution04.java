/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author Tejashree pc
 */
public class Solution04 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the 32-bit binary number N: ");
        String n=sc.next();
        int N=Integer.parseInt(n,2);
        System.out.println(N);
        int sol[]=next(N);
        System.out.println("Using brute force: "+sol[0]+" , "+sol[1]);
        System.out.println("By bit manipulation: "+nextNum(N)+" , "+previousNum(N));
    }
    
    public static int[] next(int n)   //brute force solution
    {
        int sol[]=new int[2];
        for(int i=n-1;i>=0;i--)
        {
            if(Integer.bitCount(i)==Integer.bitCount(n))
            {
                sol[0]=i;   // store next number < n which has same count of 1s as n in sol[0] 
                break;
            }
        }
        for(int i=n+1;i<=Integer.MAX_VALUE;i++)
        {
            if(Integer.bitCount(i)==Integer.bitCount(n))
            {
                sol[1]=i;   // store next number > n which has same count of 1s as n in sol[0] 
                break;
            }
        }
        return sol;
    }
    //Referred to book
    public static int nextNum(int n)    // getting number larger than n 
    {
        int m=n;
        int c0=0, c1=0;
        while(((m&1)==0)&&(m!=0))
        {
            c0++;
            m>>=1;
        }
        while((m&1)==1)
        {
            c1++;
            m>>=1;
        }
        if(c0+c1==31||c0+c1==0)
            return -1;
        int a=c0+c1;
        n=n|(1<<a);
        n=n & ~((1<<a)-1);
        n=n | (1<<(c1-1))-1;
        return n;
    }
    // Reffered from book
    public static int previousNum(int n)    // getting number smaller than n
    {
        int m=n;
        int c0=0, c1=0;
        while((m&1)==1)
        {
            c1++;
            m>>=1;
        }
        if(m==0)
            return -1;
        while(((m&1)==0)&&(m!=0))
        {
            c0++;
            m>>=1;
        }
        int a=c0+c1;
        n=n & ((~0)<<(a+1));
        int mask=(1<<(c1+1))-1;
        n=n | (mask<<(c0-1));
        return n;
    }
}
