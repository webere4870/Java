/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceenvironment;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class FileWordCounter {

    public static void main(String args[]) throws IOException
    {
        
        // Make the hash table
        Map<String, Integer> wordCounter = new HashMap<>();
        Scanner input = new Scanner(Paths.get("input.txt"));
        
        
        
        
        // Read in data
        while(input.hasNext())
        {
            
            // If key exists, add 1 to count
            // Else, add to the map with value of 1
            String str = input.next();
            if(wordCounter.containsKey(str))
            {
                int count = wordCounter.get(str) + 1;
                wordCounter.put(str, count);
            }
            else
            {
                wordCounter.put(str, 1);
            }
            
            
            
        }
        
        
        
        // Create a set of unique keys
        // Sort the set
        // Make an iterator object
        Set<String> strList = wordCounter.keySet();
        Set<String> trSet = new TreeSet(strList);
        Iterator finalSet = trSet.iterator();
        
        
        
        // Loop through the iterator to display results
        while(finalSet.hasNext())
        {
            String temp = finalSet.next().toString();
            System.out.println(temp+ ": " + wordCounter.get(temp));
        }
        
    }  
    
}
