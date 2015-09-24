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
// function route() uses depth first search to find the existing path
public class Solution01 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter number of nodes in the graph:");
        int n=sc.nextInt();
        Graph g=new Graph(n);
        System.out.println("Populate the graph:");
        while(true)
        {
            System.out.print("edge is between(Enter integers between 1 to n to create edges)? vertex 1: ");
            int v1=sc.nextInt();
            System.out.print("vertex 2: ");
            int v2=sc.nextInt();
            g.adj[v1-1][v2-1]=1;
            System.out.print("continue? 1=yes/0=no");
            int o=sc.nextInt();
            if(o==0)
                break;
        }
        while(true) {
        System.out.println("Enter the nodes that you want to search between 1 and n including both so that they have a route: ");
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        if(g.route(n1-1, n2-1))
            System.out.println("There is a route between the two nodes");
        else
            System.out.println("There isn't a route between the two nodes");
        g.resetTraverse();
        System.out.print("continue? 1=yes/0=no");
        int o=sc.nextInt();
        if(o==0)
            break;
        }
    }
}

class Graph
{
    int n;
    int adj[][];
    boolean traverse[];
    Graph(int n)
    {
        this.n=n;
        adj=new int[n][n];
        traverse=new boolean[n];
    }
    
    void resetTraverse()
    {
        for(int i=0;i<n;i++)
            traverse[i]=false;
    }
    boolean route(int start, int end)
    {
        traverse[start]=true;
        System.out.print("At Node: "+(start+1)+" ");
        for(int i=0;i<n;i++)
        {
            if(adj[start][i]==1 && !traverse[i])
            {
                if(i==end)
                    return true;
                return route(i,end);
            }
        }
        return false;
    }
}
