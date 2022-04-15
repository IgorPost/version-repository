package nalyvaiko.versionrepository.service;

import java.util.List;
import java.util.Set;

import nalyvaiko.versionrepository.dto.VersionDto;

public interface VersionService {

	void add(String dataBase, String metadataType, String objectType, VersionDto versionDto);

	List<VersionDto> get(String dataBase, String metadataType, String objectType, String odjectUuid);

	VersionDto getByNumber(String dataBase, String metadataType, String objectType, String odjectUuid, Integer number);

	Set<String> getCollectionNames();

}