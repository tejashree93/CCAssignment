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

/*
We can do this by approaching the test as a binary indicator of positive or negative test for poisoned bottles of soda.
Since there are 1000 keys and only 10 test strips, we need to figure out a way to map the 1000bottles to 10strips at a time.
Let all bottles be numbered and let us consider the binary representation of these numbers as bottle identifiers.
If there's a 1 in the ith bit position of the identifer of a bottle, then we add a drop to the ith strip. 
We can thus carry out the test for 2^10 = 1024 bottles of soda.

After waiting for 7days we read the results,there will be strips i with a positive test for poison. Enter 1 in the ith bit positions and determine the id of the bottle by looking at the test results of all test strips.
*/
//referred to book solution
public class Solution10 {
    public static void main(String args[]) throws IOException
    {
    
    }
    
    
}
class Bottle
{
    boolean pois=false;
    int id;
    
    Bottle(int id)
    {
        this.id=id;
    }
    int getId()
    {
        return this.id;
    }
    
    void setPoison()
    {
        pois=true;
    }
    
    boolean isPoisoned()
    {
        return this.pois;
    }
}

class Strip
{
    static int days=7;
}
