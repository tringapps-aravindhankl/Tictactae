package tictactaegame;
import java.io.PrintStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.*;
public class Game 
{
    public static void main( String[] args )
    {
    Tictactae tic=new Tictactae();
    Scanner scan=new Scanner(System.in);
    Scanner scan1=new Scanner(System.in);
    char mark;
    char mark1;
    int t=0;
    int count=0;
    tic.printboard();
    Tictactae.l.println("Enter Player1");
    String name=scan.nextLine();
    Tictactae.l.println("Choose X  OR O");
    mark=scan.next().charAt(0);
    HumanPlayer player1=new HumanPlayer(name,mark);
    
    Tictactae.l.println("Enter Player2");
    String name1=scan1.nextLine();
    if(mark=='X') {
    mark1='O';
    }else {
    	mark1='X';
    }
    HumanPlayer player2=new HumanPlayer(name1,mark1);
    
    HumanPlayer cp;
    cp = player1;
    
    while(count<9) {
    Tictactae.l.println(cp.name + "Turn");
    cp.makeMove();
    tic.printboard();
    if(Tictactae.checkRow() || Tictactae.checkcol() || Tictactae.checkDiag() )
    {
    	Tictactae.l.println(cp.name +"Win");
    	t++;
    	break;
    }
    else
    {
	count++;
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
    	Tictactae.l.println("Match is Draw");
    }
    }
    
      
}
