package game.ui;

import javax.swing.*;
import java.awt.*;

public class TicTacToeCell extends JButton {
    public final int row, col;
    public TicTacToeCell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
