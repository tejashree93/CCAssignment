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
public class Solution09 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        BTree b=new BTree();
        //  Referring to Cracking the coding interview book solution
    }
}
class TN {
      int val;
      TN left;
      TN right;
      TN(int x) { val = x; }      
}
class BTree
{
    List<Integer> arr=new ArrayList<>();
    TN root;
    void insert(int d)
    {
        TN p=new TN(d);
        if(root==null)
            root=p;
        else
        {
            TN nd=root, q=null;
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
    private void inorder(TN rt)
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
    
    void diplayLists()
    {
        ArrayList<LinkedList<Integer>> seq = bstSequences(root);
        for(int i=0;i<seq.size();i++)
        {
            System.out.println("Sequence " + i + ": "+seq.get(i));
        }
    }
    
    ArrayList<LinkedList<Integer>> bstSequences(TN nd)
    {
        ArrayList<LinkedList<Integer>> seq=new ArrayList<>();
        if(nd==null)
        {
            seq.add(new LinkedList<Integer>());
            return seq;
        }
        
        LinkedList<Integer> before = new LinkedList<>();
        before.add(nd.val);
        
        ArrayList<LinkedList<Integer>> left_seq = bstSequences(nd.left);
        ArrayList<LinkedList<Integer>> right_seq = bstSequences(nd.right);
        
        for(LinkedList<Integer> left : left_seq)
        {
            for(LinkedList<Integer> right : right_seq)
            {
                ArrayList<LinkedList<Integer>> mix = new ArrayList<>();
                mixLists(left, right, mix, before);
                seq.addAll(mix);
            }
        }
        return seq;
    }
    
    void mixLists(LinkedList<Integer> left, LinkedList<Integer> right, ArrayList<LinkedList<Integer>> mix, LinkedList<Integer> before)
    {
        if(before.isEmpty()||right.isEmpty())
        {
            LinkedList<Integer> l = new LinkedList<>();
            l=(LinkedList<Integer>)before.clone();
            l.addAll(left);
            l.addAll(right);
            mix.add(l);
            return;
        }
        int hl=left.removeFirst();
        before.addLast(hl);
        mixLists(left,right,mix,before);
        before.removeLast();
        left.addFirst(hl);
        
        int hr=right.removeFirst();
        before.addLast(hr);
        mixLists(left,right,mix,before);
        before.removeLast();
        right.addFirst(hr);
    }
}
