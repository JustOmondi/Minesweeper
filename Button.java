//Question 1 Assignment 6
// 2 September 2013
//By Omondi Ochieng :D
import javax.swing.*;
import java.awt.*;
public class Button extends JButton
{
    JLabel buttonLabel = new JLabel();
    int number = 0, bombsAround = 0;
    boolean bombOrNot = false;
    boolean flagged = false;
    boolean rightClicked = false;

    public Button(int n)
    {
        number = n; //Each bomb is assigned a number i.e ID
    }

    public int getNumber() // Returns the number ('ID') of a button.
    {
        return number;
    }

    public void setButtonText(Button B, int num) // Sets the text of the button to the number of bombs around it.
    {
        if (num!=0)
        {
            B.setText(String.valueOf(num));
            //B.setBorder(null);
        }
        /*else
        {
            B.setBorder(null); //removes outline of button
        }*/
        //setText(String.valueOf(num));
        //System.out.println("num = "+num);
        setBombsAround(num);
        B.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 19));
        //B.setBackground(null);
        setEnabled(false);
    }

    public void setBombsAround(int bombs) //Gives the button an attribute concerning the number of bombs around it.
    {
        bombsAround = bombs;

    }

    public int getBombsAround() //Returns the number of bombs around a point.
    {
        //System.out.println("status = "+status);
        return bombsAround;
    }

    public void setBombStatus()  //Gives a button a bomb attribute indicating that the button is a bomb.
    {
        bombOrNot = true;
    }

    public boolean isBomb()   //Returns true or false regarding whether a button is a bomb or not.
    {
        return bombOrNot;
    }

    public void setFlagged(int check) //Sets the status of a button to flagged or not
    {
        if (check == 1)  //If the method is called with 1, the button is set to flagged
        {
            flagged = true;
        }
        else  //If the method is called with 0, the button is set to 'not flagged'.
        {
            flagged = false;
        }
    }
    public boolean isFlagged() //Returns the 'flagged' status of a button.
    {
        return flagged;
    }

    public void rightClicked()  //Gives the button a right clicked attribute
    {
        rightClicked = true;
    }

    public boolean isRC()  //Returns true or false regarding whether the button has been right clicked or not.
    {
        return rightClicked;
    }


}