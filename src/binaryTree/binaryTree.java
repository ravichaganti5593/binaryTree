package binaryTree;

public class binaryTree {
	static Node current;
	static Node root;
	
	static int numberOfLeafNodes = 0;
	static int numberOfOneChildNodes = 0;
	static int numberOfTwoChildNodes = 0;
	
	public void addNode(int data) {
		Node node = new Node(data);
		
		if (root == null) {
			root = node;
			root.leftNode = null;
			root.rightNode = null;		
		}
		
		else {
			current = root;
			
			while (1>0) {
				if (data < current.data) {
					if (current.leftNode == null) {
						current.leftNode = node;
						current.leftNode.leftNode = null;
						current.leftNode.rightNode = null;
						break;
					}
					else {
						current = current.leftNode;
					}
					
				}
				else {
					if (current.rightNode == null) {
						current.rightNode = node;
						current.rightNode.leftNode = null;
						current.rightNode.rightNode = null;
						break;
					}
					else {
						current = current.rightNode;
					}
				}
			}
		}
	}
	
	
	public void delete(int data) {
		current = root;
		while (1>0) {
			if (data < current.data) {
				current = current.leftNode;
			}
			else if (data > current.data) {
				current = current.rightNode;
			}
			else if (data == current.data) {
				deleteNode(current);
				break;
			}
		}
	}
	
	
	private void deleteNode(Node deleteNode) {
		if (deleteNode.leftNode == null && deleteNode.rightNode == null) {
			current = root;
			
			while (1>0) {
				if (current.rightNode.data == deleteNode.data) {
					current.rightNode = null;
					break;
				}
				else if (current.leftNode.data == deleteNode.data) {
					current.leftNode = null;
					break;
				}
				else if(current.data > deleteNode.data) {
					current = current.leftNode;
				}
				else if(current.data < deleteNode.data) {
					current = current.rightNode;
				}
			}
		}
		else if (deleteNode.leftNode != null && deleteNode.rightNode == null) {
			int temp;
			
			temp = deleteNode.data;
			deleteNode.data = deleteNode.rightNode.data;
			deleteNode.rightNode.data = temp;
			
			deleteNode(deleteNode.rightNode);
			
		}
		else if(deleteNode.leftNode == null && deleteNode.rightNode != null) {
			int temp;
			
			temp = deleteNode.data;
			deleteNode.data = deleteNode.leftNode.data;
			deleteNode.leftNode.data = temp;
			
			deleteNode(deleteNode.leftNode);
		}
		else if(deleteNode.leftNode != null && deleteNode.rightNode != null) {
			int temp;
			
			temp = deleteNode.data;
			deleteNode.data = deleteNode.leftNode.data;
			deleteNode.leftNode.data = temp;
			
			deleteNode(deleteNode.leftNode);
		}
		
	}


	public void print() {
		preOrder(root);
		System.out.println();
		inOrder(root);
	}
	
	public void inOrder(Node temp) {
		if (temp != null) {
			preOrder(temp.leftNode);
			System.out.println(temp.data + " ");
			preOrder(temp.rightNode);	
		}
	}
	
	
	public void preOrder(Node temp) {
		if (temp != null) {
			System.out.println(temp.data + " ");
			preOrder(temp.leftNode);
			preOrder(temp.rightNode);	
		}
	}
	
	public void leafNodes(Node temp) {
		if (temp != null) {
			if (temp.leftNode == null && temp.rightNode == null) {
				numberOfLeafNodes++;
			}
			
			leafNodes(temp.leftNode);
			leafNodes(temp.rightNode);
		}
	}
	
	public void oneChild(Node temp) {
		if (temp != null) {
			if (temp.leftNode != null && temp.rightNode == null) {
				numberOfOneChildNodes++;
			}
			else if (temp.leftNode != null && temp.rightNode == null) {
				numberOfOneChildNodes++;
			}
			
			oneChild(temp.leftNode);
			oneChild(temp.rightNode);
		}
	}
	
	public void twoChildren(Node temp) {
		if (temp != null) {
			if (temp.leftNode != null && temp.rightNode != null) {
				numberOfTwoChildNodes++;
			}
			twoChildren(temp.leftNode);
			twoChildren(temp.rightNode);
		}
		
	}
	
	
	public static void main(String[] args) {
		binaryTree tree = new binaryTree();
		tree.addNode(6);
		tree.addNode(4);
		tree.addNode(10);
		tree.addNode(2);
		tree.addNode(5);
		tree.addNode(7);
		tree.addNode(11);
		tree.addNode(1);
		tree.addNode(3);
		tree.addNode(9);
		tree.print();
	}
}
