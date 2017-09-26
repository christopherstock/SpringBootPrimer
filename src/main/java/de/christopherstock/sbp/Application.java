
    package de.christopherstock.sbp;

    import  java.util.Arrays;
    import  org.springframework.boot.*;
    import  org.springframework.boot.autoconfigure.*;
    import  org.springframework.context.*;
    import  org.springframework.context.annotation.*;

    @SpringBootApplication
    public class Application
    {
        /***************************************************************************************************************
        *   TODO Colorize and create IJ Module.
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
