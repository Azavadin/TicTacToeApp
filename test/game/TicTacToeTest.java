 package game;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;
import game.TicTacToe.Peg;
public class TicTacToeTest {
    TicTacToe ticTacToe;
    @Before
    public void setUp(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void canary(){
        assertTrue(true);
    }

    @Test
    public void placePeg1(){
        assertEquals(Peg.FIRST, ticTacToe.placePeg(1,2));
    }

    @Test
    public void placePeg2(){
        ticTacToe.placePeg(1,2);
        assertEquals(Peg.SECOND, ticTacToe.placePeg(0,2));
    }

    @Test
    public void placePegAtAlreadyOccupiedPosition(){
        ticTacToe.placePeg(0,2);
        assertEquals(Peg.FIRST, ticTacToe.placePeg(0,2));
    }

    @Test
    public void placePegOutOfIndicesRange(){
        try{
            ticTacToe.placePeg(4,4);
            fail("Indices out of Range");
        }
        catch(IndexOutOfBoundsException ex){}

        assertEquals(Peg.FIRST, ticTacToe.placePeg(0,2));
    }

    @Test
    public void winByRowMatch(){
        ticTacToe = new TicTacToe(){
            public Peg checkRowMatch(int i, int j, int size){
                return Peg.FIRST;
            }
        };
        assertEquals(Peg.FIRST, ticTacToe.winner(0,1, 3));
    }

    @Test
    public void noWinByRowMatch(){
        ticTacToe = new TicTacToe(){
            public Peg checkRowMatch(int i, int j, int size){
                return Peg.NONE;
            }
        };
        assertEquals(Peg.NONE, ticTacToe.winner(0,1, 3));
    }

    @Test
    public void winByColumnMatch(){
        ticTacToe = new TicTacToe(){
            public Peg checkColumnMatch(int i, int j, int size){
                return Peg.FIRST;
            }
        };
        assertEquals(Peg.FIRST, ticTacToe.winner(0,1, 3));
    }

    @Test
    public void noWinByColumnMatch(){
        ticTacToe = new TicTacToe(){
            public Peg checkColumnMatch(int i, int j, int size){
                return Peg.NONE;
            }
        };
        assertEquals(Peg.NONE, ticTacToe.winner(0,1, 3));
    }

    @Test
    public void winByLeftDiagonalMatch(){
        ticTacToe = new TicTacToe(){
            public Peg checkLeftDiagonalMatch(int i, int j, int size){
                return Peg.FIRST;
            }
        };
        assertEquals(Peg.FIRST, ticTacToe.winner(0,1, 3));
    }

    @Test
    public void noWinByLeftDiagonalMatch(){
        ticTacToe = new TicTacToe(){
            public Peg checkLeftDiagonalMatch(int i, int j, int size){
                return Peg.NONE;
            }
        };
        assertEquals(Peg.NONE, ticTacToe.winner(0,1, 3));
    }

    @Test
    public void winByRightDiagonalMatch(){
        ticTacToe = new TicTacToe(){
            public Peg checkRightDiagonalMatch(int i, int j, int size){
                return Peg.FIRST;
            }
        };
        assertEquals(Peg.FIRST, ticTacToe.winner(0,1, 3));
    }

    @Test
    public void noWinByRightDiagonalMatch(){
        ticTacToe = new TicTacToe(){
            public Peg checkRightDiagonalMatch(int i, int j, int size){
                return Peg.NONE;
            }
        };
        assertEquals(Peg.NONE, ticTacToe.winner(0,1, 3));
    }


}


