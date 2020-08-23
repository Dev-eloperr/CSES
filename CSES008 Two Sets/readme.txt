Sum of elements till k can be divided in two equal sets iff it's sum is even

Now if we find the sum for a first few numbers(k), we can see a pattern

1(x), 2(x), 3, 4, 5(x), 6(x), 7, 8

x=>odd sum

this forms two AP (an = a + (n-1)d)

a = 3, 4
d = 4

Any number that belongs to either of these equations should give n as an integer

Now as we have identified which numbers will give a YES

We have to identify the series
Now if we try to find it manually for some of them, you can find multiple patterns, and one such patter is alternatively
adding numbers starting from last to first
if it's odd, there will be an extra number at the last

For example: 15 : (1 + 2 + 3) +4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + (12 + 13 + 14 + 15)
list1: 1,2,3,12,13,14,15
list2: 4,5,6,7,8,9,10,11