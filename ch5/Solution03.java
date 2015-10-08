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
// referred to book for optimal solution
public class Solution03 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the 32-bit binary number N: ");
        String n=sc.next();
        int N=Integer.parseInt(n,2);
        System.out.println("Longest sequence="+longestSequence(N));
    }
    public static int longestSequence(int n)
    {
        int s[]={0,0,0};    //keeps a track of counts of last three sequences
        int ele=0;
        int ms=1;
        
        for(int i=0;i<32;i++)
        {
            if((n&1)!=ele)
            {
                if(ele==1)  // end of 1s + 0s + 1s sequence
                    ms=Math.max(ms, getMax(s));
                ele=n&1;    //flip the bit
                shift(s);
            }
            s[0]++;
            n>>>=1;
        }
        if(ele==0)
            shift(s);
        return Math.max(ms, getMax(s));
    }
    
    public static int getMax(int s[])
    {
        if(s[1]==1) // if there is one 0 then merge sequences
            return s[0]+s[2]+1;
        else if(s[1]==0)    // if there are no 0s choose the maximum sequence
            return Math.max(s[0], s[2]);    
        else    // if there are more than one 0s, choose side with maximum sequence and flip a bit
            return Math.max(s[0], s[2])+1;
    }
    
    public static void shift(int s[])
    {
        s[2]=s[1];
        s[1]=s[0];
        s[0]=0;
    }
}
