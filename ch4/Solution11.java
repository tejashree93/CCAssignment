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
public class Solution11 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        BinT b=new BinT();
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
            System.out.println("Find a random Node? 1=yes/0=no: ");
            int o=sc.nextInt();
            if(o==0)
                break;
            TNod r=b.getRandomNode();
            System.out.println("Random Node's value is: "+r.val);
        }
        
    }
}

class TNod {
      int val;
      TNod left;
      TNod right;
      TNod(int x) { val = x; }      
}
class BinT
{
    
    TNod root;
    void insert(int d)
    {
        TNod p=new TNod(d);
        if(root==null)
            root=p;
        else
        {
            TNod nd=root, q=null;
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
    
    TNod getRandomNode()
    {
        List<TNod> inL=inorderTraversal();
        Random r=new Random();
        int ref=r.nextInt(inL.size());
        System.out.print(ref+":index and ");
        System.out.print("value: "+inL.get(ref).val);
        return search(inL.get(ref).val);
    }
    TNod search(int d)
    {
        TNod p=root;
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
    
    List<TNod> inorderTraversal()
    {
        List<TNod> inL = new ArrayList<>();
        boolean d=false;
        Stack st=new Stack();
        TNod current=root;
        while(!d)
        {
            while(current!=null)
            {
                st.push(current);
                current=current.left;
            }
            if(current==null&&!st.empty())
            {
                TNod p;
                p=(TNod)st.pop();
                System.out.print(p.val+" ");
                inL.add(p);
                current=p.right;
            }
            else if(current==null&&st.empty())
                d=true;
        }
        System.out.println();
        return inL;
    }
    
    void delete(int d)
    {
        boolean flag=false;
        TNod p=root;
        TNod prev=null, rp;
        while(p!=null)
        {
            if(p.val==d)
            {
                flag=true;
                break;
            }
            prev=p;
            if(d<p.val)
                p=p.left;
            else
                p=p.right;
        }
        if(!flag)
        {
            System.out.println("Node not found!");
            return;
        }
        if(p.left==null&&p.right==null)
            rp=null;
        else if(p.left==null)
            rp=p.right;
        else if(p.right==null)
            rp=p.left;
        else
        {
            rp=p.right;
            TNod s=rp.left;     // left son of rp
            if(s==null)
                rp.left=p.left;
            else
            {
                TNod f=null;
                while(s!=null)
                {
                    f=rp;
                    rp=s;
                    s=s.left;   // go to leftmost node
                }
                f.left=rp.right;
                rp.left=p.left;
                rp.right=p.right;
            }
        }
        if(p==root)
            root=rp;
        else if(prev.left==p)
            prev.left=rp;
        else
            prev.right=rp;
    }
}
