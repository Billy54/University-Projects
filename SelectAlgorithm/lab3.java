#Vasileios Georgoulas , lab3analush

package lab3analush;

import java.util.ArrayList;

class Select {
	
	private static ArrayList<Integer> s1 = new ArrayList<Integer>();
	private static ArrayList<Integer> s2 = new ArrayList<Integer>();
	private static int pivot;
	private static int t = 0;
	
	public static int select(ArrayList<Integer> s,int k){
		devide(s);
		if(s1.size()==k-1)
			return pivot;
		if(s1.size()>k-1)
			return select(s1,k);
		else
	    	return select(s2,k-1-s1.size());
	}
	private static void devide(ArrayList<Integer> s){
		if(s.isEmpty())return;
		pivot = s.get(0);
		ArrayList<Integer> c = (ArrayList<Integer>) s.clone();
		s1.clear();s2.clear();
		for(int i = 1; i<c.size();i++){
			if(c.get(i)<pivot)
				s1.add(c.get(i));
			else
				s2.add(c.get(i));
		}
	}
	private static void nearest(ArrayList<Integer> s,int k){
		int x = select(s,t);
		for(int i = 0;i<k;i++){
			int min = 0;
			int dist = Integer.MAX_VALUE;
			for(int j = 0;j<s.size();j++){
				if(Math.abs(s.get(j)-x)<dist && Math.abs(s.get(j)-x)!=0){
					dist = Math.abs(s.get(j)-x);
					min = j;
				}
			}
			System.out.println(s.get(min));
			s.set(min,Integer.MAX_VALUE);
		}
	}
	public static void main(String[] args){
		int[] s = {12,2,8,10,7,1,3,5,9};
		t = Math.floorDiv((s.length+1),2);
		ArrayList<Integer> s3 = new ArrayList<Integer>();
		for(int i = 0;i<s.length;i++) 
			s3.add(s[i]);
		System.out.println(select(s3,t)+"\n");
		nearest(s3,2);
	}
}