package tictactaegame;
import java.io.PrintStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.*;
import java.util.logging.Logger;
class Tictactae
{
	static char[][]board;
	static PrintStream L=new PrintStream((new FileOutputStream(FileDescriptor.out)));
	Tictactae(){
		board=new char[3][3];
		initBoard();
	}
	void initBoard()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				board[i][j]=' ';
			}
		}
	}
	void PrintBoard()
	{
		L.println("-------");
		for(int i=0;i<board.length;i++)
		{
			L.print("|");
			for(int j=0;j<board.length;j++)
			{
				L.print(board[i][j]+ "|");
			}
			L.println();
			L.println("-------");
		}
	}
	static void placeMark(int row,int col,char mark) {
		board[row][col]=mark;
	}
	static boolean checkRow()       
	{
		for(int i=0;i<3;i++) {
		if(board[i][0]!=' ' && board[i][0] == board[i][1] && board[i][1]== board[i][2]) {
			return true;
		}
		}
		return false;
	}
	static boolean checkcol()
	{
		for(int j=0;j<3;j++) 
		{
			if(board[0][j]!=' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
			{
				return true;
		    }
		}
		return false;
	}
	static boolean checkDiag() {
		if(board [0][0]!=' ' && board[0][0] ==  board[1][1] && board[1][1] ==  board[2][2] && board[0][0] == board[2][2] ||  board[0][2]!=' ' && board[0][2] == board[1][1] && board[1][1]==board[2][0])
		{
			return true;
		}
		return false;
	}
}
class HumanPlayer 
{
	String name;
	char mark;
	HumanPlayer(String name,char mark){
		this.name=name;
		this.mark=mark;
	}
	 
	void makeMove()
	{
	Scanner scan=new Scanner(System.in);
	int row;
	int col;
	do
	{
		System.out.println("enter row and col:");
		row=scan.nextInt();
		col=scan.nextInt();
	}while(!validMove(row,col));
	Tictactae.placeMark(row,col,mark);
	}
	boolean validMove(int row,int col)
	{
		if(row>=0 && row<=2 && col>=0 && col<=2)
		{
			if(Tictactae.board[row][col]==' ')
			{
			return true;
			}
		}
		Tictactae.L.println("Invalid");
		return false;
	}
}
public class Game 
{
    public static void main( String[] args )
    {
    Tictactae tic=new Tictactae();
    Scanner scan=new Scanner(System.in);
    Scanner scan1=new Scanner(System.in);
    char mark,mark1;
    int t=0;
    tic.PrintBoard();
    System.out.println("Enter Player1");
    String name=scan.nextLine();
    System.out.println("Choose X  OR O");
    mark=scan.next().charAt(0);
    HumanPlayer player1=new HumanPlayer(name,mark);
    
    System.out.println("Enter Player1");
    String name1=scan1.nextLine();
    if(mark=='X') {
    mark1='O';
    }else {
    	mark1='X';
    }
    HumanPlayer player2=new HumanPlayer(name1,mark1);
    
    HumanPlayer cp;
    cp = player1;
    
    while(t<9) {
    Tictactae.L.println(cp.name + "Turn");
    cp.makeMove();
    tic.PrintBoard();
    if(Tictactae.checkRow() || Tictactae.checkcol() || Tictactae.checkDiag() )
    {
    	Tictactae.L.println(cp.name +"Win");
    	t++;
    	break;
    }
    else
    {
    	if(cp==player1)
    	{
    		cp=player2;
    	}
    	else
    	{
    		cp=player1;
    	}
    }
    }
    if(t==0) {
    	Tictactae.L.println(cp.name +"Die");
    }
    }
    
      
}