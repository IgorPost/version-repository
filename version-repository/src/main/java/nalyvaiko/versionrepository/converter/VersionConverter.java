package nalyvaiko.versionrepository.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import nalyvaiko.versionrepository.domain.Author;
import nalyvaiko.versionrepository.domain.Version;
import nalyvaiko.versionrepository.dto.VersionDto;

@Component
public class VersionConverter {
	
	public Version toEntity(VersionDto versionDto) {
		String uuid = versionDto.getUuid();
		Integer number = versionDto.getNumber();
		String object = versionDto.getObject();
		Author author = new Author(versionDto.getAuthorId(), versionDto.getAuthorName());
    	return new Version(uuid, number, object, author);
    }
    
	public VersionDto toDto(Version version) {
		String uuid = version.getUuid();
		Integer number = version.getNumber();
		String object = version.getObject();
		String authorId = version.getAuthorId();
		String authorName = version.getAuthorName();
    	return new VersionDto(uuid, number, object, authorId, authorName);
    }

	public List<Version> toEntity(List<VersionDto> versionsDto) {
		return versionsDto.stream().map(v -> toEntity(v)).collect(Collectors.toList());
    }
    
	public List<VersionDto> toDto(List<Version> versions) {
		return versions.stream().map(v -> toDto(v)).collect(Collectors.toList());
    }
}
