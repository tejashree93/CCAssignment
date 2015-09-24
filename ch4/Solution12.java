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
// Referring to Cracking the coding interview book solution
public class Solution12 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        BiT b=new BiT();
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
        System.out.println("Enter the sum: ");
        int s=sc.nextInt();
        int p=b.pathsSum(b.root, s);
        System.out.println("Number of paths: "+p);
    }
}

class TrNd {
      int val;
      TrNd left;
      TrNd right;
      TrNd(int x) { val = x; }      
}
class BiT
{
    TrNd root;
    void insert(int d)
    {
        TrNd p=new TrNd(d);
        if(root==null)
            root=p;
        else
        {
            TrNd nd=root, q=null;
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
    private void inorder(TrNd rt)
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
    
    int pathsSum(TrNd root, int final_sum)
    {
        if(root==null)
            return 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        increment(count, 0 ,1);
        return pathSum(root, final_sum, 0, count);
    }
    int pathSum(TrNd nd, int final_sum, int s, HashMap<Integer,Integer> count)
    {
        if(nd==null)
            return 0;
        s=s+nd.val;
        increment(count,s,1);
        int sum = s - final_sum;
        int t = count.containsKey(sum) ? count.get(sum) : 0;
        t=t+pathSum(nd.left, final_sum, s, count);
        t=t+pathSum(nd.right, final_sum, s, count);
        
        increment(count, s, -1);
        return t;
    }
    
    void increment(HashMap<Integer,Integer> ht, int k, int d)
    {
        if(!ht.containsKey(k))
            ht.put(k, 0);
        ht.put(k, ht.get(k)+d);
    }
}
