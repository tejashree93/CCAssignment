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
        StackS st=new StackS();
        while(true)
        {
            System.out.println("Choose the operations to be performed, enter from the number indicated for each operation: ");
            System.out.println("1. push or 2. pop or 3. display or 4. minimun 5. exit");
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
                    System.out.println("Minimum is: "+st.minimum());
                    break;
                case 5:
                    return;
            }
        }
    }
}
class Node
{
    int data;
    int min;
    Node next;
    Node(){}
    Node(int d, int min)
    {
        data=d;
        this.min=min;
    }
}
class StackS
{
    Node top;
    void push(int d)
    {
        int min=Math.min(d, minimum());
        Node p=new Node(d,min);
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
        Node q=top;
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
    
    Node peek()
    {
        return top;
    }
    
    int minimum()
    {
        if(isEmpty())
            return Integer.MAX_VALUE;
        return peek().min;
    }
    
    boolean isEmpty()
    {
        if(top==null)
            return true;
        return false;
    }
}
