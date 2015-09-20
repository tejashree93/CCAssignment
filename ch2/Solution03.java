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
public class Solution03 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        LinkedList5 l1=new LinkedList5();
        
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
        // for the sake of the program to work, the middle node is found by using getMidReference()
        Node5 middle=l1.getMidReference();
        // Considering there is no start pointer to the LinkedList and working with the refernce to the middle node
        l1.deleteMiddle(middle);
        if(l1.numNodes()==1)
            System.out.println("Node can't be deleted!");
        System.out.print("Linked list after deletion: ");
        l1.display();
    }
}

class Node5
{
    int data;
    Node5 next;
    Node5()
    {}
    Node5(int d)
    {data=d;}
}

class LinkedList5
{
    Node5 start;
    void insert(int d)
    {
        Node5 p=new Node5(d);
        if(start==null)
            start=p;
        else
        {
            Node5 q=start;
            while(q.next!=null)
                q=q.next;
            q.next=p;
        }
    }
    
    int numNodes()
    {
        Node5 q=start;
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
        Node5 q=start;
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
    
    Node5 getMidReference()
    {
        Node5 n=start;
        int mid;
        if(numNodes()==0)
            return null;
        if(numNodes()%2==0)
            mid=numNodes()/2;
        else
            mid=numNodes()/2+1;
        int i=1;
        while(i!=mid)
        {
            n=n.next;
            i++;
        }
        return n;
    }
    
    void deleteMiddle(Node5 m)
    {
        if(m==null||m.next==null)   // if there are 1 or 0 nodes in the linkedlist then delete mid operation can't be performed
            return;                 // if only 1 node exists then we need to consider using start pointer to get rid of dangling pointer issues 
        Node5 p=m.next;             // while deleting the only node in the linked list but we don't have the reference to any other node as the question states.
        m.data=p.data;              
        m.next=p.next;
    }
}
