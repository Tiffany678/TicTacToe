package rocks.zipcodewilmington.tictactoe;

public class MainBoard {
public static void main(String[] arg){
    Character[][] m= new Character[][]{
                                           {'X', 'O', ' '},
                                            {' ', 'O', ' '},
                                            {'X', 'O', ' '}
    };
    Board b = new Board(m);
    System.out.println(b.getWinner());

}
}
