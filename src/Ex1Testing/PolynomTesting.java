package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.Monom;
import Ex1.Polynom;
import Ex1.Polynom_able;

class PolynomTesting {
	
	public static final double EPSILON = 0.0001;

	@Test
	void testToString() {
		Polynom p1 = new Polynom("x^2-5x+1");
		String s = p1.toString();
		Polynom p2 = new Polynom(s);
		if (!p1.equals(p2)) {
			fail("You are ****");
		}
	}

	@Test
	void testF() {
		Polynom p1 = new Polynom("4x^3-3x-2");
		double e = -1;
		if (Math.abs(p1.f(1)-e)>EPSILON) {
			fail("Arrrr!!!");
		}
		e = -28;
		if (Math.abs(p1.f(-2)-e)>EPSILON) {
			fail("Arrrr!!!");
		}
	}

	@Test
	void testAddPolynom_able() {
		Polynom p1 = new Polynom("4x^3-3x-2");
		Polynom p2 = new Polynom("4x^3-3x-2");
		Polynom expected = new Polynom("8x^3-6x-4");
		p1.add(p2);
		if (!p1.equals(expected)) {
			fail("Stop programming.");
		}
	}

	@Test
	void testAddMonom() {
		Polynom p = new Polynom("x^3+2x^2+4");
		Polynom e = new Polynom("x^3+2x^2+3x+4");
		Monom m = new Monom("3x");
		p.add(m);
		if(!p.equals(e)) {
			fail("bad bad bad");
		}
	}

	@Test
	void testSubtractMonom() {
			Polynom p = new Polynom("x^3+2x^2+3x");
			Polynom e = new Polynom("x^3+2x^2");
			Monom m = new Monom("3x");
			p.subtract(m);
			if(!p.equals(e)) {
				fail("bad bad bad");
			}
	}

	@Test
	void testSubstractPolynom() {
		Polynom p = new Polynom("x^3+2x^2+3x+2");
		Polynom e = new Polynom("x^3+2x^2");
		Polynom d = new Polynom("3x+2");
		p.substract(d);
		if(!p.equals(e)) {
			fail("bad bad bad");
		}
	}

	@Test
	void testMultiplyPolynom_able() {
		Polynom p = new Polynom("x+1");
		Polynom e = new Polynom("2+x^2+3x");
		Polynom d = new Polynom("x+2");
		p.multiply(d);
		if (!p.equals(e)) {
			fail("badd.....");
		}
	}

	@Test
	void testEqualsPolynom() {
		Polynom p1=new Polynom("4x+3x^5-4");
		Polynom p2=new Polynom("-4.0+3.0x^5+4.0x");
		if(!p1.equals(p2)) {
			fail("bug!");
		}
		String s= "4x+3x^5-4";
		if(p1.equals(s)) {
			fail("shouldn't be able...");
		}
	}

	@Test
	void testRoot() {
		Polynom p2=new Polynom("6x-5");
		double expected=0.833333;
		if(Math.abs(expected-p2.root(0, 1, 0.0001))>EPSILON) {
			fail("Failed root.");
		}
	}

	@Test
	void testCopy() {
		Polynom_able p1 = new Polynom("-4.7x^2-1.0x+6.0");
		Polynom_able p2 = p1.copy();
		if (!p1.equals(p2)) {
			fail("ahh");
		}
		p2.add(new Monom("x^2"));
		if (p1.equals(p2)) {
			fail("Stop it!!");
		}
	}

	@Test
	void testDerivative() {
		Polynom a = new Polynom("4x^5-3x^2+x-15");
		Polynom e = new Polynom("20x^4-6x+1");
		if (!e.equals(a.derivative())) {
			fail("Cmon you...");
		}
	}

	@Test
	void testArea() {
		Polynom a = new Polynom("x^2");
		Polynom b = new Polynom("-x^3+6x-1");
		double e1=21.33333334;
		double e2=109.60445714;
		if(a.area(0, 4, 0.0001)-e1>EPSILON) {
			fail("bad");
		}
		if(b.area(-2, 5, 0.0001)-e2>EPSILON) {
			fail("bad");
		}
	}

	@Test
	void testMultiplyMonom() {
		Polynom p = new Polynom("x^3+2x^2+1");
		Polynom e = new Polynom("x^4+2x^3+x");
		Monom d = new Monom("x");
		p.multiply(d);
		if (!p.equals(e)) {
			fail("badd.....");
		}
	}

	@Test
	void testInitFromString() {
		String s="x^ 5+3 x-10";
		Polynom po= new Polynom (s);			
		if(!po.equals(po.initFromString(po.toString()))) {
			fail("Nahh..");
		}
	}

}
