package kei.su.hackerranksolutions;
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

N-position：when someone at here，he wins the game;PPNN PPNN PPNN ppN
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
        if ((x%4==1 || x%4==2) && (y%4==1 ||y%4==2))
            return "Second";

        return "First";
    }

}