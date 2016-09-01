public class binary_search_tree {
	class bst_node {
		int key;
		int value;
		bst_node left;
		bst_node right;
		bst_node parent;
		public bst_node(int key1, int value1) {
			key = key1;
			value = value1;
		}	
	}
	bst_node root;	
	void add_node(int key1,int value1){
		if(root == null){
			root = new bst_node(key1,value1);
			root.parent = null;
		}
		else
			add_node(key1,value1,root,null,1);		
	}
	
	void add_node(int key1,int value1,bst_node curr_node,bst_node old_node,int direction){
		if(curr_node== null& direction == 1){
			bst_node new_node = new bst_node(key1,value1);
			old_node.right = new_node;
			new_node.parent = old_node;
		}
		else if(curr_node==null& direction ==0){
			bst_node new_node = new bst_node(key1,value1);
			old_node.left = new_node;
			new_node.parent = old_node;
		}
		else if(key1>curr_node.key){
			add_node(key1,value1,curr_node.right,curr_node,1);
			//System.out.println(curr_node.value);
		}
		else if(key1<curr_node.key)
			add_node(key1,value1,curr_node.left,curr_node,0);
		else
			System.out.println("Key already inserted");
	}
	void pre_order(){
		if(root == null)
			System.out.println("Tree is Empty");
		else
			pre_order(root);
			
	}
	void pre_order(bst_node node){
		if(node == null)
				return;
		System.out.println(node.value);
		pre_order(node.left);
		pre_order(node.right);
	}
	void post_order(){
		if(root == null)
			System.out.println("Tree is Empty");
		else
			post_order(root);
	}
	void post_order(bst_node node){
		if(node == null)
				return;		
		post_order(node.left);
		post_order(node.right);
		System.out.println(node.value);
	}
	void in_order(){
		if(root == null)
			System.out.println("Tree is Empty");
		else
			in_order(root);
	}
	void in_order(bst_node node){
		if(node == null)
				return;		
		in_order(node.left);
		System.out.println(node.value);
		in_order(node.right);		
	}
	void search(int key){
		bst_node node = search(key, root);
		if(node ==null)
			System.out.println("Not found");
		else		
			System.out.println(node.value);
	}
	bst_node search(int key,bst_node node){
		if(node==null)
			return null;
		if(node.key == key)
			return node;
		else if(node.key>key)
			return search(key,node.left);
		else if(node.key<key)
			return search(key,node.right);
		else
			return null;		
	}
	void predecessor(int key){
		bst_node pre = predecessor(key,root);
		if(pre==null)
			System.out.println("No Predecessor");
		else
			System.out.println(pre.value);
	}
	bst_node predecessor(int key,bst_node node){
		bst_node key_node = search(key,root);
		if(key_node == null)
			return null;
		else if(key_node.left !=null){
			bst_node t = key_node.left;
			while(t.right!=null)
				t=t.right;
			return t;
		}
		else if(key_node.parent.right == key_node)
			return key_node.parent;
		else if(key_node.parent.left == key_node){
			bst_node t = key_node.parent;
			while(t!=root ){
				if(t.parent.right != t)
					t = t.parent;
				else
					break;
			}
			return t.parent;
		}
		else 
			return null;			 
	}
	void delete(int value){
		bst_node deletable_node = search(value,root);		
		delete(deletable_node);
	}
	void delete(bst_node deletable_node){
		 if(deletable_node.left == null && deletable_node.right ==null){
			 if(deletable_node.parent.right == deletable_node)
				 deletable_node.parent.right = null;
			 else
				 deletable_node.parent.left = null;
		 }
		 else if(deletable_node.left == null && deletable_node.right !=null){
			 if(deletable_node.parent.right == deletable_node)
				 deletable_node.parent.right = deletable_node.right;
			 else
			 	 deletable_node.parent.left = deletable_node.right;
		 }
		 else if(deletable_node.left != null && deletable_node.right ==null){
			 if(deletable_node.parent.right == deletable_node)
				 deletable_node.parent.right = deletable_node.left;
			 else
			 	 deletable_node.parent.left = deletable_node.left;
		 }
		 else if(deletable_node.left != null && deletable_node.right !=null){
			 bst_node predecessor_node = predecessor(deletable_node.value,root);
			 deletable_node.value = predecessor_node.value;
			 deletable_node.key = predecessor_node.key;
			 delete(predecessor_node);		 
		 }		 
	}
	public static void main(String[] args) {
		binary_search_tree a = new binary_search_tree();
		/*a.add_node(5,5);
		a.add_node(2, 2);
		a.add_node(7, 7);
		a.add_node(4,4);
		a.add_node(1,1);
		a.add_node(6, 6);
		a.add_node(8,8);
		//a.pre_order();
		//a.post_order();
		//a.in_order();
		//a.search(2);
		a.predecessor(6);*/
		a.add_node(10,10);
		a.add_node(12,12);
		a.add_node(5,5);
		a.add_node(9,9);
		a.add_node(7,7);
		a.add_node(8,8);
		a.add_node(6,6);
		a.add_node(3,3);
		a.add_node(4,4);
		a.add_node(2,2);
		//a.predecessor(50);
		//a.delete(12);
		a.delete(9);
		a.in_order();
	}
}
