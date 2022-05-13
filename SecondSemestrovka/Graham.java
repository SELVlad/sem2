import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.Comparator; 
import java.util.List; 



public class Graham {


	public static int polarOrder(Point p1, Point p2, Point p3) {
		return (p2.x() - p1.x()) * (p3.y() - p1.y()) - (p2.y() - p1.y()) * (p3.x() - p1.x()); 
	}

	private static boolean equal(Point first, Point second) {
		return first.x() == second.x() & first.y() == second.y();
	}


	private static List<Point> GrahamScan(Point[] points) {

		int n = points.length; 

		if (n <= 2) return Arrays.asList(points); 

		Arrays.sort(points, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return p1.y() != p2.y() ? p1.y() - p2.y() : p1.x() - p2.x();
			}
		});


		int[] array = new int[n + 2]; 
		int p = 0; 

		for (int i = 0; i < n; i++) {

			while (p >= 2 && polarOrder(points[array[p-2]], points[i], points[array[p - 1]]) > 0) {
				p--;
			}
			array[p++] = i; 

		}

		int inf = p + 1; 
		for (int i = n - 2; i >= 0; i--) {
			if (equal(points[array[p-2]], points[i])) continue;
			while (p >= inf && polarOrder(points[array[p-2]], points[i], points[array[p - 1]]) > 0) {
				p--;
			}
			array[p++] = i; 
		}

		int len = Math.max(p - 1, 1); 

		List<Point> ret = new ArrayList<Point>(); 

		for (int i = 0; i < len; i++) {
			ret.add(points[array[i]]);
		}

		return ret;
	}

	public static List<Point> outTrees(Point[] points) {
		return GrahamScan(points); 
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(5,1,"A");
		Point p2 = new Point(1,1,"B");
		Point p3 = new Point(2,0,"C");
		Point p4 = new Point(3,1,"D");
		Point p5 = new Point(4,2,"E");
		Point p6 = new Point(3,3,"F");

		Point[] points = new Point[]{p1,p2,p3,p4,p5,p6};
		System.out.println(outTrees(points));
		
	}		


}