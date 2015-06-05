package org.fahai.pattern.composite;

import java.util.Enumeration;
import java.util.Vector;

import org.fahai.common.LogInterface;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class TreeNode implements LogInterface {

	private String name;
	private TreeNode parent;
	private Vector<TreeNode> children = new Vector<TreeNode>();
	
	public TreeNode(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public void add(TreeNode node){
		children.add(node);
	}
	
	public void remove(TreeNode node){
		children.remove(node);
	}
	
	public Enumeration<TreeNode> getChildren(){
		return children.elements();
	}
	
}
