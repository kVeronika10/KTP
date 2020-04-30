package com.company;
public class Point2d {
    private  double xCoord;
    private double yCoord;

    public Point2d ( double x,  double y)
    {
         xCoord = x;
         yCoord = y;
    }
    public Point2d()
    {
        this.xCoord=0;
        this.yCoord=0;
    }
    public double getX ()
    {
        return xCoord;
    }

    public double getY ()
    {
        return yCoord;
    }

    public void SetX(double val)
    {
        xCoord=val;
    }

    public void SetY(double val)
    {
        yCoord=val;
    }
    //метод для проверки на равенство объектов класса Point2d
    public boolean same2(Point2d a)
    {
        return ((this.xCoord==a.getX())&(this.yCoord==a.getY()));
    }

}
