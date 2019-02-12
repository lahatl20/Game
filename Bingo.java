import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bingo
{
  //the size of the array for the bingo card
	private static int ROWS = 5;
	private static int COLS = 5;

	public static void main(String[] args)
	{
    //post: these two statements create the bingo card array and the bin that holds all number called to mark the bingo card
		int[][] bingoCard = new int[ROWS][COLS];
    ArrayList<Integer> bin = new ArrayList<Integer>();
    
    //post: these five methods execute the game
    fillCard(bingoCard);
    printCard(bingoCard);
    playGame(bingoCard, bin);
    
    for(int i = 0;i<bin.size();i++)
    {
      for(int j = 0;j<11;j++)
        System.out.print(bin.get(i))
    }
    printCard(bingoCard);
	}

	public static int[][]  fillCard(int[][] bingoCard)
	{
    //post: this method fills the bingo card created in main
		try
    {
      Scanner input = new Scanner(System.in);
      input = new Scanner(new File("bingo.in"));
      
      for(int i = 0;i<ROWS;i++)
      {
        for(int j = 0;j<COLS;j++)
        {
          bingoCard[i][j] = input.nextInt();
        }
      }
    }
    
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
    
    return bingoCard;
  }

	public static void printCard(int[][] bingoCard)
	{
      //post: this method prints the bingo card before and after the game is played
      System.out.println("    B      I      N      G      O");
      for(int i = 0;i<ROWS;i++)
      {
        System.out.println("  -------------------------------");
        for(int j = 0;j<COLS;j++)
        {
          System.out.print("  |  " + bingoCard[i][j]);
        }
        System.out.println("");
      }
      System.out.println("");
	}

	public static void playGame(int[][] bingoCard, ArrayList<Integer> bin)
	{
   //post: this method plays the game by generating a random number to see mark the card with and stores those numbers in a bin to keep track of what numbers have been generated
   int number = 0;
   boolean play = true;
   int binCount = 0;
   
   while(play == true)
   {
     number = generateNum();
     for(int i = 0;i<bin.size();i++)
     {
       if(number==(bin.get(i)))
         number = generateNum();
     }
     bin.add(number);
     binCount++;
     markCard(bingoCard, number);
     play = checkForWin(bingoCard, binCount);
   }
 }

	public static boolean checkForWin(int[][] bingoCard, int counter)
	{
    //post: this methods checks to see if the player has a bingo
    int sum3 = 0;
    int sum4 = 0;
    int n = 0;
    int p = COLS;
    
    //post: this loop will chack to see if the player has a bingo in the horizontal direction
    for(int i = 0;i<ROWS;i++)
    {
      int sum1 = 0;
      for(int j = 0;j<COLS;j++)
      {
        sum1 += bingoCard[i][j];
      }
      if(sum1 == 0)
      {
      System.out.println("You got a horizaontal bingo after " + counter + " picks!!!");
      return false;
      }
    }
    
    //post: this loop will chack to see if the player has a bingo in the vertical direction
    for(int k = 0;k<COLS;k++)
    {
      int sum2 = 0;
      for(int l = 0;l<ROWS;l++)
      {
        sum2 += bingoCard[l][k];
      }
      if(sum2 == 0)
      {
      System.out.println("You got a vertical bingo after " + counter + " picks!!!");
      return false;
      }
    }
    
    //post: these two loops will chack to see if the player has a bingo in the diagonal direction
    for(int m = 0;m<ROWS;m++)
    {
       sum3 += bingoCard[m][n];
       n++;
    }
    if(sum3 == 0)
    {
     System.out.println("You got a diagonal bingo after " + counter + " picks!!!");
     return false;
    }
    
    for(int o = 0;o<ROWS;o++)
    {
      sum4 += bingoCard[o][p-1];
      p--;
    }
    if(sum4 == 0)
    {
       System.out.println("You got a diagonal bingo after " + counter + " picks!!!");
       return false;
    }
    
    return true;
	}
   
  public static int[][] markCard(int[][] bingoCard, int number)
  {
    //post: this method marks the card if the the number called is equal to any number in posistion on the card
    for(int i = 0;i<ROWS;i++)
    {
      for(int j =0;j<COLS;j++)
      {
        if(number == bingoCard[i][j])
          bingoCard[i][j] = 0;
      }
    }
    
    return bingoCard;
  }
 
  
  public static int generateNum()
	{
    //post: generates a random number
    int rand = (int)(Math.random() * 74) + 1;
    return rand;
	}
}
