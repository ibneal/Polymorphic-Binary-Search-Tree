package tree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 *  
 */
 public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {

	 private K rootKey;
	 private V rootVal;
	 private Tree<K,V> leftTree;
	 private Tree<K,V> rightTree;
	/* Provide whatever instance variables you need */

	/**
	 * Only constructor we need.
	 * @param key
	 * @param value
	 * @param left
	 * @param right
	 */
	public NonEmptyTree(K key, V value, Tree<K,V> left, Tree<K,V> right) {
		rootKey = key;
		rootVal = value;
		leftTree = left;
		rightTree = right;
	}

	public V search(K key) {
		Integer compareval = key.compareTo(rootKey);
		if (compareval == 0) {
			return rootVal;
		}
		
		else if (compareval < 0) {
			return leftTree.search(key);
		}
		
		else if (compareval > 0) {
			return rightTree.search(key);
		}
		return rootVal;
	}
	
	public NonEmptyTree<K, V> insert(K key, V value) {
		Integer compareval = key.compareTo(rootKey);
		if (compareval == 0) {
		rootVal = value;
		}
		else if (compareval < 0) {
			leftTree = leftTree.insert(key, value);
		}
		else {
			rightTree = rightTree.insert(key, value);
		}
		return this;
	}
	
	public Tree<K, V> delete(K key) {
		Integer compareval = key.compareTo(rootKey);
		if (compareval == 0) {
			try {
				this.rootKey = leftTree.max();
				this.rootVal = leftTree.search(this.rootKey);
				leftTree = leftTree.delete(leftTree.max());
			} catch (TreeIsEmptyException e) {
				try {
					this.rootKey = rightTree.min();
					this.rootVal = rightTree.search(this.rootKey);
					rightTree = rightTree.delete(rightTree.min());}
				catch (TreeIsEmptyException g) {
					return EmptyTree.getInstance();
				}
			}
		}
		if (compareval < 0 ) {
			leftTree = leftTree.delete(key);
		}
		else if (compareval > 0) {
			rightTree = rightTree.delete(key);
		}
		return this;
	}

	public K max() {
		try {
			return rightTree.max();
		}
		catch (TreeIsEmptyException e) {
			return rootKey;
		}
	}

	public K min() {
		try {
			return leftTree.min();
		}
		catch (TreeIsEmptyException e) {
			return rootKey;
		}
	}

	public int size() {
		return 1 + leftTree.size() + rightTree.size();
	}

	public void addKeysToCollection(Collection<K> c) {
		c.add(rootKey);
		leftTree.addKeysToCollection(c);
		rightTree.addKeysToCollection(c);
	}
	
	public Tree<K,V> subTree(K fromKey, K toKey) {
		int fKI = this.rootKey.compareTo(fromKey);
		int tKI = toKey.compareTo(this.rootKey);
		if (fKI < 0) {
			return rightTree.subTree(fromKey, toKey);
		}
		else if (tKI < 0) {
			return leftTree.subTree(fromKey, toKey);
		}
		else {
			return new NonEmptyTree<K, V>(rootKey, rootVal, leftTree.subTree(fromKey, toKey), rightTree.subTree(fromKey, toKey));
		}
	}
	
	public int height() {
		int lefttree = 1 + leftTree.height();
		int righttree = 1 + rightTree.height();
		return Math.max(lefttree, righttree);
	}
	
	public void inorderTraversal(TraversalTask<K,V> p) {
		leftTree.inorderTraversal(p);
		p.performTask(rootKey, rootVal);
		rightTree.inorderTraversal(p);
	}
	
	public void rightRootLeftTraversal(TraversalTask<K,V> p) {
		rightTree.rightRootLeftTraversal(p);
		p.performTask(rootKey, rootVal);
		leftTree.rightRootLeftTraversal(p);
	}	
}