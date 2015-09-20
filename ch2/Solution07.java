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
// Assuming values of Nodes in LinkedList are integers
public class Solution07 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        LinkedList6 l1=new LinkedList6();
        
        System.out.println("populate linkedlist1 with integers");
        int i=0;
        while(true)
        {
            i++;
            System.out.println("enter integer value of node"+i+" or enter -1 to exit");
            int num=sc.nextInt();
            if(num==-1)
                break;
            l1.insert(num);
        }
        LinkedList6 l2=new LinkedList6();
        
        System.out.println("populate linkedlist2 with integers");
        i=0;
        while(true)
        {
            i++;
            System.out.println("enter integer value of node"+i+" or enter -1 to exit");
            int num=sc.nextInt();
            if(num==-1)
                break;
            l2.insert(num);
        }
        System.out.println("when L1 and L2 do not intersect:");
        l1.display();
        l2.display();
        if(l1.isIntersecting(l2))
            System.out.println("L1 and L2 intersect!");
        else
            System.out.println("L1 and L2 do not intersect!");
        // creating an intersection to check whether the isIntersecting() function works.
        Random r=new Random();
        // appending l2 to l1 randomly 
        int ref=r.nextInt(l1.numNodes()+1);
        Node6 reference=l1.getReference(ref);
        l2.makeIntersect(reference);    // l2 is appended to l1 at the reference node returned by getReference()
        l2.display();
        if(l1.isIntersecting(l2))
            System.out.println("L1 and L2 intersect!");
        else
            System.out.println("L1 and L2 do not intersect!");
    }
}

class Node6
{
    int data;
    Node6 next;
    Node6()
    {}
    Node6(int d)
    {data=d;}
}

class LinkedList6
{
    Node6 start;
    void insert(int d)
    {
        Node6 p=new Node6(d);
        if(start==null)
            start=p;
        else
        {
            Node6 q=start;
            while(q.next!=null)
                q=q.next;
            q.next=p;
        }
    }
    
    int numNodes()
    {
        Node6 q=start;
        int c=0;
        while(q!=null)
        {
            c++;
            q=q.next;
        }
        return c;
    }
    void display()
    {
        Node6 q=start;
        if(q==null)
        {
            System.out.println("List is empty!");
        }
        while(q!=null)
        {
            if(q.next!=null)
                System.out.print(q.data+"->");
            else
                System.out.print(q.data);
            q=q.next;
        }
        System.out.println();
    }
    
    Node6 getReference(int ref)
    {
        Node6 n=start;
        if(numNodes()<ref||numNodes()==0)
            return null;
        int i=1;
        while(i!=ref)
        {
            n=n.next;
            i++;
        }
        return n;
    }
    void makeIntersect(Node6 n)
    {
        Node6 q=this.start;
        if(q==null)
            q=n;
        while(q.next!=null)
            q=q.next;
        q.next=n;
    }
    Node6 getLast()
    {
        Node6 q=this.start;
        while(q.next!=null)
            q=q.next;
        return q;
    }
    boolean isIntersecting(LinkedList6 l)
    {
        int n1=this.numNodes();
        int n2=l.numNodes();
        if(n1==0||n2==0)
            return false;
        Node6 ln1=this.getLast();
        Node6 ln2=l.getLast();
        if(ln1!=ln2)
            return false;
        Node6 n;
        Node6 m;
        int i;
        if(n1>n2)
        {
            i=1;
            n=this.start;
            while(i<n1-n2+1)
            {
                n=n.next;
                i++;
            }
            m=l.start;
            return intersecting(n,m);
        }
        else if(n1<=n2)
        {
            i=1;
            n=l.start;
            while(i<n2-n1+1)
            {
                n=n.next;
                i++;
            }
            m=this.start;
            return intersecting(n,m);
        }
        
        return false;
    }
    
    boolean intersecting(Node6 n, Node6 m)
    {
        while(n!=null&&m!=null)
        {
            if(m==n)
                return true;
            n=n.next;
            m=m.next;
        }
        return false;
    }
}
