package Ex1Testing;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Polynom;
import Ex1.function;

class ComplexFunctionTest {

	@Test
	void testComplexFunction() {
		Polynom p1 = new Polynom("5x");
		Polynom p2 = new Polynom("10x");
		String s="Divid";
		ComplexFunction t = new ComplexFunction("Divid", p1, p2);
		if (t.left()!=p1 || t.right()!=p2 || !(t.getOp().toString().equals(s))) {
			fail("Couldnt build complex function right");
		}
	}

	@Test
	void testF() {
		Polynom p1 = new Polynom("2x");
		Polynom p2 = new Polynom("5");
		Polynom p3 = new Polynom("2");
		String s="Times";
		ComplexFunction t1= new ComplexFunction(s, p1, p2);
		ComplexFunction t2= new ComplexFunction("divid", t1, p3);
		ComplexFunction t3= new ComplexFunction("plus", t1, p3);
		ComplexFunction t4= new ComplexFunction("min", t1, p3);
		ComplexFunction t5= new ComplexFunction("max", t1, p3);
		ComplexFunction t6= new ComplexFunction("comp", t1, p3);

		if (t1.f(1)!=10)  {fail();} //System.out.println(t1.f(1));
		if (t2.f(2)!=10)  {fail();} //System.out.println(t2.f(2));
		if (t3.f(1)!=12)  {fail();} //System.out.println(t3.f(1));
		if (t4.f(0.5)!=2) {fail();} //System.out.println(t4.f(0.5));
		if (t5.f(-1)!=2)  {fail();} //System.out.println(t5.f(-1));
		if (t6.f(10)!=20) {fail();} //System.out.println(t6.f(10));
	}

	@Test
	void testToString() {
		String s1 = "2x";
		String s2 = "-6x";
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		ComplexFunction c1 = new ComplexFunction("Plus", p1, p2);
		ComplexFunction c2 = new ComplexFunction("Plus", p2, p1);
		ComplexFunction c3 = new ComplexFunction("Max", c2, c1);
		c2 = new ComplexFunction("Plus", c3, p1);
		c1 = new ComplexFunction("Plus", c3, c2);
		//System.out.println(c1.toString());
		String expected = "plus(max(plus(-6.0x,2.0x),plus(2.0x,-6.0x)),plus(max(plus(-6.0x,2.0x),plus(2.0x,-6.0x)),2.0x))";
		if (!(c1.toString().equals(expected))) { fail("Bye bye"); }
	}

	@Test
	void testInitFromString() {
		String s1 = "0";
		Polynom p1 = new Polynom(s1);
		function x = new ComplexFunction(p1);
		String expected = "plus(max(plus(-6.0x,2.0x),plus(2.0x,-6.0x)),plus(max(plus(-6.0x,2.0x),plus(2.0x,-6.0x)),2.0x))";
		try {
			x = x.initFromString(expected);
		}catch (Exception e) { fail(); }


	}

	@Test
	void testCopy() {
		function a = new Polynom("2x");
		function b = new Polynom("x^2");
		ComplexFunction t1 = new ComplexFunction("Comp", a, b);
		ComplexFunction t2 = (ComplexFunction)t1.copy();
		if (!(t1.f(2)==t2.f(2))) {fail();} //check if copied.
		t1.plus(a);
		//	System.out.println(t1.f(2));
		//	System.out.println(t2.f(2));
		if (t1.f(2)==t2.f(2)) {fail();} //check deep copy after adding to the original func.

	}

	@Test
	void testEqualsObject() {
		function a = new Polynom("2x");
		function b = new Polynom("x^2");
		ComplexFunction t1 = new ComplexFunction("Plus", a, b);
		ComplexFunction t2 = new ComplexFunction("Plus", a, b);
		if (!(t1.equals(t2))) { fail();}

		t2 = new ComplexFunction("Plus", b, a);
		if (!(t1.equals(t2))) { fail();}

		function c = new Polynom("x^2+2x");
		function d = new Polynom("0");
		t2 = new ComplexFunction("Plus", c, d);
		if (!(t1.equals(t2))) { fail();}
	}

	@Test
	void testPlus() {
		function a = new Polynom("2x");
		function b = new Polynom("x^2");
		ComplexFunction t1 = new ComplexFunction("Plus", a, b);
		if ((t1.f(3))!=15) { fail();}
	}

	@Test
	void testMul() {
		function a = new Polynom("2x");
		function b = new Polynom("x^2");
		ComplexFunction t1 = new ComplexFunction("Times", a, b);
		if ((t1.f(3))!=54) { fail();}
	}

	@Test
	void testDiv() {
		function a = new Polynom("2x^3");
		function b = new Polynom("x^2");
		ComplexFunction t1 = new ComplexFunction("Divid", a, b);
		if ((t1.f(7))!=14) { fail();}
		b = new Polynom("0");
		t1 = new ComplexFunction("Divid", a, b);
		try {
			t1.f(4);
			fail();
		}
		catch (Exception e) {;}
	}

	@Test
	void testMax() {
		function a = new Polynom("2x");
		function b = new Polynom("x^2");
		ComplexFunction t1 = new ComplexFunction("max", a, b);
		if ((t1.f(-1))!=1) { fail();}
	}

	@Test
	void testMin() {
		function a = new Polynom("2x");
		function b = new Polynom("x^2");
		ComplexFunction t1 = new ComplexFunction("min", a, b);
		if ((t1.f(-1))!=-2) { fail();}
	}

	@Test
	void testComp() {
		function a = new Polynom("2x");
		function b = new Polynom("x^2");
		ComplexFunction t1 = new ComplexFunction("Comp", a, b);
		if (t1.f(3)!=18) { fail();}
	}

}
