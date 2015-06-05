package org.fahai.pattern.composite;

import org.fahai.common.LogInterface;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class Tree implements LogInterface{

	TreeNode root;
	
	public Tree(String name){
		root = new TreeNode(name);
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		
		nodeB.add(nodeC);
		tree.root.add(nodeB);
		log.info("The tree is builded.");
	}

}
