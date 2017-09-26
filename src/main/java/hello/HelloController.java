
    package hello;

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

            return "Timer Test action!";
        }




    }
