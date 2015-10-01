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
 // Referred from book solution
public class Solution07 {
    static long numInts=((long)Integer.MAX_VALUE)+1;
    static byte bf[]=new byte[(int)(numInts/8)];
    static String filename=""; // specify the file name in double quotes
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        // main method to test data
    }
    
    public static void findOpenNumber() throws FileNotFoundException
    {
        Scanner sc=new Scanner (new FileReader(filename));
        while(sc.hasNextInt())
        {
            int n=sc.nextInt();
            bf[n/8]|= 1<<(n%8);
        }
        for(int i=0;i<bf.length;i++)
        {
            for(int j=0;j<8;j++)
            {
                if((bf[i]&(1<<j))==0)
                {
                    System.out.println(i*8+j);
                    return;
                }
            }
        }
    }
}
