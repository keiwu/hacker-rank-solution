/*
Given n boxes, each box contain R/G/B color balls.
What's the minimum operations to separate them.
The balls are separated if no box contains balls of more than one color.
* In each operation, you can pick a single ball from some box and put it into another box.

Use of dynamic programing and bitmask technique
 */



public void minOperations() {
        int i, j;
        for (i = 0; i <= n; i++) {
        for (j = 0; j <= 7; j++) {
        dp[i][j] = (1<<30);
        }
        }
        dp[0][0] = 0;
        for (i = 0; i < n; i++){
        for (j = 0; j <= 7; j++){
        dp[i + 1][j | 1] = Math.min(dp[i + 1][j | 1], dp[i][j] + green.get(i) + blue.get(i));
        dp[i + 1][j | 2] = Math.min(dp[i + 1][j | 2], dp[i][j] + red.get(i) + blue.get(i));
        dp[i + 1][j | 4] = Math.min(dp[i + 1][j | 4], dp[i][j] + red.get(i) + green.get(i));
        }
        }
        j = 0;
        for (i = 0; i < n; i++){
        if (red.get(i) != 0) j |= 1;
        if (green.get(i) != 0) j |= 2;
        if (blue.get(i) != 0) j |= 4;
        }
        if (dp[n][j] >= (1<<30)) dp[n][j] = -1;
        System.out.println(dp[n][j]);
        }
        }

/*
   Parlindrome:
   Determine if a string can be arranged into parlindrome.
   Idea: even number of letters can be separate into two equal groups and arrange into parlindrome.
   Odd number of letters can be parlindrome only it has one group only.  eg. aaa is parlindrome, but aaabbb is not
 */
 */
 */
 */
public static String gameOfThrones(String s) {
        // Write your code here
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i=0; i<s.length(); i++){
        if (hm.containsKey(s.charAt(i))){
        hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
        } else
        hm.put(s.charAt(i), 1);
        }

        int counter=0;
        for (Map.Entry<Character, Integer> entry: hm.entrySet()){
        if (entry.getValue()%2!=0)
        counter++;
        }

        if (counter>1)
        return "NO";
        else
        return "YES";

        }



/*
 Anagram
 */
    Determine the minimum number of changes to make to change
    one string to another string.  Order doesn't matter.

    idea: iterate the first string and for each letter,
    check if the 2nd string contains that letter or not.
    If it contains that letter, remove it from the 2nd string,
    if it deosn't contain that letter, increment the counter by 1.

    The couner is the min number of changes needed.

    **Logic:
    If the 2nd string contains the same letter, then no need to change.
    If the 2nd string doesn't contain the same letter, there is one change.
    We also have to remove that letter from the 2nd string.  This is because
    1st string may have duplciate letter, so removing it from 2nd string
    to avoid double counting



    */

public static int anagram(String s) {
        // Write your code here

        if (s.length()%2!=0)
        return -1;

        int counter=0;

        List<Character> firstHalf = new ArrayList<Character>();
        List<Character> secondHalf = new ArrayList<Character>();

        for (int i=0; i<s.length()/2; i++){
        firstHalf.add(s.charAt(i));
        }

        for (int j=s.length()/2; j<s.length(); j++){
        secondHalf.add(s.charAt(j));
        }

        for (int k=0; k<firstHalf.size(); k++){
        if (secondHalf.contains(firstHalf.get(k))){
        secondHalf.remove(firstHalf.get(k));
        } else
        counter++;

        }

        return counter;

        }

        }
//use retainAll() built in java collection method to keep the matching set.
//It's like intersection of the sets by using retainAll
public static int gemstones(List<String> arr) {
        // Write your code here
        Set<Character> hset = new HashSet<Character>();
        if (arr.size()>=1){
        hset = convertToSet(arr.get(0));
        }



        for (int i=1; i<arr.size(); i++){
        hset.retainAll(convertToSet(arr.get(i)));
        }



        return hset.size();

        }

public static Set<Character> convertToSet(String s){
        Set<Character> hset = new HashSet<Character>();
        for (char c: s.toCharArray()){
        hset.add(Character.valueOf(c));
        }
        return hset;
        }

/*
Problem: Find the number of characters that occur in all strings of a list.
We store all the characters of the first item in the list to hashset.
Here hashset helps to remove the duplicate items.

Then we iterate thru the rest of the items in the list against the hashset.
If each item in the hashset occurs in the items in the list, then we increment the counter meaning we found one more.
 */
 */
 */
 */
 */
 */
