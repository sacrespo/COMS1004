SCRABBLE HELPER: 

The WordLists.java class has several methods that take in different parameters based off of what a user may want
from certain words in the Scrabble Dictionary. It throws exceptions if the dictionary.txt file cannot be found. 

The main tester class, WordListsTester.java, has a menu from which users can choose the parameters of the words
they want from the dictionary. They select which parameters (and in doing so, which method is invoked) based off 
of the number they type in (1, 2, 3, 4, 5). To quit the program, they only need to type in 0 when prompted. The
program asks the user questions based off of their initial input so as to prompt them for parameter values. Given
these values, the program then invokes the methods and writes the String[] results into txt files which are stored
in the directory that the user is in. 
