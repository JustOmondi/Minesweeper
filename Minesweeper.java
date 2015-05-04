//Question 1 Assignment 6
// 2 September 2013
//By Omondi Ochieng :D
//Minesweeper main class

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Minesweeper extends JFrame implements ActionListener, MouseListener
{
    JPanel buttonPanel = new JPanel(new GridLayout(10,10,3,3));
    JPanel topPanel = new JPanel();
    JPanel statusPanel = new JPanel();
    JLabel text = new JLabel("");
    JLabel flagLabel = new JLabel("");
    int x = 0;
    int gamesWon = 0;

    Button[] buttons = new Button[100];
    Numbers num = new Numbers();
    JButton restart, exit;
    JTextField time;


    Minesweeper()
    {
        super("Minesweeper");
        setBounds(350,72,650,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(topPanel, BorderLayout.NORTH);
        add(statusPanel);
        add(buttonPanel, BorderLayout.SOUTH);
        setResizable(false);

        doStuff();
    }

    public void doStuff()
    {
        //Restart button
        restart = new JButton("Restart");
        restart.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 19));
        restart.setBackground(new Color(135,236,84));
        restart.addActionListener(this);
        restart.setPreferredSize(new Dimension(100, 30));
        restart.setBorder(BorderFactory.createLineBorder(Color.black,2));

        //exit button
        exit = new JButton("Exit");
        exit.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 19));
        exit.addActionListener(this);
        exit.setBackground(new Color(142,102,223));  //purple
        exit.setBorder(BorderFactory.createLineBorder(Color.black,2));
        exit.setPreferredSize(new Dimension(100, 30));

        //Generate random numbers
        num.randomize();

        //Add buttons to button panel
        for (int i = 0; i < 100;i++)
        {
            buttons[i] = new Button(i);
            for (int j = 0;j<10;j++)
            {
                if (i == num.getBombs()[j])
                {

                    buttons[i].setBombStatus();
                    /*if (buttons[i].isBomb() == true)
                    {
                        System.out.println("button "+i+" is a bomb");
                    }*/
                }
            }
            buttons[i].setBackground(new Color(0,110,253)); //lighter dark blue
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.black,2));
            buttonPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
            buttons[i].addMouseListener(this);
        }

        //Time text field
        /*time = new JTextField("000",3);
        time.setEditable(false);
        time.setBackground(Color.BLACK); //black
        time.setForeground(new Color(255,154,0)); //orange
        time.setBorder(BorderFactory.createLineBorder(Color.black,3));
        time.setPreferredSize(new Dimension(70,30));
        time.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 18));
        time.setText("0"+String.valueOf(10));*/


        //Top panel set up
        topPanel.setPreferredSize(new Dimension(650,50));
        topPanel.add(exit,BorderLayout.WEST);
        //topPanel.add(time, BorderLayout.CENTER);
        topPanel.add(restart, BorderLayout.EAST);

        //Status panel set up
        statusPanel.setLayout(new BorderLayout());
        statusPanel.setPreferredSize(new Dimension(650,20));
        statusPanel.add(text, BorderLayout.WEST);
        statusPanel.add(flagLabel, BorderLayout.EAST);

        //button panel set up
        buttonPanel.setPreferredSize(new Dimension(500,500));

        //Screen panel JLabels
        text.setText("<html>Moves:"+"<br>"+String.valueOf(x));
        text.setHorizontalAlignment(0);
        text.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 19));

        flagLabel.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 19));


        //Generates the numbers to be assigned to buttons
        //num.generate();


    }

    //Unused method
    public void mouseEntered(MouseEvent mouse)
    {
        int x =  1;
    }

    //Unused method
    public void mouseExited(MouseEvent exited)
    {
        int y =0;
    }

    //Unused method
    public void mouseReleased(MouseEvent released)
    {
        int u = 9;
    }

    //Unused method
    public void mousePressed(MouseEvent pressed)
    {
        int e = 6;
    }

    public void mouseClicked(MouseEvent clickedButton)
    {
        Button clicked = (Button)clickedButton.getSource();
        int flags = 10;
        int f = 0;



        if (SwingUtilities.isRightMouseButton(clickedButton))
        {
            flagLabel.setText("Flags left: "+String.valueOf(flags-f));
            if((flags-f)>-1)
            {
                clicked.rightClicked();
                if (!clicked.isFlagged())
                {
                    if((flags-f)>-1)
                    {
                        clicked.setIcon(new ImageIcon("tick.png"));
                        clicked.setFlagged(1);
                    }

                }
                else if(clicked.isFlagged())
                {
                    clicked.setIcon(null);
                    clicked.setFlagged(0);
                    //flags+=1;

                    //time.setText("00"+String.valueOf(count));
                }
                for(int i = 0;i<100;i++)
                {

                    if (buttons[i].isFlagged())
                    {
                        f+=1;
                    }
                }

            }

            //count++;

            /*for (int i = 0;i<100;i++)
            {
                if (buttons[i] == clicked)
                {
                    if (!buttons[i].isFlagged())
                    {
                        pressedN = true;
                        time.setText("00"+String.valueOf(count));
                    }
                    else if (buttons[i].isFlagged())
                    {
                        pressedF = true;
                        time.setText("00"+String.valueOf(count));
                    }
                }
            }
            if (pressedF)
            {
                count+= 1;
                flagLabel.setText("Flags: "+String.valueOf(count));
            }
            else if(pressedN)
            {
                count-=1;
                flagLabel.setText("Flags: "+String.valueOf(count));
            } */

           /* if (!clicked.isFlagged())
            {
                //System.out.println("Not flagged");
                if (count > 0)
                {
                    clicked.setFlagged(1);
                    if(clicked.isFlagged())
                    {
                        System.out.println("flagged");
                    }
                    count--;
                    flagLabel.setText("Flags: "+String.valueOf(count));
                }
            }
            else if (clicked.isFlagged())
            {
                clicked.setFlagged(0);
                if (!clicked.isFlagged())
                {
                    System.out.println("UnFlagged");
                }
                count+=1;

                flagLabel.setText("Flags: "+String.valueOf(count));
            }*/




        }


    }



    public void actionPerformed(ActionEvent action)
    {
        for (int i = 0;i<100;i++)
        {//Start loop


            checkGame();
            if (action.getSource() == buttons[i])
            {
                x++;
                text.setText("Moves:"+String.valueOf(x));
                //text.setText(String.valueOf(buttons[i].status()));
                //buttons[i].setVisible(false);

                /*if (buttons[i].status() == 0)
                {
                    buttons[i].setBackground(null);
                    buttons[i].setText(null);
                } */
                //lookAround(i,buttons[i]);
                buttons[i].setBackground(null);
                lookAround(i,buttons[i]);
                buttons[i].setText(String.valueOf(buttons[i].getBombsAround()));
                for (int l = 0;l<10;l++)
                {
                    System.out.println(num.getBombs()[l]);
                }

                for (int j = 0;j<10;j++)
                {
                    if ((buttons[i]).getNumber() == num.getBombs()[j])
                    {


                        text.setFont(new Font("Estrangelo Edessa",  Font.BOLD, 30));
                        text.setForeground(new Color(0, 110, 253));  //blue

                        text.setBackground(new Color(253, 160, 20));
                        text.setText("HAHAHA! YOU LOOSE! :P TRY AGAIN :)");
                        statusPanel.add(text, BorderLayout.CENTER);
                        //buttons[i].setBackground(new Color(255, 50, 16)); //red
                        buttons[i].setIcon(new ImageIcon("blast2.png"));

                        for (int b : num.getBombs())
                        {

                            if ((buttons[b] != buttons[i]) && (!buttons[b].isFlagged()))
                            {

                                //buttons[b].setBackground(new Color(253, 160, 20)); //orange
                                buttons[b].setIcon(new ImageIcon("blast.png"));
                                validate();
                            }
                            //buttons[b].setText(buttons[b]);
                        }
                        for (int k = 0;k<100;k++)
                        {
                            //buttons[k].setEnabled(false);
                        }

                    }
                }

                checkAround(i);

                /* if ((buttons[i]).getNumber() == num.getBombs()[i])
                {
                    buttons[i].setBackground(Color.red);
                }  */

                //buttons[i].setText(String.valueOf(num.get()[i]));


                // for (int j = 0;i<10;i++)
// 				{
// 					for (int k = 0;j<10;j++)
// 					{
// 						buttons[i].setText(String.valueOf(num.getCells()[j][k]));
// 					}
// 				}
            }

        }//End main loop

        if (action.getSource() == restart)
        {
            setVisible(false);
            Minesweeper m = new Minesweeper();
            statusPanel.add(text, BorderLayout.WEST);
            m.setVisible(true);

        }
        else if (action.getSource() == exit)
        {
            System.exit(0);
        }
    }

    //Counts the number of bombs around each point.
    public void lookAround(int position, Button b)
    {
        int count = 0;
        for (int i = 0;i<10;i++)
        {
            if ((position > 10 && position < 19) || ((position > 20) && (position < 29)) || ((position > 30) && (position < 39))
                || ((position > 40) && (position < 49)) || ((position>50)&&(position<59)) || ((position > 60)&&(position<69))
                || ((position > 70)&&(position<79)) || ((position > 80)&&(position<89)))
            {

                if (position+10 == num.getBombs()[i]) //Number below it
                {
                    count+=1;
                }
                if(position - 10 == num.getBombs()[i])  //Number above it
                {
                    count+=1;
                }

                if (position+1 == num.getBombs()[i]) //Number to the right
                {
                    count+=1;
                }
                if (position-1 == num.getBombs()[i])   //Number to the left
                {
                    count+=1;
                }
                if (position+11 == num.getBombs()[i])   //Number diagonally right below
                {
                    count+=1;
                }
                if (position + 9 == num.getBombs()[i])  //Number diagonally left below
                {
                    count+=1;
                }
                if(position-11 == num.getBombs()[i])   //Number diagonally left above
                {
                    count+=1;
                }
                if(position - 9 == num.getBombs()[i])   //Number diagonally right above
                {
                    count+=1;
                }
            }
            else if((position > 0)&&(position < 9))
            {
                if (position-1 == num.getBombs()[i])   //Number to the left
                {
                    count+=1;
                }
                if (position+1 == num.getBombs()[i]) //Number to the right
                {
                    count+=1;
                }
                if (position+10 == num.getBombs()[i]) //Number below it
                {
                    count+=1;
                }
                if (position+11 == num.getBombs()[i])   //Number diagonally right below
                {
                    count+=1;
                }
                if (position + 9 == num.getBombs()[i])  //Number diagonally left below
                {
                    count+=1;
                }
            }
            else if ((position > 90) && (position < 99))
            {
                if (position-1 == num.getBombs()[i])   //Number to the left
                {
                    count+=1;
                }
                if (position+1 == num.getBombs()[i]) //Number to the right
                {
                    count+=1;
                }
                if(position - 10 == num.getBombs()[i])  //Number above it
                {
                    count+=1;
                }
                if(position-11 == num.getBombs()[i])   //Number diagonally left above
                {
                    count+=1;
                }
                if(position - 9 == num.getBombs()[i])   //Number diagonally right above
                {
                    count+=1;
                }
            }
            else if((position != 0) && (position != 9) && (position != 90) && (position != 99))
            {
                boolean leftEdge = false;
                //boolean rightEdge = false;
                for (int j = 10;j<90;j=j+10)
                {
                    if (position == j)
                    {
                        leftEdge = true;
                        break;
                    }
                }
                if (leftEdge)
                {
                    if(position - 10 == num.getBombs()[i])  //Number above it
                    {
                        count+=1;
                    }
                    if (position+10 == num.getBombs()[i]) //Number below it
                    {
                        count+=1;
                    }
                    if (position+11 == num.getBombs()[i])   //Number diagonally right below
                    {
                        count+=1;
                    }
                    if(position - 9 == num.getBombs()[i])   //Number diagonally right above
                    {
                        count+=1;
                    }
                    if (position+1 == num.getBombs()[i]) //Number to the right
                    {
                        count+=1;
                    }
                }
                else
                {
                    if(position - 10 == num.getBombs()[i])  //Number above it
                    {
                        count+=1;
                    }
                    if (position+10 == num.getBombs()[i]) //Number below it
                    {
                        count+=1;
                    }
                    if (position-1 == num.getBombs()[i])   //Number to the left
                    {
                        count+=1;
                    }
                    if(position-11 == num.getBombs()[i])   //Number diagonally left above
                    {
                        count+=1;
                    }
                    if (position + 9 == num.getBombs()[i])  //Number diagonally left below
                    {
                        count+=1;
                    }
                }
            }
            else if (position == 0)
            {
                if (position+10 == num.getBombs()[i]) //Number below it
                {
                    count+=1;
                }
                if (position+11 == num.getBombs()[i])   //Number diagonally right below
                {
                    count+=1;
                }
                if (position+1 == num.getBombs()[i]) //Number to the right
                {
                    count+=1;
                }
            }
            else if (position == 9)
            {
                if (position-1 == num.getBombs()[i])   //Number to the left
                {
                    count+=1;
                }
                if (position+10 == num.getBombs()[i]) //Number below it
                {
                    count+=1;
                }
                if (position + 9 == num.getBombs()[i])  //Number diagonally left below
                {
                    count+=1;
                }
            }
            else if (position == 90)
            {
                if (position+1 == num.getBombs()[i]) //Number to the right
                {
                    count+=1;
                }
                if(position - 10 == num.getBombs()[i])  //Number above it
                {
                    count+=1;
                }
                if(position - 9 == num.getBombs()[i])   //Number diagonally right above
                {
                    count+=1;
                }
            }
            else if (position == 99)
            {
                if(position - 10 == num.getBombs()[i])  //Number above it
                {
                    count+=1;
                }
                if (position-1 == num.getBombs()[i])   //Number to the left
                {
                    count+=1;
                }
                if(position-11 == num.getBombs()[i])   //Number diagonally left above
                {
                    count+=1;
                }
            }
        }

        //System.out.println(count);
        //b.setStatus(count);
        b.setButtonText(b,count);
        //return count;

    }


    //Reveals the blocks around each block that has no bombs around it.
    public void checkAround(int position)
    {
        if (buttons[position].getBombsAround() == 0)  //Check whether there are no bombs around a button
        {
            buttons[position].setText(null);

            if ((position > 10 && position < 19) || ((position > 20) && (position < 29)) || ((position > 30) && (position < 39))
                    || ((position > 40) && (position < 49)) || ((position>50)&&(position<59)) || ((position > 60)&&(position<69))
                    || ((position > 70)&&(position<79)) || ((position > 80)&&(position<89))) //The method will only perform operations on blocks that around the edges of the board.
            {
                if ((position+10 < 99) && (!buttons[position+10].isBomb()))
                {
                    lookAround(position+10, buttons[position+10]);
                    buttons[position+10].setBackground(null);
                    if (buttons[position+10].getBombsAround() != 0)
                    {
                        buttons[position+10].setText(String.valueOf(buttons[position+10].getBombsAround()));
                    }
                    buttons[position+10].setEnabled(false);
                }

                if ((position-10 > 0) && (!buttons[position-10].isBomb()))
                {
                    lookAround(position-10, buttons[position-10]);
                    buttons[position-10].setBackground(null);
                    if (buttons[position-10].getBombsAround() != 0)
                    {
                        buttons[position-10].setText(String.valueOf(buttons[position-10].getBombsAround()));
                    }
                    buttons[position-10].setEnabled(false);
                }

                if ((position+1 < 99) && (!buttons[position+1].isBomb()))
                {
                    lookAround(position+1, buttons[position+1]);
                    buttons[position+1].setBackground(null);
                    if (buttons[position+1].getBombsAround() != 0)
                    {
                        buttons[position+1].setText(String.valueOf(buttons[position+1].getBombsAround()));
                    }
                    buttons[position+1].setEnabled(false);
                }

                if ((position-1 > 0) && (!buttons[position-1].isBomb()))
                {
                    lookAround(position-1, buttons[position-1]);
                    buttons[position-1].setBackground(null);
                    if (buttons[position-1].getBombsAround() != 0)
                    {
                        buttons[position-1].setText(String.valueOf(buttons[position-1].getBombsAround()));
                    }
                    buttons[position-1].setEnabled(false);
                }

                if ((position+11 < 99) && (!buttons[position+11].isBomb()))
                {
                    lookAround(position+11, buttons[position+11]);
                    buttons[position+11].setBackground(null);
                    if (buttons[position+11].getBombsAround() != 0)
                    {
                        buttons[position+11].setText(String.valueOf(buttons[position+11].getBombsAround()));
                    }
                    buttons[position+11].setEnabled(false);
                }

                if ((position-11 > 0) && (!buttons[position-11].isBomb()))
                {
                    lookAround(position-11, buttons[position-11]);
                    buttons[position-11].setBackground(null);
                    if (buttons[position-11].getBombsAround() != 0)
                    {
                        buttons[position-11].setText(String.valueOf(buttons[position-11].getBombsAround()));
                    }
                    buttons[position-11].setEnabled(false);
                }

                if ((position+9 < 99)&& (!buttons[position+9].isBomb()))
                {
                    lookAround(position+9, buttons[position+9]);
                    buttons[position+9].setBackground(null);
                    if (buttons[position+9].getBombsAround() != 0)
                    {
                        buttons[position+9].setText(String.valueOf(buttons[position+9].getBombsAround()));
                    }
                    buttons[position+9].setEnabled(false);
                }

                if ((position-9 > 0) && (!buttons[position-9].isBomb()))
                {
                    lookAround(position-9, buttons[position-9]);
                    buttons[position-9].setBackground(null);
                    if (buttons[position-9].getBombsAround() != 0)
                    {
                        buttons[position-9].setText(String.valueOf(buttons[position-9].getBombsAround()));
                    }
                    buttons[position-9].setEnabled(false);
                }
            }

        }

    }

    //Continuously checks whether the player has won or not.
    public void checkGame()
    {
        int count = 0;
        for(int i = 0;i<100;i++) //Counts how many buttons are flagged
        {
            if(buttons[i].isFlagged())
            {
                count+=1;
            }
        }
        if (count == 10)
        {
            text.setText("Congratulations!!! You Won");
            text.setFont(new Font("Estrangelo Edessa", Font.BOLD, 30));
            text.setForeground(Color.green);
        }
    }


    public static void main(String[] args)
    {
        Minesweeper m = new Minesweeper();
        m.setVisible(true);
    }
}