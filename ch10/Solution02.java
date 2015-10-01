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
// Referred to book solution and appendix 
public class Solution02 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the number of strings in array : ");
        int n = sc.nextInt();
        String a[]=new String[n];
        System.out.println("Enter the strings : ");
        for(int i=0; i<n; i++)
        {
            System.out.println("String "+(i+1)+": ");
            a[i]=sc.next();
        }
        sortStrings(a);
        for(int i=0; i<n; i++)
        {
            System.out.print("String "+(i+1)+": "+a[i]);
        }
        System.out.println();
    }
    public static String sortChars(String s)
    {
        char c[]=s.toCharArray();
        Arrays.sort(c);
        return (new String(c));
    }
    public static void sortStrings(String[] array) 
    {
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        // Grouping words by anagrams
	for (String s : array) 
        {
            String k = sortChars(s); 
            if (!hm.containsKey(k)) 
                hm.put(k, new ArrayList<String>());
            ArrayList<String> anagrams = hm.get(k);
            anagrams.add(s);
	}
        //Converting Hash Table to Array
	int i = 0;
	for (String k : hm.keySet()) 
        {
            ArrayList<String> l = hm.get(k);
            for (String t : l) 
                array[i++] = t;
        }
    }
}

