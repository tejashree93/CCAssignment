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
public class Solution09 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the string1:");
        String s1=sc.nextLine();
        System.out.println("Enter the string2:");
        String s2=sc.nextLine();
        String cs1=s1+s1;   // concatenating the first string helps to find whther the second string is a substring of it or not
        if(isStringRotate(cs1,s2))      // erbottlewat is a substring waterbottlewaterbottle 
            System.out.println("s2 is a rotation of s1!");
        else
            System.out.println("s2 is not a rotation of s1!");
    }
    public static boolean isSubstring(String large, String small)
    {
        CharSequence smalln=(CharSequence)small;
        if(large.contains(smalln))
            return true;
        return false;
    }
    public static boolean isStringRotate(String cs1, String s2)
    {
        if(cs1.length()/2!=s2.length()) // if length of the two initial strings is not equal then they aren't Rotations of each other
            return false;
        if(isSubstring(cs1,s2))
            return true;
        return false;
    }
}
