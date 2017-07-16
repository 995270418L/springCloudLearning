package sloud.springboot;

import com.shiyuesoft.framework.EcloudProfiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.net.UnknownHostException;

/**
 * Created by ZHANGWEI5095@QQ.COM on 12:07 2017/5/31.
 */

@ComponentScan
@SuppressWarnings("unused")
@Configuration
@EnableAutoConfiguration(exclude = {MetricFilterAutoConfiguration.class, MetricRepositoryAutoConfiguration.class})
public class EcloudMicro00shiyueDemo00Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(sloud.springboot.EcloudMicro00shiyueDemo00Application.class);

    private final Environment environment;

    public EcloudMicro00shiyueDemo00Application(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void initApplication() {
        EcloudProfiles.checkDefaultProfiles(environment);
    }

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(sloud.springboot.EcloudMicro00shiyueDemo00Application.class);
        EcloudProfiles.addDefaultProfile(app);
        EcloudProfiles.profiles(app.run(args).getEnvironment());
    }
}
