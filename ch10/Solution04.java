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
        Listy ll=new Listy();
        System.out.println("Enter the elements in Listy in sorted order : ");
        int i=0;
        while(true)
        {
            System.out.print("Integer "+(i+1)+": ");
            int e=sc.nextInt();
            ll.addEle(e);
            i++;
            System.out.print("continue? 1=yes/0=no: ");
            int o=sc.nextInt();
            if(o==0)
                break;
        }
        System.out.println("Enter the element you want to search");
        int x=sc.nextInt();
        int index=ll.searchSorted(x);
        if(index>=0)
            System.out.println("Position of element is: "+index);
        else
            System.out.println("Element not found");
    }
}
class Listy
{
    List<Integer> l=new ArrayList<>();
    Listy(){l.add(0);}
    void addEle(int x)
    {
        l.add(x);
    }
    int elementAt(int index)    // for the sake of testing and implementation we use list.size()
    {
        if(index>l.size()-1)
            return -1;
        return l.get(index);
    }
    
    int searchSorted(int x) // referred to solution for the incrementing condition of i
    {
        int i=1;
        while(elementAt(i)!=-1 && elementAt(i)<x)
            i=i*2;
        return binarysearch(i/2,i,x)- 1;
    }
    
    int binarysearch(int l, int r, int x)
    {
        if(l<=r){
            int m=(l+r)/2;
            if(elementAt(m)==x)
                return m;
            else if(x<elementAt(m))
                return binarysearch(l,m-1,x);
            else
                return binarysearch(m+1,r,x);
        }
        return -1;
    }
}
