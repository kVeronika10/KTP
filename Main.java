package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Insert first point: ");
        double a1=in.nextDouble();
        double b1=in.nextDouble();
        double c1=in.nextDouble();
        Point3d first=new Point3d(a1,b1,c1);
        System.out.printf("x: %s, y: %s, z: %s\n", first.getX(), first.getY(), first.getZ());
        System.out.println("Insert second point: ");
        double a2=in.nextDouble();
        double b2=in.nextDouble();
        double c2=in.nextDouble();
        Point3d second=new Point3d(a2,b2,c2);
        System.out.printf("x: %s, y: %s, z: %s\n", second.getX(), second.getY(), second.getZ());
        System.out.println("Insert third point: ");
        double a3=in.nextDouble();
        double b3=in.nextDouble();
        double c3=in.nextDouble();
        Point3d third=new Point3d(a3,b3,c3);
        System.out.printf("x: %s, y: %s, z: %s\n", third.getX(), third.getY(), third.getZ());
        if ((first.same3(second)) ||(first.same3(third)) || (second.same3(third)))
            System.out.println("Mistake");
        else
            System.out.print("S= "+computeArea(first,second,third));
    }
    public static double computeArea(Point3d a, Point3d b, Point3d c)
    {
        double a1=a.distanceTo(c);
        double b1=a.distanceTo(b);
        double c1=c.distanceTo(b);
        double p = (a1 + b1 + c1) / 2;
        return Math.sqrt(p * (p - a1) * (p - b1) * (p - c1));
    }
}
