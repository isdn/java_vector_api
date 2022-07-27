package dev.isdn.java_vector_api;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

    @State(Scope.Benchmark)
    public static class LongTestData {
        @Param({"1000", "100000", "150000000"})
        public int arrayLength;

        long[] a, b;

        @Setup(Level.Trial)
        public void prepare() {
            a = InitData.generateLongsArray(arrayLength);
            b = InitData.generateLongsArray(arrayLength);
        }
    }

    @State(Scope.Benchmark)
    public static class DoubleTestData {
        @Param({"1000", "100000", "150000000"})
        public int arrayLength;

        double[] a, b;

        @Setup(Level.Trial)
        public void prepare() {
            a = InitData.generateDoublesArray(arrayLength);
            b = InitData.generateDoublesArray(arrayLength);
        }
    }

    @State(Scope.Benchmark)
    public static class FloatTestData {
        @Param({"1000", "100000", "300000000"})
        public int arrayLength;

        float[] a, b;

        @Setup(Level.Trial)
        public void prepare() {
            a = InitData.generateFloatsArray(arrayLength);
            b = InitData.generateFloatsArray(arrayLength);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _11_testScalarLongSum(Blackhole blackhole, LongTestData testData) {
        blackhole.consume(SumArrays.scalarLongSum(testData.a, testData.b));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _12_testVectorApiLongSum(Blackhole blackhole, LongTestData testData) {
        blackhole.consume(SumArrays.vectorApiLongSum(testData.a, testData.b));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _13_testScalarDoubleSum(Blackhole blackhole, DoubleTestData testData) {
        blackhole.consume(SumArrays.scalarDoubleSum(testData.a, testData.b));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _14_testVectorApiDoubleSum(Blackhole blackhole, DoubleTestData testData) {
        blackhole.consume(SumArrays.vectorApiDoubleSum(testData.a, testData.b));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _21_testScalarLongMul(Blackhole blackhole, LongTestData testData) {
        blackhole.consume(MulArrays.scalarLongMul(testData.a, testData.b));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _22_testVectorApiLongMul(Blackhole blackhole, LongTestData testData) {
        blackhole.consume(MulArrays.vectorApiLongMul(testData.a, testData.b));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _23_testScalarDoubleMul(Blackhole blackhole, DoubleTestData testData) {
        blackhole.consume(MulArrays.scalarDoubleMul(testData.a, testData.b));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _24_testVectorApiDoubleMul(Blackhole blackhole, DoubleTestData testData) {
        blackhole.consume(MulArrays.vectorApiDoubleMul(testData.a, testData.b));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _31_testScalarLongComp(Blackhole blackhole, LongTestData testData) {
        blackhole.consume(CompArrays.scalarLongComp(testData.a, testData.b));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _32_testVectorApiLongComp(Blackhole blackhole, LongTestData testData) {
        blackhole.consume(CompArrays.vectorApiLongComp(testData.a, testData.b));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _33_testScalarFloatComp(Blackhole blackhole, FloatTestData testData) {
        blackhole.consume(CompArrays.scalarFloatComp(testData.a, testData.b));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 2, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void _34_testVectorApiFloatComp(Blackhole blackhole, FloatTestData testData) {
        blackhole.consume(CompArrays.vectorApiFloatComp(testData.a, testData.b));
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}