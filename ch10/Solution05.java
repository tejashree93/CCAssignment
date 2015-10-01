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
//referred to solution in book
public class Solution05 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the number of strings in array : ");
        int n = sc.nextInt();
        String a[]=new String[n];
        System.out.println("Enter the strings : ");
        for(int i=0; i<n; i++)
        {
            System.out.println("Enter / for empty string: String "+(i+1)+": ");
            String s=sc.next();
            if(s.equals("/"))
            {
                a[i]="";
                continue;
            }
            a[i]=s;
        }
        System.out.println("Enter the string you want to search");
        String x=sc.next();
        int index=search(a,0,n-1,x);
        if(index>=0)
            System.out.println("Position of string is: "+index);
        else
            System.out.println("String not found");
    }
    
    public static int search(String a[], int l, int r, String x)
    {
        if(a==null||x==null||x=="")
            return -1;
        if(l<=r)
        {
            int m=(l+r)/2;
            if(a[m].isEmpty())
            {
                int low = m-1;
                int high = m+1;
                while(true)
                {
                    if(low<l&&high>r)
                        return -1;
                    else if(high<=r && !a[high].isEmpty())
                    {
                        m=high;
                        break;
                    }
                    else if(low>=l && !a[low].isEmpty())
                    {
                        m=low;
                        break;
                    }
                    low++;
                    high--;
                }
            }
            
            if(x.equals(a[m]))
                return m;
            else if(a[m].compareTo(x)<0)
                return search(a, m+1, r, x);
            else
                return search(a, l, m-1, x);
        }
        return -1;
    }
}
