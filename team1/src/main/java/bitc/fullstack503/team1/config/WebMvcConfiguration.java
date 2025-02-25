package bitc.fullstack503.team1.config;


import bitc.fullstack503.team1.util.CheckLogin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    // application.properties 에서 설정한 경로
    @Value("${resources.img.location}")
    private String imgLocation;

    // addPathPatterns : 로그인 체크를 적용할 경로
    // excludePathPatterns : 로그인 체크를 제외할 경로
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new CheckLogin())
                .addPathPatterns("/MyPage")
                .addPathPatterns("/MyPage/*")
                .addPathPatterns("/SearchDetail/bookmark")
                .addPathPatterns("/SearchDetail/reviewWrite")
                .excludePathPatterns("/");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        String path = "file:///" + imgLocation;

        registry.addResourceHandler("/images/**")
                .addResourceLocations(path);
    }

}
