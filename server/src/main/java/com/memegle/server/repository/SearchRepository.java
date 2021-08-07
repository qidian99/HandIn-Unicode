package com.memegle.server.repository;

import com.memegle.server.model.Search;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends MongoRepository<Search, ObjectId> {
}
