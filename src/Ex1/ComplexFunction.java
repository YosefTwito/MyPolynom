package Ex1;

public class ComplexFunction implements complex_function {

	function l;
	function r;
	Operation OP;

	public ComplexFunction () {;}

	public ComplexFunction (String o, function l , function r) {

		if ( l != null ) {
			this.l = l;
		}
		if ( r != null ) {
			this.r = r;
		}
		switch(o.toUpperCase())
		{
		case "PLUS"  :OP = Operation.Plus; 	break;
		case "TIMES" :OP = Operation.Times; break;
		case "DIVID" :OP = Operation.Divid; break;
		case "MAX"   :OP = Operation.Max; 	break;
		case "MIN"   :OP = Operation.Min; 	break;
		case "COMP"  :OP = Operation.Comp; 	break;
		case "NONE"  :OP = Operation.None; 	break;
		default      :OP = Operation.Error;	break;
		}
	}

	public ComplexFunction (function l) {
		this.l = l;
		this.OP = Operation.None;
	}

	@Override
	public double f(double x) {

		switch(OP.toString()) {

		case "Plus" : return this.l.f(x) + this.r.f(x);

		case "Times": return this.l.f(x) * this.r.f(x);

		case "Divid": 
			if(this.r.f(x)!=0) {
				return this.l.f(x) / this.r.f(x);
			} else { throw new RuntimeException("Can't divide by 0");}

		case "Max"  : return Math.max(this.l.f(x),this.r.f(x));

		case "Min"  : return Math.min(this.l.f(x),this.r.f(x));

		case "Comp" : 
			if (this.r != null ) {
				return this.l.f(this.r.f(x));
			}
			return this.l.f(x);

		case "None" :
			return this.l.f(x);
		}	
		return 0;
	}

	@Override
	/**
	 * @return string that represent this complex function.
	 */
	public String toString() {
		String ans="";
		String op ="";
		if(this.OP!=Operation.None) {
			if (this.OP == Operation.Plus) {
				ans+="plus";
			}
			if (this.OP == Operation.Times) {
				ans+="mul";
			}
			if (this.OP == Operation.Divid) {
				ans+="div";
			}
			if (this.OP == Operation.Max) {
				ans+="max";
			}
			if (this.OP == Operation.Min) {
				ans+="min";
			}
			if (this.OP == Operation.Comp) {
				ans+="comp";
			}
			ans+="(";
		}
		if(this.l!=null) {
			ans+=this.l;	
		}
		if(this.r!=null) {
			ans+=",";
			ans+=this.r;
			ans+=")";
		}
		return ans;
	}

	public String clearSpaces (String s) {
		String t="";
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)==' ') {continue;}
			t=""+t+s.charAt(i);
		}
		return t;
	}

	@Override
	/**
	 * @param s - string in a complex function form.
	 * @return  - a new complex function initialized by String s. 
	 */
	public function initFromString(String s) { 
		s=clearSpaces(s);
		int i=0;
		if (s.indexOf('(') == -1 && s.indexOf(')') == -1) { 
			Polynom po = new Polynom (s);
			po.sortP();
			function fun= new ComplexFunction(po);
			return fun;
		}
		else {
			while (s.charAt(i) != '(') {
				i++;
			}
			int split=splitPoint(s, i+1);
			String s1=s.substring(i+1, split);
			function left = initFromString(s1);
			String s2=s.substring(split+1, s.length()-1);
			function right = initFromString(s2);
			String s3 = s.substring(0, i);
			s3.toLowerCase();
			String s4="";
			switch(s3) {

			case "plus"	: s4="Plus"; break;

			case "mul"	: s4="Times"; break;

			case "div"	: s4="Divid"; break;

			case "max" 	: s4="Max"; break;

			case "min"	: s4="Min"; break;

			case "comp"	: s4="Comp"; break;

			default : s4="None"; break;

			}
			function fun= new ComplexFunction(s4, left, right);
			return fun;
		}
	}

	/**
	 * 
	 * @param s - string that represents a complex function
	 * @param i - location after "("
	 * @return location of the split (left and right)
	 */
	private int splitPoint (String s , int i) {
		int comma=0;
		int opener=1;
		int SplitAt=0;
		while(i != s.length()) {
			if(s.charAt(i)=='(') {
				opener++;
			}
			if(s.charAt(i)==',') {
				comma++;
			}
			if(comma==opener && s.charAt(i) == ',') {
				SplitAt=i;
				return SplitAt;
			}
			i++;
		}		
		return SplitAt;
	}

	/**
	 * @return a deep copy of this complex function.
	 */
	@Override
	public function copy() {
		function newF= new ComplexFunction(this.OP.toString(), this.l, this.r);
		return newF;
	}

	/**
	 * this method try to understand if those are approximately equals.
	 * (Compare those functions in many x-values to understand it.) 
	 * @return true if ot approximately equals to this complex function, otherwise return false.
	 */
	@Override
	public boolean equals (Object obj) {

		if ((obj instanceof ComplexFunction)) {
			boolean flag = true;
			ComplexFunction c = (ComplexFunction)obj;
			if (this.l!=c.l)   { flag = false; }
			if (this.OP!=c.OP) { flag = false; }
			if (this.r!=c.r)   { flag = false; }
			if (flag==true) { return true; }

			for (double i=-10.1; i<10.1; i+=1){
				if (Math.abs(this.f(i)-c.f(i))>0.0001) { return false; } 
			}
			return true;
		}

		if (obj instanceof Monom) {
			Polynom p = new Polynom(((Monom)obj).toString());
			ComplexFunction c = new ComplexFunction(p);
			return this.equals(c);
		}

		if (obj instanceof Polynom) {
			ComplexFunction c = new ComplexFunction((Polynom)obj);
			return this.equals(c);
		}

		return false;	
	}

	///////////// complex_function /////////////

	@Override
	public void plus(function fR) {
		if ( this.r != null ) {
			function fL = new ComplexFunction(this.OP.toString(), this.l,this.r);
			this.l = fL;
		}
		this.r = fR;
		this.OP = Operation.Plus;
	}

	@Override
	public void mul(function fR) {
		if ( this.r != null ) {
			function fL = new ComplexFunction(this.OP.toString(), this.l,this.r);
			this.l = fL;
		}
		this.r = fR;
		this.OP = Operation.Times;
	}

	@Override
	public void div(function fR) {
		if ( this.r != null ) {
			function fL = new ComplexFunction(this.OP.toString(), this.l,this.r);
			this.l = fL;
		}
		this.r = fR;
		this.OP = Operation.Divid;
	}

	@Override
	public void max(function fR) {
		if ( this.r != null ) {
			function fL = new ComplexFunction(this.OP.toString(), this.l,this.r);
			this.l = fL;
		}
		this.r = fR;
		this.OP = Operation.Max;
	}

	@Override
	public void min(function fR) {
		if ( this.r != null ) {
			function fL = new ComplexFunction(this.OP.toString(), this.l,this.r);
			this.l = fL;
		}
		this.r = fR;
		this.OP = Operation.Min;
	}

	@Override
	public void comp(function fR) {
		if ( this.r != null ) {
			function fL = new ComplexFunction(this.OP.toString(), this.l,this.r);
			this.l = fL;
		}
		this.r = fR;
		this.OP = Operation.Comp;
	}

	///////////// --- Getters --- /////////////

	@Override
	public function left() {
		if (this.l==null) { System.out.println("Is null, Should not be!");}
		return this.l;
	}

	@Override
	public function right() {
		return this.r;
	}

	@Override
	public Operation getOp() {
		return this.OP;
	}

}
