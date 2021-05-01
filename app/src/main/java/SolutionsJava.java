

/*  Using bit manipualtion.
    find the unique integer in an array.
    All but one integer appear twice in the array.  Find this unique number.

    a ^ a = 0
    a ^ 0 = a

    ^ is XOR, if two numbers are the same, they will yield 0.
    a ^ 0 yields a, which is the number we are looking for.
 */
 */
 */
 */
 */
 */
 */
 */
public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        int val = 0;
        for (int i=0; i<a.size(); i++){
        val = val ^ a.get(i);
        }

        return val;

        }


import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;



import java.io.*;
import java.util.*;
/*
Counting sort: not really using the counting sort idea.
Fails the test cases with 300,000 and 1 million test cases.
To save time, use StringBuilder but still fails the 2 test cases.
 */
 */
 */

public static void countSort(List<List<String>> arr) {
        String[] a = new String[101];
        // for (int i=0; i<a.length; i++){
        //     a[i]="";
        // }

        Arrays.setAll(a, i -> "");

        int ind;
        String str;
        for (int i=0; i<arr.size(); i++){
        ind = Integer.valueOf(arr.get(i).get(0));
        if (i<arr.size()/2){
        str="-";
        } else
        str = arr.get(i).get(1);

        a[ind] = a[ind] + str + " ";

        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<a.length; i++){
        if (a[i]!="")
        sb.append(a[i]);
        }

        System.out.println(sb.toString());




        }

/*
Counting sort: faile 1 test case with 1 million inputs
 */
public static void countSort(List<List<String>> arr) {
        List<List<String>> list = new ArrayList<List<String>>();
        int[] a = new int[101];

        for (int i=0; i<a.length; i++){
        a[i]=-1;
        }

        int ind;
        String str;

        for (int i=0; i<arr.size(); i++){
        List<String> l = new ArrayList<String>();
        list.add(l);
        }

        for (int i=0; i<arr.size(); i++){
        ind = Integer.valueOf(arr.get(i).get(0));
        if (i<arr.size()/2){
        str="-";
        } else
        str = arr.get(i).get(1);

        if (a[ind]!=-1){
        int n = a[ind];
        list.get(n).add(str);
        //list.set(n, list.get(n));
        } else {
        a[ind]=i;
        List<String> ls = new ArrayList<String>();
        ls.add(str);
        list.set(i, ls);

        }
        }

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<a.length; i++){
        if (a[i]<0)
        continue;

        for (int j=0; j<list.get(a[i]).size(); j++){
        //System.out.print(list.get(a[i]).get(j) + " ");
        sb.append(list.get(a[i]).get(j) + " ");
        }
        }

        System.out.println(sb.toString());



        }


/*
In place quick sort to save space.
It always use the last element of an input array as a pivot.
This using the last element of an array as pivot is called Lomuto partition scheme.
 */

 */
 */
 */

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = in.nextInt();
            // System.out.println(arr[i]);

        }

        quickSort(arr, 0, n-1);
    }

    public static int partition(int[] arr, int lo, int hi){
        int pivot = arr[hi];
        int i = lo;

        for (int j=lo; j<hi; j++){
            if (arr[j] < pivot){
                swap(arr, i, j);
                i=i+1;
            }
        }

        swap(arr, i, hi);

        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int lo, int hi){
        //if (hi >= lo){
        int p = partition(arr, lo, hi);
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }

        System.out.println();
        if (p-lo>1)
            quickSort(arr, lo, p-1);

        if (hi-p>1)
            quickSort(arr, p+1, hi);
        // }


    }
}

/*
    My own implementation of quick sort: showing each elements at each partition and merge
    Idea: Treat the first item in the array as the pivot.
    Partition the array in 3 sub arrays with left < pivot, right > pivot and mid == pivot.
    Each left and right sub arrays can further partition in to left/right/mid sub arrays until only 1 or less element left.
    At each partition, we followed by a merge operation.  When all the sub arrays are all done,
 */
 */
 */
 */
 */
public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int pivot = arr.get(0);
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> mid = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        for (int i=1; i<arr.size(); i++){
        if (arr.get(i)<pivot){
        left.add(arr.get(i));
        } else if (arr.get(i)>pivot){
        right.add(arr.get(i));
        } else
        mid.add(arr.get(i));
        }

        if (left.size() > 1)
        left = quickSort(left);

        if (right.size() > 1)
        right = quickSort(right);

        mid.add(pivot);

        List<Integer> ans = new ArrayList<Integer>();
        for (int i=0; i<left.size(); i++){
        System.out.print(left.get(i) + " ");
        ans.add(left.get(i));
        }

        for (int i=0; i<mid.size(); i++){
        System.out.print(mid.get(i) + " ");
        ans.add(mid.get(i));
        }

        for (int i=0; i<right.size(); i++){
        System.out.print(right.get(i) + " ");
        ans.add(right.get(i));
        }

        System.out.println();

        return ans;





        }



/*
        Insertion Sort:
        Input is a list of unsorted integers.
        Output is the same list with sorted integers.
        This is an in place sort, no need to create secondary array.  Saves memory.
        1st element of the array is sorted, so we start from the 2nd element all the
        way to the last element.
        We compare the elements before the first unsorted element.
        If the previous element is greater than the unsorted element,
        we move this previous element to the next index position.
        If the previous element is less or equal to the unsorted element,
        the unsorted element is placed right after the previous element.

        *Note, if we are compare all the previous elements until the first
        element and the unsorted element is still less or equal to it,
        we just place it at the begining of the array.  This is reflected by
        if (j==0){
            arr.set(j, curr);
        }
    */
public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        int curr;
        for (int i=1; i<n; i++){
        curr = arr.get(i);
        for (int j=i-1; j>=0; j--){
        if (curr <  arr.get(j)){
        arr.set(j+1, arr.get(j));
        if (j==0){
        arr.set(j, curr);
        }
        } else {
        arr.set(j+1, curr);
        break;
        }
        }

        for (int k=0; k<n; k++){
        System.out.print(arr.get(k) + " ");
        }
        System.out.println();
        }

        }


/*
previous was pushed successfully using token.
test again
 */
 */
/*
test upload to github after enable two way factor to use Token authentication
 */

/*
sorting the array as before.  but using bubble sor(is this a bubble sort).
Failed 2 test cases due to time out
 */
 */

class Result {

    public static List<String> bigSorting(List<String> unsorted) {
        int n = unsorted.size()-1;

        for (int i=0; i<unsorted.size(); i++){
            for (int j=0; j<n; j++){
                if (isBigger(unsorted.get(j), unsorted.get(j+1)))
                    swap(j, j+1, unsorted);
            }
            n--;
        }
        return unsorted;

    }

    static void swap(int i1, int i2, List<String> unsorted){
        String temp = unsorted.get(i2);
        unsorted.set(i2, unsorted.get(i1));
        unsorted.set(i1, temp);
    }

    public static boolean isBigger(String s1, String s2){
        if (s1.length() > s2.length())
            return true;
        else if (s1.length() < s2.length())
            return false;
        else {
            for (int i=0; i<s1.length(); i++){
                int result = s1.charAt(i) - s2.charAt(i);
                if (result!=0)  //if they are not equal, return the reslt
                    return result>0;
            }
        }

        return false;
    }

}

/*
This version passed all test cases.
It improves the compareTo method without using the build-in compareTo
 */
class Result {

    static class MyString implements Comparable<MyString>{
        String str;

        public MyString(String str){
            this.str=str;
        }

        private Integer length(){
            return this.str.length();
        }

        private Character charAt(int i){
            return this.str.charAt(i);
        }

        @Override
        public int compareTo(MyString aStr){

            if (str.length()!=aStr.length())
                return str.length()-aStr.length();

            for (int i=0; i<aStr.length(); i++){
                int result = this.str.charAt(i) - aStr.charAt(i);
                if (result!=0)  //if they are not equal, return the reslt
                    return result;
            }

            //they are equal at this step
            return 0;

        }
    }

    public static List<String> bigSorting(List<String> unsorted) {
        List<MyString> myString = new ArrayList<MyString>();
        for (int i=0; i<unsorted.size(); i++){
            myString.add(new MyString(unsorted.get(i)));
        }

        Collections.sort(myString);

        List<String> list = new ArrayList<String>();

        for (int i=0; i<myString.size(); i++){
            list.add(myString.get(i).str);
        }
        return list;

    }

}


/*
Sort an array of numeric strings where each string is a posiive number with anywhere from 1 to 1000000 digits.
Sort the array's elments in non-decreaseing or ascending order of their integer values and return the sorted array.
*****
My idea is to implement my own MyString class which implements Comparable interface.
In the compareTo method of the MyString class, I check if the two strings are the same length.
If they are I compare them at each Char begining from the Left Most one.

It fails one of the test case with 200000 elements due to time out.  got 16.80/20
 */
class Result {

    /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */

    static class MyString implements Comparable<MyString>{
        String str;

        public MyString(String str){
            this.str=str;
        }

        private Integer length(){
            return this.str.length();
        }

        private Character charAt(int i){
            return this.str.charAt(i);
        }

        @Override
        public int compareTo(MyString aStr){
            // this.str length compare to aStr.length
            // if this.str length > aString.length is true, return 1;
            // if this.str length > aString.length is false, return -1;
            // if they are equal, return 0
            int ans = ((Integer) this.str.length()).compareTo(aStr.length());

            if (ans==0){
                for (int i=0; i<aStr.length(); i++){
                    if (this.str.charAt(i)!=aStr.charAt(i)){
                        return ((Character) this.str.charAt(i)).compareTo((aStr.charAt(i)));
                    }
                }
            }

            return ans;
        }
    }

    public static List<String> bigSorting(List<String> unsorted) {
        // Write your code here

        List<MyString> myString = new ArrayList<MyString>();
        for (int i=0; i<unsorted.size(); i++){
            myString.add(new MyString(unsorted.get(i)));
        }

        Collections.sort(myString);

        List<String> list = new ArrayList<String>();

        for (int i=0; i<myString.size(); i++){
            list.add(myString.get(i).str);
        }
        return list;

    }

}
class Result {

    /*
     * Complete the 'jimOrders' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY orders as parameter.
     */

     /*
     Jim's Burgers has a line of hungry customers. Orders vary in the time it takes to prepare them. Determine the order the customers receive their orders. Start by numbering each of the customers from to

, front of the line to the back. You will then be given an order number and a preparation time for each customer.

The time of delivery is calculated as the sum of the order number and the preparation time. If two orders are delivered at the same time, assume they are delivered in ascending customer number order.
     */

    static class Pair implements Comparable<Pair>{
        Integer time;
        Integer id;

        public Pair(int time, int id){
            this.time=time;
            this.id=id;
        }

        @Override
        public int compareTo(Pair p){
            /* If this.time > p.time, return 1;
                if this.time < p.time, return -1;
                otherwise return 0
            */

            int ans = this.time.compareTo(p.time);

            if (ans==0)
                ans = this.id.compareTo(p.id);

            return ans;
        }
    }

