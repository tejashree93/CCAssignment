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
public class Solution02 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        LinkedList1 l=new LinkedList1();
        while(true)
        {
            System.out.println("Choose the operations to be performed, enter from the number indicated for each operation: 1. insert or 2. get k to last element or 3. display or 4. exit");
            System.out.println("1. insert or 2. get k to last element or 3. display or 4. exit");
            int opt=sc.nextInt();
            switch(opt)
            {
                case 1:
                    System.out.println("Enter the value of node:");
                    int d=sc.nextInt();
                    l.insert(d);
                    break;
                case 2:
                    System.out.println("Enter the value of k:");
                    int k=sc.nextInt();
                    LinkedList1 l1=l.k2last(k);
                    l1.display();
                    break;
                case 3:
                    l.display();
                    break;
                case 4:
                    return;   
            }
        }
    }
}
class Node1
{
    int data;
    Node1 next;
    Node1()
    {}
    Node1(int d)
    {data=d;}
}

class LinkedList1
{
    Node1 start;
    void insert(int d)
    {
        Node1 p=new Node1(d);
        if(start==null)
            start=p;
        else
        {
            Node1 q=start;
            while(q.next!=null)
                q=q.next;
            q.next=p;
        }
    }
    
    int numNodes()
    {
        Node1 q=start;
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
        Node1 q=start;
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
    
    LinkedList1 k2last(int k)
    {
        LinkedList1 l1=new LinkedList1();
        if(numNodes()==1)
        {
            l1.insert(start.data);
            return l1;
        }
        if(numNodes()==0)
            return null;
        Node1 q=start;
        int c=0;        // variable to keep count of which node has been reached
        Node1 prev=null;
        while(q!=null)
        {
            c++;
            prev=q;
            q=q.next;
            if(c==k)        // when count reaches the Kth node
            {
                while(prev!=null)       // insert all nodes from Kth node including it uptil the last node into the new linked list
                {
                    l1.insert(prev.data);
                    prev=prev.next;
                }
                break;
            }
        }
        return l1;
    }
}
