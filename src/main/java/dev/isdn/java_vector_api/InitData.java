package dev.isdn.java_vector_api;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class InitData {

    public static long[] generateLongsArray(int length) {
        return ThreadLocalRandom.current().ints(length).asLongStream().toArray();
    }

    public static float[] generateFloatsArray(int length) {
        float[] result = new float[length];
        IntStream.range(0, length).forEach(i -> result[i] = ThreadLocalRandom.current().nextFloat());
        return result;
    }

    public static double[] generateDoublesArray(int length) {
        return ThreadLocalRandom.current().doubles(length).toArray();
    }
}