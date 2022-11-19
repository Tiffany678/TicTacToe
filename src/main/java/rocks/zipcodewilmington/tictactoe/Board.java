package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character[][] matrix;
    public Board(Character[][] matrix) {
        this.matrix = matrix;
    }

    public Boolean isInFavorOfX() {
        int[] rowSum= new int[3];
        int[] colSum = new int[3];
        int[] rowO = new int[3];
        int[] colO = new int[3];

        int diag1=0;
        int diag2=0;
        int countX=0;
        int countO=0;
        int countY=0;
        boolean empty=false;


        for(int x=0; x<3; x++){
            for(int y=0; y<3; y++){
                if(Character.toLowerCase(matrix[x][y])==('x')){
                    rowSum[x]++;
                    countX++;
                }
                if(Character.toLowerCase(matrix[x][y])==(' ')){
                    empty=true;
                }
                if(Character.toLowerCase(matrix[x][y])==('o')){
                    countO++;
                }
                if(Character.toLowerCase(matrix[x][y])==('x')){
                    colSum[y]++;
                }
                if(x==y && Character.toLowerCase(matrix[x][y])==('x') ){
                    diag1++;
                }
                if((x+y)==2 && Character.toLowerCase(matrix[x][y])==('x')){
                    diag2++;
                }
            }
        }

        if(!empty) {
            return false;
        }
        return countX>countO;
    }

    public Boolean isInFavorOfO() {
        int countX=0;
        int countO=0;
        boolean empty=false;


        for(int x=0; x<3; x++){
            for(int y=0; y<3; y++){
                if(Character.toLowerCase(matrix[x][y])==('x')){
                    countX++;
                }
                if(Character.toLowerCase(matrix[x][y])==(' ')){
                    empty=true;
                }
                if(Character.toLowerCase(matrix[x][y])==('o')){
                    countO++;
                }
            }
        }

        if(!empty) {
            return false;
        }
        return countO>countX;
    }

    public Boolean isTie() {

        int[] rowSum= new int[3];
        int[] colSum = new int[3];
        int diag1=0;
        int diag2=0;
        int countX=0;
        int countY=0;
        boolean empty=false;

        for(int x=0; x<3; x++){
            for(int y=0; y<3; y++){
                if(Character.toLowerCase(matrix[x][y])==('x')){
                    rowSum[x]++;
                }
                if(Character.toLowerCase(matrix[x][y])==(' ')){
                    empty=true;
                }
                if(Character.toLowerCase(matrix[x][y])==('x')){
                    colSum[y]++;
                }
                if(x==y && Character.toLowerCase(matrix[x][y])==('x') ){
                    diag1++;
                }
                if((x+y)==2 && Character.toLowerCase(matrix[x][y])==('x')){
                    diag2++;
                }
            }
        }
        for(int i=0; i<3; i++){
            if(rowSum[i]>1){
                countX++;
            }else countY++;
            if(colSum[i]>1){
                countX++;
            }else countY++;

        }
        if(diag1>1){
            countX++;
        }else countY++;

        if(diag2>1){
            countX++;
        }else countY++;
        if (!empty){
            return true;
        }
        return countX==countY;
    }

    public String getWinner() {

        int[] rowSum= new int[3];
        int[] colSum = new int[3];
        int diag1=0;
        int diag2=0;


        for(int x=0; x<3; x++){
            for(int y=0; y<3; y++){
                if(Character.toLowerCase(matrix[x][y])==('x')){
                    rowSum[x]++;
                }
                if(Character.toLowerCase(matrix[x][y])==('x')){
                    colSum[y]++;
                }
                if(x==y && Character.toLowerCase(matrix[x][y])==('x') ){
                    diag1++;
                }
                if((x+y)==2 && Character.toLowerCase(matrix[x][y])==('x')){
                    diag2++;
                }
            }
        }


        for(int i=0; i<3; i++){
            if(rowSum[i]==3 || colSum[i]==3 || diag1==3 ||diag2==3){
                return "X";
            } else if (rowSum[i]==0 || colSum[i]==0 || diag1==0 || diag2==0) {
                return "O";
            }
        }

        return "";
    }

}
