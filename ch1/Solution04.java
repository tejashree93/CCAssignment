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
public class Solution04 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the String: ");
        String s=sc.nextLine();
        String ns[]=s.split(" ");
        String ms=new String();
        for(int i=0;i<ns.length;i++)
        {
            ms=ms+ns[i];
        }
        ms=ms.toLowerCase();
        char c[]=ms.toCharArray();
        merge(c,0,c.length-1);      // sorting the string gives one of the permutations of the string
        boolean f=isPalPerm(c);     // checks whether the characters can form a palindrome or not
        if(f)
            System.out.println("String is permutation of palindrome");
        else
            System.out.println("String is not permutation of palindrome");
    }
    
    public static boolean isPalPerm(char c[])
    {
        String s1=new String(c);
        int i=0, j=0, k=0;
        while(i<s1.length())         // iterate till the end of the string
        {
            j=0;
            char c1=s1.charAt(i);
            while(true)             // this loop is used to increment the count of the same character.
            {
                j++;
                i++;                
                if(i==s1.length())   // if end of the string has been reached, then check for the count of the last scanned character
                {   
                    if(j%2!=0)      // if the count is odd then increment the variable which is 
                        k++;        // used for checking if there are more than one characters with odd count
                    if(k>1)         // if there are more than one characters with an odd count then string isn't a palindrome
                        return false;
                    break;
                } 
                else if(c1!=s1.charAt(i)) // if old character isn't the same as the next one, then check for the count of the last scanned character
                {     
                    if(j%2!=0)            // if the count is odd then increment the variable which is 
                        k++;              // used for checking if there are more than one characters with odd count
                    if(k>1)               // if there are more than one characters with an odd count then string isn't a palindrome
                        return false;
                    break;
                }
            } 
        }
        return true;        // if the number of characters with an odd count is equal to or less than one, then string is palindrome
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
