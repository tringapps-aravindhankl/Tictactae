package tictactaegame;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

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
		return board [0][0]!=' ' && board[0][0] ==  board[1][1] && board[1][1] ==  board[2][2] && board[0][0] == board[2][2] ||  board[0][2]!=' ' && board[0][2] == board[1][1] && board[1][1]==board[2][0];
	
	}
}

