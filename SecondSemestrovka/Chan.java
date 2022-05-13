import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;


public class Chan {

	public static long polarOrder(Point p1, Point p2, Point p3) {
		return (p2.x() - p1.x()) * (long) (p3.y() - p1.y()) - 
			   (p2.y() - p1.y()) * (long) (p3.x() - p1.x());
	}


	public static Point[] convex_hull(Point[] points) {

		if (points.length > 1) {
			int n = points.length; 
			int k = 0; 
			Point[] hull = new Point[2 * n]; 

			Arrays.sort(points, new Comparator<Point>() {
				public int compare(Point p1, Point p2) {
					return p1.y() != p2.y() ? p1.y() - p2.y() : p1.x() - p2.x();
				}
			});


			// Builder lower hull 
			for (int i = 0; i < n; i++) {
				while (k >= 2 && polarOrder(hull[k - 2], hull[k - 1], points[i]) <= 0) {
					k--;
				}
				hull[k++] = points[i];
			}


			// Builder upper hull
			for (int i = n - 2, t = k + 1; i >= 0; i--) {
				while (k >= t && polarOrder(hull[k - 2], hull[k - 1], points[i]) <= 0) {
					k--;
				}
				hull[k++] = points[i];
			}

			if (k > 1) {
				hull = Arrays.copyOfRange(hull, 0, k - 1); 
			}
			return hull;

		} else if (points.length <= 1) {
			return points;
		} else {
			return null;
		}

	}

}