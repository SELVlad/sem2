import java.util.*;


public class Jarvis {

	public static int orientation(Point p1, Point p2, Point p3) {

		int val = (p2.y() - p1.y()) * (p3.x() - p2.x()) - 
				  (p2.x() - p1.x()) * (p3.y() - p2.y()); 


		if (val == 0) return 0; 

		return (val > 0) ? 1 : 2; 
	}


	public static void convexHull(Point points[], int n) {

		// Must be more than 3 points
		if (n < 3) return; 

		Vector<Point> lst = new Vector<>();

		// Find the most left point
		int l = 0; 
		for (int i = 1; i < n; i++) {
			if (points[i].x() < points[l].x()) {
				l = i; 
			}
		}

		int p = l, q; 
		do {
			lst.add(points[p]);

			q = (p + 1) % n; 

			for (int i = 0; i < n; i++) {
				if (orientation(points[p], points[i], points[q]) == 2) {
					q = i; 
				} 
			}

			p = q; 
		} while (p != l); // while we dont' come to first point


		for (Point temp : lst) {
			System.out.println("(" + temp.x() + "," +
								temp.y() + ")");
		}


	}


	public static void main(String[] args) {

        Point points[] = new Point[7];
        points[0]=new Point(0, 3, "A");
        points[1]=new Point(2, 3, "B");
        points[2]=new Point(1, 1, "C");
        points[3]=new Point(2, 1, "D");
        points[4]=new Point(3, 0, "E");
        points[5]=new Point(0, 0, "F");
        points[6]=new Point(3, 3, "G");
         
        int n = points.length;
        convexHull(points, n);

	}




}