package nalyvaiko.versionrepository.repository;

import java.util.List;
import java.util.Set;

import nalyvaiko.versionrepository.domain.Version;

public interface VersionRepositoryCustom {
	
	void insert(Version version, String collectionName);
	
	List<Version> findByUuid(String uuid, String collectionName);

	Version findByNumber(String uuid, Integer number, String collectionName);
	
	boolean versionAlreadyExists(String uuid, Integer number, String collectionName);
	
	Set<String> getCollectionNames();
	
}
