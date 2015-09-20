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
        System.out.println("Enter the string1:");
        String s1=sc.nextLine();
        System.out.println("Enter the string2:");
        String s2=sc.nextLine();
        boolean f=false;
        if(s1.equals(s2))
        {
            f=true;
        }
        else if(s1.length()==s2.length()+1) // checking for delete operation
        {
            f=insert_removeEdit(s1,s2);
        }
        else if(s1.length()==s2.length())   // checking for replace operation
        {
            f=replaceEdit(s1,s2);
        }
        else if(s1.length()+1==s2.length()) // checking for insert operation which is inverse of delete
        {                                   // hence, we swap the strings to be passed
            f=insert_removeEdit(s2,s1);
        }
        else
            f=false;
        if(f)
            System.out.println("one or zero edits away");
        else
            System.out.println("more than one edit away");
    }
    public static boolean insert_removeEdit(String s1, String s2)
    {
        int i=0, j=0, check=0;
        while(i<s1.length()&&j<s2.length())
        {
            if(s1.charAt(i)!=s2.charAt(j))
            {
                i++;
                check++;
                if(check>1)
                    return false;
                continue;
            }
            i++;
            j++;
        }
        if(check<=1)
            return true;
        return true;
    }
    public static boolean replaceEdit(String s1, String s2)
    {
        int i=0, j=0, check=0;
        while(i<s1.length()&&j<s2.length())
        {
            if(s1.charAt(i)!=s2.charAt(j))
            {
                check++;
                if(check>1)
                    return false;
            }
            i++;
            j++;
        }
        if(check<=1)
            return true;
        return true;
    }
}
