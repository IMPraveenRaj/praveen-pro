package com.springheaven.transformx.codility;

import java.util.*;
class Solution {
    public int solution(Point2D[] A) {
        Set<String> uniqueSlopes = new HashSet<>();

        for (Point2D statue : A) {
            int x = statue.x;
            int y = statue.y;
            if (x == 0 && y == 0) continue; // Ignore the center point (shouldn't happen)
            int gcd = gcd(x, y);
            x /= gcd;
            y /= gcd;
            // Ensure consistency in representation
            if (x < 0) {
                x = -x;
                y = -y;
            }
            uniqueSlopes.add(y + "/" + x);
        }
        return uniqueSlopes.size();
    }

    // Function to compute GCD (Greatest Common Divisor)
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}








































// Example Usage
public class Main {
    public static void main(String[] args) {
        Point2D[] statues = {
                new Point2D(-1, -2),
                new Point2D(1, 2),
                new Point2D(2, 4),
                new Point2D(-3, 2),
                new Point2D(2, -2)
        };

        Solution sol = new Solution();
        System.out.println(sol.solution(statues)); // Output: 4
    }
}

class Point2D {
    public int x;
    public int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
