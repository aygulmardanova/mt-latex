private Double calcLCSS(Trajectory t1, Trajectory t2, Double delta, Double epsilon) {
        int m = t1.length();
        int n = t2.length();

        if (m == 0 || n == 0) {
            return 0.0;
        } else if (abs(t1.get(m - 1).getX() - t2.get(n - 1).getX()) < epsilon
                && abs(t1.get(m - 1).getY() - t2.get(n - 1).getY()) < epsilon
                && abs(m - n) <= delta) {
            return 1 + calcLCSS(rest(t1), rest(t2), delta, epsilon);
        } else {
            return max(calcLCSS(rest(t1), t2, delta, epsilon), calcLCSS(t1, rest(t2), delta, epsilon));
        }
}