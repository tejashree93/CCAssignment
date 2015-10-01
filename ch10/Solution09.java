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
public class Solution09 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the number of rows:");
        int r=sc.nextInt();
        System.out.println("Enter the number of columns:");
        int c=sc.nextInt();
        int a[][]=new int[r][c];
        System.out.print("Enter the elements in sorted order");
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.print("Enter element at ("+i+","+j+") position: ");
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the element you want to search");
        int x=sc.nextInt();
        int f[]=search(a,x);
        if(f==null)
            System.out.println("Element not found");
        else
            System.out.println("Element found at ("+f[0]+","+f[1]+") position !");
    }
    public static int[] search(int a[][], int x)
    {
        int f[]=new int[2];
        boolean flag=false;
        int r=0;
        int c=a[0].length-1;
        while(r<a.length&&c>=0)
        {
            if(a[r][c]==x)
            {
                f[0]=r;
                f[1]=c;
                flag=true;
                break;
            }
            else if(x<a[r][c])
                c--;
            else if(x>a[r][c])
                r++;
        }
        if(flag)
            return f;
        else
            return null;
    }
}
