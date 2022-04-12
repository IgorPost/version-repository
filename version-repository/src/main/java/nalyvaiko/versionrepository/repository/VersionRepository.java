package nalyvaiko.versionrepository.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import nalyvaiko.versionrepository.domain.Version;

public interface VersionRepository extends MongoRepository<Version, String>, VersionRepositoryCustom {
	
}
