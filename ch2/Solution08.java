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
public class Solution08 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        LinkedList7 l1=new LinkedList7();
        
        System.out.println("populate linkedlist :");
        int i=0;
        while(true)
        {
            i++;
            System.out.println("enter value of node"+i+" or enter -1 to exit");
            Object num=sc.next();
            if(num.equals("-1"))
                break;
            l1.insert(num);
        }
        System.out.println("Before creating Loop for testing");
        l1.display();
        LoopNode ln=l1.detectLoop();
        if(ln.loop)
            System.out.println("List is Circular at node: "+ln.nd.data);
        else
            System.out.println("List is not circular!");
        l1.reset();
        // Creating loop to test the method detectLoop()
        Random r=new Random();
        int ref=r.nextInt(l1.numNodes()+1);
        System.out.println("Reference node="+ref);
        Node7 reference=l1.getReference(ref);
        l1.makeLoop(reference);
        ln=l1.detectLoop();
        if(ln.loop)
            System.out.println("List is Circular at node: "+ln.nd.data);
        else
            System.out.println("List is not circular!");
    }
}

class Node7
{
    Object data;
    Node7 next;
    boolean traverse;
    Node7()
    {}
    Node7(Object d)
    {
        data=d;
        traverse=false;
    }
}

class LinkedList7
{
    Node7 start;
    void insert(Object d)
    {
        Node7 p=new Node7(d);
        if(start==null)
            start=p;
        else
        {
            Node7 q=start;
            while(q.next!=null)
                q=q.next;
            q.next=p;
        }
    }
    void reset()
    {
        Node7 q=start;
        while(q!=null)
        {
            q.traverse=false;
            q=q.next;
        }
    }
    int numNodes()
    {
        Node7 q=start;
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
        Node7 q=start;
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
    
    Node7 getReference(int ref)
    {
        Node7 n=start;
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
    void makeLoop(Node7 n)
    {
        Node7 q=this.start;
        if(q==null)
            q=n;
        while(q.next!=null)
            q=q.next;
        q.next=n;
    }
    
    LoopNode detectLoop()
    {
        LoopNode lp;
        Node7 q=start;
        while(q!=null)
        {
            if(!q.traverse)
            {
                q.traverse=true;
                q=q.next;
            }
            else
            {
                lp=new LoopNode(q,true);
                return lp; 
            }
        }
        lp=new LoopNode(null,false);
        return lp;
    }
}

class LoopNode
{
    Node7 nd;
    boolean loop;
    LoopNode(Node7 nd, boolean loop)
    {
        this.nd=nd;
        this.loop=loop;
    }
}
