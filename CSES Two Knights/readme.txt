Idea is to subtract the total number of places where the Knights can attack each other from the total

for k==2, Two knights can be placed anywhere

2 x 2 : Total possible places = 6


for k>2,

3 x 3 : Total possible places = 36

4 x 4 : Total possible places = 120

We can represent using combinatorics since order doesn't matter
=> Total number of combination: C(k*k,2)

Now, for each 3 x 2 (or 2 x 3) matrix, there exist exactly 2 positions from where 2 Knights can directly attack each other

We have to find the sum of total number of 3 x 2 matrices and 2 x 3 matrices, multiply it by 2(since there are 2 position for each matrix)
and subtract it from the total.

Equation becomes

res = C(k*k,2) - 2 * (3 x 2 matrices + 2 x 3 matrices)

    Since chess is square, number of 3 x 2 matrices  == number of 2 x 3 matrices

= C(k*k,2) - 4 * ( 3 x 2 matrices)


How to find 3 x 2 matrices?

Example:
3 x 3 : has 2
4 x 4 : has 6
5 x 5 : has 12

So the pattern can be easily identified which is (k-2)*(k-1)

Final equation : ((k^2 * (k^2-1))/2) - 4 * (k-2) * (k-1)


