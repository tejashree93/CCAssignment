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
// Referred from book solutions
public class Solution08 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        // main method to test data
    }
    public static void checkDup(int a[])
    {
        BSet b=new BSet(32000);
        for(int i=0;i<a.length;i++)
        {
            int t=a[i];
            int n=t-1;
            if(b.get(n))
                System.out.println(t);
            else
                b.set(n);
        }
    }
}
class BSet
{
    int bit[];
    BSet(int n)
    {
        bit=new int[(n>>5)+1];
    }
    
    boolean get(int i)
    {
        int word_num=(i>>5);
        int b_num=(i & 0x1F);
        return (bit[word_num] & (1<<b_num)) != 0;
    }
    
    void set(int i)
    {
        int word_num=(i>>5);
        int b_num=(i & 0x1F);
        bit[word_num] |= 1 << b_num;
    }
}
