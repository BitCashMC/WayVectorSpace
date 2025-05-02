package us.bitcash.projects.wayvectorspace;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        EuclideanVector v1 = new EuclideanVector(new double[]{1, 2, 3, 4, 5, 6, 7, 8});
        EuclideanVector v2 = new EuclideanVector(new double[]{9, 10, 11, 12, 13, 14, 15, 16});
        System.out.println(v1.dotProduct(v2));

        System.out.println("||v1|| = " + v1.norm());

        EuclideanVector proj_v1v2 = v1.project(v2);
        System.out.println(proj_v1v2);

        EuclideanVector v1v3 = v1.subtract(proj_v1v2);

        double res = proj_v1v2.dotProduct(v1v3);
        System.out.println(res);

        System.out.println(proj_v1v2.add(v1v3));



    }
}
