package com.eva9;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author: Steve Jin
 * @description: SpringBoot启动类
 * @date: 2019-12-26 11:55
 */
@SpringBootApplication
@MapperScan("com.eva9.mapper")
public class Eva9Application extends SpringBootServletInitializer {

	private static Logger logger = LoggerFactory.getLogger(Eva9Application.class);

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Eva9Application.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
		logger.info("    ______                  ____");
		logger.info("   / ____/   ______ _      / __ \\");
   		logger.info("  / __/ | | / / __ `/_____/ /_/ /");
   		logger.info(" / /___ | |/ / /_/ /_____/\\__, /");
   		logger.info("/_____/ |___/\\__,_/      /____/");
   		logger.info("             Eva-9 v1.0 started.");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return builder.sources(Eva9Application.class);
	}
}
