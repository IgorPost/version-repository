package nalyvaiko.versionrepository.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class VersionDto {
	
	@NotBlank
	@ApiModelProperty(notes = "Universally unique identifier of object", name = "uuid", required = true)
	private String uuid;
    
	@NotNull
	@ApiModelProperty(notes = "Version number", name = "number", required = true)
	private Integer number;
	
	@NotNull
	@ApiModelProperty(notes = "Version date and time", name = "dateTime", required = true)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateTime;
    
	@NotBlank
	@ApiModelProperty(notes = "Serialized object", name = "object", required = true)
	private String object;
	
	@NotBlank
	@ApiModelProperty(notes = "Identifier of author", name = "authorId", required = true)
	private String authorId;
	
	@NotBlank
	@ApiModelProperty(notes = "Author name", name = "authorName", required = true)
	private String authorName;
    
    public VersionDto() { }

	public VersionDto(String uuid, Integer number, LocalDateTime dateTime, String object, String authorId, String authorName) {
		this.uuid = uuid;
		this.number = number;
		this.dateTime = dateTime;
		this.object = object;
		this.authorId = authorId;
		this.authorName = authorName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}
	
	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(number, uuid);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VersionDto other = (VersionDto) obj;
		return Objects.equals(number, other.number) && Objects.equals(uuid, other.uuid);
	}
	
}
