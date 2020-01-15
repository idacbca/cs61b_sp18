public class NBody {
    public static double readRadius(String p) {
        In in = new In(p);
        int t = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String p) {
        In in = new In(p);
        int t = in.readInt();
        Planet[] pA = new Planet[t];
        double radius = in.readDouble();
        for (int i = 0; i < 5; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String n = in.readString();
            pA[i] = new Planet(xP, yP, xV, yV, m ,n);
        }
        return pA;
    }

    public static void main(String[] args) {
        double T, dt;
        T = Double.parseDouble(args[0]);
        dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double R = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-R, R);
        StdDraw.setPenRadius(R);
        double t = 0;
        while (t != T) {
            double[] xForces = new double[5];
            double[] yForces = new double[5];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i< planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}