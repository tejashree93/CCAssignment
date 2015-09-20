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
//Linked List is considered to be singly linked list
public class Solution06 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        LinkedList4 l1=new LinkedList4();
        
        System.out.println("populate linkedlist with integers");
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
        LinkedList4 l2=l1.makeCopy(); // initial linked list is stored in l2
        l1.reverse();                 // original linked list l1 is reversed
        boolean f=l1.checkPalindrome(l2);   // checking whether they are equal
        if(f)
            System.out.println("The linked list is a palindrome");
        else
            System.out.println("The linked list is not a palindrome");
    }
}
class Node4
{
    int data;
    Node4 next;
    Node4()
    {}
    Node4(int d)
    {data=d;}
}

class LinkedList4
{
    Node4 start;
    void insert(int d)
    {
        Node4 p=new Node4(d);
        if(start==null)
            start=p;
        else
        {
            Node4 q=start;
            while(q.next!=null)
                q=q.next;
            q.next=p;
        }
    }
    
    int numNodes()
    {
        Node4 q=start;
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
        Node4 q=start;
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
    
    void reverse()      //reverses the linked list
    {
        Node4 q=start;
        Node4 prev=null;
        while(q!=null)
        {
            Node4 p=q.next;
            q.next=prev;
            prev=q;
            q=p;
        }
        start=prev;
    }
    
    LinkedList4 makeCopy()
    {
        LinkedList4 l=new LinkedList4();
        Node4 q=start;
        while(q!=null)
        {
            l.insert(q.data);
            q=q.next;
        }
        return l;
    }
    boolean checkPalindrome(LinkedList4 l)
    {
        Node4 q=start;
        Node4 p=l.start;
        while(q!=null&&p!=null)
        {
            if(q.data!=p.data)
                return false;
            q=q.next;
            p=p.next;
        }
        return true;
    }
}
