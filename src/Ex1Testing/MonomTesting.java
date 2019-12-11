package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.Monom;

class MonomTesting {

	public static final double EPSILON = 0.000001;

	@Test
	void testDerivative() {
		String[] monoms = {"x", "4", "6x", "-3x^2", "x^3","-2x", "10x^5"};
		String[] expected = {"1", "0", "6", "-6x", "3x^2","-2", "50x^4"};
		for(int i=0;i<monoms.length;i++) {
			Monom t=new Monom(monoms[i]);
			Monom expect=new Monom(expected[i]);
			Monom deri = new Monom (t.derivative());
			if(!deri.equals(expect)) {
				fail("Bad derivative.. Hello cruel world!");
			}
		}
	}

	@Test
	void testF() {
		String[] monoms = {"x", "4", "6x", "-3x^2", "x^3","-2x", "10x^5"};
		double[] expected = {2.0, 4.0, 12.0, -12.0, 8.0, -4.0, 320.0};
		for(int i=0;i<monoms.length;i++) {
			Monom t=new Monom(monoms[i]);
			double e=expected[i];
			double fx = t.f(2);
			if(Math.abs(fx-e)>EPSILON) {
				fail("Bad f(x) .. Hello cruel world!");
			}
		}
	}

	@Test
	void testAdd() {
		String[] monoms = {"x", "4", "6x", "x^3","-2x", "10x^5"};
		String[] monoms2 = {"2x", "-17", "-3.2x", "2x^3", "x", "x^5"};
		String[] expected = {"3x", "-13","2.8x","3x^3","-x","11x^5"};
		for(int i=0;i<monoms.length;i++) {
			Monom t1=new Monom(monoms[i]);
			Monom t2=new Monom(monoms2[i]);
			t1.add(t2);
			Monom e=new Monom(expected[i]);
			if(!t1.equals(e)) {
				fail("Bad add .. Hello cruel world!");
			}
		}
		Monom t1=new Monom(1,0);
		Monom t2=new Monom(1,1);
		try {
			t1.add(t2);
			fail("Oh ****... added Monom's of different power.");
		}
		catch (Exception e) {}
	}

	@Test
	void testSubtract() {
		String[] expected = {"x", "4", "6x", "x^3","-2x", "10x^5"};
		String[] monoms2 = {"2x", "-17", "-3.2x", "2x^3", "x", "x^5"};
		String[] monoms = {"3x", "-13","2.8x","3x^3","-x","11x^5"};
		for(int i=0;i<monoms.length;i++) {
			Monom t1=new Monom(monoms[i]);
			Monom t2=new Monom(monoms2[i]);
			t1.subtract(t2);
			Monom e=new Monom(expected[i]);
			if(!t1.equals(e)) {
				fail("Bad sub .. Hello cruel world!");
			}
		}
		Monom t1=new Monom(1,0);
		Monom t2=new Monom(1,1);
		try {
			t1.add(t2);
			fail("Oh ****... subed Monom's of different power.");
		}
		catch (Exception e) {}
	}

	@Test
	void testMultipy() {
		Monom m1=new Monom(3,4);
		Monom m2=new Monom(2,1);
		Monom expected=new Monom(6,5);
		m1.multipy(m2);
		if (!m1.equals(expected)) {
			fail("Oh ****... bad multiply.");
		}
	}

	@Test
	void testToString() {
		String[] monoms = {"4x", "-x", "8","-5x^7", "-9x^6"};
		for(int i=0;i<monoms.length;i++) {
			Monom m1=new Monom(monoms[i]);
			String s=m1.toString();
			Monom m2=new Monom(s);
			if(!m1.equals(m2)) {
				fail("Very bad situation");
			}
		}
	}

	@Test
	void testEqualsMonom() {
		String[] monoms = {"-x", "-3x", "5x"};
		String[] expected = {"x", "-x", "7x"};
		Monom r=new Monom(2,1);
		for(int i=0;i<monoms.length;i++) {
			Monom m1=new Monom(monoms[i]);
			m1.add(r);
			Monom m2=new Monom(expected[i]);
			if(!m1.equals(m2)) {
				fail("Oh ****...");
			}
		}

	}

	@Test
	void testInitFromString() {
		String[] monoms = {" 4x", "-x", "8","-5x^7", "-9x^6"};
		for(int i=0;i<monoms.length;i++) {
			Monom m= new Monom (monoms[i]);			
			if(!m.equals(m.initFromString(monoms[i].toString()))) {
				fail("Bye bye good job.. ill miss you..");
			}
		}
	}

	@Test
	void testCopy() {
		String[] monoms = {"3x", "-13","2.8x","3x^3","-x","11x^5"};
		for(int i=0;i<monoms.length;i++) {
			Monom monom= new Monom (monoms[i]);			
			if(!monom.equals(monom.copy())) {
				fail("Ahh, that's bad.");
			}
		}
	}
}
