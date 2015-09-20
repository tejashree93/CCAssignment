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
        LinkedList2 l=new LinkedList2();
        while(true)
        {
            System.out.println("Choose the operations to be performed, enter from the number indicated for each operation: 1. insert or 2. get k to last element or 3. display or 4. exit");
            System.out.println("1. insert or 2. partition or 3. display or 4. exit");
            int opt=sc.nextInt();
            switch(opt)
            {
                case 1:
                    System.out.println("Enter the value of node:");
                    int d=sc.nextInt();
                    l.insert(d);
                    break;
                case 2:
                    System.out.println("Enter the value of x:"); // element where partition occurs
                    int x=sc.nextInt();
                    LinkedList2 l2=l.part(x);
                    l2.display();
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
class Node2
{
    int data;
    Node2 next;
    Node2()
    {}
    Node2(int d)
    {data=d;}
}

class LinkedList2
{
    Node2 start;
    void insert(int d)
    {
        Node2 p=new Node2(d);
        if(start==null)
            start=p;
        else
        {
            Node2 q=start;
            while(q.next!=null)
                q=q.next;
            q.next=p;
        }
    }
    
    int numNodes()
    {
        Node2 q=start;
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
        Node2 q=start;
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
    LinkedList2 part(int x)
    {
        
        LinkedList2 l2=new LinkedList2();
        if(numNodes()==1)
        {
            l2.insert(start.data);
            return l2;
        }
        if(numNodes()==0)
        {
            return null;
        }
        Node2 q=start;
        while(q!=null)      // put all elements less than x in new linked list first
        {
            if(q.data<x)
                l2.insert(q.data);
            q=q.next;
        }
        q=start;
        while(q!=null)      // put all elements greater than x in new linked list later
        {
            if(q.data>=x)
                l2.insert(q.data);
            q=q.next;
        }
        return l2;
    }
}
