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
// depth is considered as number of levels including root node
public class Solution02 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        int a[];
        System.out.println("Enter the number of elements in the sorted array:");
        int n=sc.nextInt();
        a=new int[n];
        System.out.println("Enter the sorted array:");
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter element "+i+1+": ");
            a[i]=sc.nextInt();
        }
        System.out.println();
        BST t=new BST();
        t.middle(0, n-1, a);
        System.out.print("Inorder: ");
        t.inorder();
        System.out.println();
        System.out.print("Postorder: ");
        t.postorder();
        System.out.print("Preorder: ");
        t.preorder();
        System.out.println("Depth is "+t.depth());
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }      
}
class BST
{
    TreeNode root;
    void insert(int d)
    {
        TreeNode p=new TreeNode(d);
        if(root==null)
            root=p;
        else
        {
            TreeNode nd=root, q=null;
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
    
    void middle(int l, int r, int a[])  // makes tree with least depth
    {
        if(l<=r)
        {
            int m=l+(r-l)/2;
            insert(a[m]);
            middle(l,m-1,a);
            middle(m+1,r,a);
        }
    }
    void inorder()
    {
        inorder(root);
    }
    private void inorder(TreeNode rt)
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
    void postorder()
    {
        postorder(root);
    }
    private void postorder(TreeNode rt)
    {
        
        if(rt==null)
                return;
        else
        {
            postorder(rt.left);
            postorder(rt.right);
            System.out.print(rt.val+" ");
        }
    }
    void preorder()
    {
        preorder(root);
    }
    private void preorder(TreeNode rt)
    {
        
        if(rt==null)
                return;
        else
        {
            System.out.print(rt.val+" ");
            preorder(rt.left);
            preorder(rt.right);
        }
    }
    
    int depth()
    {
        return depth(root);
    }
    
    private int depth(TreeNode rt)
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
}
