/*
 * Melody Tribble
 * 
 */
package stringanagram;

import java.util.*;


public class Anagram {
    
    /*
    This takes in two words and compares them. It will print out the number of deletions necessary to make them anagrams. 
    If there are no deletions they are anagrams of each other
    */
            
    public static void main(String[] args) {
        
        System.out.println("Enter two Strings");
        Scanner in = new Scanner(System.in);
        String a = in.next();   //scan in two strings
        String b = in.next();
        System.out.println(deletionsNeeded(a, b)); //
    }
    /*
    this compares two strings and determines how many characters would need to be deleted to make them anagrams of each other. 
    @param first, second strings
    @return number of deletions
    */
    public static int deletionsNeeded(String first, String second) 
    {
        int deletions = 1;
        char[] string1, string2;
        
        //converts strings to char arrays
        string1 = stringToChar(first);
        string2 = stringToChar(second);
        
        //sorts arrays
        string1 = sort(string1);
        string2 = sort(string2);
        
        int i = 0;//string 1 counter
        int j = 0;//string2 counter
        
        //iterates both arrays comparing their characters
        while( i < string1.length && j < string2.length )//
        {
            if(string1[i] != string2[j]){//if the [i] of string 1 doesn't equal [j] of string 2 check if it's greater or less than string1[i]
                
                if(string1[i] < string2[j]){ //if string 1 positin is less than string two postions, string2 does not contain that character 
                    i++;                     // iterate string 1 counter by 1
                    deletions++;            // add one to deletions counter
                    
                }else{      //string1[i] > string2[j] if string 1 position is greater than string 2 position
                    j++;    // string 1 does not contain the char in string two. Move string 2 counter by one
                    deletions++; //add on the deletion counter. 
                }
                    
            }else{ // string1 char and string2 char are equal
                if (i == string1.length && j < string2.length-1){ //if string one is complete but string 2 still has more characters
                    j++;                                          //move to next char in string2
                    deletions++;                                  //and delete
                }else if(j == string2.length && i < string1.length-1){//if string 2 is complete but string 1 still has more characters
                    i++;                                          //add move to next char in string 1
                    deletions++;                                  //and delete
                }else       //both strings have more chars to compare
                    i++;    //move to next char in both strings       
                    j++;
            }
        }
        return deletions;
    }
    
    /*
    This converts a string to a char array
    @param s is a string 
    @return a is a char array
    */
    public static char[] stringToChar(String s){
        char[] a;
        a = s.toCharArray();
        return a;
    }
    /*
    This sorts a char array
    @param a is an unsorted char array
    @return a is a sorted char array
    */
    public static char[] sort(char[]a){
        Arrays.sort(a);
        //printArray(a);
        return a;
    }
    /*
    This prints an array
    @param a is a char array
    */
    public static void printArray(char[] a)
    {
        String output = "";
        for(int i = 0; i< a.length; i++)
        {
            output += a[i];
        }
        System.out.println(output + "\n");
    }
    
}
