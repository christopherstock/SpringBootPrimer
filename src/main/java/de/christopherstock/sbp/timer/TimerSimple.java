
    package de.christopherstock.sbp.timer;

    import java.util.*;
    import java.util.concurrent.*;

    /***************************************************************************************************************
    *   Invokes the timer examples.
    ***************************************************************************************************************/
    public class TimerSimple extends TimerTask implements Runnable
    {
        /***************************************************************************************************************
        *   Invokes the timer examples.
        ***************************************************************************************************************/
        public void startTimer()
        {
            System.out.println( new Date().toString() + " " + TimerSimple.class + ".startTimer() being invoked." );

            this.startPeriodicScheduler();
            // this.startCalendarScheduler();
        }

        /***************************************************************************************************************
        *   The run method being performed scheduled.
        ***************************************************************************************************************/
        public void run()
        {
            System.out.println( new Date().toString() + " " + TimerSimple.class + ".run() being invoked." );
        }

        /***************************************************************************************************************
        *   Starts a scheduler periodically.
        ***************************************************************************************************************/
        private void startPeriodicScheduler()
        {
            System.out.println( new Date().toString() + " " + TimerSimple.class + ".startPeriodicScheduler() being invoked." );

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool( 1 );
            scheduler.scheduleAtFixedRate( this, 5, 10, TimeUnit.SECONDS );
        }

        /***************************************************************************************************************
        *   Starts a scheduler by a calendar date.
        ***************************************************************************************************************/
        private void startCalendarScheduler()
        {
            System.out.println(
                  new Date().toString()
                + " "
                + TimerSimple.class
                + ".startCalendarScheduler() being "
                + "invoked."
            );

            Calendar calendar = Calendar.getInstance();

            calendar.set(
                Calendar.DAY_OF_WEEK,
                Calendar.MONDAY
            );
            calendar.set( Calendar.HOUR_OF_DAY, 10 );
            calendar.set( Calendar.MINUTE,      0  );
            calendar.set( Calendar.SECOND,      0  );
            calendar.set( Calendar.MILLISECOND, 0  );

            Timer time = new Timer();

            time.schedule( this, calendar.getTime(), TimeUnit.SECONDS.toMillis( 30 ) );
        }
    }
