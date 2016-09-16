import java.util.Random;

public class randomized_selection {
	int[] S = {5,2,10,8,25,54,29,35,6};
	void print(){
		for(int i=0;i<S.length;i++){
			System.out.println(S[i]);
		}
	}
	void random_element(int f, int r){
		int random_index = new Random().nextInt(r-f)+f;
		int a = S[random_index];
		S[random_index]=S[r];
		S[r]=a;
		//System.out.println(S[r]);
		//System.out.println("----------------------------------------------------");
	}
	int partition(int f,int r){
		random_element(f,r);
		int x = S[r];
		int i = f;
		int j = r;
		while(true){
			while(S[j]>x)
				j=j-1;
			while(S[i]<x)
				i=i+1;
			if(i<j){
				int temp = S[j];
				S[j]=S[i];
				S[i]=temp;
			}
			else
				return j;
			}
	}
	int select(int p,int r,int i){
		if(p==r)
			return S[p];
		int q = partition(p,r);
		int k = q-p+1;
		if(k==i)
			return S[q];
		else if(i<k)
			return select(p,q-1,i);
		else
			return select(q+1,r,i-k);
	}
	void select(int v){
		System.out.println(select(0,8,v));
	}
	public static void main(String args[]){
		randomized_selection a = new randomized_selection();
		a.select(9);
	}
}
