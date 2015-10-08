
import java.io.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tejashree pc
 */
/*
Logical Explaination:
Consider, family 1 has 2 boys and then a girl, BBG and 
Family 2 has only a Girl G and
Family 3 has 1 boy and then a girl, BG
If we keep collecting all this data together, and considering that the next child which is born can either be a girl or a boy with equal chances.
Then G=50% probability and B=50% probability.
Hence the gender ratio of the population (irrespective of how many boys were born before girls) will be 1:1 i.e 50% girls and 50% boys
*/
// Referred to solution in book
public class Solution07 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of families: ");
        int n=sc.nextInt();
        System.out.println("Ratio of Girls to entire population is: "+run(n));
    }
    
    public static double  run(int n)
    {
        int boys=0,girls=0;
        for(int i=0;i<n;i++)
        {
            int gender[]=runOne();
            girls += gender[0];
            boys += gender[1];
        }
        double ratio = girls/(double)(girls+boys);  // ratio of girls to total population of boys.
        return ratio;
    }
    
    public static int [] runOne() // returns number of boys born in the family by the time a girl is born.
    {
        Random r = new Random();
        int boys=0,girls=0;
        while(girls==0)
        {
            if(r.nextBoolean()) //if we get a girl
                girls++;
            else 
                boys++;
        }
        int gender[] = {girls, boys};
        return gender;
    }
}
