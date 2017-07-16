package demo.metrix.metricsCore;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by steve on 17-7-7.
 * metrix的五种数据类型之 Meters
 * Meter度量一系列事件发生的速率(rate)，例如TPS(软件测试结果的测量单位)。Meters会统计最近1分钟，5分钟，15分钟，还有全部时间的速率。
 */
public class MetersTest {

    public static Random random = new Random();

    public static void request(Meter meter){
        System.out.println("request");
        // count ++ like 标记成功了，会记录在tps里面
        meter.mark();
    }

    //方法重载
    public static void request(Meter meter, int n){
        while(n > 0){
            request(meter);
            n --;
        }
    }

    public static void main(String... args) throws InterruptedException {
        MetricRegistry registry = new MetricRegistry();

        // 这个应该是多线程的调用
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(1, TimeUnit.SECONDS);

        Meter meterTps = registry.meter(MetricRegistry.name(MetersTest.class, "request", "tps"));

        while(true){
            request(meterTps,random.nextInt(5));
            Thread.sleep(1000);
        }
    }
}
