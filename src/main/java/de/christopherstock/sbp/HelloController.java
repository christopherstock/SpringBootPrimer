
    package de.christopherstock.sbp;

    import de.christopherstock.sbp.mongo.*;
    import  de.christopherstock.sbp.timer.*;
    import  org.springframework.web.bind.annotation.*;

    @RestController
    public class HelloController
    {
        @RequestMapping( "/" )
        public String index()
        {
            return "Greetings from Spring Boot!";
        }

        @RequestMapping( "/hello" )
        public String helloAction()
        {
            return "Hello Action!";
        }

        @RequestMapping( "/timer" )
        public String timerAction()
        {
            System.out.println( "Invoking timer test action." );

            TimerSimple te = new TimerSimple();
            te.startTimer();

            return "Timer Test action!";
        }

        @RequestMapping( "/mongo/simple" )
        public String mongoSimpleAction()
        {
            System.out.println( "Invoking mongo DB action." );

            MongoDbSimple mongo = new MongoDbSimple();
            mongo.testMongoDb();

            return "MongoDB simple action!";
        }
    }
