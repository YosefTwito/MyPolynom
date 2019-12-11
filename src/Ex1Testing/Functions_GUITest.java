package Ex1Testing;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Functions_GUI;
import Ex1.Monom;
import Ex1.Polynom;
import Ex1.Range;
import Ex1.function;
import Ex1.functions;

/**
 * Partial JUnit + main test for the GUI_Functions class, expected output from the main:
 * 0) java.awt.Color[r=0,g=0,b=255]  f(x)= plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0)
1) java.awt.Color[r=0,g=255,b=255]  f(x)= plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)
2) java.awt.Color[r=255,g=0,b=255]  f(x)= div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)
3) java.awt.Color[r=255,g=200,b=0]  f(x)= -1.0x^4 +2.4x^2 +3.1
4) java.awt.Color[r=255,g=0,b=0]  f(x)= +0.1x^5 -1.2999999999999998x +5.0
5) java.awt.Color[r=0,g=255,b=0]  f(x)= max(max(max(max(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)
6) java.awt.Color[r=255,g=175,b=175]  f(x)= min(min(min(min(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)

 * @author YosefTwito
 *
 */
class Functions_GUITest {
	public static void main(String[] a) {
		Functions_GUI data = (Functions_GUI)FunctionsFactory();
		int w=1000, h=600, res=200;
		Range rx = new Range(-10,10);
		Range ry = new Range(-5,15);
		data.drawFunctions(w,h,rx,ry,res);
		data.drawFunctions("json_param.txt");
	}

	private Functions_GUI _data=null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {;}

	@BeforeEach 
	void setUp() throws Exception {
		_data = (Functions_GUI)FunctionsFactory();
	}

	@Test
	void testInitAndSaveFile() {

		function t = new ComplexFunction();
		String [] expectedS = {"plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.3x+5.0)" , 
				"plus(div(x+1,mul(mul(x+3.0,x-2.0),x-4.0)),2.0)" ,
				"div(plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.3x+5.0),-1.0x^4+2.4x^2+3.1)" , 
				"-1.0x^4+2.4x^2+3.1" ,
				"0.1x^5-1.3x+5.0" , 
				"max(max(max(max(plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.3x+5.0),plus(div(x+1,mul(mul(x+3.0,x-2.0),x-4.0)),2.0)),div(plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.3x+5.0),-1.0x^4+2.4x^2+3.1)),-1.0x^4+2.4x^2+3.1),0.1x^5-1.3x+5.0)" ,
		"min(min(min(min(plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.3x+5.0),plus(div(x+1,mul(mul(x+3.0,x-2.0),x-4.0)),2.0)),div(plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.3x+5.0),-1.0x^4+2.4x^2+3.1)),-1.0x^4+2.4x^2+3.1),0.1x^5-1.3x+5.0)" };


		Functions_GUI Fit = new Functions_GUI();
		for (int j=0; j<expectedS.length; j++) {
			Fit.add(t.initFromString(expectedS[j]));
		}

		try {
			Fit.saveToFile("testIt.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Functions_GUI Fnew = new Functions_GUI();

		try {
			Fnew.initFromFile("testIt.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (Fit.size()!=Fnew.size()) { fail(); }

		for (int i=0; i<Fit.size();i++) {
			if (!(Fit.get(i).equals(Fnew.get(i)))){ fail(); }
		}
	}


	public static functions FunctionsFactory() {
		functions ans = new Functions_GUI();
		String s1 = "3.1 +2.4x^2 -x^4";
		String s2 = "5 +2x -3.3x +0.1x^5";
		String[] s3 = {"x +3","x -2", "x -4"};
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		Polynom p3 = new Polynom(s3[0]);
		ComplexFunction cf3 = new ComplexFunction(p3);
		for(int i=1;i<s3.length;i++) {
			cf3.mul(new Polynom(s3[i]));
		}

		ComplexFunction cf = new ComplexFunction("Plus", p1,p2);
		ComplexFunction cf4 = new ComplexFunction("Divid", new Polynom("x +1"),cf3);
		cf4.plus(new Monom("2"));
		ans.add(cf.copy());
		ans.add(cf4.copy());
		cf.div(p1);
		ans.add(cf.copy());
		String s = cf.toString();
		function cf5 = cf4.initFromString(s1);
		function cf6 = cf4.initFromString(s2);
		ans.add(cf5.copy());
		ans.add(cf6.copy());
		Iterator<function> iter = ans.iterator();
		function f = iter.next();
		ComplexFunction max = new ComplexFunction(f);
		ComplexFunction min = new ComplexFunction(f);
		while(iter.hasNext()) {
			f = iter.next();
			max.max(f);
			min.min(f);
		}
		ans.add(max);
		ans.add(min);		
		return ans;
	}
}

