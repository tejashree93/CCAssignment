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
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        BinTree b=new BinTree();
        while(true)
        {
            System.out.print("Enter integer: ");
            int n=sc.nextInt();
            b.insert(n);
            System.out.print("continue? 1=yes/0=no");
            int o=sc.nextInt();
            if(o==0)
                break;
        }
        while(true)
        {
            System.out.println("Enter value of node 1 and node 2 for which you want to find the common ancestor");
            System.out.print("Node 1: ");int n1=sc.nextInt();
            BTNode p=b.search(n1);
            System.out.print("Node 2: ");int n2=sc.nextInt();
            BTNode q=b.search(n2);
            BTNode ancestor=b.ancestor(p, q);
            System.out.println("Ancestor of the nodes is: "+ancestor.val);
            System.out.print("continue? 1=yes/0=no");
            int o=sc.nextInt();
            if(o==0)
                break;
        }
    }
}

class BTNode
{
    int val;
    BTNode left,right,parent;
    BTNode(int val)
    {
        this.val=val;
    }
    
    
}

class BinTree
{
    BTNode root;
    void insert(int d)
    {
        BTNode p=new BTNode(d);
        if(root==null)
        {
            root=p;
            root.parent=null;
        }
        else
        {
            BTNode nd=root, q=null;
            while(nd!=null)
            {
                q=nd;
                if(d<nd.val)
                    nd=nd.left;
                else
                    nd=nd.right;
            }
            if(q.val>d)
            {
                q.left=p;
                p.parent=q;
            }
            if(q.val<=d)
            {
                q.right=p;
                p.parent=q;
            }
        }
    }
    BTNode search(int d)
    {
        BTNode p=root;
        while(p!=null)
        {
            if(p.val==d)
                return p;
            if(d<p.val)
                p=p.left;
            else
                p=p.right;
        }
        return null;
    }
    
    BTNode ancestor(BTNode p, BTNode q)
    {
        BTNode anc1=p, anc2=q;
        if(p==null||q==null)
            return null;
        if(p==root||q==root)
            return root;
        if(p==q)
            return p.parent;
        if(p.parent==q)
            return q;
        if(q.parent==p)
            return p;
        while(anc1!=null)
        {
            anc2=q;
            while(anc2!=anc1&& anc2!=null)
            {
                anc2=anc2.parent;
            }
            if(anc2==anc1)
            {
                return anc1;
            }
            anc1=anc1.parent;
        }
        return null;
    }
}
