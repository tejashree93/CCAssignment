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
public class Solution05 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the elements in the binary tree:");
        BT1 b=new BT1();
        List<Integer> a=new ArrayList<>();
        while(true)
        {
            System.out.print("Enter integer: ");
            int n=sc.nextInt();
            b.insert(n);
            a.add(n);
            System.out.print("continue? 1=yes/0=no");
            int o=sc.nextInt();
            if(o==0)
                break;
        }
        b.inorder();
        if(b.validate(a))
            System.out.println("The Binary tree is a BST");
        else
            System.out.println("The Binary tree is not a BST");
    }
}
class TNode1 {
      int val;
      TNode1 left;
      TNode1 right;
      TNode1(int x) { val = x; }      
}
class BT1
{
    List<Integer> arr=new ArrayList<>();
    TNode1 root;
    void insert(int d)
    {
        TNode1 p=new TNode1(d);
        if(root==null)
            root=p;
        else
        {
            TNode1 nd=root, q=null;
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
    private void inorder(TNode1 rt)
    {
        
        if(rt==null)
                return;
        else
        {
            
            inorder(rt.left);
            arr.add(rt.val);
            System.out.print(rt.val+" ");
            inorder(rt.right);
            
        }
    }
    
    boolean validate(List<Integer> a)
    {
        Collections.sort(a);
        return compare(a);
    }
    
    boolean compare(List<Integer> a)
    {
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)!= a.get(i))
                return false;
        }
        return true;
    }
    
    int depth()
    {
        return depth(root);
    }
    
    private int depth(TNode1 rt)
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
