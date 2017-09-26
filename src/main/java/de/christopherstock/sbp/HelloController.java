
    package de.christopherstock.sbp;

    import  de.christopherstock.sbp.mongo.*;
    import de.christopherstock.sbp.mongo.customer.*;
    import de.christopherstock.sbp.mongo.tarifwechsel.*;
    import  de.christopherstock.sbp.timer.*;
    import  org.springframework.beans.factory.annotation.*;
    import  org.springframework.web.bind.annotation.*;

    @RestController
    public class HelloController
    {
        @Autowired
        TarifwechselRepository tarifwechselRepository;

        @Autowired
        CustomerRepository customerRepository;

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

        @RequestMapping( "/mongo/spring1" )
        public String mongoSpringAction1()
        {
            System.out.println( "Invoking mongo DB action 1 via Spring Boot framework." );

            MongoDbSpring mongo = new MongoDbSpring();
            mongo.testMongoDbSpring1( this.tarifwechselRepository );

            return "MongoDB Spring Boot framework action 1!";
        }

        @RequestMapping( "/mongo/spring2" )
        public String mongoSpringAction2()
        {
            System.out.println( "Invoking mongo DB action 2 via Spring Boot framework." );

            MongoDbSpring mongo = new MongoDbSpring();
            mongo.testMongoDbSpring2( this.customerRepository );

            return "MongoDB Spring Boot framework action 2!";
        }
    }
