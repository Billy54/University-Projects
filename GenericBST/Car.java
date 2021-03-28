//Vasileios Gewrgoulas
//A.M. 2954


class Car implements myComparable  {

	private int CC;
	private String symbol;
	
	public Car(int c , String s){
		CC=c;symbol=s;
	}
	public int compareTo(myComparable other){
		Car O= (Car)other;
		if(CC>O.CC){
			return 1;
		}
		else if(CC<O.CC){
			return -1;
		}
		return 0;
	}
	public String toString(){
		return "symbol: "+symbol +",CC: "+CC;
	}
}