    public static List<Integer> jimOrders(List<List<Integer>> orders) {
        // The tricky part is to write a Pair class implementing Comparable.
        // Also the 2nd field of Pair class stored the id of the customer;
        Pair[] arr = new Pair[orders.size()];
        for (int i=0; i<orders.size(); i++){
            arr[i]=new Pair(orders.get(i).get(0)+orders.get(i).get(1), i);
        }

        Arrays.sort(arr);

        List<Integer> list = new ArrayList<Integer>();

        for (int i=0; i<arr.length; i++){
            list.add(arr[i].id+1);
        }

        return list;

    }

}


// Swaping integers a number of times in an array to get the largest permutation:
/*
eg. 1 2 3 4 5, swaping once the largest permuation is 5 2 3 4 1, twice is 5 4 3 2 1
The trick is to update the source array 's index position of the swapped index.
 */
 */
public class Solution {

    // Complete the largestPermutation function below.
    static int[] largestPermutation(int k, int[] arr) {
        // index array to keep track of the index of every element in the original array.
        // This is crusial as it will save time to search for the index.
        int[] index = new int[arr.length+1];

        for (int i=0; i<arr.length; i++){
            index[arr[i]]=i;
        }

        int current = arr.length;
        int j;

        // if number of swap is larger than the length of the source array,
        // we just return a sorted list begining from the the size of the array.
        // size of the array is the largest value in the input int array.
        // Elements in the input array ranges from 1 to size of the array, and they are distinct.
        if (k >= arr.length){
            for (int i=0; i<arr.length; i++){
                arr[i]=current;
                current--;
            }
            return arr;
        }

        //swap the first element with the largest element, and second element with 2nd largest element......
        // at the same time update the index array to reflect the new index of the moved element
        for (j=0; j<k; j++){

            int src = index[current];
            if (!swap(src, j, arr, index)){
                if (k+1 <= arr.length)
                    k++;
            }

            current--;
        }



        return arr;


    }

    static boolean swap(int src, int dest, int[] arr, int[] index){
        if (src == dest)
            return false;

        index[arr[src]] = dest;
        index[arr[dest]] = src;
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
        return true;
    }


public class Solution {

    /*  Given a budget, buy two items to maximize the money spent.
        // we sort the keyboard in descending order and drives in accsending order.
        // We iterate the item in keyboard and drives until the sum is greater than
        // our budget b.  We keep that sum as the temporary max.  Then we start from
        // the next element of keyboard and continue at the element of drive where it
        // breaks the max budget when it were summing up with the previous keyboard item.
        // This will avoid looping for the entire drives items again.     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        int n = keyboards.length;
        int m = drives.length;
        int max=-1;
        Arrays.sort(keyboards);
        Arrays.sort(drives);

        // we sort the keyboard in descending order and drives in accsending order.
        // We iterate the item in keyboard and drives until the sum is greater than
        // our budget b.  We keep that sum as the temporary max.  Then we start from
        // the next element of keyboard and continue at the element of drive where it
        // breaks the max budget when it were summing up with the previous keyboard item.
        // This will avoid looping for the entire drives items again.
        int j=0;
        for(int i = n-1; i >=0; i--){    //putting j at the outside loop preventing from restarting from beginning again
            for(; j < m; j++){
                System.out.println("keyboard " + i + " is " + keyboards[i] + " drives " + j + " is " + drives[j]);
                if(keyboards[i]+drives[j] > b) break; //This prevents j from incrementing
                if(keyboards[i]+drives[j] > max)
                    max = keyboards[i]+drives[j];
            }
        }

        return max;

    }


/*/
DDUUUUDD return 1 valley because we go down 2 and go back up 2 to get to the sea level.
We don't count UUDD because that's count as mountain.
WE can use stack but time out if input is large.
The following has no time out issue without using stack
 */
 */
 */
 */
/*
 * Complete the 'countingValleys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */

public static int countingValleys(int steps, String path) {
        // Write your code here
        int counter=0;
        int levels=0;

        for (int i=0; i<path.length(); i++){
        if (path.charAt(i)=='U'){
        levels++;
        } else
        levels--;

        if (levels==0 && path.charAt(i)=='U')
        counter++;


        }

        return counter;

        }
/*
A teacher asks the class to open their books to a page number. A student can either start turning pages from the front of the book or from the back of the book. They always turn pages one at a time. When they open the book, page

is always on the right side:

image

When they flip page
, they see pages and . Each page except the last page will always be printed on both sides. The last page may only be printed on the front, given the length of the book. If the book is pages long, and a student wants to turn to page

, what is the minimum number of pages to turn? They can start at the beginning or the end of the book.

Given
and , find and print the minimum number of pages that must be turned in order to arrive at page .
 */

static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */

        int pagesTurn=0;
        int minPagesTurn=Integer.MAX_VALUE;

        //turning from back, if odd number of pages, the opening page contains 2 pages
        // so we have n-p+1-2 = n-p-1 pages more to go.  Each turn shows 2 pages, so /2
        if (n%2!=0){
        pagesTurn = (n-p-1)/2;
        if (pagesTurn<0)
        pagesTurn=0;

        //this ensure no negative pages
        if ((n-p-1)%2>0){
        pagesTurn++;
        }
        if (pagesTurn < minPagesTurn)
        minPagesTurn=pagesTurn;

        } else {
        // if even number of pages, we have n-p+1-1 = n-p pages
        // -1 because we have only 1 page in the last open page
        pagesTurn = (n-p)/2;
        if (pagesTurn<0)
        pagesTurn=0;

        if ((n-p)%2>0){
        pagesTurn++;
        }
        if (pagesTurn < minPagesTurn)
        minPagesTurn=pagesTurn;
        }


        // turning from the front
        pagesTurn = (p-1)/2;

        if (pagesTurn<0)
        pagesTurn=0;

        if ((p-1)%2>0){
        pagesTurn++;
        }

        if (pagesTurn < minPagesTurn)
        minPagesTurn=pagesTurn;

        return minPagesTurn;



        }


/*
Convert a day in 1700 to 2700 to date

Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on the Day of the Programmer (the 256th day of the year) during a year in the inclusive range from 1700 to 2700.

From 1700 to 1917, Russia's official calendar was the Julian calendar; since 1919 they used the Gregorian calendar system. The transition from the Julian to Gregorian calendar system occurred in 1918, when the next day after January 31st was February 14th. This means that in 1918, February 14th was the 32nd day of the year in Russia.

In both calendar systems, February is the only month with a variable amount of days; it has 29 days during a leap year, and 28 days during all other years. In the Julian calendar, leap years are divisible by 4; in the Gregorian calendar, leap years are either of the following:

    Divisible by 400.
    Divisible by 4 and not divisible by 100.

Given a year,
, find the date of the 256th day of that year according to the official Russian calendar during that year. Then print it in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is

.

For example, the given year
= 1984. 1984 is divisible by 4, so it is a leap year. The 256th day of a leap year after 1918 is September 12, so the answer is 12.09.1984

.

Function Description

Complete the dayOfProgrammer function in the editor below. It should return a string representing the date of the 256th day of the year given.

dayOfProgrammer has the following parameter(s):

    year: an integer

 */
 */
 */
public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        String date="";
        int number = 256;
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year<1918){
            if (year%4==0){
                days[1] = 29;
            }

            int i;
            for(i=0; i<days.length; i++){
                if (number>days[i]){
                    number=number-days[i];
                } else
                    break;
            }

            String month;
            date=number+"."+String.format("%02d", i+1)+"."+year;

        } else if (year==1918){
            days[1]=15;
            int i;
            for(i=0; i<days.length; i++){
                if (number>days[i]){
                    number=number-days[i];
                } else
                    break;
            }

            String month;
            date=number+"."+String.format("%02d", i+1)+"."+year;
        } else if (year > 1918 && year <=2700){
            if ((year%4==0&& year%100!=0)|| year%400==0){
                days[1] = 29;
            }

            int i;
            for(i=0; i<days.length; i++){
                if (number>days[i]){
                    number=number-days[i];
                } else
                    break;
            }
            date=number+"."+String.format("%02d",i+1)+"."+year;
        }


        return date;

    }

/*
    Given an array of integers and a positive integer k , determine the number of pairs where i < j and ar[i]+ ar[j] is divisible by .
    We can do O(n^2) by brute force.  However, we noticed we can use remainder of k to ground k groups of numbers.  then remainder 1 and k-1 is one group, 2 and k-2 is one group etc...
    This achieves O(n) times


    */
 */
 */
 */
// Complete the divisibleSumPairs function below.
static int divisibleSumPairs(int n, int k, int[] ar) {
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i=0; i<ar.length; i++){
        int remainder = ar[i]%k;
        if (map.containsKey(remainder)){
        List<Integer> itemsList = map.get(remainder);
        itemsList.add(ar[i]);
        map.put(remainder, itemsList);
        } else{
        List<Integer> itemsList = new ArrayList<Integer>();
        itemsList.add(ar[i]);
        map.put(remainder, itemsList);
        }
        }

        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
        List<Integer> items = entry.getValue();
        Integer key = entry.getKey();

        for (int i=0; i<items.size(); i++){
        System.out.print("key " + key + " value : " + items.get(i) + " ");
        }
        System.out.println();
        }

        int l=1;
        int counter=0;
        if (map.isEmpty())
        return 0;

        if (map.containsKey(0))
        counter= map.get(0).size() * (map.get(0).size()-1) / 2;
        for (int j=1; j<k; j++){
        if (j>k-l)
        break;

        if (map.containsKey(j) && map.containsKey(k-l)){
        if (j==k-l)
        counter+=map.get(j).size() * (map.get(k-l).size()-1)/2;
        else
        counter+=map.get(j).size() * map.get(k-l).size();
        }
        l++;
        }

        return counter;


        }

