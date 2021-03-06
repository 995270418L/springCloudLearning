package demo.metrix.metricsCore;


import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by steve on 17-7-7.
 * metrix的五种数据类型之Counters
 * Counter 就是计数器，Counter 只是用 Gauge 封装了 AtomicLong 。
 * 我们可以使用如下的方法，使得获得队列大小更加高效。
 */

public class CounterTest {

    public static Queue<String> q = new LinkedBlockingQueue<String>();

    public static Counter pendingJobs;

    public static Random random = new Random();

    public static void addJobs(String job){
        pendingJobs.inc();
        q.offer(job);
    }

    public static String takeJob(){
        pendingJobs.dec();
        return q.poll();
    }

    public static void main(String... args) throws InterruptedException {
        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(1, TimeUnit.SECONDS);
        pendingJobs = registry.counter(MetricRegistry.name(CounterTest.class, "pending-jobs", "size"));

        int num = 1;
        while(true){
            Thread.sleep(200);
            if(random.nextDouble() > 0.7){
                String job = takeJob();
                System.out.println("take job: " + job);
            }else{
                String job = "job" + num;
                addJobs(job);
                System.out.println("add job: " + job );
            }
            num ++;
        }
    }
}
