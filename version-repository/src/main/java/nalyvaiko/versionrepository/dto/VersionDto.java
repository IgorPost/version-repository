package nalyvaiko.versionrepository.dto;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

public class VersionDto {
	
	@ApiModelProperty(notes = "Universally unique identifier of object", name = "uuid", required = true)
	private String uuid;
    
	@ApiModelProperty(notes = "Version number", name = "number", required = true)
	private Integer number;
    
	@ApiModelProperty(notes = "Serialized object", name = "number", required = true)
	private String object;
    
    public VersionDto() { }

	public VersionDto(String uuid, Integer number, String object) {
		this.uuid = uuid;
		this.number = number;
		this.object = object;
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

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
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