public static int gemstones(List<String> arr) {
        // Write your code here
        Set<Character> hset = new HashSet<Character>();
        if (arr.size()>=1){
        for (int i=0; i<arr.get(0).length(); i++){
        hset.add(arr.get(0).charAt(i));
        }
        }

        Character current;
        int counter = 0;
        boolean found;
        Iterator<Character> it = hset.iterator();
        while (it.hasNext()){
        current = it.next();
        found = true;
        for (int i=1; i<arr.size(); i++){
        if (arr.get(i).indexOf(current)==-1){   //Instead of using contains, we use indexOf to see if the specific character occurs; if not, a -1 is returned
        found = false;
        break;
        }
        }

        if (found)
        counter++;
        }

        return counter;

        }

        }



/*
Given a string, remove characters until the string is made up of any two alternating characters.
When you choose a character to remove, all instances of that character must be removed.
Determine the longest string possible that contains just two alternating letters.

constraint: character is in the range of [a-z]

eg: "abaccba" will return 5 because removing 'c' will result "ababa" which is length of 5


 */

class Result {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        // Write your code here
        boolean found = false;
        int digits = 1;
        String subStr;
        int i=0;
        int subStrLth;
        long subStrNum;
        String nextStr;
        long nextNum;
        long startNum;
        while(digits<=s.length()/2){
            subStr = s.substring(i, digits);
            subStrNum = Long.parseLong(subStr);
            startNum = subStrNum;
            subStrLth = String.valueOf(subStrNum+1).length();
            int j=subStr.length();
            while (j<s.length()){
                int startIdx = j;
                int endIdx = startIdx + subStrLth;
                if (endIdx > s.length()){
                    found = false;
                    break;
                }
                nextStr = s.substring(startIdx, endIdx);
                nextNum = Long.parseLong(nextStr);
                if (subStrNum + 1 != nextNum){
                    found = false;
                    break;
                } else if (subStrNum+1 == nextNum && endIdx == s.length()){
                    found = true;
                    break;
                }
                subStrNum = nextNum;
                subStrLth = String.valueOf(subStrNum+1).length();
                j = endIdx;
            }

            if (found){
                System.out.println("YES " + startNum);
                break;
            }
            digits++;
        }

        if (!found)
            System.out.println("NO");



    }

}

class Result {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    static final int NUMBER_OF_LETTERS = 26;
    static final int ASCII_OFFSET = 97;
    public static int alternate(String s) {
        // Write your code here

        String str = s;
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=0; i<s.length(); i++){
            if (!stack.isEmpty() &&stack.peek() == s.charAt(i)){
                str = str.replaceAll(String.valueOf(s.charAt(i)), "");
                stack.pop();

            } else{
                stack.push(s.charAt(i));
            }
        }


        char[][] charMatrix = new char[NUMBER_OF_LETTERS][NUMBER_OF_LETTERS];
        int[][] countMatrix = new int[NUMBER_OF_LETTERS][NUMBER_OF_LETTERS];

        int max = -1;
        int idx;
        char c;
        for (int i=0; i<str.length(); i++){
            c = str.charAt(i);
            idx = (int) c - ASCII_OFFSET;

            for (int j=0; j<NUMBER_OF_LETTERS; j++){

                if (charMatrix[idx][j]!=c && countMatrix[idx][j]!=-1){
                    countMatrix[idx][j]++;

                } else
                    countMatrix[idx][j]=-1;

                charMatrix[idx][j]=c;
            }

            for (int k=0; k<NUMBER_OF_LETTERS; k++){
                if(charMatrix[k][idx]!=c && countMatrix[k][idx]!=-1){
                    countMatrix[k][idx]++;

                } else
                    countMatrix[k][idx] = -1;

                charMatrix[k][idx]=c;

            }


        }

        for (int i=0; i<NUMBER_OF_LETTERS; i++){
            for (int j=0; j<NUMBER_OF_LETTERS; j++){
                if (countMatrix[i][j]>max)
                    max = countMatrix[i][j];
            }
        }


        return max>=2?max:0;

    }

}




    /*
        Problem: Find a integer in the arraylist such that the sum of the numbers
        on its left is the sum of the numbers on its right.

        Idea: keep a leftSum variable while going thru the list from index 0.
        The leftSum should equal to half of the (sum of the list minus the number of
        the current index) / 2.


    */
