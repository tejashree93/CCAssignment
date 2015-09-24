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
        System.out.println("Enter the lemgth of array");
        int n=sc.nextInt();
        MultiStack m=new MultiStack(n);
        int s;
        while(true)
        {
            System.out.println("Choose the operations to be performed, enter from the number indicated for each operation: ");
            System.out.println("1. push or 2. pop or 3. display or 4. exit");
            int opt=sc.nextInt();
            switch(opt)
            {
                case 1:
                    System.out.println("Enter the stack number 1/2/3:");
                    s=sc.nextInt();
                    System.out.println("Enter the integer:");
                    int d=sc.nextInt();
                    m.push(d, s, n);
                    break;
                case 2:
                    System.out.println("Enter the stack number 1/2/3:");
                    s=sc.nextInt();
                    int p=m.pop(s, n);
                    if(p!=-1)
                    System.out.println("Popped element: "+p);
                    break;
                case 3:
                    System.out.println("Enter the stack number 1/2/3:");
                    s=sc.nextInt();
                    m.display(s, n);
                    break;
                case 4:
                    return;   
            }
        }
    }
}
class MultiStack
{
    int ms[];
    int top[];
    MultiStack(int n)
    {
        ms=new int[n];
        top=new int[n];
        top[0] = n/3 + 1;
        top[1] = 2*n/3 + 1;
        top[2] = n;
    }
    
    void push(int data, int stack, int n)
    {
        stack=stack-1;
        switch(stack)
        {
            case 0:
                if(top[stack]==0)
                {
                    System.out.println("Stack1 overflow");
                    return;
                }
                ms[--top[stack]]=data;
                break;
            case 1:
                if(top[stack]==n/3+1)
                {
                    System.out.println("Stack2 overflow");
                    return;
                }
                ms[--top[stack]]=data;
                break;
            case 2:
                if(top[stack]==2*n/3+1)
                {
                    System.out.println("Stack3 overflow");
                    return;
                }
                ms[--top[stack]]=data;
                break;
        }
        return;
    }
    
    int pop(int stack, int n)
    {
        stack=stack-1;
        switch(stack)
        {
            case 0:
                if(top[stack]==n/3+1)
                {
                    System.out.println("Stack1 is empty. unable to pop");
                    return -1;
                }
                return ms[top[stack]++];
            case 1: 
                if(top[stack]==2*n/3+1)
                {
                    System.out.println("Stack2 is empty. unable to pop");
                    return -1;
                }
                return ms[top[stack]++];
            case 2:
                if(top[stack]==n)
                {
                    System.out.println("Stack3 is empty. unable to pop");
                    return -1;
                }
                return ms[top[stack]++];
        }
        return -1;
    }
    
    void display(int stack, int n)
    {
        stack--;
        switch(stack)
        {
            case 0:
                if(top[stack]==n/3+1)
                {
                    System.out.println("Stack1 is empty.");
                    return;
                }
                for(int i=top[stack];i<n/3+1;i++)
                    System.out.print(ms[i]+" ");
                break;
            case 1: 
                if(top[stack]==2*n/3+1)
                {
                    System.out.println("Stack2 is empty.");
                    return;
                }
                for(int i=top[stack];i<2*n/3+1;i++)
                    System.out.print(ms[i]+" ");
                break;
            case 2:
                if(top[stack]==n)
                {
                    System.out.println("Stack3 is empty.");
                    return;
                }
                for(int i=top[stack];i<n;i++)
                    System.out.print(ms[i]+" ");
                break;
        }
    }
}