/*
Basically this is a problem finding the Smallest Common Multiplier and Largest Common Factor problem

There will be two arrays of integers. Determine all integers that satisfy the following two conditions:

    The elements of the first array are all factors of the integer being considered
    The integer being considered is a factor of all elements of the second array

These numbers are referred to as being between the two arrays. Determine how many such numbers exist.

Example

There are two numbers between the arrays: and .
, , and for the first value.
, and , for the second value. Return

.

Function Description

Complete the getTotalX function in the editor below. It should return the number of integers that are betwen the sets.

getTotalX has the following parameter(s):

    int a[n]: an array of integers
    int b[m]: an array of integers

Returns

    int: the number of integers that are between the sets

 */

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // This step gets the Smallest Common Multiplier of all the integers of a
        for (int i=0; i<a.size(); i++){
            int number = a.get(i);
            for (int j=2; j<=number; j++){
                int jPrimeCounter = 0;
                while (number%j==0){
                    number=number/j;
                    jPrimeCounter++;
                }

                if (map.containsKey(j)){
                    if (jPrimeCounter > map.get(j))
                        map.put(j, jPrimeCounter);
                } else if (jPrimeCounter>0){
                    map.put(j, jPrimeCounter);
                }
            }
        }

        Set entrySet = map.entrySet();

        // Obtaining an iterator for the entry set
        Iterator it = entrySet.iterator();

        // Iterate through HashMap entries(Key-Value pairs)
        int scm=1;
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            scm *= Math.pow(Double.valueOf((Integer)me.getKey()), Double.valueOf((Integer)me.getValue()));

        }


        map.clear();

        for (int i=0; i<b.size(); i++){
            int number = b.get(i);
            int entries = 0;
            //notice b.get(i) instead of using number.
            //this is purposely done to insert 1 (x^0 where x is the possible values of j), so when not all numbers have a common factor we use 1 instead for the common factor.
            for (int j=2; j<=b.get(i); j++){
                int jPrimeCounter = 0;
                while (number%j==0){
                    number=number/j;
                    jPrimeCounter++;
                }

                if (map.containsKey(j)){
                    if (jPrimeCounter < map.get(j))
                        map.put(j, jPrimeCounter);
                } else if (jPrimeCounter>0){
                    map.put(j, jPrimeCounter);
                } else  //this will make all the other j's have a 0 counter, necessary for when there are no common prime factor's.  EG. 2x2x2x3 and 2x2x2, with this else statement, we are ensuring 3^1 is not considered to be smallest, but 3^0 = 1 is smallest
                    map.put(j, 0);
            }


        }

        entrySet = map.entrySet();
        it = entrySet.iterator();
        int lcf=1;
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            lcf *= Math.pow(Double.valueOf((Integer)me.getKey()), Double.valueOf((Integer)me.getValue()));

        }

        int counter = 0;
        for (int k= scm; k<=lcf; k++){
            //k%scm==0 to ensure the k's are divisible by the scm
            if (lcf%k==0 && k%scm==0){
                counter++;
            }
        }

        return counter;
    }

}


/*
You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).

    The first kangaroo starts at location x1

and moves at a rate of v1
meters per jump.
The second kangaroo starts at location x2
and moves at a rate of v2

    meters per jump.

You have to figure out a way to get both kangaroos at the same location at the same time as part of the show. If it is possible, return YES, otherwise return NO.
 */
public class Solution {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x1>x2){
            if (v1<v2){
                if ((x1-x2)%(v2-v1)==0)
                    return "YES";
                else
                    return "NO";
            }else
                return "NO";
        }else if (x1<x2){
            if (v1>v2){
                if ((x2-x1)%(v1-v2)==0)
                    return "YES";
                else
                    return "NO";
            }
            else
                return "NO";
        } else{
            if (v1==v2)
                return "YES";
            else
                return "NO";
        }

    }


/*
 * Complete the timeConversion function below.
 convert a am/pm format to 24 hours format
 */
 */
static String timeConversion(String s) {
        /*
         * Write your code here.
         */

        int n=s.length();
        String format = s.substring(n-2, n);
        String sub = s.substring(0, n-2);
        String[] parts = sub.split(":");

        if (format.equalsIgnoreCase("PM")){
        if (Integer.valueOf(parts[0]) < 12)
        return Integer.valueOf(parts[0]) + 12 + ":" + parts[1]+":" + parts[2];
        else
        return sub;
        } else{
        if(Integer.valueOf(parts[0]) < 12)
        return sub;
        else
        return "00"+ ":" + parts[1]+":" + parts[2];
        }




        }


/*
Diagonal difference of a matrix
 */
public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int rows = arr.size();
        int diagonalSum1= 0;
        int diagonalSum2=0;
        for (int i=0; i<rows; i++){
        for (int j=0; j<rows; j++){
        if (i==j)
        diagonalSum1+=arr.get(i).get(j);

        if (i+j==rows-1)
        diagonalSum2+=arr.get(i).get(j);
        }
        }


        return Math.abs(diagonalSum1-diagonalSum2);

        }

/*
recursion to calculate the sum of an integer array
 */
static long aVeryBigSum(long[] ar) {
        int n = ar.length;
        if (n==1)
        return ar[0];

        return ar[0] + aVeryBigSum(Arrays.copyOfRange(ar, 1, n));


        }

/*
This version is an enhanced version comparing to the previous one.  It basically just calculate the distance from source to each neede origin and
stop the rest of the nodes.  This distance assume to be the shortest distance.  But still fail 19/20 test cases.  I guess there's no much difference
in terms of time saved.  Maybe we should use other method to solve this question instead of Dijkastra's algorithm


Kitty's calculation using Dijkastra's shortest path algorithm to calculate the shortest path from origin to each node on the graph.
Fail on 19/20 test cases due to time out.
 */
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        //System.out.println("n and q: " + n + " " +q);

        List<List<Node>>adj = new ArrayList<List<Node>>();
        for (int i=0;  i <= n;  i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        int src;
        int dest;
        int cost = 1;
        for (int i=0;  i < n-1;  i++) {
            src=in.nextInt();
            dest=in.nextInt();
            //System.out.println("src and dest: " + src + " " +dest);

            adj.get(src).add(new Node(dest, cost));
            adj.get(dest).add(new Node(src, cost));


        }

        DPQ dpq = new DPQ(n);

        int sum;
        int source;
        int destination;
        for (int i=0;  i < q;  i++) {
            sum=0;
            int k = in.nextInt();
            int[] s = new int[k];
            for (int j=0;  j < k;  j++) {
                s[j] = in.nextInt();
                //System.out.print("set to be calculated " + s[j] + " ");
            }
            //System.out.println();

            for (int l=0; l<k-1; l++){
                source = s[l];
                //dpq.dijkstra(adj, source);

                List<Integer> destList = new ArrayList<Integer>();
                List<Integer> destListBu = new ArrayList<Integer>();


                for (int m=l+1; m<k; m++){
                    //destination=s[m];
                    destList.add(s[m]);
                    destListBu.add(s[m]);
                    //sum = sum + source * destination * dpq.dist[destination];
                    // System.out.println("sum for combo " + source + " destination " +
                    // destination + " distance " + dpq.dist[destination] + " is " + sum);
                }

                dpq.dijkstra(adj, source, destList);

                for (Integer des: destListBu){
                    sum = sum + source * des * dpq.dist[des];
                }

            }

            System.out.println((int) (sum% (Math.pow(10, 9) + 7)));
        }


    }

    public static class Node implements Comparator<Node>{
        int node;
        int cost;

        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        public Node(){}

        @Override
        public int compare(Node node1, Node node2){
            if (node1.cost < node2.cost)    return -1;
            if (node1.cost > node2.cost)    return 1;
            return 0;
        }

        @Override
        public String toString(){
            return "node is " + node + " and cost is " + cost;
        }
    }

    static class DPQ{
        private int V;
        public int[] dist;
        private PriorityQueue<Node> pq;
        List<List<Node>> adj;
        private Set<Integer> settled;
        private List<Integer> destList;
        private boolean endOfCalculation = false;

        public DPQ(int V){
            this.V = V;
            dist = new int[V+1];
            settled = new HashSet<Integer>();

            //priority queue with capacity V and comparator new Node
            pq = new PriorityQueue<Node>(V, new Node());

        }

        public void dijkstra(List<List<Node>> adj, int src, List<Integer> destLst){
            this.adj = adj;
            this.destList = destLst;
            settled.clear();
            endOfCalculation = false;


            //pq = new PriorityQueue<Node>(V, new Node());

            for (int i=0; i<V+1; i++){
                dist[i] = Integer.MAX_VALUE;
            }

            //System.out.println("dijkstra src " + src);

            // add src node to pq
            pq.add(new Node(src, 0));
            //distance to src is 0
            dist[src] = 0;

            while (settled.size() != V && !endOfCalculation){
                //System.out.println("head of queque " + pq);
                // remove the minimum distance node
                // from the priority queue
                int u = pq.remove().node;
                settled.add(u);
                neighbors(u);
            }

        }

        public void neighbors(int u){

            for (int i=0; i< adj.get(u).size(); i++){
                Node v = adj.get(u).get(i);

                if (!settled.contains(v.node)){
                    //System.out.println("before dist[" + v.node + "] is " + dist[v.node]);
                    dist[v.node] = Math.min(dist[v.node], dist[u] + v.cost);
                    if (destList.contains(v.node)){
                        destList.remove(new Integer(v.node));
                    }

                    if (destList.isEmpty()){
                        endOfCalculation = true;
                        break;
                    }
                    // System.out.println("after dist[" + v.node + "] is " + dist[v.node]);
                    pq.add(new Node(v.node, dist[v.node]));
                }
            }
        }

    }
}


/*
Kitty's calculation using Dijkastra's shortest path algorithm to calculate the shortest path from origin to each node on the graph.
Fail on 19/20 test cases due to time out.
 */
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        //System.out.println("n and q: " + n + " " +q);

        List<List<Node>>adj = new ArrayList<List<Node>>();
        for (int i=0;  i <= n;  i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        int src;
        int dest;
        int cost = 1;
        for (int i=0;  i < n-1;  i++) {
            src=in.nextInt();
            dest=in.nextInt();
            //System.out.println("src and dest: " + src + " " +dest);

            adj.get(src).add(new Node(dest, cost));
            adj.get(dest).add(new Node(src, cost));


        }

        int sum;
        for (int i=0;  i < q;  i++) {
            sum=0;
            int k = in.nextInt();
            int[] s = new int[k];
            for (int j=0;  j < k;  j++) {
                s[j] = in.nextInt();
                //System.out.print("set to be calculated " + s[j] + " ");
            }
            //System.out.println();

            for (int l=0; l<k-1; l++){
                int source = s[l];

                DPQ dpq = new DPQ(n);

                dpq.dijkstra(adj, source);

                for (int m=l+1; m<k; m++){
                    int destination=s[m];
                    sum = sum + source * destination * dpq.dist[destination];
                    // System.out.println("sum for combo " + source + " destination " +
                    // destination + " distance " + dpq.dist[destination] + " is " + sum);
                }
            }

            System.out.println((int) (sum% (Math.pow(10, 9) + 7)));
        }


    }

    public static class Node implements Comparator<Node>{
        int node;
        int cost;

        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        public Node(){}

        @Override
        public int compare(Node node1, Node node2){
            if (node1.cost < node2.cost)    return -1;
            if (node1.cost > node2.cost)    return 1;
            return 0;
        }

        @Override
        public String toString(){
            return "node is " + node + " and cost is " + cost;
        }
    }

    static class DPQ{
        private int V;
        private int[] dist;
        private PriorityQueue<Node> pq;
        List<List<Node>> adj;
        private Set<Integer> settled;

        public DPQ(int V){
            this.V = V;
            dist = new int[V+1];
            settled = new HashSet<Integer>();

            //priority queue with capacity V and comparator new Node
            pq = new PriorityQueue<Node>(V, new Node());

        }

        public void dijkstra(List<List<Node>> adj, int src){
            this.adj = adj;

            for (int i=0; i<V+1; i++){
                dist[i] = Integer.MAX_VALUE;
            }

            //System.out.println("dijkstra src " + src);

            // add src node to pq
            pq.add(new Node(src, 0));
            //distance to src is 0
            dist[src] = 0;

            while (settled.size() != V){
                //System.out.println("head of queque " + pq);
                // remove the minimum distance node
                // from the priority queue
                int u = pq.remove().node;
                settled.add(u);
                neighbors(u);
            }

        }

        public void neighbors(int u){
            //System.out.println("neighbor of " + u + " size " + adj.get(u).size());

            for (int i=0; i< adj.get(u).size(); i++){
                Node v = adj.get(u).get(i);
                //System.out.println("neighbor of u " + v.node);

                if (!settled.contains(v.node)){
                    //System.out.println("before dist[" + v.node + "] is " + dist[v.node]);
                    dist[v.node] = Math.min(dist[v.node], dist[u] + v.cost);
                    // System.out.println("after dist[" + v.node + "] is " + dist[v.node]);
                    pq.add(new Node(v.node, dist[v.node]));
                }
            }
        }

    }
}


