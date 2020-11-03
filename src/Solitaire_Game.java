/*
 ** Program Purpose: Create an interactive solitaire program
 ** Author: Elizabeth Ruggiero
 ** Period: 3
 ** Date: 5/17/20
 ** Version: 1
 */

//import java libraries

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Solitaire_Game {
    //variable instantiation
    private static Play_Board mainBoard;
    private static Title_Page intro;

    //main method creates title page and play board
    public static void main(String[] args) throws InterruptedException {
        intro = new Title_Page();
        intro.action();
        intro.getPlayButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                intro.setVisible(false);
                mainBoard = new Play_Board();
                mainBoard.action();

                //restart button can be clicked five times before having to click run again
                mainBoard.getRestartButton().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mainBoard.end();
                        mainBoard = new Play_Board();
                        mainBoard.action();


                        mainBoard.getRestartButton().addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                mainBoard.end();
                                mainBoard = new Play_Board();
                                mainBoard.action();
                                mainBoard.getRestartButton().addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        mainBoard.end();
                                        mainBoard = new Play_Board();
                                        mainBoard.action();
                                        mainBoard.getRestartButton().addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                mainBoard.end();
                                                mainBoard = new Play_Board();
                                                mainBoard.action();
                                                mainBoard.getRestartButton().addActionListener(new ActionListener() {
                                                    public void actionPerformed(ActionEvent e) {
                                                        mainBoard.addLabel(new JLabel("Max restarts reached. Please close window and reopen to play again."));
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });


                    }
                });


            }
        });
    }
}
