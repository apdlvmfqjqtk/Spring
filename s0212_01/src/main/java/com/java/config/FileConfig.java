package com.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer{

	//images 링크가 들어오면 찾는 위치를 c:upload폴더에서 찾아라
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/images/**")
	    .addResourceLocations("file:///c:/static/");
	    
	    //파일업로드에서 파일위치를 지정
	    registry.addResourceHandler("/upload/board/**")
	    .addResourceLocations("file:///c:/upload/board/");
	    
	}

}