package com.datastructures.lab.solution.question2;

import java.util.ArrayList;

public class LongestPathBinaryTreeApplicaton {

	private static class Node {
		public Node left, right;
		public int key;
	}

	private static Node newNode(int data) {
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	private static Node insertNode(Node root, int key) {
		Node newNode = newNode(key);
		Node x = root;
		Node y = null;
		while (x != null) {
			y = x;// Storing the root
			if (key < x.key)
				x = x.left;
			else if (key > x.key)
				x = x.right;
			else {
				System.out.println("Value already exists!");
				return newNode;
			}
		}
		if (y == null) {
			y = newNode;
		} else if (key < y.key)
			y.left = newNode;
		else
			y.right = newNode;
		return y;
	}

	public static ArrayList<Integer> findLongestPath(Node root) {
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

		ArrayList<Integer> rightList = findLongestPath(root.right);

		ArrayList<Integer> leftList = findLongestPath(root.left);

		if (rightList.size() < leftList.size()) {
			leftList.add(root.key);
		} else {
			rightList.add(root.key);
		}

		return (leftList.size() > rightList.size() ? leftList : rightList);
	}

	public static void main(String[] args) {
		int[] inputArray = { 100, 20, 130, 10, 50, 110, 140, 5 };
		Node root = null;
		Node result = null;
		for (int i = 0; i < inputArray.length; i++) {
			if (root == null) {
				root = insertNode(root, inputArray[i]);
			} else {
				result = insertNode(root, inputArray[i]);
				if (result.key == inputArray[i])
					i -= 1;
			}
		}

		ArrayList<Integer> output = findLongestPath(root);
		int n = output.size();

		System.out.print(output.get(n - 1));
		for (int i = n - 2; i >= 0; i--) {
			System.out.print(" -> " + output.get(i));
		}

	}
}
