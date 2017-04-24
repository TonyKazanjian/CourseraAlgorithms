import java.util.*;

/**
 * Created by tonykazanjian on 4/9/17.
 */
public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        List<Integer> pointsToReturn = new ArrayList<>();
        //write your code here
        int[] points = new int[2 * segments.length];
        Arrays.sort(segments);

        for (int i = 0; i < segments.length; i ++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }

        for (int i = 0; i < segments.length-1; i ++) {
            int intersectingPoint = 0;

            //If we have the intersection and points in the bank
            for (int point : pointsToReturn) {
                if (point <= segments[i].end && point >= segments[i+1].start){
                    intersectingPoint = point;
                    break;
                }
            }

            // If segment A intersects with Segment B ...
            if (intersectingPoint == 0 && segments[i].end > segments[i+1].start) {
                pointsToReturn.add(segments[i].end);
            }
            // If they don't insersect each other
            else if (segments[i].end < segments[i+1].start) {
                pointsToReturn.add(segments[i + 1].end);
            }
        }

        return pointsToReturn;
    }

    private static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment o) {
            if (end < o.end) {
                return -1;
            } else if (end > o.end){
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }

        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
