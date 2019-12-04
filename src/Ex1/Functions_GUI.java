package Ex1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Functions_GUI implements functions{
	
	ArrayList<function> G = new ArrayList<function>();

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

	@Override
	public void initFromFile(String file) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveToFile(String file) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub
		
	}

}
