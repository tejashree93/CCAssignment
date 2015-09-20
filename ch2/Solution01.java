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
public class Solution01 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        LinkedList l=new LinkedList();
        while(true)
        {
            System.out.println("Choose the operations to be performed, enter from the number indicated for each operation: 1. insert or 2. delete duplicates or 3. display or 4. exit");
            int opt=sc.nextInt();
            switch(opt)
            {
                case 1:
                    System.out.println("Enter the value of node:");
                    int d=sc.nextInt();
                    l.insert(d);
                    break;
                case 2:
                    l.removeDuplicate();
                    l.display();
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

class Node
{
    int data;
    Node next;
    Node()
    {}
    Node(int d)
    {data=d;}
}

class LinkedList
{
    Node start;
    void insert(int d)
    {
        Node p=new Node(d);
        if(start==null)
            start=p;
        else
        {
            Node q=start;
            while(q.next!=null)
                q=q.next;
            q.next=p;
        }
    }
    void removeDuplicate()
    {
        if(numNodes()<=1)
            return;
        Node q=start;
        while(q!=null)
        {
            int val=q.data;
            Node p=q.next;
            Node prev=q;
            while(p!=null)
            {
                if(val==p.data)
                {
                    prev.next=p.next;
                    p=p.next;
                }
                else
                {
                    prev=p;
                    p=p.next;
                }
            }
            q=q.next;
        }
    }
    int numNodes()
    {
        Node q=start;
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
        Node q=start;
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
}
