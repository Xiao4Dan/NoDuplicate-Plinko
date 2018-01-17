
/* * * * * * * * * * * * * * * * * * * * * * * * * *
 * Create an array of size 10 and fill it randomly *
 * with the numbers 0 to 9;                        *
 * Ensure that no number is repeated               *
 * Hint: what is a boolean variable for?           *
 * @A-S- Grade 12                                  *
 * @QvQ                                            *
 * * * * * * * * * * * * * * * * * * * * * * * * * */
import java.util.*;
public class NoDuplicates
{
    public static void main(String[] args)
    {
        //scanner
        Scanner in = new Scanner(System.in);
        //creating a boolean array with size of 10
        //to check which number has been used
        boolean[] test = new boolean[10];
        //creating an int array to store and display numbers
        int[] nums = new int[10];
        //variable to store randomized number
        int k;
        //prepare randomization
        Random numGen = new Random();
        //set up the bolean to make the game keep going
        boolean yes=true;
        String play="";
        //prmpt
        System.out.println("This is the program of NoDuplicate! ");

        //do the loop that runs over the whole int array
        while(yes == true)
        {
            System.out.print("Random non-repeat sequence: ");
            for ( int i=0; i<nums.length; i++ )
            {

                do
                {
                    //ranzomize the first integer in the array
                    k = numGen.nextInt(10);
                }while(test[k] == true);//redo the randomization if the spot has been used
                //and initial this number to the spot
                nums[i] = k;
                //make the spot true that it won't be taken again
                test[k] = true;
                //print out the spot each time
                System.out.append(nums[i] + "");
            }
            //skip a line
            System.out.println(" ");
            //ask if they want to play again
            System.out.println("Do you want to play it? (Y/N)");
            play = in.nextLine().toLowerCase();
            //change yes to true and run the game
            if(play.equals("y"))
            {
                yes=true;
                //reset the arrays
                test=new boolean[10];
                nums=new int[10];
            }
            else
            { yes = false; }
        }
        System.out.println("Good Game and Enjoy your day sir! ");
    }
}