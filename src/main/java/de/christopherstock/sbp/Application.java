
    package de.christopherstock.sbp;

    import  java.util.Arrays;
    import  org.springframework.boot.*;
    import  org.springframework.boot.autoconfigure.*;
    import  org.springframework.context.*;
    import  org.springframework.context.annotation.*;
    import  org.springframework.scheduling.annotation.*;

    @SpringBootApplication
    @EnableScheduling
    public class Application // extends AbstractMongoConfiguration
    {
        /***************************************************************************************************************
        *   The main method being invoked when the Spring Boot Framework is started.
        *
        *   TODO ASAP Alter all system.outs to log.info.
        ***************************************************************************************************************/
        public static void main( String[] args )
        {
            SpringApplication.run( Application.class, args );
        }

        @Bean
        public CommandLineRunner commandLineRunner( ApplicationContext ctx )
        {
            return args -> {

                System.out.println( "Here are the beans provided by Spring Boot:" );

                String[] beanNames = ctx.getBeanDefinitionNames();
                Arrays.sort( beanNames );

                for ( String beanName : beanNames )
                {
                    System.out.println( beanName );
                }
            };
        }
    }
