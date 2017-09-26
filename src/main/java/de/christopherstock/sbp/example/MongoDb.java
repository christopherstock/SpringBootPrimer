
    package de.christopherstock.sbp.example;

    import  java.util.*;
    import  java.util.concurrent.*;
    import  com.mongodb.*;
    import  com.mongodb.client.*;
    import  org.bson.*;

    /*******************************************************************************************************************
    *   Tests the MongoDB database management system.
    *
    *   @author  Christopher Stock
    *   @version 1.0
    *******************************************************************************************************************/
    public class MongoDb
    {
        /***************************************************************************************************************
        *   Tests the MongoDB.
        ***************************************************************************************************************/
        public void testMongoDb()
        {
            System.out.println( new Date().toString() + " " + MongoDb.class + ".testMongoDb() being invoked." );

            // get mongo client
            MongoClient mongo = new MongoClient( "localhost" , 27017 );

            // get database names
            MongoIterable<String> databaseNames = mongo.listDatabaseNames();
            for ( String databaseName : databaseNames )
            {
                System.out.println( "Database name [" + databaseName + "]" );
            }

            // get database
            MongoDatabase database = mongo.getDatabase( "tarifwechsel-db" );

            // get collections
            MongoIterable<String> collectionNames = database.listCollectionNames();
            for ( String collectionName : collectionNames )
            {
                System.out.println( " Collection name [" + collectionName + "]" );
            }

            // get collection
            MongoCollection<Document> collection = database.getCollection( "dbEntity" );

            // get tuple count
            long tupleCount = collection.count();
            System.out.println( " Collection dbEntity tuple count [" + tupleCount + "]" );

            FindIterable<Document> tuples = collection.find();
            for ( Document tuple : tuples )
            {
                System.out.println( " Tuple [" + tuple + "]" );
                System.out.println( " createDate [" + tuple.getDate( "createDate" ) + "]" );
            }

            this.findOutdatedTuples( collection );

            // close the database connection
            mongo.close();
        }

        /***************************************************************************************************************
        *   Lists all outdated tuples.
        *
        *   @param collection The collection to find outdated tuples in.
        ***************************************************************************************************************/
        private void findOutdatedTuples( MongoCollection<Document> collection )
        {
            System.out.println( "" );
            System.out.println( "===== findOutdatedTuples() being invoked =====" );
            System.out.println( "" );

            // create search query TODO to separate method!
            BasicDBObject searchQuery = this.createOutdateSearchQuery();

            System.out.println( "" );
            long outdatedTupleCount = collection.count( searchQuery );
            System.out.println( "[" + outdatedTupleCount + "] tuples found" );

            FindIterable<Document> outdatedTuples = collection.find( searchQuery );
            for ( Document outdatedTuple : outdatedTuples )
            {
                System.out.println( " Outdated Tuple [" + outdatedTuple + "]" );
            }
            System.out.println( "" );

            // delete outdated tuples
            // collection.deleteMany( searchQuery );
        }

        /***************************************************************************************************************
        *   Creates a MongoDB query object that searches for outdated tuples.
        *
        *   @return The query object that searches outdated tuples.
        ***************************************************************************************************************/
        private BasicDBObject createOutdateSearchQuery()
        {
            Date startDate = new Date( System.currentTimeMillis() - TimeUnit.DAYS.toMillis( 15 ) );

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put
            (
                "createDate",
                new BasicDBObject( "$gt", startDate )
            );

            return searchQuery;
        }
    }
