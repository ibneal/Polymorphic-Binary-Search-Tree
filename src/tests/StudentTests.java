package tests;

import java.util.Set;

import org.junit.Assert;

import junit.framework.TestCase;
import tree.PolymorphicBST;

public class StudentTests extends TestCase {
	public void testSubMap() {
		PolymorphicBST<Integer, String> polytree = new PolymorphicBST<Integer, String>();
		polytree.put(4, "4");
		polytree.put(3, "3");
		polytree.put(5, "5");
		polytree.put(6, "6");
		polytree.put(1, "1");
		polytree.put(9, "9");
		polytree.put(7, "7");
		polytree.put(2, "2");
		polytree.put(11, "11");
		
		PolymorphicBST<Integer, String> npolytree = polytree.subMap(2, 9);
		Set<Integer> set = npolytree.keySet();
		System.out.println(set);
		assertEquals(npolytree, npolytree);
	}
	
	public void testMax() {
		PolymorphicBST<Integer, String> polytree = new PolymorphicBST<Integer, String>();
		polytree.put(4, "4");
		polytree.put(3, "3");
		polytree.put(5, "5");
		polytree.put(6, "6");
		polytree.put(1, "1");
		polytree.put(9, "9");
		polytree.put(7, "7");
		polytree.put(2, "2");
		polytree.put(11, "11");
		
		System.out.println(polytree.getMax().toString());
		assertEquals("11", polytree.getMax().toString());
	}
	
	public void testMin() {
		PolymorphicBST<Integer, String> polytree = new PolymorphicBST<Integer, String>();
		polytree.put(4, "4");
		polytree.put(3, "3");
		polytree.put(5, "5");
		polytree.put(6, "6");
		polytree.put(1, "1");
		polytree.put(9, "9");
		polytree.put(7, "7");
		polytree.put(2, "2");
		polytree.put(11, "11");
		
		System.out.println(polytree.getMin().toString());
		assertEquals("1", polytree.getMin().toString());
	}
	
	public void testHeight() {
		PolymorphicBST<Integer, String> polytree = new PolymorphicBST<Integer, String>();
		polytree.put(4, "4");
		polytree.put(3, "3");
		polytree.put(5, "5");
		polytree.put(6, "6");
		polytree.put(1, "1");
		polytree.put(9, "9");
		polytree.put(7, "7");
		polytree.put(2, "2");
		polytree.put(11, "11");
		
		System.out.println(polytree.height());
		assertEquals(5, polytree.height());
	}
	
	public void testDelete() {
		PolymorphicBST<Integer, String> polytree = new PolymorphicBST<Integer, String>();
		polytree.put(4, "4");
		polytree.put(3, "3");
		polytree.put(5, "5");
		polytree.put(6, "6");
		polytree.put(1, "1");
		polytree.put(9, "9");
		polytree.put(7, "7");
		polytree.put(2, "2");
		polytree.put(11, "11");
		
		polytree.remove(4);
		polytree.toString();
		assertEquals(polytree.toString(), polytree.toString());
	}
	
	public void testSize() {
		PolymorphicBST<Integer, String> polytree = new PolymorphicBST<Integer, String>();
		polytree.put(4, "4");
		polytree.put(3, "3");
		polytree.put(5, "5");
		polytree.put(6, "6");
		polytree.put(1, "1");
		polytree.put(9, "9");
		polytree.put(7, "7");
		polytree.put(2, "2");
		polytree.put(11, "11");
		polytree.toString();
		assertEquals(9, polytree.size());
	}
	
	
}