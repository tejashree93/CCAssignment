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
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the number of elements in array 1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter the number of elements in array 2: ");
        int n2 = sc.nextInt();
        int a[]=new int[n1+n2];
        int b[]=new int[n2];
        System.out.println("Enter the elements in array 1: ");
        for(int i=0; i<n1; i++)
        {
            System.out.print("Integer "+(i+1)+": ");
            a[i]=sc.nextInt();
        }
        System.out.println();
        System.out.println("Enter the elements in array 2: ");
        for(int i=0; i<n2; i++)
        {
            System.out.print("Integer "+(i+1)+": ");
            b[i]=sc.nextInt();
        }
        mergeSort(a,b);
        System.out.println();
        System.out.println("Merged and Sorted elements of the two arrays are: ");
        for(int i=0; i<a.length; i++)
        {
            System.out.println("Integer "+(i+1)+": "+a[i]);
        }
    }
    
    public static void mergeSort(int a[], int b[])
    {
        int i=a.length-b.length-1;
        int j=b.length-1;
        int k=a.length-1;
        while(j>=0)
        {
            if(i>=0 && a[i]>b[j])
                a[k--] = a[i--];
            else
                a[k--] = b[j--];
        }
    }
}

