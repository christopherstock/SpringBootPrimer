
    package de.christopherstock.sdb.config;

    import  com.mongodb.*;
    import  org.springframework.beans.factory.annotation.*;
    import  org.springframework.context.annotation.*;
    import  org.springframework.data.mongodb.config.*;
    import  org.springframework.data.mongodb.core.mapping.event.*;
    import  org.springframework.data.mongodb.repository.config.*;
    import  org.springframework.validation.beanvalidation.*;
    import  java.util.*;

    @Configuration
    @EnableMongoRepositories( "de.christopherstock.sbp.mongo" )
    public class SpringMongoConfig extends AbstractMongoConfiguration
    {
        @Value("${spring.data.mongodb.host}")
        private String hostnamen;

        @Value("${spring.data.mongodb.port}")
        private String port;

        @Value("${spring.data.mongodb.database}")
        private String database;

        @Value("${spring.data.mongodb.username}")
        private String username;

        @Value("${spring.data.mongodb.password}")
        private String password;

        @Bean
        public ValidatingMongoEventListener validatingMongoEventListener() {
            return new ValidatingMongoEventListener(validator());
        }
        @Bean
        public LocalValidatorFactoryBean validator() {
            return new LocalValidatorFactoryBean();
        }

        @Override
        public String getDatabaseName() {
            return database;
        }
        @Override
        @Bean
        public Mongo mongo() throws Exception {
            final List<ServerAddress> addresses = new ArrayList<>();
            String[] hostnames = hostnamen.split(",");
            for (String hostname:hostnames) {
                addresses.add(new ServerAddress(hostname, Integer.parseInt(port)));
            }
            final MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
            MongoClientOptions options = MongoClientOptions.builder().readPreference(ReadPreference.primaryPreferred()).build();
            return new MongoClient(addresses, Collections.singletonList(credential), options);
        }
    }