public static String balancedSums(List<Integer> arr) {
        // Write your code here
        int leftSum=0;
        int sum=0;

        for (int i=0; i<arr.size(); i++){
        sum+=arr.get(i);
        }

        for (int j=0; j<arr.size(); j++){
        if (leftSum==(sum-arr.get(j))/2)
        return "YES";

        leftSum+=arr.get(j);
        }

        return "NO";

        }

/*
Find two numbers in an array with a sum in O(n) times.
Same idea as using HashMap.  This time using Array.
 */
 */
 */
public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        int frequency[] = new int[10001];
        List result = new ArrayList<Integer>();
        Arrays.fill(frequency, -1);
        for (int i=0; i<arr.size(); i++){
        int x = arr.get(i);
        int y = m - x;

        if (y>=0){
        int j = frequency[y];

        if (j!=-1){
        result.add(j+1);
        result.add(i + 1);
        break;
        }

        frequency[x] = i;
        }



        }

        return result;


        }

        }

/*
O(n) time to find two numbers in a list sum up to a number by using hashmap
 */
*/
 */
public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List result = new ArrayList<Integer>();
        for (int i=0; i<arr.size(); i++){
        int x = arr.get(i);
        int y = m - x;

        //get the index of the other value
        Integer j = map.get(y);

        //if that value is found, we return the result
        if (j!=null){
        result.add(j+1);
        result.add(i + 1);
        break;
        }

        // if not found, we add the current value as key and index as value
        map.put(x, i);


        }

        return result;


        }

        }

/*
Two people are playing Nimble! The rules of the game are:

    The game is played on a line of n

squares, indexed from 0 to n-1. Each square i(where 0<=i<n) contains Ci
coins. For example: [0, 2, 3, 0, 6]
nimble.png
The players move in alternating turns. During each move, the current player must remove exactly 1
coin from square i and move it to square j if and only if 0<=j < i
.
The game ends when all coins are in square 0

    and nobody can make a move. The first player to have no available move loses the game.

Given the value of n

and the number of coins in each square, determine whether the person who wins the game is the first or second person to move. Assume both players move optimally.

Input Format

The first line contains an integer, T
, denoting the number of test cases.
Each of the 2T

subsequent lines defines a test case. Each test case is described over the following two lines:

1. An integer, n , denoting the number of squares.
2. n space-separated integers, C0, C1, ....., Cn-1 , where each Ci describes the number of coins at square i

    .

Constraints
1 <= T <= 10^4
1 <=n <=100
0<=Ci <=10^9


Output Format

For each test case, print the name of the winner on a new line (i.e., either
or

).

Sample Input

2
5
0 2 3 0 6
4
0 0 0 0

Sample Output

First
Second

 */


public static String nimbleGame(List<Integer> pile) {
        int nimSum = 0;
        //use the position of each dice as its height, then we have
        // converted the original question to a nim problem.
        // For example, if the original input is [0, 2, 3, 0, 6],
        // meaning there are 0 dice in square 0, 2 dices in square 1,
        // 3 dices in square 2, 0 dice in square 3, and 6 dices in square 4.
        // We convert to [1, 1, 2, 2, 2, 4, 4, 4, 4, 4, 4], meaning 2 piles of dices
        // having height of 1 (each of the two dices in square 1 can only have 1 move,
        // namely, to square 0), 3 pile of dices have heights of 2, and 6 piles of dices
        // having hieght of 4 (the height meaning the number of ways to move a dice.  The
        // dice in square 4 can move to square 3, 2, 1, 0, thus a height of 4.)

        // We can now use the nim sum to calculate the answer.
        // we only need to calculate the squares with odd number of dices.
        // Further, we only need to calculate XOR 1 if the dices is odd number.
        // It is true because the even ones are canceled out when calculating the
        // nim sum with XOR.
        for (int i = 0; i < pile.size(); i++) {
            if (pile.get(i)%2!=0){
                nimSum = nimSum ^ i;

             }
        }

        if (nimSum > 0)
        return "First";
        else
        return "Second";


        }

        }


package kei.su.hackerranksolutions;

