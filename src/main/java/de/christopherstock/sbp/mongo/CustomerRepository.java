
    package de.christopherstock.sbp.mongo;

    import  java.util.*;
    import  org.springframework.data.mongodb.repository.*;
    import  org.springframework.data.repository.query.*;

    public interface CustomerRepository extends MongoRepository<Customer, String>
    {
        public Customer findByFirstName( String firstName );

        public List<Customer> findByLastName( String lastName );
/*
        @Query("{createDate: { $regex: ?0 } })")
        public List<Customer> getOutdated( @Param( "createDate" ) Date createDate );
*/
    }
