package nalyvaiko.versionrepository.service;

import static java.lang.String.format;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nalyvaiko.versionrepository.converter.VersionConverter;
import nalyvaiko.versionrepository.domain.Version;
import nalyvaiko.versionrepository.dto.VersionDto;
import nalyvaiko.versionrepository.exeption.VersionAlreadyExistsException;
import nalyvaiko.versionrepository.repository.VersionRepository;

@Service
public class VersionService {
	
	private static final String COLLECTION_NAME_PATTERN = "%s.%s.%s";
	
	private VersionConverter converter;
	private VersionRepository repository;
	
	public VersionService() { }
    
	@Autowired
	public VersionService(VersionConverter converter, VersionRepository repository) {
		this.converter = converter;
		this.repository = repository;
	}

	public void add(String dataBase, String metadataType, String objectType, VersionDto versionDto) {
		
		String collectionName = getCollectionName(dataBase, metadataType, objectType);
		
		if (repository.versionAlreadyExists(versionDto.getUuid(), versionDto.getNumber(), collectionName)) {
			throw new VersionAlreadyExistsException("Version already exists!");
		}
		
		Version version = converter.toEntity(versionDto);
		repository.insert(version, collectionName);
    }
    
    public List<VersionDto> get(String dataBase, String metadataType, String objectType, String odjectUuid) {
    	String collectionName = getCollectionName(dataBase, metadataType, objectType);
    	List<Version> versions = repository.findByUuid(odjectUuid, collectionName);
    	return converter.toDto(versions);
    }
    
    public VersionDto getByNumber(String dataBase, String metadataType, String objectType, String odjectUuid, Integer number) {
    	String collectionName = getCollectionName(dataBase, metadataType, objectType);
    	Version version = repository.findByNumber(odjectUuid, number, collectionName);
    	return converter.toDto(version);
    }

    public Set<String> getCollectionNames() {
    	return repository.getCollectionNames();
    }
    
    private String getCollectionName(String dataBase, String metadataType, String objectType) {
    	return format(COLLECTION_NAME_PATTERN, dataBase, metadataType, objectType);
    }
    
}
