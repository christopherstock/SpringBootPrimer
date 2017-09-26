
    package de.christopherstock.sbp.mongo.customer;

    import  org.springframework.data.annotation.Id;
    import  java.util.*;

    public class Customer
    {
        @Id
        public String id;

        public String firstName;

        public String lastName;

        public Date createDate;

        public Customer()
        {
        }

        public Customer( String firstName, String lastName, Date createDate )
        {
            this.firstName  = firstName;
            this.lastName   = lastName;
            this.createDate = createDate;
        }

        @Override
        public String toString()
        {
            return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', createDate='%s']",
                id,
                firstName,
                lastName,
                createDate.toString()
            );
        }
    }
