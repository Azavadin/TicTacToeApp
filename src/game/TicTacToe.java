package game;
public class TicTacToe {
    int SIZE = 3;
    public enum Peg {NONE, FIRST, SECOND};
    private Peg currentPeg;
    private Peg cells[][] = new Peg[SIZE][SIZE];
    public TicTacToe(){
        currentPeg = Peg.FIRST;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                cells[i][j] = Peg.NONE;
            }
        }
    }

    public Peg checkRowMatch(int i, int j, int size){
        Peg pegPlaced = cells[i][0];
        for(int p = 1; p < size; p++) {
            if (cells[i][p] != pegPlaced)
                return Peg.NONE;
        }
        return pegPlaced;
    }
    public Peg checkColumnMatch(int i, int j, int size){
        Peg pegPlaced = cells[0][j];
        for(int p = 1; p < size; p++) {
            if (cells[p][j] != pegPlaced)
                return Peg.NONE;
        }
        return pegPlaced;
    }

    public Peg winner(int i, int j, int size) {
        Peg winner = checkRowMatch(i, j, size);
        if(winner != Peg.NONE)
            return winner;
        winner = checkColumnMatch(i, j, size);
        if(winner != Peg.NONE)
            return winner;
        winner = checkLeftDiagonalMatch(i, j, size);
        if(winner != Peg.NONE)
            return winner;
        winner = checkRightDiagonalMatch(i, j, size);
        return winner;
    }

    public Peg placePeg(int i, int j) {
        if(cells[i][j] == Peg.NONE){
            cells[i][j] = currentPeg;
            currentPeg = toggle();
        }
        return cells[i][j];
    }

    public Peg toggle(){
        return (currentPeg == Peg.FIRST)? Peg.SECOND: Peg.FIRST;
    }

    public Peg checkLeftDiagonalMatch(int i, int j, int size) {
        Peg pegPlaced = cells[i][j];
        if(i != j)
            return Peg.NONE;
        else{
            for(int p = 0; p < size; p++){
                if(cells[p][p] != pegPlaced)
                    return Peg.NONE;
            }
            return pegPlaced;
        }
    }

    public Peg checkRightDiagonalMatch(int i, int j, int size) {
        Peg pegPlaced = cells[i][j];
        int row = size-1;
        int column = 0;
        while(column != size-1){
            if(cells[row][column] != pegPlaced)
                return Peg.NONE;
            row--;
            column++;
        }
        return pegPlaced;

    }


}
