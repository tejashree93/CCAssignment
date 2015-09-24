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
        Stack1 st=new Stack1();
        while(true)
        {
            System.out.println("Choose the operations to be performed, enter from the number indicated for each operation: ");
            System.out.println("1. push or 2. pop or 3. display or 4. sort 5. exit");
            int opt=sc.nextInt();
            switch(opt)
            {
                case 1:
                    System.out.println("Enter the integer:");
                    int d=sc.nextInt();
                    st.push(d);
                    break;
                case 2:
                    int p=st.pop();
                    if(p!=-1)
                        System.out.println("Popped element: "+p);
                    break;
                case 3:
                    st.display();
                    break;
                case 4:
                    System.out.println("Sorted Stack is: ");
                    st.sort();
                    st.display();
                    break;
                case 5:
                    return;
            }
        }
    }
}

class Stack1
{
    Node1 top;
    void push(int d)
    {
        Node1 p=new Node1(d);
        if(top==null)
            top=p;
        else
        {
            p.next=top;
            top=p;
        }
    }
    
    void display()
    {
        if(isEmpty())
        {
            System.out.print("Stack is empty!");
            return;
        }
        Node1 q=top;
        while(q!=null)
        {
            System.out.print(q.data+" ");
            q=q.next;
        }
    }
    
    int pop()
    {
        if(top==null)
        {
            System.out.println("Stack is empty. no element to pop.");
            return -1;
        }
        int x=top.data;
        top=top.next;
        return x;
    }
    
    int peek()
    {
        return top.data;
    }
    
    boolean isEmpty()
    {
        if(top==null)
            return true;
        return false;
    }
    
    void sort()     // uses selection sort to sort the stack
    {
        Node1 q=top;
        Node1 p, track=null;
        while(q.next!=null)
        {
            int keep=q.data, temp = keep;
            p=q.next;
            while(p!=null)
            {
                if(keep>p.data)
                {
                    keep=p.data;
                    track=p;
                } 
                if(temp==keep)
                    track=q;
                p=p.next;
            }
            if(temp!=keep)
            {
                temp=q.data;
                q.data=keep;
                track.data=temp;
            }
            q=q.next;
        }
    }
}

class Node1
{
    int data;
    Node1 next;
    Node1(){}
    Node1(int d)
    {
        data=d;
    }
}
