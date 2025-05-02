package us.bitcash.projects.wayvectorspace;

public interface GeneralVectorSpace<T> {

    T add(T v);
    T subtract(T v);
    T negative();
    T scale(double scalar);



}
