Thinking Hat..!!! (100 Marks)

Rohan was asked to solve the following problem:
For any given permutation in range(1,2,3...n), Rohan calculates two values S1 and S2.
where,
S1 = number of pairs(i , j) in that permutation such that i < j and perm[i] > perm[j] and
S2 = Sum(max(0 , i - perm[i])) where perm[i] is the value present at index i in the current permutation.

For example : For permutation(4, 1, 2, 3)
Value of S1 = 3   ( {4 , 1} , {4 , 2} , {4 , 3} )
S2 = max(0 , 1 - 4) + max(0 , 2 - 1) + max(0 , 3 - 2)  + max(0 , 4 - 3) = 0 + 1 + 1 + 1 = 3
We can see value of both S1 and S2 are equal. 

Now you are provided the length of permutation and some initial value of permutation, you have to count the total number
of valid permutation of  given length such that for each permutation value of S1 and S2 are equal. 

Input Specification:
You will be given a function which contains two arguments
1. an integer which represents the Length of the permutation ( 1<= length<= 30)
2. an integer array representing the  prefix of the permutation
First line contain length of the permutation ( N ) 
Second line contain length of the initial prefix ( K )
Next K lines contain a single integer


Output Specification:
You need to return in how many ways(integer only) we can augment the prefix to a complete permutation so that the Rohan's algorithm gives correct results.
(Output your result in range(-2^31 to 2^31 - 1))

Note : Output should be -1 if input is invalid.


Sample Test Case 1
Sample Input
5
2
1
4

Sample Output
3

Sample Test Case 2
Sample Input
5
4
6
4
2
1

Samp