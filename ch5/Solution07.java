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
public class Solution07 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter  1st 32-bit binary number N: ");
        String n=sc.next();
        int N=Integer.parseInt(n,2);
        //System.out.println(N);
        int x=swap(N);
        System.out.println("Pairwise swap solution: "+Integer.toBinaryString(x)+" , "+x);
    }
    public static int swap(int n)
    {
        int x=(((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1)); // mask all odd bits and shift right logically and mask all even bits and shift left and merge the two values
        return x;
    }
}
