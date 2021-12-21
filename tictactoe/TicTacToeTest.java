package tictactoe;

import java.io.*;
import java.util.Random;

public class TicTacToeTest {

	public static void main(String[] args)throws IOException {
		
		final char x='x';
		final char o='o';
		final int userturn=1;
		final int systemturn=0;
		
		int row=0;
		int col=0;
		int flag=1;
		int firstmove;
		int userctr=0;
		int systemctr=0;
		boolean start =true;
		boolean legal;
		boolean win;
		boolean ack=false;
		String userack;
		long starttime=System.nanoTime();
		TicTacToeBoard board = new TicTacToeBoard();
		TicTacToeOpr boardoprs = new TicTacToeOpr();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("********************");
		System.out.println("|  TICTACTOE GAME  |");
		System.out.println("******************** \n");
		
		Random random = new Random();
		firstmove=random.nextInt((userturn-systemturn)+1)+systemturn;
		
		//initializing board grids
		boardoprs.initBoard(board);

	while(start) {
		
		while(ack) {
			System.out.print("Would you like to continue (y/n)?:");
			userack=br.readLine();
			if(userack.equalsIgnoreCase("n")) {
				if(userctr < systemctr)
					System.out.println("\nWhat a loser..!!");
				else 
					System.out.println("\nWell Played..!!");
				Runtime runtime=Runtime.getRuntime();
				long beforegc=runtime.freeMemory()/1024;
				runtime.gc();
				long aftergc=runtime.freeMemory()/1024;
				System.out.println("The game took "+(aftergc-beforegc)+" B memory in JVM");
				
				return;
			}
			
			else if(userack.equalsIgnoreCase("y")){
				firstmove=random.nextInt((userturn-systemturn)+1)+systemturn;
				boardoprs.initBoard(board);
				flag=1;
				ack=false;
			}
			else
				System.out.println("\nInvalid Entry. Try again.");
		}
		//starttime=System.nanoTime();
		if(firstmove==userturn) {
			if(flag==1) {
				boardoprs.displayBoard(board);
				flag=0;
			}
						
			row=boardoprs.acceptRow(board);
			col=boardoprs.acceptColumn(board);
			
			row-=1; 
			col-=1;
			
			legal=boardoprs.isLegalMove(board, row, col);
		
			if(legal) {
				boardoprs.userMove(board,row,col,x);
				win=boardoprs.checkMove(board, x);
				System.out.println("--*Your Move*--");
				boardoprs.displayBoard(board);
				if(boardoprs.isBoardFull(board) && win == false && boardoprs.checkSystemWin(board, o) == false ) {
					System.out.println("Match Draw..!!");
					ack=true;
					boardoprs.score(userctr, systemctr, starttime);
					continue;
				}
					
				else{
					if(win) {
						System.out.println("Congratz....You Won!");
						ack=true;
						userctr++;
						boardoprs.score(userctr, systemctr, starttime);
						continue;
					}
					
				}
			}
			else {
				boardoprs.displayBoard(board);
				System.out.println("Entry already available");
				continue;
			}
			System.out.println("--*Computer's Move*--");
			win=boardoprs.ifSystemWining(board, o);
			if(boardoprs.isBoardFull(board) && boardoprs.checkMove(board, x) == false && boardoprs.checkSystemWin(board, o) == false ) {
				System.out.println("Match Draw..!!");
				ack=true;
				boardoprs.score(userctr, systemctr, starttime);
				continue;
			}
			
			else {
				if(win) {
					boardoprs.displayBoard(board);
					System.out.println("Computer Won...LOL :D!");
					ack=true;
					systemctr++;
					boardoprs.score(userctr, systemctr, starttime);
					continue;
				}
			}
			boardoprs.systemMove(board,x,o);
			win=boardoprs.checkSystemWin(board, o);
			boardoprs.displayBoard(board);
			
			if(boardoprs.isBoardFull(board) && boardoprs.checkMove(board, x) == false && boardoprs.checkSystemWin(board, o) == false ) {
				System.out.println("Match Draw..!!");
				ack=true;
				boardoprs.score(userctr, systemctr, starttime);
				continue;
			}
			
			else {
				if(win) {
					System.out.println("Computer Won...LOL :D!");
					ack=true;
					systemctr++;
					boardoprs.score(userctr, systemctr, starttime);
					continue;
				}
			}
				
		}
	
		//system plays first
		else {
			System.out.println("--*Computer's move*--");
			win=boardoprs.ifSystemWining(board, o);
			if(boardoprs.isBoardFull(board) && boardoprs.checkMove(board, x) == false && boardoprs.checkSystemWin(board, o) == false ) {
				boardoprs.displayBoard(board);
				System.out.println("Match Draw..!!");
				ack=true;
				boardoprs.score(userctr, systemctr, starttime);
				continue;
			}
			
			else {
				if(win) {
					boardoprs.displayBoard(board);
					System.out.println("Computer Won...LOL :D!");
					ack=true;
					systemctr++;
					boardoprs.score(userctr, systemctr, starttime);
					continue;
				}
			}
			boardoprs.systemMove(board,x,o);
			boardoprs.displayBoard(board);
			win=boardoprs.checkSystemWin(board, o);
			
			if(boardoprs.isBoardFull(board) && boardoprs.checkMove(board, x) == false && boardoprs.checkSystemWin(board, o) == false ) {
				System.out.println("Match Draw..!!");
				ack=true;
				boardoprs.score(userctr, systemctr, starttime);
				continue;
			}
			else { 
				if(win) {
					System.out.println("Computer Won...LOL :D!");
					ack=true;
					systemctr++;
					boardoprs.score(userctr, systemctr, starttime);
					continue;
				}
			}
			legal=false;
			while(legal==false) {
				row=boardoprs.acceptRow(board);
				col=boardoprs.acceptColumn(board);
				row-=1; 
				col-=1;
				
				legal=boardoprs.isLegalMove(board, row, col);
	
				if(legal) {
					boardoprs.userMove(board,row,col,x);
					win=boardoprs.checkMove(board, x);
					System.out.println("--*Your Move*--");
					boardoprs.displayBoard(board);
					if(boardoprs.isBoardFull(board) && boardoprs.checkMove(board, x) == false && boardoprs.checkSystemWin(board, o) == false ) {
						System.out.println("Match Draw..!!");
						ack=true;
						boardoprs.score(userctr, systemctr, starttime);
						continue;
					}
					
					else { 
						if(win) {
							System.out.println("Congratz....You Won!");
							ack=true;
							userctr++;
							boardoprs.score(userctr, systemctr, starttime);
							continue;
						}
					}
				}
				else {
					boardoprs.displayBoard(board);
					System.out.println("Entry already available");
				}
			}
		} //end of system's first move
	
	}
	/*Runtime runtime=Runtime.getRuntime();
	System.out.println("Free memory in JVM before Garbage Colletion:"+runtime.freeMemory());
	runtime.gc();
	System.out.println("Free memory in JVM after Garbage Colletion:"+runtime.freeMemory());
*/
}

}					