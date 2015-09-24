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
public class Solution10 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        // Referring to Cracking the coding interview book solution
    }
}
class TNd {
      int val;
      TNd left;
      TNd right;
      TNd(int x) { val = x; }      
}
class BT2
{
    List<Integer> arr=new ArrayList<>();
    TNd root;
    void insert(int d)
    {
        TNd p=new TNd(d);
        if(root==null)
            root=p;
        else
        {
            TNd nd=root, q=null;
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
    private void inorder(TNd rt)
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
    
    boolean hasTree(TNd t1, TNd t2)
    {
        if(t2==null)
            return true;
        return checkSub(t1,t2);
    }
    boolean checkSub(TNd t1, TNd t2)
    {
        if(t1==null)
            return false;
        else if(t1.val==t2.val && compareTree(t1,t2))
            return true;
        return (checkSub(t1.left,t2) || checkSub(t1.right,t2));
    }
    
    boolean compareTree(TNd t1, TNd t2)
    {
        if (t1 == null && t2 == null)
            return true;
        else if (t1 == null || t2 == null)
            return false;
        else if(t1.val!=t2.val)
            return false;
        else
            return (compareTree(t1.left,t2.left) && compareTree(t1.right,t2.right));
    }
}
