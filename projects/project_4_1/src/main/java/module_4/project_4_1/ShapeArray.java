/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package module_4.project_4_1;

/**
 *
 * @author lotfey
 */
public class ShapeArray {

    public static void main(String[] args) {

        Sphere sphere = new Sphere(5.0);
        Cylinder cylinder = new Cylinder(3.0, 7.0);
        Cone cone = new Cone(4.0, 9.0);

        Shape[] shapeArray = { sphere, cylinder, cone };

        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
            System.out.println();
        }
    }
}
