package demo.metrix.metricsCore;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by steve on 17-7-7.
 * metrix的五种数据类型之Guages（最简单的度量指标，只有一个简单的返回值。）
 */

public class GaugesTest {

    /**
     * 初始化一个大小为5的LinkedBlockingDeque
     */
    public static Queue<String> q = new LinkedBlockingDeque<String>();

    public static void main(String... args) throws InterruptedException {
        // Metric类的核心，存放所有metric的容器，也是使用metric库的起点
        /**
         * 每一个 metric 都有它独一无二的名字，Metrics 中使用句点名字，如 com.example.Queue.size
         * 当你在 com.example.Queue 下有两个 metric 实例，可以指定地更具体：
         *  com.example.Queue.requests.size 和 com.example.Queue.response.size 。
         *
         *  MetricRegistry.name(Queue.class, "requests", "size")
         *  MetricRegistry.name(Queue.class, "responses", "size")
         */
        MetricRegistry registry = new MetricRegistry();

        /**
         * Metircs 提供了 Report 接口，用于展示 metrics 获取到的统计数据。metrics-core中主要实现了四种
         * reporter： JMX, console, SLF4J, 和 CSV。 在本文的例子中，我们使用 ConsoleReporter 。
         */
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        //开始每隔一秒打印数据
        /**
         * period: 周期
         * TimeUnit: 单位
         */
        reporter.start(1, TimeUnit.SECONDS);
        // 真正实现获取数据的方法
        registry.register(MetricRegistry.name(GaugesTest.class, "queue", "size"),
                new Gauge() {
                    @Override
                    public Object getValue() {
                        return q.size();
                    }
                });
            while(true){
                Thread.sleep(1000);
                q.add("balabala");
            }
    }
}
