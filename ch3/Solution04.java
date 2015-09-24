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
        MyQueue m=new MyQueue();
        while(true)
        {
            System.out.println("Choose the operations to be performed, enter from the number indicated for each operation: ");
            System.out.println("1. enqueue or 2. dequeue or 3. display or 4. peek 5. exit");
            int opt=sc.nextInt();
            switch(opt)
            {
                case 1:
                    System.out.println("Enter the integer:");
                    int d=sc.nextInt();
                    m.enqueue(d);
                    break;
                case 2:
                    int p=m.dequeue();
                    if(p!=-1)
                        System.out.println("Popped element: "+p);
                    break;
                case 3:
                    m.display();
                    break;
                case 4:
                    System.out.println("First element by peeking: "+m.peek());
                    break;
                case 5:
                    return;
            }
        }
    }
}

class Stack2
{
    Node2 top;
    void push(int d)
    {
        Node2 p=new Node2(d);
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
        Node2 q=top;
        while(q!=null)
        {
            System.out.print(q.data+" ");
            q=q.next;
        }
        System.out.println();
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
    
    int size()
    {
        int c=0;
        Node2 q=top;
        while(q!=null)
        {
            c++;
            q=q.next;
        }
        return c;
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
    
    
}

class Node2
{
    int data;
    Node2 next;
    Node2(){}
    Node2(int d)
    {
        data=d;
    }
}

class MyQueue
{
    Stack2 s_first_ins = new Stack2();
    Stack2 s_last_ins = new Stack2();
    void enqueue(int d)
    {
        s_last_ins.push(d);
    }
    
    int dequeue()
    {
        int e=-1;
        if(s_first_ins.top==null && s_last_ins.top==null)
        {
            System.out.println("Queue is empty");
            return -1;
        }
        if(s_first_ins.top==null)
        {
            while(!s_last_ins.isEmpty())
            {
                int d = s_last_ins.pop();
                s_first_ins.push(d);
            }
        }
        e=s_first_ins.pop();
        return e;
    }
    
    int peek()
    {
        int e=-1;
        if(s_first_ins.top==null && s_last_ins.top==null)
        {
            System.out.println("Queue is empty");
            return -1;
        }
        if(s_first_ins.top==null)
        {
            while(!s_last_ins.isEmpty())
            {
                int d = s_last_ins.pop();
                s_first_ins.push(d);
            }
        }
        e=s_first_ins.top.data;
        return e;
    }
    
    
    void display()
    {
        if(s_first_ins.top==null && s_last_ins.top==null)
        {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("MyQueue Stack of first ins :");
        s_first_ins.display();
        System.out.println("MyQueue Stack of last ins :");
        s_last_ins.display();
    }
}
