package brickbreaker;

import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.*;


/*
Kacper Rajchel
24/04/2020
*/

public class Gameplay extends JPanel implements KeyListener, ActionListener 
{
    /**
     *
     */
    private static final long serialVersionUID = 931488970361079783L;

    private boolean play = false;
    private int score = 0;



    private int verticalBricks = 3;
    private int horizontalBricks = 8;
    private int totalBricks = verticalBricks * horizontalBricks;
    private float directionXSpeed = -3 + randomInt();
    private float directionYSpeed = -3 + randomInt();


    private Timer timer;
    private int delay = 8;

    private int playerPosX = 310; //Start pos

    private int ballPosX = 120;
    private int ballPosY = 350;
    private float ballDirectionX = directionXSpeed;
    private float ballDirectionY = directionYSpeed;


    private MapGenerator map = new MapGenerator(verticalBricks, horizontalBricks);

    private Integer randomInt()
    {
        return ThreadLocalRandom.current().nextInt(0,2);
    }

    public Gameplay()
    {
       // map = new MapGenerator(verticalBricks, horizontalBricks); //3 by 7 column bricks
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
        
    }

    public void paint(Graphics g)
    {
        //background
        g.setColor(Color.white);
        g.fillRect(0, 0, 700, 600);

        //borders
        g.setColor(Color.gray);

        //Left Border
        g.fillRect(0, 0, 5, 600);

        //Top Border
        g.fillRect(0, 0, 700, 5);

       //Right Border
        g.fillRect(680, 0, 5, 600);


        //score
        g.setColor(Color.darkGray);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString(""+score, 590, 30);

        //the bottom paddle
        g.setColor(Color.blue);
        g.fillRect(playerPosX, 550, 100, 8);

        //the ball bject.
        g.setColor(Color.red);
        g.fillOval(ballPosX, ballPosY, 20, 20);


        if (totalBricks <= 0)
        {
            play = false;
            ballDirectionX = 0;
            ballDirectionY = 0;
            g.setColor(Color.black);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Won! Score: " + score, 260, 300);


            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart ", 230, 350);
        }




        if (ballPosY > 570)
        {
            play = false;
            ballDirectionX = 0;
            ballDirectionY = 0;
            g.setColor(Color.black);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over, Scores: " + score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press ENTER to restart the game. ", 230, 350);
        }

        //drawing map
        map.draw((Graphics2D)g);



        g.dispose();




    }














    @Override
    public void actionPerformed(ActionEvent e) 
    {
        timer.start();
        repaint(); //Repaint every couple seconds.
        if (play)
        {
            //Detects paddle
            if (new Rectangle(ballPosX, ballPosY, 20 , 20).intersects(new Rectangle(playerPosX, 550, 100, 8)))
            {
                ballDirectionY = -ballDirectionY;
            }

            A: for (int i = 0; i < map.map.length; i++)
                {
                    for (int j = 0; j < map.map[0].length; j++)
                    {
                        if (map.map[i][j] > 0)
                        {

                            int brickX = j * map.brickWidth + 80;
                            int brickY = i * map.brickHeight + 50;
                            int brickWidth = map.brickWidth;
                            int brickHeight = map.brickHeight;


                            Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                            Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20 , 20);
                            Rectangle brickRect = rect;


                            if (ballRect.intersects(brickRect))
                            {
                                map.setBrickValue(0, i, j);
                                totalBricks --;
                                score += 5;

                                if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) 
                                {
                                    ballDirectionX = -ballDirectionX;
                                }
                                else
                                {
                                    ballDirectionY = -ballDirectionY;
                                }

                                break A;
                            }
                        }
                    }
                }



        ballPosX += ballDirectionX;
        ballPosY += ballDirectionY;

        //for the left border
        if (ballPosX < 0)
        {
            ballDirectionX = -ballDirectionX;
        }

        //for the top
        if (ballPosY < 0)
        {
            ballDirectionY = -ballDirectionY;
        }

        //for the right border
        if (ballPosX >= 650)
        {
            ballDirectionX = -ballDirectionX;
        }
    }
    repaint();
}



    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub


    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            if(playerPosX >= 600)
            {
                playerPosX = 600;
            }
            else
            {
                moveLeft();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(playerPosX <= 10)
            {
                playerPosX = 10;
            }
            else
            {
                moveRight();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if(!play)
            {
                play = false;
                ballPosX = 120;
                ballPosY = 350;
                ballDirectionX = directionXSpeed - randomInt();
                ballDirectionY = directionYSpeed - randomInt();
                playerPosX = 310;
                score = 0;
                totalBricks = verticalBricks * horizontalBricks;
                map = new MapGenerator(verticalBricks,  horizontalBricks);

                repaint();
            }
        }
    }

    public void moveLeft()
    {
        play = true;
        if (playerPosX - 10 <= 30)
        {
            return;
        }
        else
        {
        playerPosX -= 45;
        }
    }

    public void moveRight()
    {
        play = true;
        if(playerPosX + 100 >= 670)
        {
            return;
        }
        else
        {
            playerPosX += 45;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    
    
}