/*
using two stacks to solve the max index product problem (same as the previous problem) pass all test cases.
This problem can be easily solved by using two stacks in O(n).
First Stack stores index of nearest greator element on the left.
Second Stack stores index of nearest greator element on the right.

 */

public class Solution {
    // Complete the solve function below.
    static long solve(int[] arr) {
        long ans = 0;
        int n = arr.length;
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        int[] left = new int[n];
        int[] right = new int[n];
        int i;

        left[0]=0;
        s1.push(0);

        for (i=1; i<n; i++){
            while(!s1.isEmpty() && arr[i]>=arr[s1.peek()])
                s1.pop();

            if(s1.isEmpty())
                left[i] = 0;
            else
                left[i] = s1.peek()+1;  //index starts at 0, must add 1 because question's index start at 1

            s1.push(i);
        }

        right[n-1] = 0;
        s2.push(n-1);

        for(i=n-2; i>=0; i--){
            while(!s2.isEmpty() && arr[i]>=arr[s2.peek()])
                s2.pop();

            if(s2.isEmpty())
                right[i] = 0;
            else
                right[i] = s2.peek()+1;

            s2.push(i);
        }

        for(i=0;i<n;i++){
            ans=Math.max(ans,(long)left[i]*right[i]);
        }




        return ans;

    }

/*
Using one stack and my idea to solve the max index product problem.
 This approach fails 3 of the 12 test cases

You are given a list of numbers . For each element at position (), we define and as:
= closest index j such that j < i and . If no such j exists then = 0.
= closest index k such that k > i and . If no such k exists then

= 0.

We define
= * . You need to find out the maximum

among all i.

Input Format

The first line contains an integer
, the number of integers. The next line contains the

integers describing the list a[1..N].

Constraints


Output Format

Output the maximum
among all indices from to

.

Sample Input

5
5 4 3 4 5

Sample Output

8

Explanation

We can compute the following:



 */
 */
 */
public class Solution {
    static class Pair{
        int value;
        int index;

        public Pair(int value, int index){
            this.value=value;
            this.index=index;
        }
    }

    // Complete the solve function below.
    static long solve(int[] arr) {
        long max = 0;
        long n = arr.length;
        Stack<Pair> s = new Stack();
        int i=1;
        long topValue=0;
        long indexProduct=0;
        while (i<=n){
            if (!s.empty() && arr[i-1] > s.peek().value){
                topValue=s.pop().value;

                while(!s.empty()){
                    if(topValue==s.peek().value)
                        topValue=s.pop().value;
                    else{
                        break;
                    }
                }


                if (!s.empty()){
                    indexProduct = i * s.peek().index;
                }

                Pair aPair=new Pair(arr[i-1], i);
                s.push(aPair);

                if (indexProduct > max)
                    max = indexProduct;
            } else {
                Pair aPair=new Pair(arr[i-1], i);
                s.push(aPair);
            }
            i++;
        }

        return max;


    }

// Use the stack method to solve the JIm and the Skyscraper's problem. in O(n) time complexity.
// last two test cases fail due to wrong anser (could be because int/long.  But return change to long still fail)
public class Solution {
    static class APair{
        int value;
        int counter;

        public APair(int value, int counter){
            this.value=value;
            this.counter=counter;
        }
    }

    // Complete the solve function below.
    static long solve(int[] arr) {
        Stack<APair> s = new Stack();
        int n = arr.length;
        int i=0;
        APair pairTop = new APair(0, 0);
        long result=0;

        while(i<n){
            if (!s.empty() && arr[i]>s.peek().value){
                pairTop=s.pop();
                if (pairTop.counter>1)
                    //n*(n-1)/2 is the total combinations out of the numbers
                    result=result+pairTop.counter*(pairTop.counter-1)/2;
            } else if (!s.empty() && arr[i]==s.peek().value){
                s.peek().counter++;     // increement the counter of the same item
                i++;
            } else{
                s.push(new APair(arr[i], 1));
                i++;
            }
        }

        while(!s.empty()){
            pairTop = s.pop();
            result=result+pairTop.counter*(pairTop.counter-1)/2;
        }

        return result*2;


    }


// brute force method to solve the Jim and the Skyscrapers problem.
// got timed out
/*

Jim has invented a new flying object called HZ42. HZ42 is like a broom and can only fly horizontally, independent of the environment. One day, Jim started his flight from Dubai's highest skyscraper, traveled some distance and landed on another skyscraper of same height! So much fun! But unfortunately, new skyscrapers have been built recently.

Let us describe the problem in one dimensional space. We have in total
skyscrapers aligned from left to right. The th skyscraper has a height of . A flying route can be described as with , which means, Jim starts his HZ42 at the top of the skyscraper and lands on the skyscraper . Since HZ42 can only fly horizontally, Jim will remain at the height only. Thus the path can be valid, only if each of the skyscrapers is not strictly greater than and if the height of the skyscraper he starts from and arrives on have the same height. Formally, is valid iff and

.

Help Jim in counting the number of valid paths represented by ordered pairs

.

Input Format

The first line contains
, the number of skyscrapers. The next line contains

space separated integers representing the heights of the skyscrapers.

Output Format

Print an integer that denotes the number of valid routes.

Constraints

and no skyscraper will have height greater than and less than

.

Sample Input #00

6
3 2 1 2 3 3

Sample Output #00

8

 */

public class Solution {

    // Complete the solve function below.
    static int solve(int[] arr) {
        int counter=0;
        int n = arr.length;
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if (arr[i]<arr[j]){
                    break;
                }
                else if (arr[i] == arr[j]){
                    counter++;
                }
            }
        }
        System.out.println("counter " + counter);
        return counter*2;


    }

// This uses the Binary Index Tree to solve the same overlapping problem as previous commit.
// This takes O(logN) times and avoid time out.
/*
Dave_NoSleepOwl
4 years ago

I solved this using two binary indexed trees, longest running time being 0.28s. Let [L1,R1], [L2,R2] be intervals, with L1 <= R1, L2 <= R2. To check whether they overlap or not, we simply check if ((R2 < L1) || (L2 > R1)) holds. If this is true, then they are NOT overlapping, otherwise they overlap.

Let the set of all N intervals be given, say [A1,B1] ... [AN,BN], for each player interval [C,D] we want to count the number of NON-overlapping intervals from [Ai,Bi]'s, then the overlap count can be incremented by (N - (non-overlapping count)). We can use a binary indexed tree to preprocess the [Ai,Bi]'s to store the number of Bi's occurred BEFORE a given position, and another BIT tree for the number of Ai's occurring AFTER a given position.

Then, when the player interval [C,D] is given, simply use the BIT trees above to determine the number of Ai's greater then D, and the number of Bi's less then C.
 */
public class Solution {

    public static class FenwikTree {
        private int BIT[];

        public FenwikTree(int size) {
            BIT = new int[size];
        }

        public void add(int index, int value) {
            while (index <= BIT.length) {
                BIT[index-1] += value;
                index += (index & -index);
            }
        }

        public int sum(int index) {
            int s = 0;

            while (index > 0) {
                s += BIT[index-1];
                index -= (index & -index);
            }

            return s;
        }
    }


    // Complete the solve function below.
    static int solve(int[][] shots, int[][] players) {
        int n = shots.length;
        int m = players.length;

        FenwikTree aTree = new FenwikTree(100000);
        FenwikTree bTree = new FenwikTree(100000);

        for (int i = 0;i < n; i++) {
            aTree.add(shots[i][0], 1);
            bTree.add(shots[i][1], 1);
        }

        int sum = 0;
        for (int j = 0; j < m; j++) {
            int a = players[j][0];
            int b = players[j][1];
            sum += m - bTree.sum(a-1) - (m - aTree.sum(b));
        }

        return sum;


    }


public class Solution {

