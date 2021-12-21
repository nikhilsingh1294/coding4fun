package tictactoe;

import java.util.Random;
import java.io.*;
public class TicTacToeOpr {
	int row,col;
	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	//TicTacToeBoard board=new TicTacToeBoard();
	
	//accepting row
	public int acceptRow(TicTacToeBoard board){
		System.out.println("Enter the Row");
		try {
			row=Integer.parseInt(br.readLine());
		}
		catch(Exception e) {
			displayBoard(board);
			acceptRow(board);
		}
		
		if( row-1 >= board.MAXROW || row-1<0 ) {
			displayBoard(board);
			System.out.println("Row limit 1 to 3");
			acceptRow(board);
		}
		return row;
	}
	
	//accepting column
	public int acceptColumn(TicTacToeBoard board){
		System.out.println("Enter the Column");
		try {
			col=Integer.parseInt(br.readLine());
		}
		catch(Exception e) {
			displayBoard(board);
			System.out.println("Row entered is: "+row);
			acceptColumn(board);
		}
		if( col-1 >= board.MAXCOL || col-1<0 ) {
			displayBoard(board);
			System.out.println("Row entered is: "+row);
			System.out.println("WARNING: Column limit 1 to 3");
			acceptColumn(board);
		}
		return col;
	}
	
		
	//displays scores of user and system
	public void score(int userctr, int systemctr, long starttime)
	{
		System.out.println("\tYOU | COMPUTER");
		System.out.println("\t "+userctr+"  | \t"+systemctr);
		//long endtime=System.nanoTime();
		//System.out.println("\nTotal time taken: "+((endtime-starttime)/1000000000)+"s");
	}
	
	//making system's move
	public void systemMove(TicTacToeBoard board, char x, char o){
		
		boolean block=blockIfUserWining(board,x,o);
		boolean systemmovestatus;
		while(block==false) {
			systemmovestatus=makeSystemMove(board,x,o);
			if(systemmovestatus == true)
				break;
		}
	}
	
public boolean ifSystemWining(TicTacToeBoard board, char o) {
		
		/*---------wining left diagonal---------------------*/
		if( board.grids[0][0] == board.grids[1][1] && board.grids[0][0] == o ) {
			if(board.grids[2][2]==' ') {
				board.grids[2][2]=o;
				return true;
			}
		}
		if( board.grids[0][0] == board.grids[2][2] && board.grids[0][0] == o ) {
			if(board.grids[1][1]==' ') {
				board.grids[1][1]=o;
				return true;
			}
		}
		if( board.grids[1][1] == board.grids[2][2] && board.grids[1][1] == o ) {
			if(board.grids[0][0]==' ') {
				board.grids[0][0]=o;
				return true;
			}
		}
		
		/*------------wining right diagonal---------------*/
		if( board.grids[0][2] == board.grids[1][1] && board.grids[0][2] == o ) {
			if(board.grids[2][0]==' ') {
				board.grids[2][0]=o;
				return true;
			}
		}
		if( board.grids[0][2] == board.grids[2][0] && board.grids[0][2] == o ) {
			if(board.grids[1][1]==' ') {
				board.grids[1][1]=o;
				return true;
			}
		}
		if( board.grids[2][0] == board.grids[1][1] && board.grids[2][0] == o ) {
			if(board.grids[0][2]==' ') {
				board.grids[0][2]=o;
				return true;
			}
		}
		
		/*------------wining first row------------------*/
		if( board.grids[0][0] == board.grids[0][1] && board.grids[0][0] == o ) {
			if(board.grids[0][2]==' ') {
				board.grids[0][2]=o;
				return true;
			}
		}
		if( board.grids[0][0] == board.grids[0][2] && board.grids[0][0] == o ) {
			if(board.grids[0][1]==' ') {
				board.grids[0][1]=o;
				return true;
			}
		}
		if( board.grids[0][1] == board.grids[0][2] && board.grids[0][1] == o ) {
			if(board.grids[0][0]==' ') {
				board.grids[0][0]=o;
				return true;
			}
		}
				
		/*-----------wining second row-----------------*/
		if( board.grids[1][0] == board.grids[1][1] && board.grids[1][0] == o ) {
			if(board.grids[1][2]==' ') {
				board.grids[1][2]=o;
				return true;
			}
		}
		if( board.grids[1][0] == board.grids[1][2] && board.grids[1][0] == o ) {
			if(board.grids[1][1]==' ') {
				board.grids[1][1]=o;
				return true;
			}
		}
		if( board.grids[1][1] == board.grids[1][2] && board.grids[1][1] == o ) {
			if(board.grids[1][0]==' ') {
				board.grids[1][0]=o;
				return true;
			}
		}
				
		/*-------------wining third row--------------*/
		if( board.grids[2][0] == board.grids[2][1] && board.grids[2][0] == o ) {
			if(board.grids[2][2]==' ') {
				board.grids[2][2]=o;
				return true;
			}
		}
		if( board.grids[2][0] == board.grids[2][2] && board.grids[2][0] == o ) {
			if(board.grids[2][1]==' ') {
				board.grids[2][1]=o;
				return true;
			}
		}
		if( board.grids[2][1] == board.grids[2][2] && board.grids[2][1] == o ) {
			if(board.grids[2][0]==' ') {
				board.grids[2][0]=o;
				return true;
			}
		}
		
		/*-----------wining first column------------*/
		if( board.grids[0][0] == board.grids[1][0] && board.grids[0][0] == o ) {
			if(board.grids[2][0]==' ') {
				board.grids[2][0]=o;
				return true;
			}
		}
		if( board.grids[0][0] == board.grids[2][0] && board.grids[0][0] == o ) {
			if(board.grids[1][0]==' ') {
				board.grids[1][0]=o;
				return true;
			}
		}
		if( board.grids[1][0] == board.grids[2][0] && board.grids[1][0] == o ) {
			if(board.grids[0][0]==' ') {
				board.grids[0][0]=o;
				return true;
			}
		}
		
		/*----------wining second column-----------*/
		if( board.grids[0][1] == board.grids[1][1] && board.grids[0][1] == o ) {
			if(board.grids[2][1]==' ') {
				board.grids[2][1]=o;
				return true;
			}
		}
		if( board.grids[1][1] == board.grids[2][1] && board.grids[1][1] == o ) {
			if(board.grids[0][1]==' ') {
				board.grids[0][1]=o;
				return true;
			}
		}
		if( board.grids[0][1] == board.grids[2][1] && board.grids[0][1] == o ) {
			if(board.grids[1][1]==' ') {
				board.grids[1][1]=o;
				return true;
			}
		}
				
		/*--------wining third column------------*/
		if( board.grids[0][2] == board.grids[1][2] && board.grids[0][2] == o ) {
			if(board.grids[2][2]==' ') {
				board.grids[2][2]=o;
				return true;
			}
		}
		if( board.grids[1][2] == board.grids[2][2] && board.grids[1][2] == o ) {
			if(board.grids[2][2]==' ') {
				board.grids[2][2]=o;
				return true;
			}
		}
		if( board.grids[0][2] == board.grids[2][2] && board.grids[0][2] == o ) {
			if(board.grids[1][2]==' ') {
				board.grids[1][2]=o;
				return true;
			}
		}
		return false;
		
	}
	
