
    package de.christopherstock.sbp.mongo;

    import  de.christopherstock.sbp.mongo.customer.*;
    import  java.util.*;
    import  org.junit.*;
    import  org.junit.runner.*;
    import  org.springframework.beans.factory.annotation.*;
    import  org.springframework.boot.test.autoconfigure.web.servlet.*;
    import  org.springframework.boot.test.context.*;
    import  org.springframework.test.context.junit4.*;

    /*******************************************************************************************************************
    *   Tests the MongoDB database management system via Spring Framework.
    *
    *   @author  Christopher Stock
    *   @version 1.0
    *******************************************************************************************************************/
    @RunWith( SpringRunner.class )
    @SpringBootTest
    @AutoConfigureMockMvc
    public class MongoDbSpringTest
    {
        @Autowired
        CustomerRepository customerRepository;

        @Test
        public void customersAvailable()
        {
            List<Customer> testCustomer = this.customerRepository.findByLastName( "Smith" );

            Assert.assertEquals( 2, testCustomer.size() );
        }
    }
