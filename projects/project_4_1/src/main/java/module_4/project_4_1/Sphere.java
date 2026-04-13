/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module_4.project_4_1;

/**
 *
 * @author lotfey
 */
public class Sphere extends Shape {

    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double surface_area() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    @Override
    public String toString() {
        return "Sphere [radius=" + radius + "]\n"
             + "Surface Area: " + surface_area() + "\n"
             + "Volume: " + volume();
    }
}

