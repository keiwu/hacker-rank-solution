
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;



import java.io.*;
import java.util.*;

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
