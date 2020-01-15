public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx, dy, d;
        dx = p.xxPos - this.xxPos;
        dy = p.yyPos - this.yyPos;
        d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }

    public double calcForceExertedBy(Planet p) {
        double f, g;
        g = 6.67 * Math.pow(10, -11);
        f = (g * this.mass * p.mass) / (this.calcDistance(p) * this.calcDistance(p));
        return f;
    }

    public double calcForceExertedByX(Planet p) {
        double f, dx, d, fx;
        f = this.calcForceExertedBy(p);
        dx = p.xxPos - this.xxPos;
        d = this.calcDistance(p);
        fx = (f * dx) / d;
        return fx;
    }

    public double calcForceExertedByY(Planet p) {
        double f, dy, d, fy;
        f = this.calcForceExertedBy(p);
        dy = p.yyPos - this.yyPos;
        d = this.calcDistance(p);
        fy = (f * dy) / d;
        return fy;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double fx = 0;
        for (Planet e : p) {
            if(this.equals(e)) continue;
            fx += this.calcForceExertedByX(e);
        }
        return fx;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double fy = 0;
        for (Planet e : p) {
            if(this.equals(e)) continue;
            fy += this.calcForceExertedByY(e);
        }
        return fy;
    }

    public void update(double dt, double fx, double fy) {

    }
}