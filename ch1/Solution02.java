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
// the sorting in this solution could've been done using Collections.sort() method for Lists.
public class Solution02 {
    public static void main (String args[]) throws IOException
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter string 1");
        String s1=sc.next();
        System.out.println("Enter string 2");
        String s2=sc.next();
        boolean sol=checkPerm(s1,s2);       // call to the function that checks whether strings s1 and s2 are permutations of each other.
        if(sol)
            System.out.println("Strings 1 and 2 are permutations of each other!");
        else
            System.out.println("Strings 1 and 2 are not permutations of each other!");
    }
    public static boolean checkPerm(String s1, String s2)
    {
        char c1[]=s1.toCharArray();         // Storing each character from Strings s1 and s2 to Character Arrays c1 and c2 respectively so that we can sort the characters.
        char c2[]=s2.toCharArray();
        if(s1.length()!=s2.length())        //If the length of the 2 strings is not equal then they can't be permutations of each other.
            return false;
        else 
        {
            merge(c1,0,s1.length()-1);      // Sort the characters in String s1 and s2 so that we can compare them and find out whether the characters in the 2 strings match or not
            merge(c2,0,s2.length()-1);
            for(int i=0; i<s1.length();i++) // checking whther characters from s1 and s2 are a perfect match
            {                               // alternate method can be : String ns1=new String(c1);
                if(c1[i]!=c2[i])            // String ns2=new String(c2);
                    return false;           // if(ns1.equals(ns2))
            }                               // return true;
            return true;                    // else return false;
        }
    }
    public static void merge(char c[], int f, int l)    // This function divides the character array into 2 halves and calls function mergeList to sort and put them back in the array 
    {
        if(f<l)                                         // if the lower index f is less than the upper index l for a character array that has been passed to sort
        {
            int m=f+(l-f)/2;                            // Finding the middle portion of the array to be sorted 
            merge(c,f,m);                               // Sort first half of the array
            merge(c,m+1,l);                             // Sort second half of the array
            mergeList(c,f,m,m+1,l);                     // the function that actually sorts and merges the character array
        }
    }
    public static void mergeList(char c[], int lb1, int ub1, int lb2, int ub2)  // Sorts and merges the divided character arrays.
    {
        int i=lb1;      // start point to iterate through left half of the array
        int j=lb2;      // start point to iterate through right half of the array
        int k=0;
        char nc[]=new char[c.length];   // temporary char array to store sorted elements
        while(i<=ub1&&j<=ub2)           // iterates uptill the smallest length between the two arrays is reached and sorts
        {
            if(c[i]<c[j])
                nc[k++]=c[i++];
            else
                nc[k++]=c[j++];
        }
        while(i<=ub1)                   // if there are anymore elements remaining in the left array then add them to the sorted list
            nc[k++]=c[i++];
        while(j<=ub2)                   // if there are anymore elements remaining in the right array then add them to the sorted list
            nc[k++]=c[j++];
        for(int m=lb1,n=0; m<=ub2;m++,n++)  // transfer back elements to the original array as it is pass by reference
        {
            c[m]=nc[n];
        }
    }
}
