//Vasileios Gewrgoulas
//AM 2954 



import java.util.*;

class PriorityQueue {
	
	private int[] priorityqueue;
	private int capacity;
	private int t;
	
	public PriorityQueue(){
		capacity = 100;
		priorityqueue=new int[100];
	}
	public PriorityQueue(int capacity){
		this.capacity=capacity;
		priorityqueue=new int[capacity];
	}
	public boolean insert(int x){
		if(t==capacity){
			return false; 
		}
		else if(t==0){this.priorityqueue[0]=x;t++;}
		else if(x>priorityqueue[0]){
			priorityqueue[t]=priorityqueue[0];
			t++;
			priorityqueue[0]=x;
		}
		else{priorityqueue[t]=x;t++;}
		return true;
	}
	public int getMax(){
		if(t==0){return -1;}
		return priorityqueue[0];
	}
	public int extractMax(){
		if(t==0){return -1;}
		int max=0;
		int maxvalue=priorityqueue[0];
		for(int i=1; i<t; i++){
			priorityqueue[i-1]=priorityqueue[i];
			if(priorityqueue[i]>=priorityqueue[max]){max=i-1;}
		}
		t--;
		int x = priorityqueue[0];
		priorityqueue[0]=priorityqueue[max];
		priorityqueue[max]=x;		
		return maxvalue;
	}
	public boolean merge(PriorityQueue other){
		if(this.capacity-this.t>=other.t){
			if(this.priorityqueue[0]<other.priorityqueue[0]){
				int p = this.priorityqueue[0];
				this.priorityqueue[0]=other.priorityqueue[0];
				other.priorityqueue[0]=p;
			}
			for(int i = 0; i<other.t;i++){
				this.priorityqueue[t+i]=other.priorityqueue[i];
			}
			this.t+=other.t;other.t=0;
			return true;
		}
		return false;
	}
	public String toString(){
		String output="";
		for(int i =0; i<t; i++){			
			output+=this.priorityqueue[i]+",";
		}
		return "["+output+"]";
	}
	public boolean equals(PriorityQueue other){
		if(this.t==other.t && this.getMax()==other.getMax()){				
			int[] array1 = new int[t];
			int[] array2 = new int[t];
			for(int i = 0; i<t; i++){
				array1[i]=this.priorityqueue[i];
				array2[i]=other.priorityqueue[i];
			}
			Arrays.sort(array1);Arrays.sort(array2);
			return Arrays.equals(array1,array2);
		}
		return false;
	}
	

}
