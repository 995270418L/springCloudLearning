package sloud.springboot;

import com.shiyuesoft.framework.EcloudProfiles;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by ZHANGWEI5095@QQ.COM on 12:07 2017/5/31.
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        EcloudProfiles.addDefaultProfile(application.application());
        return application.sources(sloud.springboot.EcloudMicro00shiyueDemo00Application.class);
    }
}
