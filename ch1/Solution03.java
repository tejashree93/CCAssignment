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
    public static void main (String args[]) throws IOException
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter String with padding and length:");
        String l=sc.nextLine();
        int len=sc.nextInt();
        char cl[]=l.toCharArray();
        String sol=urling(cl,len);
        System.out.println("New URLed string is: "+sol);
        
    }
    
    public static String urling(StringBuffer ns)
    {
        String sol=new String();
        for(int i=0;i<ns.length();i++)
        {
            if(ns.charAt(i)==' ')
            {
                sol=ns.deleteCharAt(i).toString();
                sol=ns.insert(i,"%20").toString();
            }
        }
        return sol;
    }
    public static String urling(char cl[], int len) // method that inserts %20 in place of spaces
    {
        int j=0;                        // variable that is used to populate the new array nc[] with characters.
        char nc[]=new char[cl.length];  // local character array to store the new string after replacing spaces with %20
        for(int i=0; i<len; i++)        // loop runs for the number of characters in the string without considering extra space. 
        {                               // that is the string's true length
            if(cl[i]==' ')              // if the character is a space then the 3 characters in the new array nc[] will be %,2,0.
            {
                nc[j++]='%';
                nc[j++]='2';
                nc[j++]='0';
            }
            else                        // if the character isn't a space then copy characters from the previous character array  
            {                           // to the new character array nc[]
                nc[j++]=cl[i];
            }
        }
        String sol=new String(nc);      // Convert the char array to string and return the solution
        return sol;
    }
}
