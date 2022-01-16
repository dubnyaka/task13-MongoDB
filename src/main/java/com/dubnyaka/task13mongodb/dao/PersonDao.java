package com.dubnyaka.task13mongodb.dao;

import com.dubnyaka.task13mongodb.data.PersonData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PersonDao {

    private final MongoOperations db;

    public Optional<PersonData> get(String id) {
        return Optional.of(db.findById(id, PersonData.class));
    }

    public List<PersonData> getByLastname(String lastName){
        Criteria criteria = new Criteria();

        criteria.and("last_name").is(lastName);
        return db.find(Query.query(criteria),PersonData.class);
    }

    public Optional<List<PersonData>> getAll(){
        return Optional.of(db.findAll(PersonData.class));
    }


    public void save(PersonData personData) {
        db.save(personData);
    }

}

