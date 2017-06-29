package game.ui;

import game.TicTacToe;
import game.TicTacToe.Peg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame{
    public static final int SIZE = 3;
    TicTacToe ticTacToe;
    protected void frameInit(){
        ticTacToe = new TicTacToe();
        super.frameInit();
        setLayout(new GridLayout(3,3));
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                TicTacToeCell cell = new TicTacToeCell(i, j);
                getContentPane().add(cell);
                cell.addActionListener(new cellClickedHandler());
            }
        }
    }
    public static void main(String args[]){
        JFrame frame = new TicTacToeFrame();
        frame.setSize(150, 150);
        frame.setVisible(true);
    }

    private class cellClickedHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent){
            TicTacToeCell cell = (TicTacToeCell)actionEvent.getSource();
            TicTacToe.Peg placed = ticTacToe.placePeg(cell.row, cell.col);
            if(placed == Peg.FIRST)
                cell.setText("X");
            if(placed == Peg.SECOND)
                cell.setText("O");
            Peg winner = ticTacToe.winner(cell.row, cell.col, SIZE);
            if(winner != Peg.NONE){
                JOptionPane.showMessageDialog(cell, "The winner is "+winner.toString());
            }
        }
    }
}
