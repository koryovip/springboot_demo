package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.b0000.B0000Service;

@SpringBootApplication
public class CommandLineRunnerApplication {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.println("main()");
        try (ConfigurableApplicationContext ctx = SpringApplication.run(CommandLineRunnerApplication.class, args)) {
            CommandLineRunnerApplication app = ctx.getBean(CommandLineRunnerApplication.class);
            app.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private B0000Service b0000Service;

    public void run(String... args) throws Exception {
        logger.debug("処理開始");
        b0000Service.select();
        logger.debug("処理終了");
    }
}
