package cn.caizhongdong.rest.app;

/**
 * Created by caizhongdong on 2017/7/5.
 */
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(RequestContextFilter.class);
        //配置restful package.
        packages("cn.caizhongdong.rest.resource");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);


        //登记身份验证过滤器，类上增加Provider注解，这里不需要登记(使用spring+jersey后，Provider注解不起作用了，需要手工登记)
        //Provider不起作用是jersey < v2.5 bug; https://java.net/jira/browse/JERSEY-2175
        //this should be helpful  http://stackoverflow.com/questions/25905941/jersey-global-exceptionhandler-doesnt-work
        //register(AuthenticationFilter.class);

        //register(RolesAllowedDynamicFeature.class); //这个会使得PermitAll, RolesRequired(""), DenyAll等注解起作用
        register(JacksonJsonProvider.class);
        //register(MultiPartFeature.class);
    }
}
