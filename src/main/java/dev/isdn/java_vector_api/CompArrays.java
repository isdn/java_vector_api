package dev.isdn.java_vector_api;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.LongVector;
import jdk.incubator.vector.VectorSpecies;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/*
long -> (a + b) * 5
float -> (a * b) + 0.45
 */
public class CompArrays {

    private static final VectorSpecies<Long> SPECIES_LONG = LongVector.SPECIES_256;
    private static final VectorSpecies<Float> SPECIES_FLOAT = FloatVector.SPECIES_256;

    private static final long kl = 5L;
    private static final float kf = 0.45F;

    public static long[] scalarLongComp(long[] a, long[] b) {
        int length = Math.min(a.length, b.length);
        return LongStream.range(0, length).map(i ->
                (a[(int)i] + b[(int)i]) * kl
        ).toArray();
    }

    public static long[] vectorApiLongComp(long[] a, long[] b) {
        int length = Math.min(a.length, b.length);
        int upperBound = SPECIES_LONG.loopBound(length);
        long[] result = new long[length];

        for (int i = 0; i < upperBound; i += SPECIES_LONG.length()) {
            LongVector va = LongVector.fromArray(SPECIES_LONG, a, i);
            LongVector vb = LongVector.fromArray(SPECIES_LONG, b, i);
            va.add(vb).mul(kl).intoArray(result, i);
        }
        IntStream.range(upperBound, length).forEach(i ->
                result[i] = (a[i] + b[i]) * kl
        );
        return result;
    }

    public static float[] scalarFloatComp(float[] a, float[] b) {
        int length = Math.min(a.length, b.length);
        float[] result = new float[length];
        IntStream.range(0, length).forEach(i ->
                result[i] = (a[i] * b[i]) + kf
        );
        return result;
    }

    public static float[] vectorApiFloatComp(float[] a, float[] b) {
        int length = Math.min(a.length, b.length);
        int upperBound = SPECIES_FLOAT.loopBound(length);
        float[] result = new float[length];
        float[] c = new float[SPECIES_FLOAT.length()];
        Arrays.fill(c, kf);
        FloatVector vc = FloatVector.fromArray(SPECIES_FLOAT, c, 0);

        for (int i = 0; i < upperBound; i += SPECIES_FLOAT.length()) {
            FloatVector va = FloatVector.fromArray(SPECIES_FLOAT, a, i);
            FloatVector vb = FloatVector.fromArray(SPECIES_FLOAT, b, i);
            va.fma(vb, vc).intoArray(result, i);
        }
        IntStream.range(upperBound, length).forEach(i ->
                result[i] = (a[i] * b[i]) + kf
        );
        return result;
    }
}