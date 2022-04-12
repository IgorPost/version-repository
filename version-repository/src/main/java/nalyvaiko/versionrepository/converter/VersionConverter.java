package nalyvaiko.versionrepository.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import nalyvaiko.versionrepository.domain.Version;
import nalyvaiko.versionrepository.dto.VersionDto;

@Component
public class VersionConverter {
	
	public Version toEntity(VersionDto versionDto) {
		String uuid = versionDto.getUuid();
		Integer number = versionDto.getNumber();
		String object = versionDto.getObject();
    	return new Version(uuid, number, object);
    }
    
	public VersionDto toDto(Version version) {
		String uuid = version.getUuid();
		Integer number = version.getNumber();
		String object = version.getObject();
    	return new VersionDto(uuid, number, object);
    }

	public List<Version> toEntity(List<VersionDto> versionsDto) {
		return versionsDto.stream().map(v -> toEntity(v)).collect(Collectors.toList());
    }
    
	public List<VersionDto> toDto(List<Version> versions) {
		return versions.stream().map(v -> toDto(v)).collect(Collectors.toList());
    }
}
