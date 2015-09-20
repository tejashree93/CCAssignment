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
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the Number of rows and columns in the N x N matrix:");
        int n=sc.nextInt();
        Object mat[][]=new Object[n][n];
        System.out.println("Enter the pixels in the matrix:");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print("Enter pixel at "+i+" and "+j+" position:");
                mat[i][j]=(Object)sc.next();
            }
        }
        display(mat,n);
        rotate90Right(mat,n);
        System.out.println("Rotated pixel positions by 90 degrees left are:");
        display(mat,n);
        rotate90Left(mat,n);
        System.out.println("Rotated pixel positions by 90 degrees right are:");
        display(mat,n);
    }
    public static void rotate90Right(Object mat[][],int n)
    {
        for(int i=0;i<n/2;i++)
        {
            int e=n-1-i;
            for(int j=i;j<e;j++)
            {
                int p=j-i;
                Object F_left=mat[i][j];
                mat[i][j]=mat[e-p][i];
                mat[e-p][i]=mat[e][e-p];
                mat[e][e-p]=mat[j][e];
                mat[j][e]=F_left;
            }
        }
    }
    
    public static void rotate90Left(Object mat[][],int n)
    {
        for(int i=0;i<n/2;i++)
        {
            int e=n-1-i;
            for(int j=i;j<e;j++)
            {
                int p=j-i;
                Object F_left=mat[j][i];
                mat[j][i]=mat[i][e-p];
                mat[i][e-p]=mat[e-p][e];
                mat[e-p][e]=mat[e][j];
                mat[e][j]=F_left;
            }
        }
    }
    
    public static void display(Object mat[][], int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
