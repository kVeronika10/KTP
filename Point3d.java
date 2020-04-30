package com.company;

public class Point3d extends Point2d {
    private double zCoord;

    public Point3d ( double x,  double y, double z)
    {
       super(x,y);
       zCoord=z;
    }

    public Point3d()
    {
        super();
        this.zCoord=0;
    }

    double getZ()
    {
        return zCoord;
    }

    public void SetZ(double val)

    {
        zCoord=val;
    }
    //метод для проверки на равенство объектов класса Point3d
    public boolean same3(Point3d a)
    {
        return ((super.same2(a))&(this.getZ()==a.getZ()));

    }

    //метод для вычисления расстояния между двумя объектами класса Point3d
    public double distanceTo(Point3d point)
    {
        return Math.abs(Math.sqrt(Math.pow(getX() - point.getX(), 2) + Math.pow(getY() - point.getY(), 2) + Math.pow(zCoord - point.getZ(), 2)));
    }
}
