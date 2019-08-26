package nadiatests;

import java.util.Arrays;
/** http://javarevisited.blogspot.sg/2013/03/Anagram-how-to-check-if-two-string-are-anagrams-example-tutorial.html
 *  Two strings are anagrams if they are written using the same exact letters, ignoring space, punctuation and capitalization. Each letter should have the same count in both strings
 *  For example, ‘Eleven plus two’ and ‘Twelve plus one’ are meaningful anagrams of each other.
 */
public class AnagramCheck {
    public static boolean isAnagram(String word, String anagram){
        if(word.length() != anagram.length()){
            return false;
        }
        char[] chars = word.toCharArray();
        for(char c : chars){
            int index = anagram.indexOf(c);
            if(index != -1){
                anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length());
            }else{
                return false;
            }
        }
        return anagram.isEmpty();
    }

    /* GOOD  */
    public static boolean isAnagram2(String word, String anagram){
        if(word.length() != anagram.length()){
            return false;
        }
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);
        return Arrays.equals(charFromWord, charFromAnagram);

    }

    public static boolean isAnagram3(String word, String anagram){
        char[] characters = word.toCharArray();
        StringBuilder sbSecond = new StringBuilder(anagram);
        for(char ch : characters){
            int index = sbSecond.indexOf("" + ch);
            if(index != -1){
                sbSecond.deleteCharAt(index);  //GOOD
            }else{
                return false;
            }
        }
        return sbSecond.length()==0 ? true : false;
    }

    public static void main(String args[]) {
        String a = "eleven plus two";
        String b = "twelve plus one";
        String c = "boat";
        String d = "toad";

        System.out.println(isAnagram(a,b));
        System.out.println(isAnagram2(a,b));
        System.out.println(isAnagram3(a,b));

        System.out.println(isAnagram(c,d));
        System.out.println(isAnagram2(c,d)) ;
        System.out.println(isAnagram3(c,d));

    }
}


