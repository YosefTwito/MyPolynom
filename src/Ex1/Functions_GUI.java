package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Functions_GUI implements functions{
	
	ArrayList<function> G = new ArrayList<function>();
	
	Color [] colors = {Color.BLUE, Color.DARK_GRAY, Color.MAGENTA, Color.GREEN, Color.ORANGE, Color.CYAN, Color.RED, Color.PINK };
	
	public Functions_GUI() {
		G = new ArrayList<function>();
	}

	@Override
	public int size() {
		return G.size();
	}

	@Override
	public boolean isEmpty() {
		return G.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return G.contains(o);
	}

	@Override
	public Iterator<function> iterator() {
		return G.iterator();
	}

	@Override
	public Object[] toArray() {
		return G.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return G.toArray(a);
	}

	@Override
	public boolean add(function e) {
		 return G.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return G.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return G.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {
		return G.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return G.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return G.retainAll(c);
	}

	@Override
	public void clear() {
		G.clear();
	}
	
	public function get(int i) {
		return G.get(i);
	}

	@Override
	/**
	 * this method initialize G functions from a given text file.
	 */
	public void initFromFile(String file) throws IOException {
		G = new ArrayList<function>();
		function t = new ComplexFunction();
		String line="";
		try 
        {
        	BufferedReader br = new BufferedReader(new FileReader(file));
        	
            while ((line = br.readLine()) != null) 
            {
                G.add(t.initFromString(line));
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            System.out.println("could not read file");
        }
		
	}

	@Override
	/**
	 * this mmethod write the G functions in a given text file.
	 */
	public void saveToFile(String file) throws IOException {
		
		Iterator<function> it = G.iterator();
		
		try 
		{
			PrintWriter pw = new PrintWriter(new File(file));
			StringBuilder sb = new StringBuilder();
			
			while (it.hasNext()) {
				function f = it.next();
				sb.append(f.toString()+"\n");
			}	
			pw.write(sb.toString());
			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
	}

	@Override
	/**
	 * this method draws the G functions on a canvas window with Axiss.
	 */
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		
		//Start setting lines on canvas.
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		for (double i = rx.get_min(); i <= rx.get_max(); i++) {
			StdDraw.line(i, ry.get_min(), i, ry.get_max());
		}
		for (double i = ry.get_min(); i <= ry.get_max(); i++) {
			StdDraw.line(rx.get_min(), i, rx.get_max(), i);
		}
		//Drawing Axis
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
	
		StdDraw.setFont(new Font("Calibri", Font.ITALIC, 14));
		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());
		//Numbers on Axis
		for (double i = rx.get_min(); i <= rx.get_max(); i++) {
			StdDraw.text(i, -0.30, Integer.toString(Math.toIntExact((long) i)));
		}
		for (double i = ry.get_min(); i <= ry.get_max(); i++) {
			StdDraw.text(-0.20,i, Integer.toString(Math.toIntExact((long) i)));
		}
		//Drawing functions.
		for (function f : G) {
			double step = (Math.abs(rx.get_min())+Math.abs(rx.get_max()))/resolution;
			int R = (int)(Math.random()*256);
			int G = (int)(Math.random()*256);
			int B= (int)(Math.random()*256);
			Color color = new Color(R, G, B);
			StdDraw.setPenColor(color);
			for (double i = rx.get_min(); i < rx.get_max(); i+=step)
			{
				StdDraw.line(i, f.f(i), i+step, f.f(i+step));
			}
		}
		
		/* --//Not enoght colors -- Did not use eventually.--
		for (int j=0; j<G.size(); j++) {
			double step = (Math.abs(rx.get_min())+Math.abs(rx.get_max()))/resolution;
			Color color = colors[j%8];
			StdDraw.setPenColor(color);
			function f = G.get(j);
			for (double i = rx.get_min(); i < rx.get_max(); i+=step)
			{
				StdDraw.line(i, f.f(i), i+step, f.f(i+step));
			}
		}
		*/
	}
			
	@Override
	/**
	 * this method reads the parameters out of json file and draw the G functions on a canvas.
	 */
	public void drawFunctions(String json_file) {

		int w=1000, h=600, res=200;
		Range rx = new Range(-10,10);
		Range ry = new Range(-5,15);
		double [] Range_X = {-10,10};
		double [] Range_Y = {-5,-15};
		
		try {
			JSONObject o = (JSONObject)new JSONParser().parse(new FileReader(json_file));
			JSONArray X;
			JSONArray Y;
			if(o.get("Width")	   != null){   w = Math.toIntExact((long) o.get("Width")); }
			if(o.get("Height") 	   != null){   h = Math.toIntExact((long) o.get("Height")); }
			if(o.get("Resolution") != null){ res = Math.toIntExact((long) o.get("Resolution")); }
			
			if(o.get("Range_X")    != null){
				X = (JSONArray) o.get("Range_X");
				Iterator<Long> it = X.iterator();
				int i=0;
				while(it.hasNext() && i<2){ Range_X[i++] = (double)it.next().doubleValue(); }					
			}
			
			if(o.get("Range_Y") != null){
				Y = (JSONArray) o.get("Range_Y");
				Iterator<Long> itr = Y.iterator();
				int i=0;
				while(itr.hasNext() && i<2){ Range_Y[i++] = (double)itr.next().doubleValue(); }					
			}
			
			rx = new Range(Range_X[0], Range_X[1]);
			ry = new Range(Range_Y[0], Range_Y[1]);
			drawFunctions(w, h, rx, ry, res);
		}
		catch (Exception e) {
		}

	}

}
