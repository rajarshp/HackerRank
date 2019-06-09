package com.sample.hackerrank.sorting;

public class BinarySearchTree {

	Node root;
	Node head;
	Node prev;

	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return data + " ";
		}

	}

	public Node extractLeafNode(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			if (head == null) {
				head = root;
				prev = root;
			} else {
				prev.right = root;
				root.left = prev;
				prev = root;
			}
			return null;
		}
		root.left = extractLeafNode(root.left);
		root.right = extractLeafNode(root.right);

		return root;
	}

	public void insertNode(int data) {

		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
//			System.out.println("Root created " + root);
		} else {
			Node start = root;
			Node parent;

			while (true) {
				parent = start;

				if (data < start.data) {
					start = start.left;

					if (start == null) {
						parent.left = newNode;
						return;
					}
				} else {
					start = start.right;

					if (start == null) {
						parent.right = newNode;
						return;
					}
				}
//				System.out.println("Node created " + parent);
			}
		}

	}

	public void printDLL(Node head) {
//		Node temp;
		while (head != null) {
			System.out.println(head.data + " ");
			head = head.right;
		}
	}

	public void printBST(Node root, int size) {

		if (root == null) {
			return;
		} else {
			size += 10;

			printBST(root.right, size);

			System.out.print("\n");

			for (int i = 10; i < size; i++) {
				System.out.print(" ");
			}
			System.out.print(root.data + "\n");

			printBST(root.left, size);
		}
	}

	public void inOderTraaverse(Node start) {

		if (start != null) {
			inOderTraaverse(start.left);

			System.out.println(start);

			inOderTraaverse(start.right);
		}
	}

	public void preOderTraaverse(Node start) {

		if (start != null) {

			System.out.println(start);

			preOderTraaverse(start.left);
			preOderTraaverse(start.right);
		}
	}

	public void findNode(int value) {

		Node start = root;

		while (start.data != value && start != null) {
			if (value < start.data) {
				start = start.left;
			} else {
				start = start.right;
			}
		}
		System.out.println(start);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 12, 5, 44, 8, 2, 78, 42 };

		BinarySearchTree bst = new BinarySearchTree();

		for (int a : arr) {
			bst.insertNode(a);
		}

//		bst.printBST(bst.root, arr.length);
//		System.out.println(bst.root);
//		bst.findNode(78);
//		System.out.println("In Oder:");
//		bst.inOderTraaverse(bst.root);
//		System.out.println("Pre Oder:");
//		bst.preOderTraaverse(bst.root);

		bst.extractLeafNode(bst.root);
		bst.printDLL(bst.head);
	}

}
