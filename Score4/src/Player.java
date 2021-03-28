
import java.util.Scanner;
class Player {
	
	Scanner input=new Scanner(System.in);
	
	private int colour;
	private String type = "humanPlayer"; 
	private int a;
	
	public Player(int colour){
		this.colour=colour;
	}
	public Player(int colour,String player){
		this.colour=colour;
		this.type=player;
	}
	private void humanPlay(Grid grid){
		while(true){
			while(true){
				System.out.println("give position between 0 - 5 ");
				this.a=input.nextInt();
				if(0<=a && a<6){break;}
			}
			if(grid.isValidMove(a)){break;}
		}
		grid.addPiece(a, colour);
	}
	private void computerPlay(Grid grid){
		for(int i = 0; i<6; i++){
			if(grid.isValidMove(i)){
				if(grid.checkposition(i, 2)){
					this.a=i;
					grid.addPiece(this.a,this.colour);
					return;
				}	
			}	
		}
		for(int i = 0; i<6; i++){
			if(grid.isValidMove(i)){
				if(grid.checkposition(i, 1)){
					this.a=i;
					grid.addPiece(a, 2);
					return;
				}
			}
		}
		while(true){
			int p = (int)(Math.random() * 6);
			this.a=p;
			if(grid.isValidMove(a)){
				grid.addPiece(this.a,this.colour);return;
			}
		}	
	}
	public void play(Grid grid){
		if(colour==1){
			humanPlay(grid);
		}
		else if(type.equals("human")){
			humanPlay(grid);
		}
		else{
			computerPlay(grid);}
	}
	public int getcolour(){
		return colour;
	}
	public int getposition(){
		return a;
	}
	

}
