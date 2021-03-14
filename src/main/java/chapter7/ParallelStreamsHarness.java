package chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

public class ParallelStreamsHarness {
	
	public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

	public static void main(String[] args) {
		
		System.out.println("Number of processors: " + ParallelStreams.getAvailableProcessors());
		//System.out.println("Fastest iterative sum done in : " + measurePerf(ParallelStreams::iterativeSum, 10_000_000) + " ms.");
		//System.out.println("Fastest sequential sum done in : " + measurePerf(ParallelStreams::sequentialSum, 100_000_000) + " ms.");
		//System.out.println("Fastest ranged sum done in : " + measurePerf(ParallelStreams::rangedSum, 100_000_000) + " ms.");
		//System.out.println("Fastest parallel sum done in : " + measurePerf(ParallelStreams::parallelSum, 10_000_000) + " ms.");
		//System.out.println("Fastest parallel ranged sum done in : " + measurePerf(ParallelStreams::parallelRangedSum, 10_000_000) + " ms.");
		//System.out.println("Side effect parallel sum done in : " + measurePerf(ParallelStreams::sideEffectParallelSum, 10_000_000) + " ms.");
		System.out.println("Side effect parallel sum done in : " + measurePerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " ms.");

	}
	
	public static long measurePerf(Function<Long, Long> f, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long result = f.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result iteration " + i + ": " + result + ", duration: " + duration);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

}
