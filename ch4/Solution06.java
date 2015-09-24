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
public class Solution06 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        Bst b=new Bst();
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
        while(true) {
        System.out.println("Find successor of which node? give its integer value:");
        int v=sc.nextInt();
        TNode2 t=b.search(v);
        if(t==null)
        {
            System.out.print("No successor");
            break;
        }
        TNode2 successor=b.inorderSuccessor(t);
        if(successor==null)
            break;
        System.out.println("Inorder successor is: "+successor.val);
        System.out.print("continue? 1=yes/0=no");
        int o=sc.nextInt();
        if(o==0)
            break;
        }
    }
}
class TNode2 {
      int val;
      TNode2 left;
      TNode2 right;
      TNode2(int x) { val = x; }      
}
class Bst
{
    List<TNode2> inL = new ArrayList<>();
    TNode2 root;
    void insert(int d)
    {
        TNode2 p=new TNode2(d);
        if(root==null)
            root=p;
        else
        {
            TNode2 nd=root, q=null;
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
    
    
    
    TNode2 search(int d)
    {
        TNode2 p=root;
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
    
    void inorderTraversal()
    {
        boolean d=false;
        Stack st=new Stack();
        TNode2 current=root;
        while(!d)
        {
            while(current!=null)
            {
                st.push(current);
                current=current.left;
            }
            if(current==null&&!st.empty())
            {
                TNode2 p;
                p=(TNode2)st.pop();
                System.out.print(p.val);
                inL.add(p);
                current=p.right;
            }
            else if(current==null&&st.empty())
                d=true;
        }
        System.out.println();
    }
    
    TNode2 inorderSuccessor(TNode2 n)
    {
        inorderTraversal();
        if(inL.isEmpty()||inL.size()==1||inL.get(inL.size()-1)==n)
        {
            System.out.println("No inorder Succesor");
            return null;
        }
        for(int i=0; i<inL.size();i++)
        {
            if(inL.get(i)==n)
                return inL.get(i+1);
        }
        return null;
    }
    
}
