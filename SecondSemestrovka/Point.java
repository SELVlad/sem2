public class Point {

	private String name; 
	private int x; 
	private int y; 

	public Point(int i, int j, String s) {
		x = i; 
		y = j; 
		name = s; 
	}

	public String toString() {
		return name; 
	}

	public int x() {
		return this.x; 
	}

	public int y() {
		return this.y; 
	}



}