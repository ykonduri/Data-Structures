public class binary_search {
	int[] S = new int[30];
	int first,mid,last;
	binary_search(){
		S[0] = 1;
		S[1] = 2;
		S[2] = 4;
		S[3] = 7;
		S[4] = 10;
		S[5] = 23;
		first = 0;
		last = 5;
		//System.out.println(5/2);
	}
	void search(int number){
		search(number, first,last);
	}
	int search(int number,int first_usage, int last_usage){
		int mid = first_usage + ((last_usage-first_usage)/2);
		if(S[mid]==number){
			System.out.println("Element found");
			return 999;
		}
		else if(first_usage==last_usage){
			System.out.println("Element not found");
			//System.out.println(last);
			if(last_usage<(first+(last-first))/2){
				return mid+1;
			}
			else
				return mid;
		}
		else if(S[mid]>number){
			last_usage = mid-1;
			return search(number,first_usage,last_usage);
		}
		else {
			first_usage = mid+1;
			return search(number,first_usage,last_usage);
		}		
	}
	void add(int number){
		if(number>S[last]){
			System.out.println("Element not found");
			last = last+1;
			S[last] = number;
		}
		else{
			int exists = search(number,first,last);
			//System.out.println(exists);
			if(exists!=999){
				for(int i=last;i>=exists;i--){
					S[i+1]=S[i];
				}
				S[exists]=number;
				last = last+1;
			}
		}
	}
	void print(){
		for(int i=0;i<=last;i++){
			System.out.println(S[i]);
		}
	}
	
	public static void main(String args[]){
		binary_search array= new binary_search();
		//array.search(1);
		array.add(3);
		array.add(12);
		array.add(50);
		array.print();
	}
}
