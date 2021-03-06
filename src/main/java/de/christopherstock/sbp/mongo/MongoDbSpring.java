
    package de.christopherstock.sbp.mongo;

    import com.mongodb.*;
    import de.christopherstock.sbp.mongo.customer.*;
    import de.christopherstock.sbp.mongo.tarifwechsel.*;
    import org.springframework.data.domain.*;

    import  java.util.*;
    import java.util.concurrent.*;

    /*******************************************************************************************************************
    *   Tests the MongoDB database management system via Spring Framework.
    *
    *   @author  Christopher Stock
    *   @version 1.0
    *******************************************************************************************************************/
    public class MongoDbSpring
    {
        /***************************************************************************************************************
        *   Tests the MongoDB 'TarifwechselRepository' via Spring Framework.
        ***************************************************************************************************************/
        public void testMongoDbSpring1( TarifwechselRepository repository )
        {
            System.out.println
            (
                    new Date().toString()
                +   " "
                +   MongoDbSpring.class
                +   ".testMongoDbSpring1() being invoked"
            );

            TarifwechselEntity test = repository.getById( "1" );

            System.out.println( "Entity read: " + test );

            System.out.println( "Repository count: " + repository.count() );

            List<TarifwechselEntity> entities = repository.findAll();
            for ( TarifwechselEntity entity : entities )
            {
                System.out.println( "" );
                System.out.println( " Entity Nachname: " + entity.getNachname() );
            }
        }

        /***************************************************************************************************************
        *   Tests the MongoDB 'CustomerRepository' via Spring Framework.
        ***************************************************************************************************************/
        public void testMongoDbSpring2( CustomerRepository repository )
        {
            System.out.println
            (
                    new Date().toString()
                +   " "
                +   MongoDbSpring.class
                +   ".testMongoDbSpring2() being invoked"
            );

            repository.deleteAll();

            // save a couple of customers
            repository.save
            (
                new Customer
                (
                    "Alice",
                    "Smith",
                    new Date( System.currentTimeMillis() - TimeUnit.DAYS.toMillis( 15 ) )
                )
            );
            repository.save
            (
                new Customer
                (
                    "Bob",
                    "Smith",
                    new Date( System.currentTimeMillis() - TimeUnit.DAYS.toMillis( 30 ) )
                )
            );

            // fetch all customers
            System.out.println( "" );
            System.out.println("Customers found with findAll():");
            System.out.println("-------------------------------");

            for ( Customer customer : repository.findAll() )
            {
                System.out.println(customer);
            }
            System.out.println();

            // fetch an individual customer
            System.out.println( "" );
            System.out.println( "Customer found with findByFirstName('Alice'):" );
            System.out.println( "--------------------------------" );
            System.out.println( repository.findByFirstName( "Alice" ) );

            System.out.println( "" );
            System.out.println( "Customers found with findByLastName('Smith'):" );
            System.out.println( "--------------------------------" );
            for ( Customer customer : repository.findByLastName( "Smith" ) )
            {
                System.out.println( customer );
            }

            System.out.println( "" );
            System.out.println( "OUTDATED Customers (older than 20 days):" );
            System.out.println( "--------------------------------" );

            List<Customer> allCustomers = repository.findAll();

            for ( Customer customer : allCustomers )
            {
                if ( customer.createDate.getTime() < System.currentTimeMillis() - TimeUnit.DAYS.toMillis( 20 ) )
                {
                    System.out.println( customer );
                }
            }

            System.out.println( "" );
            System.out.println( "NOT-OUTDATED Customers (younger than 20 days):" );
            System.out.println( "--------------------------------" );
/*
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put
            (
                "createDate",
                new BasicDBObject( "$gt", System.currentTimeMillis() - TimeUnit.DAYS.toMillis( 20 ) )
            );

            Example<S> test = new Example<S>();

            List<Customer> allCustomers2 = repository.findAll( test );
*/

            // test

            // List<Customer> allCustomersTest = repository.getOutdated( new Date() );

        }
    }
