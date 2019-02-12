# Game

Project 1 (Bingo) Algorithm
Written by: Langston Hughes


1. BingoTester (Main Method)
	
	A. Calls the fillCard  method in the Bingo class
	
	B. Calls the printCard method in the Bingo class
	
	C. Calls the playGame method in the Bingo class

2. Bingo
	
	A. fillCard method -  Fills a bingo card using a loop using a random number generator
		
		i. The numbers in column B should be between 1 and 15
		
		ii. The numbers in column I should be between 16 and 30
		
		iii. The numbers in column N should be between 31 and 45
		
		iv. The numbers in column G should be between 46 and 60
		
		v. The numbers in column O should be between 61 and 75
	
	B. printCard method - Prints the bingo card
		
		i. Should lok something like this:
 
 
			
B | I | N | G | O
			
-----------------
			
# | # | # | # | #
      
-----------------
      
# | # | # | # | #
      
-----------------
      
# | # | # | # | #
      
-----------------
      
# | # | # | # | #
      
-----------------
      
# | # | # | # | #
			
-----------------

	
	C. playGame method - Picks from B, I, N, G, and O at random and picks a number at random using a loop to mark the card.
		
		i. The mark to be used on the card is 0
    
		ii. A letter is chosen at random from B, I, N, G, and O
    
		iii. A random number is generated in the range of the letter chosen
    
		iv. A mark is made on the card if the number and letter and number on the card matches the generated number and letter
		
		v. After each mark, the checkForWin method is called
	D. checkForWin method - checks to see if the player wins and the printCard method is called
		
		i. If the sum of a row is zero, the player wins and the printCard method is called
		
		ii. If the sum of a column is zero, the player wins and the printCard method is called
		
		iii. If the sum of a diagonal is zero, the player wins and the printCard method is called
		
		iv. If the sum in a column, row, or diagonal is not zero, then the program goes back to the playGame method
