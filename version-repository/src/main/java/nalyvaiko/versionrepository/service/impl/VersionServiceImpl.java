package nalyvaiko.versionrepository.service.impl;

import static java.lang.String.format;
import static java.util.Objects.isNull;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nalyvaiko.versionrepository.converter.VersionConverter;
import nalyvaiko.versionrepository.domain.Version;
import nalyvaiko.versionrepository.dto.VersionDto;
import nalyvaiko.versionrepository.exeption.VerionNotFoundException;
import nalyvaiko.versionrepository.exeption.VersionAlreadyExistsException;
import nalyvaiko.versionrepository.repository.VersionRepository;
import nalyvaiko.versionrepository.service.VersionService;

@Service
public class VersionServiceImpl implements VersionService {
	
	private static final String VERSION_NOT_FOUND = "Version not found!";
	private static final String VERSION_ALREADY_EXISTS = "Version already exists!";

	private static final String COLLECTION_NAME_TEMPLATE = "%s.%s.%s";
	
	private VersionConverter converter;
	private VersionRepository repository;
	
	public VersionServiceImpl() { }
    
	@Autowired
	public VersionServiceImpl(VersionConverter converter, VersionRepository repository) {
		this.converter = converter;
		this.repository = repository;
	}

	@Override
	public void add(String dataBase, String metadataType, String objectType, VersionDto versionDto) {
		String collectionName = getCollectionName(dataBase, metadataType, objectType);
		if (repository.versionAlreadyExists(versionDto.getUuid(), versionDto.getNumber(), collectionName)) {
			throw new VersionAlreadyExistsException(VERSION_ALREADY_EXISTS);
		}
		Version version = converter.toEntity(versionDto);
		repository.insert(version, collectionName);
    }
    
    @Override
	public List<VersionDto> get(String dataBase, String metadataType, String objectType, String odjectUuid) {
    	String collectionName = getCollectionName(dataBase, metadataType, objectType);
    	List<Version> versions = repository.findByUuid(odjectUuid, collectionName);
    	return converter.toDto(versions);
    }
    
    @Override
	public VersionDto getByNumber(String dataBase, String metadataType, String objectType, String odjectUuid, Integer number) {
    	String collectionName = getCollectionName(dataBase, metadataType, objectType);
    	Version version = repository.findByNumber(odjectUuid, number, collectionName);
    	if (isNull(version)) {
    		throw new VerionNotFoundException(VERSION_NOT_FOUND);
    	}
    	return converter.toDto(version);
    }

    @Override
	public Set<String> getCollectionNames() {
    	return repository.getCollectionNames();
    }
    
    private String getCollectionName(String dataBase, String metadataType, String objectType) {
    	return format(COLLECTION_NAME_TEMPLATE, dataBase, metadataType, objectType);
    }
    
}