    // Base on the idea that if the [C, D] is the range of the player and [A, B] is the range of the shot.
    // if D is less than A or if C is greater than B, then there is no overlapping.
    // So the overlapping is the total of possible overlapping - non overlapping
    // This solution is simple but timed out on some cases
    static int solve(int[][] shots, int[][] players) {
        int count=0;
        System.out.println(players.length + "<-player, shots " + shots.length);
        for (int i=0; i<players.length; i++){
            for (int j=0; j<shots.length; j++){
                if (shots[j][0] > players[i][1])
                    count++;
                else if (shots[j][1]<players[i][0]){
                    count++;
                }
            }
        }

        return players.length * shots.length - count;


    }

//helper function to sanitize index
static int sanitizeIndex(int index,int n){
        if(index>=0&&index<n)
        return index;
        if(index<0)
        return index+n;

        return index%n;
        }
    /*
    For each student, we calculate the previous positions that will
    make the current student not finished.
    eg.  if we start at index 8, and the extra time for this student to
    finish is 3.  So basically starting at index 7 or 6 will guarantee a fail for
    student at index 8.  We get the starting index 6 by current index - extra time + 1
    which is 8-3+1=6; And the starting index guarantee to pass is current index + 1,
     which is the next nedex 8+1=9.
     After we get all the starting index and ending index, we put it in a running sum
     builder array.  The starting index will contribute 1 and ending index will contribute -1 to the running sum builder.

     Alter the running sum builder is finished, we loop through the values and add them up one by one to find the smallest value.  We are finding the smallest value because
     smallest unfinished is the same as largest finished.
         */
static int solve(int[]t){
        int arrSize=t.length;
        int[]runningSumBuilder=new int[arrSize];

        int startIndex;
        int endIndex;
        for(int i=0;i<arrSize; i++){
        if(t[i]==0||t[i]==arrSize)
        continue;

        startIndex=sanitizeIndex(i-t[i]+1,arrSize);
        endIndex=sanitizeIndex(i+1,arrSize);

        if(endIndex<=startIndex){
        runningSumBuilder[0]+=1;
        }

        runningSumBuilder[startIndex]+=1;
        runningSumBuilder[endIndex]-=1;
        }

        int min=Integer.MAX_VALUE;
        int studentStartIndex=0;
        int runningSum=0;


        for(int i=0;i<arrSize; i++){
        runningSum=runningSumBuilder[i]+runningSum;
        if(runningSum<min){
        studentStartIndex=i;
        min=runningSum;
        }
        }

        return studentStartIndex+1;


        }

/*
 * Complete the contacts function below.
 Use Trie tree to store 26 characters so each node has 26 children.
 When we add the contact name to the tree, we increase its node size by 1 to keep track of the number of
 name at that specific node(letter).  Its like finding the prefix at that node.
 We just return the size at that node to tell how many matches for that prefix.

 More challenging thing is to find out what are the names matching that prefix.
 */
 */
 */
 */
 */
 */
 */
static int[]contacts(String[][]queries){
/*
 * Write your code here.
 */


class TrieNode {
    int size;
    HashMap<Character, TrieNode> children = new HashMap();

    void putChildIfAbsent(char c) {
        children.putIfAbsent(c, new TrieNode());
    }

    TrieNode getChild(char c) {
        return children.get(c);
    }
}

class Trie {
    TrieNode root = new TrieNode();

    void addName(String name) {
        TrieNode curr = root;
        for (char c : name.toCharArray()) {
            curr.putChildIfAbsent(c);
            curr = curr.getChild(c);
            curr.size++;    // increse the size of current node
        }
    }

    // find name or part of name prefix
    int findNameCount(String name) {
        TrieNode curr = root;
        for (char c : name.toCharArray()) {
            curr = curr.getChild(c);
            if (curr == null)
                return 0;   //if any part of the name is empty, then no match
        }

        return curr.size;   //size records the number of match when we add
    }
}

    Trie trie = new Trie();
    List<Integer> arrList = new ArrayList<Integer>();
    String op = "";

        for(int i=0;i<queries.length;i++){
        for(int j=0;j<queries[i].length;j++){
        if(queries[i][j].equals("add")){
        trie.addName(queries[i][j+1]);
        break;
        }else if(queries[i][j].equals("find")){
        int found=trie.findNameCount(queries[i][j+1]);
        arrList.add(found);
        break;
        }
        }
        }


        int[]ans=new int[arrList.size()];
        for(int i=0;i<arrList.size();i++){
        ans[i]=Integer.parseInt(arrList.get(i).toString());
        }


        return ans;

        }


// This is a problem to find the prime numbers and use the prime number to
// do calculation.  The second part is test your queue techniques.
//  Which is very straight forward.
static int[] waiter(int[] number, int q) {
        /*
         * Write your code here.
         */
        Stack<Integer> s= new Stack<Integer>();
        Stack<Integer> b= new Stack<Integer>();
        Stack<Integer> a= new Stack<Integer>();

        for (int i=0; i<number.length; i++){
        s.push(number[i]);
        }

        boolean isPrime = true;
        List arrList = new ArrayList<Integer>();
        //add the first 2 prime numbers to the list
        arrList.add(2);
        arrList.add(3);

        //10000 will generate 1229 prime numbers;  Since the upper bound is 1200, we are good
        for (int i=4; i<=10000; i++){
        for (int j=2; j<=(int) Math.sqrt(i); j++){
        if (i%j==0 && i!=j){
        isPrime=false;
        break;
        }
        }
        if (isPrime){
        arrList.add(i);
        }
        isPrime=true;
        }

        System.out.println(arrList.size());

        int[] arr = new int[arrList.size()];
        for(int i = 0; i < arrList.size(); i++) {
        arr[i] = Integer.parseInt(arrList.get(i).toString());
        }

        Stack<Integer> temp = new Stack<Integer>();
        ArrayList<Integer> ansList = new ArrayList<Integer>();
        for (int j=0; j<q; j++){
        while(!s.empty()){
        Integer top=s.pop();
        if (top % arr[j] == 0){
        b.push(top);
        } else
        a.push(top);
        }

        while (!b.empty()){
        ansList.add((Integer)b.pop());
        }

        while (!a.empty()){
        temp.push(a.pop());
        }

        while (!temp.empty()){
        s.push(temp.pop());
        }
        }

        while (!s.empty()){
        ansList.add((Integer)s.pop());
        }

        int[] ans = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++) {
        ans[i] = Integer.parseInt(ansList.get(i).toString());
        }

        return ans;

        }


//Simple Text Editor
/*
In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, . You must perform operations of the following

types:

    append

- Append string to the end of
.
delete
- Delete the last characters of
.
print
- Print the character of
.
undo
- Undo the last (not previously undone) operation of type or , reverting

    to the state it was in prior to that operation.

Input Format

The first line contains an integer,
, denoting the number of operations.
Each line of the subsequent lines (where ) defines an operation to be performed. Each operation starts with a single integer, (where ), denoting a type of operation as defined in the Problem Statement above. If the operation requires an argument, is followed by its space-separated argument. For example, if and , line

will be 1 abcd.

Constraints

The sum of the lengths of all in the input
.
The sum of
over all delete operations

    .
    All input characters are lowercase English letters.
    It is guaranteed that the sequence of operations given as input is possible to perform.

Output Format

Each operation of type
must print the

character on a new line.

Sample Input

8
1 abc
3 3
2 3
1 xy
3 2
4
4
3 1

Sample Output

c
y
a

Explanation

Initially,
is empty. The following sequence of

operations are described below:

. We append to , so
.
Print the
character on a new line. Currently, the
character is c.
Delete the last
characters in (), so
.
Append
to , so
.
Print the
character on a new line. Currently, the
character is y.
Undo the last update to
, making empty again (i.e.,
).
Undo the next to last update to
(the deletion of the last characters), making
.
Print the
character on a new line. Currently, the character is a.
 */
public static void main(String[]args){
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String str="";
        Stack<String> stack=new Stack<String>();
        Scanner sc=new Scanner(System.in);
        // there are n queryies
        int n=sc.nextInt();
        int choice;
        int k;

        while(n>0){
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    stack.push(str);
                    str=str+sc.next();
                    break;
                case 2:
                stack.push(str);
                    k=sc.nextInt();
                    str=str.substring(0,str.length()-k);
                    break;
                case 3:
                    k=sc.nextInt();
                    System.out.println(str.charAt(k-1));
                    break;
                case 4:
                    str=stack.peek();
                    stack.pop();
                    break;
            }
            n--;
            }
        }


// LargestRectangle using stack

//For every bar ‘x’, we calculate the area with ‘x’ as the smallest bar in the rectangle. If we calculate such area for every bar ‘x’ and find the maximum of all areas, our task is done. How to calculate area with ‘x’ as smallest bar? We need to know index of the first smaller (smaller than ‘x’) bar on left of ‘x’ and index of first smaller bar on right of ‘x’. Let us call these indexes as ‘left index’ and ‘right index’ respectively.
//        We traverse all bars from left to right, maintain a stack of bars. Every bar is pushed to stack once. A bar is popped from stack when a bar of smaller height is seen. When a bar is popped, we calculate the area with the popped bar as smallest bar. How do we get left and right indexes of the popped bar – the current index tells us the ‘right index’ and index of previous item in stack is the ‘left index’. Following is the complete algorithm.
//
//        1) Create an empty stack.
//
//        2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
//        ……a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
//        ……b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
//
//        3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
static long largestRectangle(int[] a) {
        int max=0;  //overall max
        int i=0;    //index for iterate the array a
        int topIndex;   //index in array a at the top of stack
        Stack<Integer> s = new Stack<>();
        while(i<a.length){
        if(s.isEmpty()||a[s.peek()]<=a[i]){
        s.push(i++);
        }else{
        topIndex=s.pop();
        int currentMax=a[topIndex]*(s.isEmpty()?i:i-s.peek()-1);
        max=Math.max(currentMax, max);
        }
        }

        while(!s.isEmpty()){
        topIndex=s.pop();
        int currentMax=a[topIndex]*(s.isEmpty()?i:i-s.peek()-1);
        max=Math.max(currentMax, max);
        }
        return max;

        }



// Complete the largestRectangle function below.
static long largestRectangle(int[] a) {
        int max=0;
        //for each element in an array, we find the left and right bound of the
        //element that's occurs first less than the current height a[i].
        //We compute the area of this rectangle with max and update max area accordingly.
        //After finishing the loop, return max.
        for (int i=0; i<a.length; i++){
        int sum=a[i];
        //find the left bound of current rectangle i
        int k=i-1;
        while(k>=0){
        if(a[k]>=a[i]){
        sum=sum+a[i];
        max=Math.max(max, sum);
        } else{
        max=Math.max(max, sum);
        break;
        }
        k--;
        }

        //find the right bound of current ractangle i
        k=i+1;
        while(k<a.length){
        if(a[k]>=a[i]){
        sum=sum+a[i];
        max=Math.max(max, sum);
        } else{
        max=Math.max(max, sum);
        break;
        }
        k++;
        }
        }

        return max;


        }
/*
Game of two stacks
 */
 /*
  * Complete the twoStacks function below.
  */
 static int twoStacks(int x, int[] a, int[] b) {
         int lengthB = 0;
         int sum = 0;
         // sum all value in the b array until its sum <=x
         while (lengthB < b.length && sum + b[lengthB] <= x) {
         sum += b[lengthB];
         lengthB++;
         }

         // temporarily set the maxScore to the lengthB
         int maxScore = lengthB;

         // Add one item at a time from a stack to sum
         // If sume is bigger than x, keep removing the value of b stack begining
         // from the bottom of stack.  If after removing all values in b stack and
         // the sum is still bigger, break out of the loop.  maxScore should be the
         // length of bStack;
         // Otherwise, we continue to swap out the element in b stack and add element
         // in a stack to compute the new maxScore, if any, then update the maxScore.
         for (int lengthA = 1; lengthA <= a.length; lengthA++) {
         sum += a[lengthA - 1];

         while (sum > x && lengthB > 0) {
         lengthB--;
         sum -= b[lengthB];
         }

         if (sum > x) {
         break;
         }

         maxScore = Math.max(maxScore, lengthA + lengthB);
         }
         return maxScore;






         }

 // This use queue to solve the Down to Zero problem.
//This is the best of the 3 solutions.  Get 11.2 point.  passed half of the test cases
// the rest failed due to timeout;  need to optimize the code.
// The previous 2 solutions only get 8 points.
 public class Solution {

     static class Pair{
         int x;  // this refer to n
         int y;  // this refer to count

         Pair(int x, int y){
             this.x =x;
             this.y=y;
         }
     }

