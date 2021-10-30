/**
 * In computer science, linear search or sequential search is a method for 
 * finding a target value within a list. It sequentially checks each element of 
 * the list for the target value until a match is 
 * found or until all the elements have been searched.
 * <p>
 * Worst-case performance      O(n)<br>
 * Best-case performance       O(1)<br>
 * Average performance         O(n)<br>
 * Worst-case space complexity O(1)<br>
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Linear_search">Linear Search (Wikipedia)</a>
 * <br>
 * @author Gourav Gupta
 */
public class LinearSearch {

    public static final int unorderedLinearSearch(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            int iValue = array[i];
            if (value == iValue)
                return i;
        }
        return Integer.MAX_VALUE;
    }
    
    public static final int orderedLinearSearch(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]){
                return i;
            }
            else if (array[i] > value){
             return -1;
            }
        }
        return Integer.MAX_VALUE;
    }
    
    public static void main(String[] args) {
      int[] integers = {1,2,3,4,5,6,7,8,8,8,9,9,9,0};
         //the element that should be found
         int shouldBeFound = 9;

         int atIndex = LinearSearch.unorderedLinearSearch(shouldBeFound, integers);

         System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                 , shouldBeFound, integers[atIndex], atIndex, integers.length));
         
         int[] sortedArray = {10,20,30,40,50};
         //the element that should be found
         int key = 30;
         
         atIndex = LinearSearch.orderedLinearSearch(key, sortedArray);

         System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                 , key, sortedArray[atIndex], atIndex, sortedArray.length));
         
 }
}
