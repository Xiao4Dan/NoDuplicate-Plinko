
/* * * * * * * * * * * * * * * * * * * * * * * * * *
 * The game of Plinko                              *
 * User may pick a chip and it falls down          *
 * When the chip touch the bottom output the money *
 * @AS                                             *
 * @QvQ                                            *
 * * * * * * * * * * * * * * * * * * * * * * * * * */
import java.util.*;
public class Plinko
{
    public static void main (String[] args)
    {
        //set up the environment
        Scanner in=new Scanner(System.in);
        Random numGen=new Random();
        String[] spots={" " , " " , " " , " " , " " , " " , " " , " " , " "}; //spots
        int position; //NEED A CHECKIGN PROCEDURE
        int[] results= {100,500,1000,0,10000,0,1000,500,100};
        int movement = 0; //move before or after
        int total = 0;
        int game = 1; //if the game continue rolling
        //Display the table of all 10 rolls
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("|   0   |   1   |   2   |   3   |   4   |   5   |   6   |   7   |   8   |   |");
        System.out.println("|   |       |       |       |       |       |       |       |       |       |");
        System.out.println("|       |       |       |       |       |       |       |       |       |   |");
        System.out.println("|   |       |       |       |       |       |       |       |       |       |");
        System.out.println("|       |       |       |       |       |       |       |       |       |   |");
        System.out.println("|   |       |       |       |       |       |       |       |       |       |");
        System.out.println("|       |       |       |       |       |       |       |       |       |   |");
        System.out.println("|   |       |       |       |       |       |       |       |       |       |");
        System.out.println("|       |       |       |       |       |       |       |       |       |   |");
        System.out.println("|   |  100  |  500  | 1000  |   0   | 10000 |   0   | 1000  |  500  |  100  |");
        System.out.println("-----------------------------------------------------------------------------");
        //starting the game
        System.out.println("Welcome to PLINKO! ");
        do
        {
            //keep asking untill its between 0 and 9
            do
            {
                System.out.println("Where do you want to put you chip? ");
                position = Integer.parseInt(in.nextLine()); //assume the user input all numbers
            }while(position > 8 || position < 0);
            //drop the dies
            System.out.println("The chip satrts at spot " + position);
            //general ten rolls of numbers illustrating the displacement of the chip
            System.out.println("-----------------------------------------------------------------------------"); //border
            for( int i = 0; i <= 9; i++ )
            {
                //randomize the number is the chip going left or right
                if( i % 2 == 0 )
                {
                    movement = numGen.nextInt(2); //randomize the digit between 0 and 1 to make the chip able to shift
                    position += movement; //then apply this chip to position for display issue
                    //if it goes outside the border, drag it back !
                    if(position == 9)
                    {position=8;}
                    //making the chip visible
                    spots[position]="#"; 
                    //out put the line
                    System.out.println("|   " + spots[0]+"   |   " + spots[1]+"   |   " + spots[2]+"   |   " + spots[3]+"   |   " + spots[4] +
                        "   |   " + spots[5]+"   |   " + spots[6] + "   |   " + spots[7]+ "   |   " + spots[8] + "   |   |");

                }
                else if ( i % 2 == 1 )
                {
                    movement = numGen.nextInt(2) - 1; //randomize the digit between 0 and 1 to make the chip able to shift
                    position += movement; //then apply this chip to position for display issue
                    //if it goes outside the border, drag it back !
                    if(position == -1)
                    {position=0;}
                    //making the chip visible
                    spots[position]="#"; 
                    //out put the line
                    System.out.println("|   |   " + spots[0] + "   |   " + spots[1] + "   |   " + spots[2] + "   |   " + spots[3] + "   |   " + spots[4] +
                        "   |   " + spots[5] + "   |   " + spots[6] + "   |   " + spots[7] + "   |   " + spots[8] + "   |");
                }
                //making the chip invisible
                spots[position]=" ";
            }
            System.out.println("-----------------------------------------------------------------------------"); //border
            //display the result
            System.out.println("|   |  100  |  500  | 1000  |   0   | 10000 |   0   | 1000  |  500  |  100  |"); //show the user where he has been
            System.out.println("You have won " + results[position] + " dollars!");
            total += results[position];
            System.out.println();
            //ask if the game continutes
            System.out.println("Do you want to play again ? (input (0-9) will continue the game)");
            game = Integer.parseInt(in.nextLine());
        }while(game >= 0 & game <= 9);
        System.out.println("Game Over. Enjoy your day sir. ");
    }
}