package Ex1;
import java.util.ArrayList;
/**
 * This class represents a tester for the Monom class, 
*/

public class MonomTest {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		testBadForms();
		testBadAdd();
		testBadSub();
	}
	private static void test1() {
		System.out.println("*****  Test1:  *****");
		String[] monoms = {"2", "-x","-3.2x^2","0","x","x^4","-x^2"};
		for(int i=0;i<monoms.length;i++) {
			Monom m = new Monom(monoms[i]);
			String s = m.toString();
			m = new Monom(s);
			double fx = m.f(i);
			System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"\t f("+i+") = "+fx);
		}
	}
	private static void test2() {
		System.out.println("*****  Test2:  *****");
		ArrayList<Monom> monoms = new ArrayList<Monom>();
		monoms.add(new Monom(0,5));
		monoms.add(new Monom(-1,0));
		monoms.add(new Monom(-1.3,1));
		monoms.add(new Monom(-2.2,2));
		monoms.add(new Monom(4.2,1));
		monoms.add(new Monom(2.3,3));
		
		for(int i=0;i<monoms.size();i++) {
			Monom m = new Monom(monoms.get(i));
			String s = m.toString();
			Monom m1 = new Monom(s);
			boolean e = m.equals(m1);
			System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"  \teq: "+e);
		}
	}
	private static void test3() {
		System.out.println("*****  Test3:  *****");
		ArrayList<Monom> monoms = new ArrayList<Monom>();
		monoms.add(new Monom(7,2));
		monoms.add(new Monom(-3.2,3));
		monoms.add(new Monom(-4.8,1));
		monoms.add(new Monom(6,0));
		ArrayList<Monom> monoms2 = new ArrayList<Monom>();
		monoms2.add(new Monom(-2,2));
		monoms2.add(new Monom(4.2,3));
		monoms2.add(new Monom(2.3,1));
		monoms2.add(new Monom(-2.5,0));
		ArrayList<Monom> monoms3 = new ArrayList<Monom>();
		
		for(int i=0;i<monoms.size();i++) {
			String a = monoms.get(i).toString();
			monoms3.add(monoms.get(i));
			monoms.get(i).add(monoms2.get(i));
			String b = monoms.get(i).toString();
			monoms.get(i).subtract(monoms2.get(i));
			String c = monoms.get(i).toString();
			System.out.println(i+") before add: "+a+"    \tafter add: "+b+"  \tafter sub: "+c);
		}
	}
	private static void test4() {
		System.out.println("*****  Test4:  *****");
		ArrayList<Monom> monoms = new ArrayList<Monom>();
		monoms.add(new Monom(4,1));
		monoms.add(new Monom(-3.2,3));
		monoms.add(new Monom(10,1));
		monoms.add(new Monom(5,0));
		ArrayList<Monom> monoms2 = new ArrayList<Monom>();
		monoms2.add(new Monom(-2,2));
		monoms2.add(new Monom(5,3));
		monoms2.add(new Monom(2.3,4));
		monoms2.add(new Monom(-2.5,0));
		for (int i=0; i<monoms.size();i++) {
			String s1=monoms.get(i).toString();
			String s2=monoms2.get(i).toString();
			monoms.get(i).multipy(monoms2.get(i));
			String s3=monoms.get(i).toString();
		System.out.println(i+") first monom: "+s1+"   \tsecond monom: "+s2+"   \tmultiplied: "+s3);	
		}
	}
	
	private static void testBadForms() {
		System.out.println("*****  test Bad Forms  *****");
		String[] monoms = {"2^", "-xx","-3.2x+^2","x0","x6","x^4x","-^2","","t"};
		for(int i=0;i<monoms.length;i++) {
			try {
				Monom m = new Monom(monoms[i]);
			}
			catch (Exception e) {
				System.out.println("catched and Exception, '"+monoms[i]+"' is bad Form");
			}
		}
	}
	
	private static void testBadAdd() {
		System.out.println("***** bad Add: *****");
		ArrayList<Monom> monoms = new ArrayList<Monom>();
		monoms.add(new Monom(2,5));
		monoms.add(new Monom(-1,0));
		monoms.add(new Monom(-1.3,1));
		monoms.add(new Monom(-2.2,2));
		monoms.add(new Monom(4.2,1));
		monoms.add(new Monom(2.3,3));
		monoms.add(new Monom(-1.3,2));
		monoms.add(new Monom(-2.2,6));
		monoms.add(new Monom(4.2,1));
		monoms.add(new Monom(2.3,4));
		for(int i=0;i<monoms.size();i+=2) {
			try 
			{
				monoms.get(i).add(monoms.get(i+1));
			}
			catch (Exception e)
			{
				System.out.println("catched an Exception: Can't Add '"+monoms.get(i).toString()+"' , '"+monoms.get(i+1).toString()+ "' , Monom's power unequal");
			}
		}
	}
	
	private static void testBadSub() {
		System.out.println("***** bad Sub: *****");
		ArrayList<Monom> monoms = new ArrayList<Monom>();
		monoms.add(new Monom(2,5));
		monoms.add(new Monom(-1,0));
		monoms.add(new Monom(-1.3,1));
		monoms.add(new Monom(-2.2,2));
		monoms.add(new Monom(4.2,1));
		monoms.add(new Monom(2.3,3));
		monoms.add(new Monom(-1.3,2));
		monoms.add(new Monom(-2.2,6));
		monoms.add(new Monom(4.2,1));
		monoms.add(new Monom(2.3,4));
		for(int i=0;i<monoms.size();i+=2) {
			try 
			{
				monoms.get(i).subtract(monoms.get(i+1));
			}
			catch (Exception e)
			{
				System.out.println("catched an Exception: Can't Sub '"+monoms.get(i).toString()+"' , '"+monoms.get(i+1).toString()+ "' , Monom's power unequal");
			}
		}
	}
}