	public boolean makeSystemMove(TicTacToeBoard board, char x, char o) {
		
		int firstcorner=1, lastcorner=4;
		Random random = new Random();
		int gridcorner = random.nextInt((lastcorner-firstcorner)+1)+firstcorner;
		
		//marking in the corners...going clockwise
		if( board.grids[0][0] != ' ' && board.grids[0][2] != ' ' && board.grids[2][2] != ' ' && board.grids[2][0] != ' ') 
			markInEmpty(board,o);
		
		else if(gridcorner==1) {
			if( board.grids[0][0]==' ' )
				board.grids[0][0]=o;
			else 
				return false;
		}
		
		else if(gridcorner==2) {
			if( board.grids[0][2]==' ' )
				board.grids[0][2]=o;
			else
				return false;
		}
		
		else if(gridcorner==3) {
			if( board.grids[2][2]==' ' )
				board.grids[2][2]=o;
			else
				return false;
		}
		
		else if(gridcorner==4) {
			if( board.grids[2][0]==' ' )
				board.grids[2][0]=o;
			else
				return false;
		}
		else
		{}
		
		return true;
	}
	
	public void markInEmpty(TicTacToeBoard board, char o) {
				
		for(int indexi=0; indexi<3; indexi++ ) {
			for(int indexj=0; indexj<3; indexj++ ){
				if( board.grids[indexi][indexj] == ' ' ) {
					board.grids[indexi][indexj]=o;
					return;
				}
			}
		}
	}
	
