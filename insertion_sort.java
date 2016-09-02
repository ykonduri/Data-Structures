public class insertion_sort {
	int[] S ={9,5,7,1,3,25,56,16,10};
	void sort(){
		for(int i=1;i<S.length;i++){
			int key = S[i];
			int j=i-1;
			//System.out.println(S[j]);
			while(j>=0&&S[j]>=key){
				S[j+1]=S[j];
				j=j-1;
			}
			S[j+1]=key;
			
		}
	}
	void print(){
		for(int i =0;i<S.length;i++){
			System.out.println(S[i]);
		}
	}
	public static void main(String args[]){
		insertion_sort a = new insertion_sort();
		//a.print();
		a.sort();
		a.print();
		
	}
}
