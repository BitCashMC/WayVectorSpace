package us.bitcash.projects.wayvectorspace;

public interface EuclideanVectorSpace extends GeneralVectorSpace<EuclideanVector> {

    double dotProduct(EuclideanVector vector);
    double norm();
    EuclideanVector project(EuclideanVector component);

}