	public boolean isBoardFull(TicTacToeBoard board) {
		
		for(int indexi=0; indexi<3; indexi++ ) {
			for(int indexj=0; indexj<3; indexj++ ){
				if( board.grids[indexi][indexj] == ' ' )
					return false;
			}
		}
		return true;
	}
	
	
	public boolean blockIfUserWining(TicTacToeBoard board, char x, char o) {
		
		/*---------blocking left diagonal---------------------*/
		if( board.grids[0][0] == board.grids[1][1] && board.grids[0][0] == x ) {
			if(board.grids[2][2]==' ') {
				board.grids[2][2]=o;
				return true;
			}
		}
		if( board.grids[0][0] == board.grids[2][2] && board.grids[0][0] == x ) {
			if(board.grids[1][1]==' ') {
				board.grids[1][1]=o;
				return true;
			}
		}
		if( board.grids[1][1] == board.grids[2][2] && board.grids[1][1] == x ) {
			if(board.grids[0][0]==' ') {
				board.grids[0][0]=o;
				return true;
			}
		}
		
		/*------------blocking right diagonal---------------*/
		if( board.grids[0][2] == board.grids[1][1] && board.grids[0][2] == x ) {
			if(board.grids[2][0]==' ') {
				board.grids[2][0]=o;
				return true;
			}
		}
		if( board.grids[0][2] == board.grids[2][0] && board.grids[0][2] == x ) {
			if(board.grids[1][1]==' ') {
				board.grids[1][1]=o;
				return true;
			}
		}
		if( board.grids[2][0] == board.grids[1][1] && board.grids[2][0] == x ) {
			if(board.grids[0][2]==' ') {
				board.grids[0][2]=o;
				return true;
			}
		}
		
		/*------------blocking first row------------------*/
		if( board.grids[0][0] == board.grids[0][1] && board.grids[0][0] == x ) {
			if(board.grids[0][2]==' ') {
				board.grids[0][2]=o;
				return true;
			}
		}
		if( board.grids[0][0] == board.grids[0][2] && board.grids[0][0] == x ) {
			if(board.grids[0][1]==' ') {
				board.grids[0][1]=o;
				return true;
			}
		}
		if( board.grids[0][1] == board.grids[0][2] && board.grids[0][1] == x ) {
			if(board.grids[0][0]==' ') {
				board.grids[0][0]=o;
				return true;
			}
		}
				
		/*-----------blocking second row-----------------*/
		if( board.grids[1][0] == board.grids[1][1] && board.grids[1][0] == x ) {
			if(board.grids[1][2]==' ') {
				board.grids[1][2]=o;
				return true;
			}
		}
		if( board.grids[1][0] == board.grids[1][2] && board.grids[1][0] == x ) {
			if(board.grids[1][1]==' ') {
				board.grids[1][1]=o;
				return true;
			}
		}
		if( board.grids[1][1] == board.grids[1][2] && board.grids[1][1] == x ) {
			if(board.grids[1][0]==' ') {
				board.grids[1][0]=o;
				return true;
			}
		}
				
		/*-------------blocking third row--------------*/
		if( board.grids[2][0] == board.grids[2][1] && board.grids[2][0] == x ) {
			if(board.grids[2][2]==' ') {
				board.grids[2][2]=o;
				return true;
			}
		}
		if( board.grids[2][0] == board.grids[2][2] && board.grids[2][0] == x ) {
			if(board.grids[2][1]==' ') {
				board.grids[2][1]=o;
				return true;
			}
		}
		if( board.grids[2][1] == board.grids[2][2] && board.grids[2][1] == x ) {
			if(board.grids[2][0]==' ') {
				board.grids[2][0]=o;
				return true;
			}
		}
		
		/*-----------blocking first column------------*/
		if( board.grids[0][0] == board.grids[1][0] && board.grids[0][0] == x ) {
			if(board.grids[2][0]==' ') {
				board.grids[2][0]=o;
				return true;
			}
		}
		if( board.grids[0][0] == board.grids[2][0] && board.grids[0][0] == x ) {
			if(board.grids[1][0]==' ') {
				board.grids[1][0]=o;
				return true;
			}
		}
		if( board.grids[1][0] == board.grids[2][0] && board.grids[1][0] == x ) {
			if(board.grids[0][0]==' ') {
				board.grids[0][0]=o;
				return true;
			}
		}
		
		/*----------blocking second column-----------*/
		if( board.grids[0][1] == board.grids[1][1] && board.grids[0][1] == x ) {
			if(board.grids[2][1]==' ') {
				board.grids[2][1]=o;
				return true;
			}
		}
		if( board.grids[1][1] == board.grids[2][1] && board.grids[1][1] == x ) {
			if(board.grids[0][1]==' ') {
				board.grids[0][1]=o;
				return true;
			}
		}
		if( board.grids[0][1] == board.grids[2][1] && board.grids[0][1] == x ) {
			if(board.grids[1][1]==' ') {
				board.grids[1][1]=o;
				return true;
			}
		}
				
		/*--------blocking third column------------*/
		if( board.grids[0][2] == board.grids[1][2] && board.grids[0][2] == x ) {
			if(board.grids[2][2]==' ') {
				board.grids[2][2]=o;
				return true;
			}
		}
		if( board.grids[1][2] == board.grids[2][2] && board.grids[1][2] == x ) {
			if(board.grids[2][2]==' ') {
				board.grids[2][2]=o;
				return true;
			}
		}
		if( board.grids[0][2] == board.grids[2][2] && board.grids[0][2] == x ) {
			if(board.grids[1][2]==' ') {
				board.grids[1][2]=o;
				return true;
			}
		}
		return false;
		
	}
	
