package com;

import java.util.HashMap;
import java.util.Map;

public class OuterClassTest {

	private class Inner {
		
		private int a = 0;
		
		public Inner() {
			System.out.println("1111111111111");
		}
	}
	
	public static void main(String[] args) {
		/*OuterClassTest outerClass = new OuterClassTest();
		OuterClassTest.Inner inner = outerClass.new Inner();*/
		StringBuilder sb = new StringBuilder("1,2,");
		sb.append("3");
		sb.append(",4");
		System.out.println(sb.toString());
	}
}
