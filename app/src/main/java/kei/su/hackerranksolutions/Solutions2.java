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