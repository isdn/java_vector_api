package dev.isdn.java_vector_api;

import jdk.incubator.vector.DoubleVector;
import jdk.incubator.vector.LongVector;
import jdk.incubator.vector.VectorSpecies;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MulArrays {

    private static final VectorSpecies<Long> SPECIES_LONG = LongVector.SPECIES_256;
    private static final VectorSpecies<Double> SPECIES_DOUBLE = DoubleVector.SPECIES_256;

    public static long[] scalarLongMul(long[] a, long[] b) {
        int length = Math.min(a.length, b.length);
        return LongStream.range(0, length).map(i -> a[(int)i] * b[(int)i]).toArray();
    }

    public static long[] vectorApiLongMul(long[] a, long[] b) {
        int length = Math.min(a.length, b.length);
        int upperBound = SPECIES_LONG.loopBound(length);
        long[] result = new long[length];

        for (int i = 0; i < upperBound; i += SPECIES_LONG.length()) {
            LongVector va = LongVector.fromArray(SPECIES_LONG, a, i);
            LongVector vb = LongVector.fromArray(SPECIES_LONG, b, i);
            va.mul(vb).intoArray(result, i);
        }
        IntStream.range(upperBound, length).forEach(i -> result[i] = a[i] * b[i]);
        return result;
    }

    public static double[] scalarDoubleMul(double[] a, double[] b) {
        int length = Math.min(a.length, b.length);
        double[] result = new double[length];
        IntStream.range(0, length).forEach(i -> result[i] = a[i] * b[i]);
        return result;
    }

    public static double[] vectorApiDoubleMul(double[] a, double[] b) {
        int length = Math.min(a.length, b.length);
        int upperBound = SPECIES_DOUBLE.loopBound(length);
        double[] result = new double[length];

        for (int i = 0; i < upperBound; i += SPECIES_DOUBLE.length()) {
            DoubleVector va = DoubleVector.fromArray(SPECIES_DOUBLE, a, i);
            DoubleVector vb = DoubleVector.fromArray(SPECIES_DOUBLE, b, i);
            va.mul(vb).intoArray(result, i);
        }
        IntStream.range(upperBound, length).forEach(i -> result[i] = a[i] * b[i]);
        return result;
    }
}