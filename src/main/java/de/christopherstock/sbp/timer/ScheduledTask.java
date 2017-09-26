
    package de.christopherstock.sbp.timer;

    import  java.util.*;
    import  org.slf4j.*;
    import  org.springframework.scheduling.annotation.*;
    import  org.springframework.stereotype.*;

    /***************************************************************************************************************
    *   Demonstrates the usage of Scheduled Tasks in the Spring Boot Framework.
    ***************************************************************************************************************/
    @Component
    public class ScheduledTask
    {
        /** The logger instance. */
        private static final Logger log = LoggerFactory.getLogger( ScheduledTask.class );

        @Scheduled( fixedRate = 5000 )
        public void reportCurrentTime()
        {
            System.out.println( new Date().toString() + ScheduledTask.class + ".reportCurrentTime() being invoked" );

            log.info( "Current time being reported {}", new Date().toString() );
        }
    }
