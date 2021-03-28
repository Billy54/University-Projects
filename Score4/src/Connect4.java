

import java.util.Scanner;

class Connect4 {
	
	

		public static void main(String[] args){
			@SuppressWarnings("resource")
			Scanner input=new Scanner(System.in);
			Grid grid = new Grid();
			Player  player1 = new Player(1);
			System.out.println("player1 choose the type of opponet,type human for humanplayer or anything else for computerplayer");
			Player player2 = new Player(2,input.next());
			grid.printGrid();
			while(true){
				player1.play(grid);
				grid.printGrid();
				if(grid.isWinningpiece(player1.getposition()) || grid.isFull()){break;}
				player2.play(grid);
				System.out.println();
				grid.printGrid();
				if(grid.isWinningpiece( player2.getposition()) || grid.isFull()){break;}
			}
			if(grid.isWinningpiece(player1.getposition())){
				System.out.println("player1 win!");
			}
			else if(grid.isWinningpiece(player2.getposition())){
				System.out.println("player2 win!");
			}
			else{System.out.println("DRAW");}
		}
}
