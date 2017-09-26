
    package de.christopherstock.sbp.mongo;

    import  java.util.*;
    import  org.springframework.data.mongodb.repository.MongoRepository;

    public interface CustomerRepository extends MongoRepository<Customer, String>
    {
        public Customer findByFirstName( String firstName );

        public List<Customer> findByLastName( String lastName );



/*
        public List<Customer> getOutdated( Date threshold );
*/


    }