	//marking user's move in an array
	public void userMove(TicTacToeBoard board, int row, int col, char x){
		board.grids[row][col]=x;
	}
	
	//to see whether the row and column are within range or not
	public boolean isLegalMove(TicTacToeBoard board,int row, int col) {
		if(board.grids[row][col]!=' ')
			return false;
		else
			return true;
	}
	
	//to check whether the move led towards the win
	public boolean checkMove(TicTacToeBoard board, char mark) {
		if( board.grids[0][0] == board.grids[1][1] && board.grids[0][0]	== board.grids[2][2] && board.grids[0][0] == mark )
	  		return true;
		else if( board.grids[0][2] == board.grids[1][1] && board.grids[0][2] == board.grids[2][0] && board.grids[0][2] == mark )
			return true;
		else if( board.grids[0][0] == board.grids[0][1] && board.grids[0][0] == board.grids[0][2] && board.grids[0][0] == mark )
			return true;
		else if( board.grids[2][0] == board.grids[2][1] && board.grids[2][0] == board.grids[2][2] && board.grids[2][0] == mark )
			return true;
		else if( board.grids[0][0] == board.grids[1][0] && board.grids[0][0] == board.grids[2][0] && board.grids[0][0] == mark )
			return true;
		else if( board.grids[0][2] == board.grids[1][2] && board.grids[0][2] == board.grids[2][2] && board.grids[0][2] == mark )
			return true;
		else if( board.grids[0][1] == board.grids[1][1] && board.grids[0][1] == board.grids[2][1] && board.grids[0][1] == mark )
			return true;
		else if( board.grids[1][0] == board.grids[1][1] && board.grids[1][0] == board.grids[1][2] && board.grids[1][0] == mark )
			return true;
		else
			return false;
		
	}
	
	//to check system's win
	public boolean checkSystemWin(TicTacToeBoard board, char mark) {
		if( board.grids[0][0] == board.grids[1][1] && board.grids[0][0]	== board.grids[2][2] && board.grids[0][0] == mark )
	  		return true;
		else if( board.grids[0][2] == board.grids[1][1] && board.grids[0][2] == board.grids[2][0] && board.grids[0][2] == mark )
			return true;
		else if( board.grids[0][0] == board.grids[0][1] && board.grids[0][0] == board.grids[0][2] && board.grids[0][0] == mark )
			return true;
		else if( board.grids[2][0] == board.grids[2][1] && board.grids[2][0] == board.grids[2][2] && board.grids[2][0] == mark )
			return true;
		else if( board.grids[0][0] == board.grids[1][0] && board.grids[0][0] == board.grids[2][0] && board.grids[0][0] == mark )
			return true;
		else if( board.grids[0][2] == board.grids[1][2] && board.grids[0][2] == board.grids[2][2] && board.grids[0][2] == mark )
			return true;
		else if( board.grids[0][1] == board.grids[1][1] && board.grids[0][1] == board.grids[2][1] && board.grids[0][1] == mark )
			return true;
		else if( board.grids[1][0] == board.grids[1][1] && board.grids[1][0] == board.grids[1][2] && board.grids[1][0] == mark )
			return true;
		else
			return false;
	}
	
	//displaying the TicTacToe Board
	public void displayBoard(TicTacToeBoard board) {
		System.out.println();
		for( int row=0; row < board.MAXROW; row++ ) {
			for( int col=0; col<board.MAXCOL; col++ ) {
				System.out.print("  "+board.grids[row][col]);
				if(col!=2)
					System.out.print("  |");
			}
			if(row!=2)
				System.out.println("\n  -------------");
		}
		System.out.println("\n");
	}
	
	
	//initializing the TicTacToe Board
	public void initBoard(TicTacToeBoard board) {
		for( int row=0; row < board.MAXROW; row++ ) {
			for( int col=0; col<board.MAXCOL; col++ )
				board.grids[row][col]=' ';
		}
	}
}
