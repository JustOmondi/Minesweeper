//Question 1 Assignment 6
// 2 September 2013
//By Omondi Ochieng :D

import javax.swing.*;
import java.lang.Math;

public class Numbers
{
    //int[][] numberList = new int[10][10]; //Array of cell numbers
    //int[] num2 = new int[100];
    int[] bombs = new int[10]; //Array of bombs
    //int number = 0;
    //int count = 0;


    /*public void generate() //Creates list cell numbers to be assigned to buttons.
    { //Start of generate() method

        for (int i = 0;i<10;i++)
        {
            for (int j = 0;j<10;j++)
            {
                numberList[i][j] = number;
                number++;
            }
        }
    } // End of generate*/

    // Generates a list of unique random numbers
    public void randomize()
    {
        int number, count = 0;
        boolean repeated = false;
        for (int i = 0;i<10;i++)
        {
            number = (int)(Math.random()*100);
            //System.out.println(number);
            bombs[i] = number;
        }

        // The list of random numbers is checked for any repetitions
        for (int j = 0;j<10;j++)
        {
            count = 0;
            for (int k = 0;k<10;k++)
            {
                if (bombs[k] == bombs[j])
                {
                    count++;
                }

            }
            if (count > 1)
            {
                repeated = true; //Indicates whether a certain value is repeated
            }
        }
        if (repeated) // if a value is repeated, the method is called again. i.e. this continues until a list of completely unique integers is obtained.
        {
            randomize();
        }

    }

    /*public int[][] getCells()
    {
        return numberList;
    }*/

    //Returns list of bombs
    public int[] getBombs()
    {
        return bombs;
    }
    /*public int[] get()
    {
        return num2;
    }  */

}