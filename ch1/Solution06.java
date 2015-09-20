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
public class Solution06 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the String");
        String s=sc.next();
        String comp=compress(s);
        System.out.println("Compressed string is: "+comp);
    }
    
    public static String compress(String s)
    {
        int i=0;
        String ns=new String();     // String that stores compressed form of String s
        int j=0;                    // counter for keeping a track of the same characters  
        while(i<s.length())         // iterate till the end of the string
        {
            j=0;
            char c=s.charAt(i);     // Store a new character for comparison
            while(true)             // this loop is used to increment the count of the same character.
            {
                j++;
                i++;                // this variable is to scan the complete length of the string
                if(i==s.length())   // if end of the string has been reached then append the last scanned character
                {                   // and its count to the compressed string ns and exit loop
                    ns=ns+c+j;
                    break;
                } 
                else if(c!=s.charAt(i)) // if old character isn't the same as the next one, then append last scanned
                {                       // character and its count to compressed string ns and exit loop
                    ns=ns+c+j;
                    break;
                }
            } 
        }
        if(ns.length()>s.length())  // compare the length of the new string with the old string and decide whther
            return s;               // new string is actually smaller in length than the original one. 
        return ns;                  // If so, then return the new compressed string else, return the original string
    }
}
