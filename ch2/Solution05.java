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
public class Solution05 {
     public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the 1st number");
        int n1=sc.nextInt();
        int n=n1;
        System.out.println("Enter the 2nd number");
        int n2=sc.nextInt();
        int m=n2;
        LinkedList3 l1=makeList(n1);
        LinkedList3 l2=makeList(n2);
        l1.display();
        l2.display();
        LinkedList3 l3=sum(l1,l2);// this is the method that adds the two LinkedLists by creating their Linked Lists.
        l3.display();
        int ans=l3.showNum();
        System.out.println("sum is "+ans);
        
        // follow up part
        
        /* Going by what I have done, and if the 2 forward Representations of the number using LinkedList are given,
        Then the sum() function can be called after reversing the linked list representation of each individual Linked List.
        To get the forward representation LinkedList of the answer that is obtained by sum(), it is reversed again and then dislayed.
        */
        
    }
     public static LinkedList3 sum(LinkedList3 l1, LinkedList3 l2)
    {
        LinkedList3 l3=new LinkedList3();
        int s=0, t;
        Node3 i=l1.start;
        Node3 j=l2.start;
        while(i!=null&&j!=null)
        {
            s=s+i.data+j.data;
            if(s>=10)
            {
                t=s%10;
                l3.insert(t);
                s=s/10;
            }
            else
            {
                l3.insert(s);
                s=0;
            }
            i=i.next;
            j=j.next;
        }
        while(i!=null)
        {
            s=s+i.data;
            if(s>=10)
            {
                t=s%10;
                l3.insert(t);
                s=s/10;
            }
            else
            {
                l3.insert(s);
                s=0;
            }
            i=i.next;
        }
        while(j!=null)
        {
            s=s+j.data;
            if(s>=10)
            {
                t=s%10;
                l3.insert(t);
                s=s/10;
            }
            else
            {
                l3.insert(s);
                s=0;
            }
            j=j.next;
        }
        if(s>0)
            l3.insert(s);
        return l3;
    }
     
     public static LinkedList3 makeList(int n)
     {
         LinkedList3 l=new LinkedList3();
         while(n!=0)
         {
            int d=n%10;
            l.insert(d);
            n=n/10;
         }
         return l;
     }
     
     public static int reverseNum(int n)
     {
         int r=0;
         while(n!=0)
         {
            r=r*10;
            r=r+n%10;
            n=n/10;
         }
         return r;
     }
}
class Node3
{
    int data;
    Node3 next;
    Node3()
    {}
    Node3(int d)
    {data=d;}
}

class LinkedList3
{
    Node3 start;
    void insert(int d)
    {
        Node3 p=new Node3(d);
        if(start==null)
            start=p;
        else
        {
            Node3 q=start;
            while(q.next!=null)
                q=q.next;
            q.next=p;
        }
    }
    
    int numNodes()
    {
        Node3 q=start;
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
        Node3 q=start;
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
    int showNum()
    {
        reverse();
        return makeNum();
    }
    void reverse()      //reverses the linked list
    {
        Node3 q=start;
        Node3 prev=null;
        while(q!=null)
        {
            Node3 p=q.next;
            q.next=prev;
            prev=q;
            q=p;
        }
        start=prev;
    }
    int makeNum()
    {
        if(numNodes()==1)
            return start.data;
        Node3 q=start;
        int s=0;
        int n=numNodes()-1;
        while(q!=null)
        {
            s=s+q.data*(int)Math.pow(10, n);
            n--;
            q=q.next;
        }
        return s;
    }
    
}
