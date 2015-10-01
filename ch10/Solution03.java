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
public class Solution03 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the number of elements in array : ");
        int n = sc.nextInt();
        int a[]=new int[n];
        System.out.println("Enter the elements in array in rotated sorted order : ");
        for(int i=0; i<n; i++)
        {
            System.out.print("Integer "+(i+1)+": ");
            a[i]=sc.nextInt();
        }
        System.out.println("Enter the element you want to search");
        int x=sc.nextInt();
        int index=searchRotatedArray(a,x);
        if(index!=-1)
            System.out.println("Position of element is: "+index);
        else
            System.out.println("Element not found");
    }
    
    public static int searchRotatedArray(int a[], int x)
    {
        int part=0;
        for(int i=0; i<a.length-1;i++)
        {
            if(a[i]>a[i+1])
            {
              part=i;  
              break;
            }
        }
        if(part==0)
            return binarysearch(0, a.length-1,a,x);
        if(a[0]==x)
            return 0;
        else if(a[0]<x)
            return binarysearch(1,part,a,x);
        else if(a[0]>x)
            return binarysearch(part+1, a.length-1,a,x);
        return -1;
    }
    
    public static int binarysearch(int l, int r, int a[], int x)
    {
        if(l<=r)
        {
            int m=(l+r)/2;
            if(a[m]==x)
                return m;
            else if(x<a[m])
                return binarysearch(l,m-1,a,x);
            else
                return binarysearch(m+1,r,a,x);
        }
        return -1;
    }
}