     /*
      * Complete the downToZero function below.
      */
     static int downToZero(int n) {
         Set<Integer> memo = new HashSet<Integer>();
         int count=0;
         Queue<Pair> queue = new LinkedList<Pair>();

         //HashMap item = new HashMap<Integer, Integer>();
         //item.put(n, count);
         queue.add(new Pair(n, count));

         while(!queue.isEmpty()){
             Pair item = queue.remove();
             n =item.x;
             count = item.y;

             //base case
             if (n<=1){
                 if (n==1)
                     count+=1;
                 break;
             }

             // decrease by 1
             if (!memo.contains(n-1)){
                 memo.add(n-1);
                 queue.add(new Pair(n-1, count+1));
             }

             // decrease by max of (a or b where a x b =n)
             int sqrt=(int) Math.sqrt(n);
             for (int i=sqrt; i>1; i--){
                 if (n%i==0){
                     int factor = n/i;
                     if(!memo.contains(factor)){
                         memo.add(factor);
                         queue.add(new Pair(factor, count+1));
                     }
                 }
             }


             System.out.println(item.x + " " + item.y);
         }
         return count;
     }

 /*
  * Complete the downToZero function below.
  */
 static int[] minMoves = new int[1000001];
 static int downToZero(int n) {
         /*
          * Write your code here.
          */

         // basic condition
         if (n<=3)
            return n;

         //if already know for n, just return the result without calculating
         if (minMoves[n]>0)
            return minMoves[n];

         int min = Integer.MAX_VALUE;

         //flag to avoid stackoverflow
         // if we are in the option 1 to find the min, then option 2 will not be necessary
         // It is because option 2 will produce min at n, option 1 is always smaller once
         // enter the for loop's n%i==0 condition.
         //option 1 to reduce to zero by keep dividing
         for (int i=(int) Math.floor(Math.sqrt(n)); i>=2; i--){
                if (n%i==0){
                int factor=n/i;
                min = Math.min(min, 1+downToZero(factor));
             }
         }

         //option 2 to reduce to zero by keep subtracting by 1
         min = Math.min(min, 1+downToZero(n-1));

         // store the result for
         minMoves[n]=min;

         return min;

         }


// method 1
// Dynamic programming to reduce n to zero
 static int downToZero(int n) {
         if (n<=3)
         return n;

         int[] dp = new int[n+1];
         for (int i=0; i<=n; i++){
         dp[i]=-1;
         }

         dp[0]=0;
         dp[1]=1;
         dp[2]=2;
         dp[3]=3;

         int sqrt;
         for (int i=4; i<=n; i++){
         if(dp[i]>-1)
         continue;

         int min = Integer.MAX_VALUE;
         sqrt=(int) Math.sqrt(i);

         while(sqrt>1){
         if (i%sqrt==0){
         int factor=i/sqrt;  //N=a*b -> factor is the larger of a or b
         if(dp[factor]>-1)
         continue;
         min=Math.min(min, 1+dp[factor]);
         }
         sqrt--;
         }

         min=Math.min(min, 1+dp[i-1]);
         dp[i]=min;
         }

         return dp[n];

         }


// Complete the minimumMoves function below.
// castle on the grid
static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY)    {
        if (startX==goalX && startY==goalY)
        return 0;

        //for going left/top/right/bottom rereferening the current point
        int[] xOffSet={-1, 0, 1, 0};
        int[] yOffSet={0, 1, 0, -1};
        int gridSize = grid.length;
        char[][] grids = new char[gridSize][gridSize];
        int[][] moves = new int[gridSize][gridSize];

        for (int i=0; i<grid.length; i++){
        for(int j=0; j<grid[i].length(); j++){
        grids[i][j] = grid[i].charAt(j);

        System.out.print(grid[i].charAt(j));

        //initial the moves array to -1, meaning not visited
        moves[i][j] = -1;
        }

        System.out.println();

        }

        moves[startX][startY]=0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        while (true){
        Point head= queue.poll();
        for(int i=0; i<xOffSet.length; i++){
        int nextX = head.x;
        int nextY = head.y;
        while(isOpen(grids, nextX+xOffSet[i], nextY+yOffSet[i])){
        nextX+=xOffSet[i];
        nextY+=yOffSet[i];
        if (nextX==goalX && nextY==goalY){
        return moves[head.x][head.y]+1;
        }

        if (moves[nextX][nextY]<0){
        moves[nextX][nextY]=moves[head.x][head.y]+1;
        queue.offer(new Point(nextX, nextY));
        }
        }
        }
        }


        }

public static boolean isOpen(char[][] grid, int x, int y){
        return x>=0 && x<grid.length && y>=0&&y<grid.length && grid[x][y]=='.';
        }


// Balance brackets using stack
// Complete the isBalanced function below.[({})] is a balanced string
static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++){
        if (s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
        stack.push(s.charAt(i));
        } else if (s.charAt(i)=='}'){
        if (stack.isEmpty())
        return "NO";
        if(stack.pop()!='{')
        return "NO";
        } else if (s.charAt(i)==']'){
        if (stack.isEmpty())
        return "NO";
        if(stack.pop()!='[')
        return "NO";
        } else if (s.charAt(i)==')'){
        if (stack.isEmpty())
        return "NO";
        if(stack.pop()!='(')
        return "NO";
        }
        }

        if (stack.isEmpty())
        return "YES";
        else
        return "NO";


        }


// Complete the isBalanced function below.[({})] is a balanced string
static String isBalanced(String s) {
        int n=-1;

        while (s.length()!=n){
        n=s.length();
        s=s.replace("[]", "");
        s=s.replace("{}", "");
        s=s.replace("()", "");
        }

        if (s.length()==0)
        return "YES";
        else
        return "NO";


        }

class Result {

    static class Graph
    {
        // A user define class to represent a graph.
        // A graph is an array of adjacency lists.
        // Size of array will be V (number of vertices
        // in graph)
        int V;
        ArrayList<ArrayList<Integer> > adjListArray;

        // constructor
        Graph(int V)
        {
            this.V = V;
            // define the size of array as
            // number of vertices
            adjListArray = new ArrayList<>(V);

            // Create a new list for each vertex
            // such that adjacent nodes can be stored
            System.out.println("V " + V);
            for (int i = 0; i < V; i++) {
                adjListArray.add(i, new ArrayList<>());
            }
        }

        // Adds an edge to an undirected graph
        void addEdge(int src, int dest)
        {
            // Add an edge from src to dest.
            adjListArray.get(src).add(dest);

            // Since graph is undirected, add an edge from dest
            // to src also
            adjListArray.get(dest).add(src);
        }

        int DFSUtil(int v, boolean[] visited)
        {
            // Mark the current node as visited and print it
            visited[v] = true;
            System.out.print(v + " ");
            // Recur for all the vertices
            // adjacent to this vertex
            int connected = 1;
            for (int x : adjListArray.get(v)) {
                if (!visited[x])
                    connected = connected+ DFSUtil(x, visited);
            }

            return connected;
        }

        List<Integer> connectedComponents()
        {
            // Mark all the vertices as not visited
            boolean[] visited = new boolean[V];
            List<Integer> result = new ArrayList<Integer>();

            for (int v = 0; v < V; v++) {
                if (!visited[v]) {
                    // print all reachable vertices
                    // from v
                    int nodesConnected = DFSUtil(v, visited);
                    System.out.println();
                    result.add(nodesConnected);
                }
            }

            return result;
        }
    }

    /*
     * Complete the 'componentsInGraph' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY gb as parameter.
     */

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        // set the number of vertices to number of test cases * 2  + 1
        // each test case has src and destination, that's why * 2.
        // plus 1 because we are begining at 0
        int totalVerticies = gb.size() * 2 + 1;
        Graph g = new Graph(totalVerticies);

        // add all the edges to graph
        for (int i=0; i<gb.size(); i++){
            g.addEdge(gb.get(i).get(0), gb.get(i).get(1));
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        List<Integer> result = new ArrayList<Integer>();
        // result contains the number of all connected vertices
        result = g.connectedComponents();

        // filter out the max connected vertices and min connected nodes (1 is      exlcuded)
        for (int i=0; i<result.size(); i++){
            if(result.get(i)>max)
                max=result.get(i);

            if (result.get(i)<min&&result.get(i)!=1)
                min=result.get(i);
        }
        result.clear();
        result.add(min);
        result.add(max);

        return result;

    }



}


static class Graph
{
    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices
    // in graph)
    int V;
    ArrayList<ArrayList<Integer> > adjListArray;

    // constructor
    Graph(int V)
    {
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new ArrayList<>();

        // Create a new list for each vertex
        // such that adjacent nodes can be stored

        for (int i = 0; i < V; i++) {
            adjListArray.add(i, new ArrayList<>());
        }
    }

    // Adds an edge to an undirected graph
    void addEdge(int src, int dest)
    {
        // Add an edge from src to dest.
        adjListArray.get(src).add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        adjListArray.get(dest).add(src);
    }

    void DFSUtil(int v, boolean[] visited)
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        // Recur for all the vertices
        // adjacent to this vertex
        for (int x : adjListArray.get(v)) {
            if (!visited[x])
                DFSUtil(x, visited);
        }
    }
    void connectedComponents()
    {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                // print all reachable vertices
                // from v
                DFSUtil(v, visited);
                System.out.println();
            }
        }
    }
}

    /*
     * Complete the 'componentsInGraph' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY gb as parameter.
     */

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        int totalVerticies = gb.size() * 2;
        Graph g = new Graph(totalVerticies);

        for (int i=0; i<gb.size(); i++){
            g.addEdge(gb.get(i).get(0), gb.get(i).get(1));
        }

        g.connectedComponents();


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        List<Integer> result = new ArrayList<Integer>();
        result.add(min);
        result.add(max);

        return result;

    }

}



//Create a MyQueue class to wrap the two stacks.
// First time implementing it as wrapper.
// Code is cleaner and reusability
public class Solution {

    public static class MyQueue<Integer>{
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stackReverse = new Stack<Integer>();

        public void enque(Integer number){
            stack.push(number);
        }

        public Integer deque(){
            if (queueSize()==0)
                return null;

            if(stackReverse.empty())
                reverseStack();

            return stackReverse.pop();
        }

        public Integer peek(){
            if (queueSize()==0)
                return null;

            if (stackReverse.empty())
                reverseStack();

            return stackReverse.peek();
        }

        public int queueSize(){
            return stack.size() + stackReverse.size();
        }

