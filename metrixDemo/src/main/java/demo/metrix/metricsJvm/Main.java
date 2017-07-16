package demo.metrix.metricsJvm;

import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.MetricSet;
import com.codahale.metrics.jvm.BufferPoolMetricSet;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;

import java.lang.management.ManagementFactory;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by steve on 17-7-7.
 * In this blog we will see how to get metrics about memory, buffers,
 * threads and the garbage collection (gc) process from the JVM
 */
public class Main {

    private final static MetricRegistry registry = new MetricRegistry();

    public static void main(String... args){
        //register four metric sets
        registerAll("gc", new GarbageCollectorMetricSet(), registry);
        registerAll("buffers", new BufferPoolMetricSet(ManagementFactory.getPlatformMBeanServer()), registry);
        registerAll("memory", new MemoryUsageGaugeSet(),registry);
        registerAll("threads", new ThreadStatesGaugeSet(), registry);

        printMetric("threads.count");
//        byte[] big = new byte[1000000000];
//        printMetric("memory.stack.usage");

    }

    private static void registerAll(String prefix, MetricSet metricSet, MetricRegistry registry){
        for(Map.Entry<String, Metric> entry : metricSet.getMetrics().entrySet()){
            //metric还有集合类型？？？
            if(entry.getValue() instanceof MetricSet){
                registerAll(prefix + "." + entry.getKey(), (MetricSet) entry.getValue(), registry);
            }else{
                // 打印出来所有的metricName
                String metricsName = prefix + "." + entry.getKey();
                System.out.println("metrics.key: " + metricsName);
                registry.register(metricsName, entry.getValue());
            }
        }
    }

    private static void pringAllMetrics(){
        for(String metricsName : registry.getGauges().keySet()){
            printMetric(metricsName);
        }
    }

    private static void printMetric(String metricName){
        Object value = registry.getGauges().get(metricName).getValue();
        System.out.println("name=" + metricName+", value = " + value);
    }
}
