
	
	class Grid {
		
		private int[][] grid;
		private int[]width;
		private int y;
		private int z;

		
		public Grid(){
			grid = new int[13][12];
			width = new int[6];
		}
		public Grid(int width,int height){
			grid = new int[width+6][height+6];
			this.width = new int[height];
		}
		public void printGrid(){
			for(int i = 0; i<7; i++){
				for(int j = 0; j<6; j++){
					System.out.print(grid[i+3][j+3]);
					System.out.print("	");
				}
				System.out.println();
				System.out.println();
			}
		}
		public boolean isValidMove(int a){
	    	if(width[a] == 7){
	    		return false;
	    	}
	    	return true;
	    }
	    public void addPiece(int a , int b){
	    	this.grid[9-width[a]][a+3] = b;
	    	width[a]++;
	    }
	    public boolean isWinningpiece(int a){
	    	
	    	boolean t = true;
	    	int x = grid[10-width[a]][a+3];
	    	if(width[a]>=4){
	    		for(int i = 10-width[a]; i<14-width[a]; i++){     //column check using array 7x6
	    			if(grid[i][a+3]!=x){
	    				t=false;
	    				break;
	    			}
	    		}
	    		if(t==true){return t;}
	    	}   
	    	t = true;                        
	    	if(a>=3){
	    		 y=a;
	    		 z=6-a;
	    		if(z>4){z=4;}
	    	}
	    	else{
	    		y = 3;
	    		z = a+1;
	    	}
	    	for(int i = 0; i<z; i++){							//row check using array 7x6
	    		for(int j = y+i; j<i+4+y; j++){
	    			if(grid[10-width[a]][j]!=x){
	    				t=false;
	    				break;
	    			}
	    		}
	    		if(t){return true;}
	    		t=true;
	    	}
	    	
	    	for(int i=0; i<4; i++){
	    		t=true;
	    		for(int k = a+i,l = 7-width[a]+i; k<a+i+4 && l<11-width[a]+i; k++,l++ ){
	    			if(grid[l][k]!=x){t=false;break;}
	    		}																		//Diagonal check using array 13x12
	    		if(t){return true;}
	    		t=true;
	    		for(int k = a+6-i,l=7-width[a]+i; k>a+2-i && l<11-width[a]+i; k--,l++ ){
	    			if(grid[l][k]!=x){t=false;break;}
	    		}
	    		if(t){return t;}
	    	}
	    	return false;
	    }
	    public boolean checkposition(int a , int colour){
	    	grid[9-width[a]][a+3]=colour;
	    	width[a]++;
	    	boolean t=isWinningpiece(a);
	    	grid[10-width[a]][a+3]=0;
	    	width[a]--;
	    	return t;
	    }
	    public boolean isFull(){
	    	for(int i = 0; i<6; i++){
	    		if(width[i]<7){return false;}
	    	}
	    	return true;
	    }
	}


