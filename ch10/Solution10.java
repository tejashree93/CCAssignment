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
 // Referred from book
public class Solution10 {
    static TNode1 root = null;
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
        for(int i=0; i<n; i++)
        {
            track(a[i]);
        }
        for(int i=0; i<n; i++)
        {
            System.out.println("The rank of "+a[i]+" is: "+getRankN(a[i]));
        }
    }
    public static void track(int n)
    {
        if (root==null)
            root=new TNode1(n);
        else
            root.insert(n);
    }
    
    public static int getRankN(int n)
    {
        return root.getRank(n);
    }
}
class TNode1 {
      int val;
      TNode1 left;
      TNode1 right;
      int l_size=0;
      TNode1(int x) { val = x; }     
      
      public void insert(int x)
      {
          if(x<=val)
          {
              if(left!=null)
                left.insert(x);
              else
                left=new TNode1(x);
              l_size++;
          }
          else
          {
              if(right!=null)
                  right.insert(x);
              else 
                  right=new TNode1(x);
          }
      }
      
      public int getRank(int x)
      {
          if(x==val)
              return l_size;
          else if(x<val)
          {
              if(left==null)
                  return -1;
              else
                  return left.getRank(x);
          }
          else
          {
              int r_rank= right == null? -1 : right.getRank(x);
              if(r_rank==-1)
                  return -1;
              else
                  return l_size+1+r_rank;
          }
      }
}
