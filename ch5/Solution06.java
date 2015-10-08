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
public class Solution06 {
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
        System.out.println("Number of flip operations required: "+convertCount(N,M));
    }
    public static int convertCount(int n, int m)
    {
        int i=n^m;  //  n ex-or m
        // count the number of bits that are 1 in i as those are the number of bits which need to be flipped
        int c=Integer.bitCount(i);
        return c;
    }
}
