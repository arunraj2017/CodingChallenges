7 Star Cities in A State (100 Marks)

In a state of India every city is given 1 to 7 stars according to facilities in that city.
So lets consider N cities (C1 to Cn) of that state and every city is given a number between 1 to 7 corresponding to level of the cities. Some cities are connected to each other also. 

A person plays a very interesting game. He starts from city C1 and after visiting some cities out of C1 to Cn he finally ends his journey in city Cn ( he may visit a city multiple times and also he can leave some city also). During the course of journey the person construct a number ( call this number S) by appending the rating number of the city in the right of already formed number. Initial he start with empty and append rating of C1 as he starts with city C1.
 
The interesting part of the game is that he wants to visit the cities in a way that the number S formed should be divisible by all its digit and the sum of all the digits of S should be as less as can be possible.


Input Format 
You will be given a function which contains an array of size N corresponding to the rating of N cities and a 2-Dimensional integer array f size N*N which shows the connectivity of cities. If in this array entry E[i][j] is one then it means city Ci is connected to city Cj in graph as arguments.

Output Format
You need to return the Sum of digits of the number S(integer only) formed by appending the rating of cities traversed by the person such that S is divisible by all the digits it contains and the sum is the minimum possible sum.


Note: Output should be -1 of no solution exits.


Sample Test Case
Sample Input
4
1
2
1
4
4
4
0 1 1 1
1 0 0 1
1 0 0 1
1 1 1 0

Sample Output
7


Explanation
Array R of rating would be {1, 2, 1, 4} 
2- D array E of connectivity would be {0#1#1#1,1#0#0#1,1#0#0#1,1#1#1#0}




Ci- j here Ci is the city and j is the city rating (1<= j <= 7) 
Answer would be C1 C2 C4 
Number S would be 124 
124 is divisible by 1, 2 and 4 as well. And for the above example it is the minimum possible sum, i.e. sum of the digits of 124  will be 7.