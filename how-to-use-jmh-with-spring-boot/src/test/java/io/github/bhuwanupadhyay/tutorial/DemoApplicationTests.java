package io.github.bhuwanupadhyay.tutorial;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class DemoApplicationTests {

	private static OrderLineRepository repository;

	@Autowired
	public void setRepository(OrderLineRepository repository) {
		DemoApplicationTests.repository = repository;
	}

	@Test
	public void runBenchmarks() throws Exception {
		Options opts = new OptionsBuilder()
				// set the class name regex for benchmarks to search for to the current class
				.include("\\." + this.getClass().getSimpleName() + "\\.")
				.warmupIterations(3)
				.measurementIterations(3)
				// do not use forking or the benchmark methods will not see references stored within its class
				.forks(0)
				// do not use multiple threads
				.threads(1)
				.shouldDoGC(true)
				.shouldFailOnError(true)
				.jvmArgs("-server")
				.build();

		new Runner(opts).run();
	}

	@Benchmark
	public void dbInserts(Parameters parameters) {
		int size = Integer.parseInt(parameters.batchSize);

		for (int i = 0; i < size; i++) {
			OrderLine line = new OrderLine();
			line.setAddressLine("Jhamsikhel Ward #3, Arun Thapa Chwok, Lalitpur, Nepal");
			line.setItemId(1L);
			line.setQuantity(i);
			repository.save(line);
		}
	}

	@State(value = Scope.Benchmark)
	public static class Parameters {

		@Param({"1", "1000"})
		String batchSize;
	}

}
