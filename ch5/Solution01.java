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
public class Solution01 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter  1st 32-bit binary number N: ");
        String n=sc.next();
        int N=Integer.parseInt(n,2);
        //System.out.println(N);
        System.out.print("Enter 2nd 32-bit binary number M: ");
        String m=sc.next();
        int M=Integer.parseInt(m,2);
        //System.out.println(M);
        System.out.print("Enter  bit position j: ");
        int j=sc.nextInt();
        System.out.print("Enter  bit position i: ");
        int i=sc.nextInt();
        int ans=insert(M,N,i,j);
        if(ans==Integer.MIN_VALUE)
            System.out.println("Cant insert!");
        else
            System.out.println("New number is : "+ans+"and its  binary representation is "+Integer.toBinaryString(ans));
    }
    
    public static int createMask(int j, int i)
    {
        int one=~0;
        //System.out.println("one : "+Integer.toBinaryString(one));
        int l=one<<(j+1);       // 1s before position j and 0s from position j
        //System.out.println("l : "+Integer.toBinaryString(l));
        int r=one>>>(32-i);     // 1s after position i and 0s from and before i
        //System.out.println("r : "+Integer.toBinaryString(r));
        int mask= l|r;          // mask with bit positions between and including i and j initialized to 0s
        //System.out.println("mask : "+Integer.toBinaryString(mask));
        return mask;
    }
    
    public static int insert(int m, int n, int i, int j)
    {
        if(j-i+1<5)
            return Integer.MIN_VALUE;
        int mask=createMask(j,i);
        int ncleared=n & mask;  // clear bit positions between j and i including them
        //System.out.println("ncleared : "+Integer.toBinaryString(ncleared));
        int new_m=m<<i;         // Make M ready to be inserted by making the i-1 bits 0s
        //System.out.println("new m : "+Integer.toBinaryString(new_m));
        int merged=ncleared|new_m;
        //System.out.println("merged : "+Integer.toBinaryString(merged));
        return merged;
    }
}
