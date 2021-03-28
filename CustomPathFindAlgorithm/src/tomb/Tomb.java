
//Vasileios Georgoulas
package tomb;

import java.util.LinkedList;
import java.util.Queue;

public class Tomb {
	
	private static int counter = 1;
	
	public static void Tomb(){
		int [] visited = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		Integer [][] map = {{1,0,0,0,0,0},{1,1,0,0,0,1},{1,1,0,0,0,2},{0,1,0,1,0,3},{1,0,0,0,0,4},{1,1,0,1,0,5},{0,1,0,1,0,6},
			                {0,0,0,0,1,0},{1,0,0,1,1,1},{0,1,0,1,1,2},{1,0,1,1,1,3},{1,1,0,1,1,4},{0,1,1,0,1,5},{0,0,1,0,1,6},
			                {1,0,0,1,2,0},{0,1,1,0,2,1},{1,0,1,0,2,2},{0,1,1,0,2,3},{0,0,1,1,2,4},{1,0,0,0,2,5},{0,1,0,1,2,6},
			                {0,0,1,0,3,0},{0,0,0,1,3,1},{1,0,0,1,3,2},{1,1,0,1,3,3},{1,1,1,1,3,4},{0,1,0,1,3,5},{0,0,1,1,3,6},
			                {1,0,0,1,4,0},{0,1,1,0,4,1},{0,0,1,1,4,2},{0,0,1,1,4,3},{0,0,1,0,4,4},{1,0,1,1,4,5},{0,1,1,1,4,6},
			                {0,0,1,0,5,0},{1,0,0,0,5,1},{0,1,1,0,5,2},{1,0,1,0,5,3},{1,1,0,0,5,4},{0,1,1,0,5,5},{0,0,1,0,5,6}};
		
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		visited[0] = 1;
		queue.add(map[0]);
		while(!queue.isEmpty()){
			Integer cell[] = queue.remove();
			for(int i = 0; i<4;i++){
				if(cell[i]==1){
					if(i==0){
						int x = cell[4];int y = cell[5]+1;
						int t = 7*x + y;
						if(visited[t]==0){ //alagh dikton
							counter++;
							visited[t]=1;
							queue.add(map[t]);
						}
					}
					if(i==1){
						int x = cell[4];int y = cell[5]-1;
						int t = 7*x + y;
						if(visited[t]==0){
							counter++;
							visited[t]=1;
							queue.add(map[t]);
						}
					}
					if(i==2){
						int x = cell[4]-1;int y = cell[5];
						int t = 7*x + y;
						if(visited[t]==0){
							counter++;
							visited[t]=1;
							queue.add(map[t]);
						}
					}
					if(i==3){
						int x = cell[4]+1;int y = cell[5];
						int t = 7*x + y;
						if(visited[t]==0){
							counter++;
							visited[t]=1;
							queue.add(map[t]);
						}
					}
				}
			}
		}
	}
	public static void main(String[] args){
		Tomb();
		System.out.println(counter);
	}
}