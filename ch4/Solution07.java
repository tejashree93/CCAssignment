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
        System.out.println("Enter number of projects: ");
        int n=sc.nextInt();
        GraphP g=new GraphP(n);
        while(true)
        {
            System.out.print("Enter dependencies between projects (numbers 1 to n): dependent project: ");
            int v1=sc.nextInt();
            System.out.print("project independent of above project: ");
            int v2=sc.nextInt();
            g.insert(v1-1, v2-1);
            System.out.print("continue? 1=yes/0=no: ");
            int o=sc.nextInt();
            if(o==0)
                break;
        }
        System.out.println("Following is the build Order for the projects: ");
        g.topologicalSort();
    }
}

class GraphP
{
    int n;
    int adj[][];
    GraphP(){}
    GraphP(int n)
    {
        this.n=n;
        adj=new int[n][n];
    }
    
    void insert(int u, int v)
    {
        adj[v][u]=1;
    }
    
    void topologicalSort()
    {
        Stack s=new Stack();
        boolean traverse[]=new boolean[n];
        for(int i=0;i<n;i++)
            traverse[i]=false;
        for(int i=0;i<n;i++)
        {
            if(!traverse[i])
                topSort(i, traverse, s);
        }
        
        while(!s.isEmpty())
        {
            System.out.print(((int)s.peek()+1)+" ");
            s.pop();
        }
        System.out.println();
    }
    
    void topSort(int v, boolean traverse[], Stack s)
    {
        traverse[v] = true;
        for(int i=0;i<n;i++)
        {
            if(adj[v][i]==1 && !traverse[i])
                topSort(i,traverse,s);
        }
        s.push(v);
    }
}