        public void reverseStack(){

            while (!stack.empty()){
                stackReverse.push(stack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        Scanner sc = new Scanner(System.in);
        // there are n queryies
        int n = sc.nextInt();
        int choice;

        while (n > 0) {
            choice = sc.nextInt();

            switch(choice){
                //case 1: just adding the val to the top of the original stack
                case 1:
                    int val = sc.nextInt();
                    queue.enque(val);

                    break;

                //case 2:  we only reverse the original stack and assign to                              // stackReverse when we stackReverse is empty.
                // This greatly increase efficiency and solved the time out problem
                case 2:
                    queue.deque();
                    break;

                // case 3 is the same as case 2, only need to reverseStack when empty
                case 3:
                    System.out.println(queue.peek());
                    break;
            }
            n--;
        }


    }



    // implementing a queue data structure using two stacks.
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stackReverse = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        // there are n queryies
        int n = sc.nextInt();
        int choice;

        boolean stackReversed = false;

        while (n > 0) {
            choice = sc.nextInt();

            switch(choice){
                //case 1: just adding the val to the top of the original stack
                case 1:
                    int val = sc.nextInt();
                    stack.push(val);

                    break;

                //case 2:  we only reverse the original stack and assign to                              // stackReverse when we stackReverse is empty.
                // This greatly increase efficiency and solved the time out problem
                case 2:
                    if(stackReverse.empty())
                        stackReverse = reverseStack(stack);

                    stackReverse.pop();
                    break;

                // case 3 is the same as case 2, only need to reverseStack when empty
                case 3:
                    if (stackReverse.empty())
                        stackReverse = reverseStack(stack);

                    System.out.println(stackReverse.peek());
                    break;
            }
            n--;
        }


    }


    public static Stack<Integer> reverseStack(Stack<Integer> stack){
        Stack<Integer> stackReverse = new Stack<Integer>();
        while (!stack.empty()){
            stackReverse.push(stack.pop());
        }

        return stackReverse;
    }
}



public class SolutionsJava {

    class SinglyLinkedListNode {
        public Integer data;
        public SinglyLinkedListNode next;

    }

    	/* Class node is defined as :
    class Node
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/

    static int height(Node N) {
        if (N == null)
            return 0;

        return N.ht;
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.ht = max(height(y.left), height(y.right)) + 1;
        x.ht = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.ht = max(height(x.left), height(x.right)) + 1;
        y.ht = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    static int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    static void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.val + " " + node.ht);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    static Node myInsert(Node node, int key){
        /* 1. Perform the normal BST insertion */
        if (node == null){
            Node newNode = new Node();
            newNode.val=key;
            newNode.ht = 0;
            return newNode;
        }

        if (key < node.val)
            node.left = myInsert(node.left, key);
        else if (key > node.val)
            node.right = myInsert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.ht = 1 + max(height(node.left),
                height(node.right));

                /* 3. Get the balance factor of this ancestor
            node to check whether this node became
            unbalanced */
        int balance = getBalance(node);
        int positiveFactor=1;
        int negativeFactor=-1;
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > positiveFactor && key < node.left.val)
            return rightRotate(node);

        // Right Right Case
        if (balance < negativeFactor && key > node.right.val)
            return leftRotate(node);

        // Left Right Case
        if (balance > positiveFactor && key > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < negativeFactor && key < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }



    static Node insert(Node root,int val)
    {
        //preOrder(root);

        //System.out.println("**********************************");

        root = myInsert(root, val);

        //preOrder(root);

        return root;
    }




    // Java version of remove duplicates; after convert to Kotlin it doesn't work
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        /*Another reference to head*/
        SinglyLinkedListNode curr = head;


        /* Traverse list till the last node */
        while (curr != null) {
            SinglyLinkedListNode temp = curr;
            /*Compare current node with the next node and
            keep on deleting them until it matches the current
            node data */
            while(temp!=null && temp.data==curr.data) {
                temp = temp.next;
            }
            /*Set current node next to the next different
            element denoted by temp*/
            curr.next = temp;
            curr = curr.next;
        }

        return head;

    }

    // AVL binary tree balanced height.
    // if return value is -1, the tree is not balanced.
    // other value means the tree is balanced.
    static int balanceHeight(Node root){
        if (root==null)
            return 0;

        int leftTreeHeight=balanceHeight(root.left);
        //if left subtree is not balanced, the whole tree is not balanced
        //-1 meaning not balanced.
        if (leftTreeHeight==-1)
            return -1;

        int rightTreeHeight=balanceHeight(root.right);
        //if right subtree is not balanced, the whole tree is not balanced
        if (rightTreeHeight==-1)
            return -1;

        // for a AVL binary tree, the balance factor is 1
        // if the left tree and right tree height is different more than 1,
        // the tree is not balanced.
        // change the balance factor to 0 make it checking a full balance tree
        // instead of AVL balance tree
        if (Math.abs(leftTreeHeight-rightTreeHeight) > 1)
            return -1;

        //return the max of the two sub trees plus 1.
        int height = Math.max(leftTreeHeight,rightTreeHeight)+1;
        System.out.println(root.val + " " + height + "*");
        return (Math.max(leftTreeHeight,rightTreeHeight)+1);
    }


    // check binary tree
    static boolean checkBST(Node root) {
        //continue the loop if root is not null
        //if root.left is not null, and root.left.data < root.data,
        //call checkBST recursively.
        // if root.left.data > root.data, return false
        // Similar idea for the right child of root.
        // make sure to break out the while loop when the sub tree are checked.
        // After the checking of the whole tree and still not false returned,
        // we can return true indicating it is a binary tree.
        while (root!=null){
            if (root.left!=null){
                if(root.left.data>root.data)
                    return false;
                else
                    checkBST(root.left);
            }

            if (root.right!=null){
                if(root.right.data<root.data)
                    return false;
                else
                    checkBST(root.right);
            }

            break;

        }

        return true;
    }



    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */

        int items=0;
        for (int i=0; i<indexes.length; i++){
            for (int j=0; j<indexes[i].length; j++){
                System.out.println(indexes[i][j] + " i " + i + " j " + j);
                items++;
            }
        }

        int[] index1D = new int[items+1];


        index1D[0] = 1;
        int idx = 1;

        for (int i=0; i<indexes.length; i++){
            for (int j=0; j<indexes[i].length; j++){
                index1D[idx] = indexes[i][j];
                idx++;
            }
        }

        for (int i=0; i<index1D.length; i++){
            System.out.print(index1D[i] + " ");
        }

        Node root=null;

        root = insertLevelOrder(index1D, root, 0);

        inOrder(root);

        //  for (int i=0; i<queries.length; i++){
        //      System.out.println(queries[i] + "******");
        //  }

        return indexes;

    }

    static int dis = 0;
    static public Node insertLevelOrder(int[] arr, Node root, int i){
        if (i<arr.length){
            Node temp=new Node(arr[i]);
            root = temp;

            System.out.println("construct tree node " + root.data);
            //insert to the left child, left child is 2*i + 1 since we start
            //with index 0;
            root.left=insertLevelOrder(arr, root.left, 2*i+1);

            //insert to the right child, right child is 2*i + 2
            root.right=insertLevelOrder(arr, root.right, 2*i+2);
        }

        return root;


    }

    static public void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "*");
            inOrder(root.right);
        }
    }

    // Purpose: construct a complete binary tree
    // arr: integer array holding the data values to be inserted to the tree
    // root; root node
    // i: ith index in the array
    public Node insertLevelOrder(int[] arr, Node root, int i){
        if (i<arr.length){
            Node temp=new Node(arr[i]);
            root = temp;

            //insert to the left child, left child is 2*i + 1 since we start
            //with index 0;
            root.left = insertLevelOrder(arr, root.left, 2*i+1);

            //insert to the right child, right child is 2*i + 2
            root.right = insertLevelOrder(arr, root.right, 2*i+2);
        }

        return root;


    }


    // Function to print tree nodes in InOrder fashion
    public void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        Tree t2 = new Tree();
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        t2.inOrder(t2.root);
    }



    //Huffman decoding

    /*
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;

*/

    void decode(String s, Node root) {
        Node current = root;

        //iterate the input code.
        // for each code, we traverse the tree from node and fetching the
        // correct letter.  Advance the index accordingly while traverse the tree.
        for (int i=0; i<s.length(); i++){
            while(current!=null){
                //check if a char is null
                if (s.charAt(i)=='0'){
                    if(current.left.data=='\0'){
                        i++;
                        current=current.left;
                    } else{
                        System.out.print(current.left.data);
                        current=root;
                        break;
                    }
                } else {
                    if (current.right.data=='\0'){
                        i++;
                        current=current.right;
                    } else{
                        System.out.print(current.right.data);
                        current=root;
                        break;
                    }
                }
            }

        }



    }

    // Complete the hasCycle function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode slowPtr=head;
        SinglyLinkedListNode fastPtr=head;

        //loop until fastPtr reach the end of the linked list
        while(fastPtr!=null){

            // advance slowPtr to the next node or else break;
            if (slowPtr.next!=null)
                slowPtr=slowPtr.next;
            else
                break;

            // advance fastPtr to the next node or else break;
            if(fastPtr.next!=null&&fastPtr.next.next!=null){
                fastPtr=fastPtr.next.next;
            } else
                break;

            // if fastPtr meet with slowPtr again, there is a loop
            if(slowPtr==fastPtr)
                return true;

        }

        // return false when reaching the end of the linkedlist
        return false;
    }

    // my version of remove duplicates;
    static SinglyLinkedListNode removeDuplicatesMyversion(SinglyLinkedListNode head) {
        /*Another reference to head*/
        SinglyLinkedListNode curr = head;


        /* Traverse list till the last node */
        while (curr != null) {
            SinglyLinkedListNode nextNode = curr.next;
            //make sure to do a null check for the next node
            // kotlin version doesn't have the null check.  Maybe because of that the 2 to 6 test cases fails
            if (nextNode!= null && curr.data == nextNode.data){
                nextNode = nextNode.next;
                curr.next = nextNode;
            } else {
                curr = curr.next;
            }

        }

        return head;

    }

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    // given two head nodes of two linked list, find the common node which points to the same memory address
    // algorithm: compare each node of list 1 to each node in list 2 using two while loop
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while(head1!=null){
            // assign head2 to a temp variable;
            SinglyLinkedListNode temp=head2;
            while (temp!=null){
                // compare head to each of the 2nd linked list node
                if (head1 == temp)
                    return head1.data;  // if node in list 1 == node in list 2; return

                temp=temp.next; //advance to the next node of list2
            }
            //advance to the next node of list 1
            head1=head1.next;
        }

        // no node is equal
        return -1;

    }



    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */

    // Insert a node into a doubly linked list in a sorted list and maintained the sorting property
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        // create the node with data
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        //assign head to current, and use current to do iterations
        DoublyLinkedListNode current;

        // if the lined list is empty, the newNode is the head of the list
        if (head==null){
            head=newNode;
        } else if (head.data >= data){ // insert new node to the front of the list
            //head's prev is newNOde
            head.prev=newNode;
            // newNode's next is head
            newNode.next=head;
            // newNode becomes the head of the linked list
            head=newNode;

        } else{
            current=head;
            while(current.next!=null && data>=current.next.data){
                current=current.next;
            }

            if (current.next!=null){
                // if current next is not null, have that node's prev point to the newNode
                current.next.prev=newNode;
            }

            //newNode's prev point to current
            newNode.prev=current;
            //newNode's next point to current next.  if current next is null, it points              //to null
            newNode.next=current.next;
            //current's next point to new node
            current.next=newNode;


        }

        //head is not changed, but the underlying nodes changed
        return head;

    }



    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    // reverse a doubly linked list
    // Same version of code doesn't work on Kotlin.
    // So remember if you think your Kotlin code is right but still fail some of the test cases,
    // , be sure to write the same version of code (usually just change the way variable is declared plus semicolon;),
    // and then it will pass the test cases.  It happened couple of times already.
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = null;
        DoublyLinkedListNode current = head;

        while(current!=null){
            // if the current's next pointer is null, we point the current's next to current's prev node and break out of the loop
            if (current.next==null){
                current.next=current.prev;
                break;
            }

            // make sure to store the current's previous node first; critical step
            DoublyLinkedListNode pre=current.prev;
            // current's prev node becomes current's next when reversing
            // make sure to use an example to walk thru the code if confused
            current.prev=current.next;
            // holding the next node before making change to it
            temp=current.next;
            // current's next is the previous node when reversing
            current.next=pre;

            // advance the next node
            current=temp;

        }

        return current;

    }


    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Binary tree preorder traversal using recursive
    public static void preOrder(Node root) {
        while(root!=null){      //we should use if(root!=null) instead of a while loop
            System.out.print(root.data + " ");
            if(root.left!=null)
                preOrder(root.left);

            if (root.right!=null)
                preOrder(root.right);

            break;

        }
    }

    // post order traversal using recursive method.
    // same idea as preOrder traversal, but delaying printing the node value until all the left/right childs are print
    public static void postOrder(Node root) {
        while(root!=null){

            if(root.left!=null)
                postOrder(root.left);

            if (root.right!=null)
                postOrder(root.right);

            System.out.print(root.data + " ");

            break;

        }
    }

    // in order traverse of a binary tree;
