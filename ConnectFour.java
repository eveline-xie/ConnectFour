//Yang Xie
//112719816


import java.util.Scanner;
public class ConnectFour{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        char[][] board= new char[6][7];
        //set up the empty board
        for(int x=0; x<board.length; x++){
            for(int y=0; y<board[x].length; y++){
                board[x][y]=' ';
            }
        }

        boolean flag=true;
        boolean goRed=true;
        boolean goYellow=true;

        showBoard(board);

        while(flag){
            
            if(goRed){
                System.out.print("Drop a red disk at column (0 - 6): ");
                int redNum=stdin.nextInt();
                if(redNum>=0&&redNum<=6){

                    if(isFull(board,redNum)){
                        System.out.println("Full column, try again!");
                        goYellow=false;
                    }

                    play(board, 'R', redNum);
                    showBoard(board);
                    if(!status(board)){
                        System.out.print("The red player won");
                        flag=false;
                        break;
                    }


                }else{
                    System.out.println("Invalid column number, try again!");
                    goYellow=false;
                }
            }
            goRed=true;

            if(goYellow){
                System.out.print("Drop a yellow disk at column (0 - 6): ");
                int yellowNum=stdin.nextInt();
                if(yellowNum>=0&&yellowNum<=6){

                    if(isFull(board,yellowNum)){
                        System.out.println("Full column, try again!");
                        goRed=false;
                    }

                    play(board, 'Y', yellowNum);
                    showBoard(board);
                    if(!status(board)){
                        System.out.println("The yellow player won");
                        flag=false;
                    }

                }else{
                    System.out.println("Invalid column number, try again!");
                    goRed=false;
                }
            }
            goYellow=true;
            
        }
        stdin.close();
        

        
    } 


    public static void showBoard(char[][] board){
        System.out.println();
        for (int row = 0; row < board.length; row++){
            System.out.print("|");
            for (int column = 0; column < board[row].length; column++){
                System.out.print( " "+ board[row][column] + " |"); }
            System.out.println(); }
        System.out.println(".............................");
    }


    public static void play(char[][] board, char player, int num){
        for(int x=board.length-1; x>=0; x--){
            if(board[x][num]==' '){
                board[x][num]= player;
                break;
            }
        }
    }

    public static boolean status(char[][] board){
        boolean flag=true;

        //check horizontal
        for(int x=0; x<board.length; x++){
            for(int y=0; y<board[x].length-3; y++){
                if(board[x][y]!=' '){
                    if(board[x][y]==board[x][y+1]&& board[x][y+1]==board[x][y+2]&&board[x][y+2]==board[x][y+3]){
                        flag = false;
                    }
                }
            }
        }

        //check vertical
        for(int y=0; y<board[0].length; y++){
            for(int x=0; x<board.length-3;x++){
                if(board[x][y]!=' '){
                    if(board[x][y]==board[x+1][y]&& board[x+1][y]==board[x+2][y]&&board[x+2][y]==board[x+3][y]){
                        flag = false;
                    }
                }
            }
        }

        //check diagonal from top left 
        for(int x=0; x<board.length-3; x++){
            for(int y=0; y<board[x].length; y++){
                if(board[x][y]!=' '){
                    if(board[x][y]==board[x+1][y+1]&&board[x][y]==board[x+2][y+2]&&board[x][y]==board[x+3][y+3])
                        flag = false;
                }
            }
        }

        //check diagonal from top right
        for(int x=0; x<board.length-3; x++){
            for(int y=3; y<board[x].length; y++){
                if(board[x][y]!=' '){
                    if(board[x][y]==board[x+1][y-1]&&board[x][y]==board[x+2][y-2]&&board[x][y]==board[x+3][y-3])
                        flag = false;
                }
            }
        }

        return flag;

    }

    public static boolean isFull(char[][] board, int num){
        boolean f=false;
        int count=0;
        
            for(int x=0; x<board.length; x++){
                if(board[x][num]!=' '){
                    count++;
                }
            }
            if(count==6){
                f=true;
            }
        

        return f;

    }




}