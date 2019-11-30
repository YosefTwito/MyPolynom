package Ex1;

public class PolynomTest {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		testBadForms();
		testBadRoot();
		testBadArea();
	}

	
	public static void test1() {
		String p []= {"x", "3+1.4x^3-34x", "2x^2-4", "-1.2x-7.1", "3-3.4x+1", "3.1x-1.2", "3X^2-3.1"};
		System.out.println("*****test1*****");
		for (int i=0; i<p.length; i++) {
			Polynom t = new Polynom(p[i]);
			//t.toString();
			System.out.print(t.toString()+"\t\t f(2)= "+t.f(2));
			System.out.println();
		}
	}
	
	public static void test2() {
		String p []= {"x", "3+1.4x^3-34x", "2x^2-4", "-1.2x-7.1", "3-3.4x+1", "3.1x-1.2", "3X^2-3.1"};
		System.out.println();
		System.out.println("*****test2*****");
		for (int i=0; i<p.length; i++) {
			Polynom t1 = new Polynom(p[i]);
			Polynom t2 = new Polynom();
			t2.add(t1);
			System.out.print("first: "+t1.toString()+"\t second: "+t2.toString());
			System.out.println("\t is equal:"+t1.equals(t2));	
		}
	}
	
	public static void test3() {
		String p []= {"x", "3+1.4x^3-34x", "2x^2-4", "-1.2x-7.1", "3-3.4x+1", "3.1x-1.2", "3X^2-3.1"};
		System.out.println();
		System.out.println("*****test3*****");
		for (int i=0; i<p.length; i++) {
			Polynom t1 = new Polynom(p[i]);
			Polynom t2 = new Polynom();
			t2.substract(t1);
			System.out.println("first: "+t1.toString()+"\t second: "+t2.toString());
		}
	}
	
	public static void test4() {
		String p []= {"x", "3+1.4x^3-34x", "2x^2-4", "-1.2x-7.1", "3-3.4x+1", "3.1x-1.2", "3X^2-3.1"};
		System.out.println();
		System.out.println("*****test4*****");
		for (int i=0; i<p.length; i++) {
			Polynom t1 = new Polynom(p[i]);
			Polynom t2 = new Polynom();
			t2=(Polynom) t1.copy();
			System.out.print("first: "+t1.toString()+"\t second: "+t2.toString());
			System.out.println("\t is equal:"+t1.equals(t2));
		}
	}
	
	public static void test5() {
		String p []= {"x", "3+1.4x^3-34x", "2x^2-4", "-1.2x-7.1", "3-3.4x+1", "3.1x-1.2", "3X^2-3.1"};
		Monom m = new Monom(1,1);
		System.out.println();
		System.out.println("*****test5*****");
		for (int i=0; i<p.length; i++) {
			Polynom t1 = new Polynom(p[i]);
			System.out.print("before: "+t1.toString()+"\t  ");
			t1.multiply(m);
			System.out.println("after multiply by x: "+t1.toString());
		}
	}
	
	public static void test6() {
		String p []= {"x", "3+1.4x^3-34x", "2x^2-4", "-1.2x-7.1", "3-3.4x+1", "3.1x-1.2", "3X^2-3.1"};
		Polynom m = new Polynom("x+1");
		System.out.println();
		System.out.println("*****test6*****");
		for (int i=0; i<p.length; i++) {
			Polynom t1 = new Polynom(p[i]);
			System.out.print("before: "+t1.toString()+"\t  ");
			t1.multiply(m);
			System.out.println("after multiply by x+1: "+t1.toString());
		}
	}
	
	public static void test7() {
		String p []= {"x", "3+1.4x^3-34x", "2x^2-4", "-1.2x-7.1", "3-3.4x+1", "3.1x-1.2", "3X^2-3.1"};
		System.out.println();
		System.out.println("*****test7*****");
		for (int i=0; i<p.length; i++) {
			Polynom t1 = new Polynom(p[i]);
			System.out.print("before: "+t1.toString()+"\t  ");
			System.out.println("after derivating: "+t1.derivative().toString());
		}
	}
	
	public static void test8() {
		System.out.println();
		System.out.println("*****test8*****");
		Polynom p = new Polynom("x^2");
		System.out.println("the area of: x^2"+p+" = "+p.area(0, 4,0.0001));
		Polynom t = new Polynom("-x^3+6x-1");
		System.out.println("the area of: -x^3+6x-1"+t+" = "+t.area(-2, 5,0.0001));
		Polynom r = new Polynom("7x^2-16x+2");
		System.out.println("the area of: 7x^2-16x+2"+r+" = "+r.area(-14, 0,0.0001));
	}
	
	public static void test9() {
		System.out.println();
		System.out.println("*****test9*****");
		Polynom f = new Polynom("x+1");
		System.out.println("f(x)=x+1 root is at x="+f.root(-4, 4, 0.0001));
		f = new Polynom("x^3-3");
		System.out.println("f(x)=x^3-3 root is at x="+f.root(-4, 4, 0.0001));
		f = new Polynom("-3x^2+7x+2");
		System.out.println("f(x)=-3x^2+7x+2 root is at x="+f.root(0, 4, 0.0001));
		f = new Polynom("2x^8-6x-6");
		System.out.println("f(x)=2x^8-6x-6 root is at x="+f.root(-5, 1, 0.0001));
		f = new Polynom("3x^3+x^2-1");
		System.out.println("f(x)=3x^3+x^2-1 root is at x="+f.root(0, 2, 0.0001));
	}
	
	public static void testBadForms() {
		System.out.println();
		System.out.println("*****Test Bad Forms: *****");
		String p []= {"x2", "3+1.4x^^3-34x", "2x2-4", "--1.2x-7.1", "(3-3.4x+1)", "", "3X^2^1"};
		for (int i=0; i<p.length; i++) {
			try {
				Polynom t1 = new Polynom(p[i]);
			}
			catch (Exception e) {
				System.out.println("cathced a bad form String Exception for: '"+p[i]+"'");
			}
		}
	}

	public static void testBadRoot() {
		System.out.println();
		System.out.println("*****Test Bad values Root: *****");
		Polynom t1 = new Polynom("x^2-5");
		
		double x0=2, x1=-3, eps=0.0001;
		try {
			t1.root(x0, x1, eps);
		}
		catch (Exception e) {
			System.out.println("cathced an Exception for root values: x0="+x0+", x1="+x1+", "+"eps="+eps+", for: "+t1.toString());
		}
		x0=0;
		x1=4;
		eps=0;
		try {
			t1.root(x0, x1, eps);
		}
		catch (Exception e) {
			System.out.println("cathced an Exception for root values: x0="+x0+", x1="+x1+", "+"eps="+eps+", for: "+t1.toString());
		}
		Polynom t2= new Polynom("x+2");
		x0=0;
		x1=4;
		eps=0.0001;
		try {
			t2.root(x0, x1, eps);
		}
		catch (Exception e) {
			System.out.println("cathced an Exception for root values: x0="+x0+", x1="+x1+", "+"eps="+eps+", for: "+t2.toString());
		}
	}
	
	public static void testBadArea() {
		System.out.println();
		System.out.println("*****Test Bad values Area: *****");
		Polynom t1 = new Polynom("x^3-2");
		
		double x0=2, x1=-3, eps=0.0001;
		try {
			t1.area(x0, x1, eps);
		}
		catch (Exception e) {
			System.out.println("cathced an Exception for area values: x0="+x0+", x1="+x1+", "+"eps="+eps+", for: "+t1.toString());
		}
		x0=0;
		x1=4;
		eps=-0.0001;
		try {
			t1.area(x0, x1, eps);
		}
		catch (Exception e) {
			System.out.println("cathced an Exception for area values: x0="+x0+", x1="+x1+", "+"eps="+eps+", for: "+t1.toString());
		}
	}
	
}