//    1. Traverse the left subtree, i.e., call Inorder(left-subtree)
//   2. Visit the root.
//   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
    public static void inOrder(Node root) {
        if(root!=null){

            if(root.left!=null)
                inOrder(root.left);

            System.out.print(root.data + " ");  //visit the root

            if (root.right!=null)
                inOrder(root.right);
        }

    }



    // find the height of a binary tree
    public static int height(Node root) {
        // if root is null, the height is 0
        if (root==null)
            return 0;

        // initialize left and right subtree height to 0;
        int leftTreeHeight=0;
        int rightTreeHeight=0;

        // if left subtree is not null, we have one more level plus the height of
        // its subtree
        if (root.left!=null)
            leftTreeHeight = height(root.left)+1;

        // same as the right subtree
        if (root.right!=null)
            rightTreeHeight=height(root.right)+1;

        // compare the height of the left and right subtree, we return the max of the two trees
        return Math.max(leftTreeHeight, rightTreeHeight);
    }

    //Breath first printing a binary tree values
    //It prints out the tree values at each level from root to leaves
    public static void printLevelOrder(Node node){
        //loop from level 1 to height of the tree
        // getHeight is another helper function to calculate the height of the tree
        for (int level=1; level<=height(node); level++)
            printGivenLevel(node, level);
    }

    // print the node in a given level
    public static void printGivenLevel(Node root, int level){
        // if the tree is null, return
        if(root==null)
            return;
        // if we arrive at that level, print the value out.
        if(level==1)
            System.out.println(root.data);
        else if(level>1){
            //we print its left child, in order to print it, its level has to decrease
            //(because we only printing it when level==1)
            //the more further traversing down, the level is higher to compensate that
            // for printing the value at level==1
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }




        public static int getLeftHeight(Node root) {
            // if root is null, the height is 0
            if (root==null)
                return 0;

            // initialize left and right subtree height to 0;
            int leftTreeHeight=0;

            // if left subtree is not null, we have one more level plus the height of
            // its subtree
            if (root.left!=null)
                leftTreeHeight = getLeftHeight(root.left)+1;


            return leftTreeHeight;
        }

        public static int getRightHeight(Node root) {
            // if root is null, the height is 0
            if (root==null)
                return 0;

            // initialize left and right subtree height to 0;
            int rightTreeHeight=0;

            // if left subtree is not null, we have one more level plus the height of
            // its subtree
            if (root.right!=null)
                rightTreeHeight = getRightHeight(root.right)+1;


            return rightTreeHeight;
        }

        public static void traverseRightTree(Node root){
            while(root!=null){
                System.out.print(root.data + " ");
                if (root.right!=null){
                    root=root.right;
                } else
                    break;
            }
        }

        public static void traverseLeftTree(Node root){
            while(root!=null){
                System.out.print(root.data + " ");
                if (root.left!=null){
                    root=root.left;
                } else
                    break;
            }
        }

        // Given a pointer to the root of a binary tree, print the top view of the binary tree.
        //
        //The tree as seen from the top the nodes, is called the top view of the tree.
        public static void topView(Node root) {
            // get the height of the straight left tree
            int leftHeight=getLeftHeight(root);

            // get the height of the straight right tree
            int rightHeight=getRightHeight(root);

            // if rightHeight is longer, print the right tree
            if (leftHeight<rightHeight){
                traverseRightTree(root);
            } else
                traverseLeftTree(root); // if leftHeight is longer, print the left tree
        }

    }




    // this is actually building a full binary tree;
    // all the data are inserted one node at a time
    public static Node insert(Node root,int data) {
        Node current = root;
        Node newNode = new Node(data);

        //
        if(current==null){
            root=newNode;
            return root;
        }

        while(current!=null){

            // put the data on the left side of the tree
            if(current.data>data){
                // insert the node here
                if(current.left==null){
                    current.left=newNode;
                    break;
                }

                // update the new current and continue the while loop
                current=current.left;
            }else{
                if(current.right==null){
                    current.right=newNode;
                    break;
                }

                current=current.right;
            }
        }

        return root;
    }


    // Binary search tree: Lowest Common Ancestor
    public static Node lca(Node root, int v1, int v2) {
        // set the root to the current common parent
        Node currentParent=root;

        while(root!=null){
            //if both v1 and v2 are on the left of the root,
            // we set root.left as the current common parent
            if(root.data>v1 && root.data>v2){
                currentParent=root.left;
                root=root.left;
                // if both v1 and v2 are on the right of the root,
                // we set root.right as the current common parent
            }else if (root.data<v1 && root.data<v2){
                currentParent=root.right;
                root=root.right;
                // if v1 and v2 is not on the same side, we stop there because
                // the common parent is found
            } else
                break;
        }

        return currentParent;
    }


    //Using Stack to keep track of the maximum element in the stack while adding and deleting nodes.
    public class Solution {
        private static class StackNode{
            int val;
            int curMax;

            public StackNode(int val, int curMax){
                this.val = val;
                this.curMax = curMax;
            }
        }


        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

            Scanner sc = new Scanner(System.in);
            // there are n queryies
            int n = sc.nextInt();
            int max = Integer.MIN_VALUE;

            Stack<StackNode> stack = new Stack<StackNode>();

            while (n > 0) {
                int choice = sc.nextInt();

                switch(choice){
                    // adding a node to the top of stack.  Also storing the max at that node
                    case 1:
                        int val = sc.nextInt();
                        max = Math.max(val, max);
                        stack.push(new StackNode(val, max));
                        break;

                     // reset the max depending if the stack is empty or not.
                    //  If not empty, get the max from the current node by using peek.
                    case 2:
                        if(!stack.isEmpty())
                            stack.pop();

                        // reset max
                        if(stack.isEmpty()){
                            max = Integer.MIN_VALUE;
                        } else
                            max = stack.peek().curMax;

                        break;

                    // Print the stack's current max value
                    case 3:
                        System.out.println(stack.peek().curMax);
                        break;


                }

                n--;
            }
            sc.close();
        }


        /*
         * Complete the cookies function below.
         *   Given k you need to have elements greater than k
            if a element is less than k perform :
            ( Least no+2* 2nd least number).
            *
            * Idea is to use min heap (priority Queque), and keep calculate the top two values until greater than k.
         */
        static int cookies(int k, int[] A) {
            /*
             * Write your code here.
             */

            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            int arrSize=A.length;

            for (int i=0; i<arrSize; i++){
                pq.add(A[i]);
            }

            int count=0;
            while(pq.size() > 1 && pq.peek() < k){
                int smallest = pq.poll();
                int second = pq.poll();

                int newVal = smallest + 2*second;
                pq.add(newVal);
                count++;
            }

            if (pq.peek() < k){
                return -1;
            }

            return count;
        }


        /*
         * Complete the 'equalStacks' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY h1
         *  2. INTEGER_ARRAY h2
         *  3. INTEGER_ARRAY h3
         */

        public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
            // Write your code here

            //Declare stacks
            Stack<Integer> s1= new Stack<Integer>();
            Stack<Integer> s2= new Stack<Integer>();
            Stack<Integer> s3= new Stack<Integer>();

            // calculate the sum in each list and assign values in list of reverse
            // to stack
            int sumS1 = 0;
            for (int i=h1.size()-1; i>=0; i--){
                s1.push(h1.get(i));
                sumS1 = sumS1 + h1.get(i);
            }

            int sumS2 = 0;
            for (int i=h2.size()-1; i>=0; i--){
                s2.push(h2.get(i));
                sumS2 = sumS2 + h2.get(i);
            }

            int sumS3 = 0;
            for (int i=h3.size()-1; i>=0; i--){
                s3.push(h3.get(i));
                sumS3 = sumS3 + h3.get(i);
            }

            // get the min height of the stacks
            int min = Math.min(Math.min(sumS1, sumS2), sumS3);

            // set all the stack flags to false
            boolean s1Flag=false;
            boolean s2Flag=false;
            boolean s3Flag=false;

            // if the height is larger than min, we take away the top element of the stack.
            // and then calculate the new min if it is smaller than the min.
            // if the height is the same as min, we set the flag to true.
            // when all the flags are set to true, meaning the heights of the stacks are same
            while(true){
                if (sumS1 > min){
                    s1Flag=false;
                    int val = s1.pop();
                    sumS1=sumS1-val;
                    if (sumS1 < min)
                        min=sumS1;
                } else if (sumS1== min){
                    s1Flag=true;
                }

                if (sumS2 > min){
                    s2Flag=false;
                    int val = s2.pop();
                    sumS2=sumS2-val;
                    if (sumS2 < min)
                        min=sumS2;
                } else if (sumS2== min){
                    s2Flag=true;
                }

                if (sumS3 > min){
                    s3Flag=false;
                    int val = s3.pop();
                    sumS3=sumS3-val;
                    if (sumS3 < min)
                        min=sumS3;
                } else if (sumS3== min){
                    s3Flag=true;
                }

                if (s1Flag && s2Flag && s3Flag)
                    break;

            }




            return min;

        }











    }
