package binaryTree;

public class Node {
	static int numberOfNodes = 0;
	
	int data;
	Node leftNode;
	Node rightNode;
	
	Node(int data) {
		this.data = data;
		numberOfNodes++;
	}
}
