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
// Referred to book solution
public class Solution08 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        // code for testing
    }
    
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y)
    {
        int first_offset = x1 % 8;
        int first = x1/8;
        if(first_offset!=0)
            first++;
        int end_offset = x2 % 8;
        int last = x2/8;
        if(end_offset != 7)
            last--;
        //set all bytes
        for(int i=first;i<=last;i++)
            screen[(width/8)*y+i] = (byte) 0xFF;
        //create masks for start and end
        byte start_mask = (byte) (0xFF >> first_offset);
        byte end_mask = (byte) ~(0xFF >> (end_offset+1));
        
        //Set start and end
        if((x1/8) == (x2/8))    //x1 and x2 are in the same byte
        {
            byte mask = (byte) (start_mask & end_mask);
            screen[(width/8)*y+(x1/8)] |= mask;
        } 
        else
        {
            if(first_offset!=0)
            {
                int byte_number = (width/8)*y+first-1;
                screen[byte_number] |= start_mask;
            }
            if(end_offset!=7)
            {
                int byte_number=(width/8)*y+last+1;
                screen[byte_number] |= end_mask;
            }
        }
    }
}
