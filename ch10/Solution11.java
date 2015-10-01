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
public class Solution11 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the number of elements in array : ");
        int n = sc.nextInt();
        int a[]=new int[n];
        System.out.println("Enter the elements in array: ");
        for(int i=0; i<n; i++)
        {
            System.out.print("Integer "+(i+1)+": ");
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        PeakValley(a);
        System.out.println("Desireed array: ");
        for(int i=0; i<n; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    public static void PeakValley(int a[])
    {
        for(int i=1;i<a.length;i+=2)
        {
            int t=a[i-1];
            a[i-1]=a[i];
            a[i]=t;
        }
    }
}
