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
public class Solution08 {
    public static void main (String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns in the matrix");
        int m=sc.nextInt();
        int n=sc.nextInt();
        int mat[][]=new int[m][n];
        System.out.println("Enter the elements in the matrix, values should be greater than or equal to zero: "); // Assume that all the entered values are equal to or greater than zero
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                mat[i][j]=sc.nextInt();
            }
        }
        int nm[][]=makeZeroMatrix(mat);
        display(nm);
    }
    
    public static int[][] makeZeroMatrix(int mat[][])
    {
        int m=mat.length,n=mat[0].length;
        int nm[][]=new int[m][n];           // matrix that will be returned as a result
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                nm[i][j]=-1;        // set value of all elements in matrix to -1 so that there won't be ambiguity while converting rows and columns to 0
            }                       // Assuming that all the entered values are equal to or greater than zero
        }
        outer: for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j]==0)
                {
                    rowZero(nm,i);  // makes row corresponding to the 0 element 0
                    colZero(nm,j);  // makes column corresponding to the 0 element 0
                    continue outer;
                }
                else if(nm[i][j]!=0)        // if element is not zero then copy the non-zero value to the new matrix
                    nm[i][j]=mat[i][j];
            }
        }
        return nm;
    }
    
    public static void display(int nm[][])
    {
        for(int i=0; i<nm.length; i++)
        {
            for(int j=0; j<nm[0].length; j++)
            {
                System.out.print(nm[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void rowZero(int nm[][], int r)
    {
        for(int i=0; i<nm[r].length; i++)
            nm[r][i]=0;
    }
    public static void colZero(int nm[][], int c)
    {
        for(int i=0; i<nm.length; i++)
            nm[i][c]=0;
    }
}
