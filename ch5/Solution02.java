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
public class Solution02 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a real number between 0 and 1: ");
        double n=sc.nextDouble();
        String bn=binaryRepresentation(n);
        System.out.println("Result: "+bn);
    }
    
    public static String binaryRepresentation(double n)
    {
        if(n<=0||n>=1)
            return "Error";
        double f=0.5;
        StringBuilder s=new StringBuilder();
        s.append(".");
        //int a=0;
        while(n>0)
        {
            //System.out.println("while "+(a++)+" n="+n);
            if(s.length()>32)
            {
                //System.out.println("in >=32");
                return "Error";
            }
            if(n>=f)
            {
                s.append(1);
                n=n-f;
            }
            else
                s.append(0);
            f=f/2;
        }
        return s.toString();
    }
}
