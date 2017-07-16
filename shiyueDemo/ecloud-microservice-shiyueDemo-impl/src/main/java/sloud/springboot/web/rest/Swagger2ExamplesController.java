package sloud.springboot.web.rest;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Created by ZHANGWEI5095@QQ.COM on 4:50 2017/6/16.
 */

@Api(value = "Swagger2ControllerUse", tags = "Swagger2Controller")
@RestController("")
@RequestMapping("security")
public class Swagger2ExamplesController {

    @ApiOperation(value = "Swagger2Api-post请求", notes = "详细描述Swagger2Api用法和注解")
    @ApiResponses({
            @ApiResponse(code = 401, message = "未授权")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "token", dataType = "string", paramType = "header")
    })
    @RequestMapping(method = RequestMethod.POST, value = {"/swagger/show"})
    public SwaggerModel post(SwaggerModel model) {
        return new SwaggerModel();
    }


    @ApiOperation(value = "Swagger2Api-get", notes = "详细描述Swagger2Api用法和注解")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "令牌", dataType = "string", paramType = "header")
    })
    @RequestMapping(method = RequestMethod.GET, value = {"/swagger/show"})
    public SwaggerModel get(SwaggerModel model) {
        return new SwaggerModel();
    }

    @ApiModel("SwaggerModel对象")
    class SwaggerModel {
        @ApiModelProperty(value = "用户名", required = true)
        private String userName;
        @ApiModelProperty(value = "密码", required = true)
        @NotNull
        private String password;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
