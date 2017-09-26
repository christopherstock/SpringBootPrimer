
    package de.christopherstock.sbp.mongo;

    import  java.util.*;

    /*******************************************************************************************************************
    *   Tests the MongoDB database management system via Spring Framework.
    *
    *   @author  Christopher Stock
    *   @version 1.0
    *******************************************************************************************************************/
    public class MongoDbSpring
    {
        /***************************************************************************************************************
        *   Tests the MongoDB via Spring Framework.
        ***************************************************************************************************************/
        public void testMongoDbSpring( TarifwechselRepository repository )
        {
            System.out.println
            (
                    new Date().toString()
                +   " "
                +   MongoDbSpring.class
                +   ".testMongoDbSpring() being invoked"
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
    }
