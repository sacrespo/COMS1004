BULLS AND COWS: 

For Bulls and Cows, I used Oracle to create the computer's four digit random number by 
using arrays: I created an array that had the digits from 0-9, then randomly shuffled 
the 9 numbers and took the first four and put them into a String. Additionally, Oracle 
finds the numbers of bulls and cows by using character arrays because it was easier 
for me to keep track of what matches were already bulls (and thus, could not be cows) 
that way. 

The Game class has one long method, play(), that prompts the user for input and tells 
the user when they won, whether they want to play again, and responds to those 
choices. It calls three methods that keep track of the players stats. The player's 
number of rounds determines the size of the array that keeps the turn stats, 
gameResults. The three methods, findBest, findWorst, and findAverage, find the 
smallest number in the array, the largest number of the array, and the average of the 
values in the array respectively. 

The tester class is short and to the point: it creates a new game and plays it. 
