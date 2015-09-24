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
        // implemented the class for setOf Stacks but can't figure out follow up part
    }
}

class SetOfStacks
{
    List<Stack> set=new ArrayList<>();
    Stack topmost;
    void push(int d)
    {
        if(set.isEmpty())
            topmost=null;
        else
            topmost=set.get(set.size()-1);
        if(topmost!=null && !topmost.exceed())
        {
            topmost.push(d);
        }
        else
        {
            Stack ns=new Stack(topmost.threshold);
            ns.push(d);
            set.add(ns);
        }
    }
    
    int pop()
    {
        if(topmost==null)
        {
            System.out.println("STack underflow");
            return -1;
        }
        int x=topmost.pop();
        if(topmost.isEmpty())
            set.remove(set.size()-1);
        return x;
    }
    
}

class NodeS
{
    int data;
    NodeS next;
    NodeS(){}
    NodeS(int d)
    {
        data=d;
    }
}
class Stack
{
    NodeS top;
    int threshold;
    Stack(int t)
    {
        threshold=t;
    }
    void push(int d)
    {
        NodeS p=new NodeS(d);
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
        NodeS q=top;
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
    
    int size()
    {
        int c=0;
        NodeS q=top;
        while(q!=null)
        {
            c++;
            q=q.next;
        }
        return c;
    }
    
    boolean isEmpty()
    {
        if(top==null)
            return true;
        return false;
    }
    boolean exceed()
    {
        return threshold==size();
    }
}
