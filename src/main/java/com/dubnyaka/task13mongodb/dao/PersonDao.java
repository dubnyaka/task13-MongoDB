package com.dubnyaka.task13mongodb.dao;

import com.dubnyaka.task13mongodb.data.PersonData;
import com.dubnyaka.task13mongodb.dto.PersonDto;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends MongoRepository<PersonData, String> {

    @Query(value = "{'full_name': ?0}")
    List<PersonDto> findByFull_name(String fullName);

    @Query(value = "{'is_pep': true}", fields = "{'_id':0, 'first_name':1}")
    List<Document> getPepOnlyFirstNames();

}

