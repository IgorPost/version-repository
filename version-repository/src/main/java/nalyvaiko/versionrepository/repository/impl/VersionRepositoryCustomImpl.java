package nalyvaiko.versionrepository.repository.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import nalyvaiko.versionrepository.domain.Version;
import nalyvaiko.versionrepository.repository.VersionRepositoryCustom;

public class VersionRepositoryCustomImpl implements VersionRepositoryCustom {

	private static final String UUID = "uuid";
	private static final String NUMBER = "number";
	
	private MongoTemplate mongoTemplate;

	@Autowired
	public VersionRepositoryCustomImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void insert(Version version, String collectionName) {
		mongoTemplate.insert(version, collectionName);
	}

	@Override
	public List<Version> findByUuid(String uuid, String collectionName) {
		Query query = new Query();
		query.addCriteria(Criteria.where(UUID).is(uuid));
		query.with(Sort.by(Sort.Direction.ASC, NUMBER));
		return mongoTemplate.find(query, Version.class, collectionName);
	}

	@Override
	public Version findByNumber(String uuid, Integer number, String collectionName) {
		Query query = new Query();
		query.addCriteria(Criteria.where(UUID).is(uuid).and(NUMBER).is(number));
		return mongoTemplate.findOne(query, Version.class, collectionName);
	}
	
	@Override
	public boolean versionAlreadyExists(String uuid, Integer number, String collectionName) {
		Query query = new Query();
		query.addCriteria(Criteria.where(UUID).is(uuid).and(NUMBER).is(number));
		return !mongoTemplate.find(query, Version.class, collectionName).isEmpty();
	}

	@Override
	public Set<String> getCollectionNames() {
		return mongoTemplate.getCollectionNames();
	}
	
}
