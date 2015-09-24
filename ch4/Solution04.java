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
public class Solution04 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the elements in the binary tree:");
        BinaryTree b=new BinaryTree();
        while(true)
        {
            System.out.print("Enter integer: ");
            int n=sc.nextInt();
            b.insert(n);
            System.out.print("continue? 1=yes/0=no: ");
            int o=sc.nextInt();
            if(o==0)
                break;
        }
        if(b.isBalanced())
            System.out.println("BT is balanced");
        else
            System.out.println("BT is not balanced");
    }
}
class TNode3 {
      int val;
      TNode3 left;
      TNode3 right;
      TNode3(int x) { val = x; }      
}
class BinaryTree
{
    List<TNode3> inL = new ArrayList<>();
    TNode3 root;
    void insert(int d)
    {
        TNode3 p=new TNode3(d);
        if(root==null)
            root=p;
        else
        {
            TNode3 nd=root, q=null;
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
    int depthLeft(TNode3 nd)
    {
        int c=0;
        while(nd.left!=null)
        {
            nd=nd.left;
            c++;
        }
        return c;
    }
    
    int depthRight(TNode3 nd)
    {
        int c=0;
        while(nd.right!=null)
        {
            nd=nd.right;
            c++;
        }
        return c;
    }
    
    boolean isBalanced()
    {
        inorderTraversal(this.root);
        for(int i=0;i<inL.size();i++)
        {
            TNode3 nd = inL.get(i);
            int left_height = depthLeft(nd);
            int right_height = depthRight(nd);
            if(Math.abs(left_height-right_height)>1)
                return false;
        }
        return true;
    }
    
    public void inorderTraversal(TNode3 root)
    {
        
        boolean d=false;
        Stack st=new Stack();
        TNode3 current=root;
        while(!d)
        {
            while(current!=null)
            {
                st.push(current);
                current=current.left;
            }
            if(current==null&&!st.empty())
            {
                TNode3 p;
                p=(TNode3)st.pop();
                System.out.print(p.val);
                inL.add(p);
                current=p.right;
            }
            else if(current==null&&st.empty())
                d=true;
        }
        System.out.println();
    }
}
