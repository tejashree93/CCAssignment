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
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the string: ");
        String st=s.next();
        int i;
        boolean flag=isUnique(st);  // call function to check uniqueness of characters
        if(flag)
            System.out.println("All character in the String are unique!");
        else
            System.out.println("All characters in the String are not unique!");
    }
    public static boolean isUnique(String st)
    {
        if(st.length()>128)                 // there can only be 128 unique characters
            return false;
        for(int i=0; i<st.length(); i++)    // for all characters in the string we check whether the last Index of their occurrence is the same as the first index. 
        {                                   // if it isn't same, it means there are more than one occurrence of that character.
            if(i!=st.lastIndexOf(st.charAt(i)))     
            {
                return false;               //this means the character isn't unique in the string
            }
        }
        return true;                        // if the character is unique then the first and last index for it will be the same, hence all characters in the string are unique.
    }
    
}
