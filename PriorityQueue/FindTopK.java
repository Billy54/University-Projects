//Vasileios Gewrgoulas
//AM 2954 


class FindTopK {
	public static void main(String[] args){
		int[] values = {2, 5, 15, 34, 6, 12, 10, 23, 3, 5, 4, 15, 2};
		int K = 5;
		printTopK(values, K);
	}
	
	//incrementaly find the top k values using a priority queue of k length
	private static void printTopK(int[] values, int K){			
																	
		
		PriorityQueue queue = new PriorityQueue(K);
		int i=0;
		while(i<13){
			if(!queue.insert(values[i]) && queue.getMax() > values[i]){
				queue.extractMax();i--;}
			++i;
		}
		System.out.println(queue);
	}
}