public static String misereNim(List<Integer> pile){
        // Write your code here
        int nimSum=0;
        int counter=0;
        for(int i=0;i<pile.size();i++){
            nimSum=nimSum^pile.get(i);
            if(pile.get(i)==1)
                counter++;
        }

        //This to handle the situation when all the piles have exactly 1 object each.
        // If begeining at even number of piles and First player remove a pile to
        // reduce to odd number of piles, then First player wins.
        // Otherwise First player lose.
        if(counter==pile.size()){
            if(counter%2==0)
                return"First";
            else
            return"Second";
        }
        //if I can make a move so changin nimsum from non 0 to 0, then I will win.
        //So we need nimsum to be > 0, and after making a move, the nimsum becomes 0
        if(nimSum>0)
            return"First";
        else
            return"Second";

}



/*
__pranjal
        3 months ago

        I don't usually comment but this one took a lot more time so here it goes

        If there are two players 1,2 and two identical towers

        player 2 will always win. ie. any move made by player 1 in tower1 can be made by player2 in tower2 However if the towers are not equal player 1 will win, he can make thetowers identical. Mathematically num (xor) num == 0 ? player2win ; player1win

        For three towers [6,5,3] I can decompose this as [(4,2),(4,1),(2,1)] rearranging [4,4,2,2,1,1] you can see 2 towers of identical height therefore player2 will win Mathematically 6 (xor) 5 (xor) 3 == 0 ? player2win ; player1win this concept can be applied for more than 3 numbers

george_e_greaney
1 year ago

(for some reason this isn't scrolling, so I have to break this into sections) the values are intermixed with other pairs.
So a ^ a ^ b ^ b (which would be 0 ^ 0 = 0) is the same as a ^ b ^ a ^ b, just the same as 1 + 2 + 3 + 4 = 10 is the same as 1 + 3 + 2 + 4 = 10.
so to find out if a list of numbers is all paired values, just xor them all together; the pairs will cancel out and if you wind up with a non-zero result,
then you have one or more unmatched values in the group.




 */


class Result {

    /*
     * Complete the 'nimGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY pile as parameter.
     */

    /*
    Idea: nimSum (Xor of all pile size) of all the pile sizes.  If it is non zero, the player wins.

    In normal play, the winning strategy is to finish every move with a nim-sum of 0. This is always possible if the nim-sum is not zero before the move. If the nim-sum is zero, then the next player will lose if the other player does not make a mistake. To find out which move to make, let X be the nim-sum of all the heap sizes. Find a heap where the nim-sum of X and heap-size is less than the heap-size; the winning strategy is to play in such a heap, reducing that heap to the nim-sum of its original size with X.
    */
    public static String nimGame(List<Integer> pile) {
        // Write your code here

        int nimSum = 0;
        for (int i = 0; i < pile.size(); i++) {
            nimSum = nimSum ^ pile.get(i);
        }

        if (nimSum > 0)
            return "First";
        else
            return "Second";


    }

}

class Result {

/*
    Two players are playing a game on a 15 x 15

    chessboard. The rules of the game are as follows:

    The game starts with a single coin located at some x y

    coordinates. The coordinates of the upper left cell are (1, 1) , and of the lower right cell are (15, 15)

.

    In each move, a player must move the coin from cell (x, y)

    to one of the following locations:
    1. (x-2, y+1)
    1. (x-2, y-1)

    1. (x+1, y-2)

    1. (x-1, y-2)


    Note: The coin must remain inside the confines of the board.

    Beginning with player 1, the players alternate turns. The first player who is unable to make a move loses the game.
    */
 */

    /*
     * Complete the 'chessboardGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x
     *  2. INTEGER y
     */

     /*

     Based on this pattern:
P-position：when someone at here，he loses the game;

N-position：when someone at here，he wins the game;
PPNN PPNN PPNN ppN
PPNN ppNN ppNN ppN
NNNN NNNN NNNN NNN
NNNN NNNN NNNN NNN

PPNN PPNN PPNN ppN
PPNN ppNN ppNN ppN
NNNN NNNN NNNN NNN
NNNN NNNN NNNN NNN

PPNN PPNN PPNN ppN
PPNN ppNN ppNN ppN
NNNN NNNN NNNN NNN
NNNN NNNN NNNN NNN

ppNN PPNN ppNN PPN
PPNN PPNN ppNN PPN
NNNN NNNN NNNN NNN
     */

    public static String chessboardGame(int x, int y) {
        // Write your code here
        if ((x % 4 == 1 || x % 4 == 2) && (y % 4 == 1 || y % 4 == 2))
            return "Second";

        return "First";
    }

}