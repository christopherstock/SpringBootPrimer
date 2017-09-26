
    package de.christopherstock.sbp.mongo;

    import  org.springframework.data.mongodb.repository.*;

    public interface TarifwechselRepository extends MongoRepository<TarifwechselEntity, String>
    {
        TarifwechselEntity getById( String id );

        TarifwechselEntity insert( TarifwechselEntity entity );
    }
