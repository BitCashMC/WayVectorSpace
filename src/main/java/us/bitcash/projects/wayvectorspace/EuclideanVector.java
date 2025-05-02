package us.bitcash.projects.wayvectorspace;

import java.util.Arrays;

public class EuclideanVector implements EuclideanVectorSpace {

    private final double[] components;
    private final double dimensions;

    public EuclideanVector(double[] components) {
        this.components = components;
        this.dimensions = components.length;
    }

    @Override
    public double dotProduct(EuclideanVector vector) {
        if (vector.dimensions != this.dimensions) throw new IllegalStateException("Differing dimensions");

        double sum = 0;
        for (int i = 0; i<this.components.length; i++) {
            sum += MathUtils.round2(this.components[i] * vector.components[i]);
        }
        return MathUtils.round2(sum);
    }

    @Override
    public double norm() {
        return MathUtils.round2(Math.sqrt(Arrays.stream(this.components).map(p->p*p).sum()));
    }

    /*
    Projection is the process of scaling some vector such that the distance between it and the vector in question is orthogonal to the vector scaled.
    The formula for that scalar is u*a / a*a, where u is the vector we wish to project, and a is the vector we want to project u along
     */
    @Override
    public EuclideanVector project(EuclideanVector component) {
        final double k = MathUtils.round2((this.dotProduct(component)) / component.dotProduct(component));
        return component.scale(k);
    }

    @Override
    public EuclideanVector add(EuclideanVector v) {
        if (v.dimensions != this.dimensions) throw new IllegalStateException("Differing dimensions");

        double[] addends = new double[components.length];
        for (int i = 0; i<this.components.length; i++) {
            addends[i] = this.components[i]+v.components[i];
        }
        return new EuclideanVector(addends);
    }

    @Override
    public EuclideanVector subtract(EuclideanVector v) {
        return this.add(v.negative());
    }

    @Override
    public EuclideanVector negative() {
        return new EuclideanVector(Arrays.stream(this.components).map(p->p*-1).map(MathUtils::round2).toArray());
    }

    @Override
    public EuclideanVector scale(double scalar) {
        return new EuclideanVector(Arrays.stream(this.components).map(p->scalar*p).map(MathUtils::round2).toArray());
    }

    @Override
    public String toString() {
        return Arrays.toString(this.components);
    }
}
