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
        BT b=new BT();
        System.out.println("Enter the elements in the Binary Tree:");
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
        b.inorder();
        b.listDepth();
        for(int i=1;i<=b.depth();i++)
        {
            System.out.println("List at level "+(i-1)+" is: ");
            b.displayAtLevel(i-1);
        }
    }
}

class TNode {
      int val;
      TNode left;
      TNode right;
      TNode(int x) { val = x; }      
}
class BT
{
    List<List<Integer>> l = new ArrayList<>();
    TNode root;
    void insert(int d)
    {
        TNode p=new TNode(d);
        if(root==null)
            root=p;
        else
        {
            TNode nd=root, q=null;
            while(nd!=null)
            {
                q=nd;
                if(d<nd.val)
                    nd=nd.left;
                else
                    nd=nd.right;
            }
            if(q.val>d)
                q.left=p;
            if(q.val<=d)
                q.right=p;
        }
    }
    
    void inorder()
    {
        inorder(root);
    }
    private void inorder(TNode rt)
    {
        
        if(rt==null)
                return;
        else
        {
            
            inorder(rt.left);
            System.out.print(rt.val+" ");
            inorder(rt.right);
            
        }
    }
    
    int depth()
    {
        return depth(root);
    }
    
    private int depth(TNode rt)
    {
        if(rt==null)
            return 0;
        else
        {
            int ld = depth(rt.left);
            int rd = depth(rt.right);
            if(ld>=rd)
                return (ld+1);
            else
                return (rd+1);
        }
    }
    void displayAtLevel(int i)
    {
        System.out.println(l.get(i));
    }
    void listDepth()
    {
        listDepth(root);
    }
    private void listDepth(TNode rt)
    {
        int d=depth();
        for(int i=1;i<=d;i++)
        {
            List<Integer> y= new ArrayList<>();
            getElementAtLevel(y, rt, i);
            l.add(y);
        }
    }
    
    void getElementAtLevel(List<Integer> y, TNode rt, int level)
    {
        if(rt==null)
        {
            return;
        }
        if(level==1)
        {
            y.add(rt.val);
        }
        else if(level>1)
        {
            getElementAtLevel(y,rt.left,level-1);
            getElementAtLevel(y,rt.right,level-1);
        }
    }
    
}
