package nalyvaiko.versionrepository.domain;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Version {
    
	@Id
    private String id;
    
    private String uuid;
    
    private Integer number;
    
    private String object;
    
    public Version() { }

	public Version(String uuid, Integer number, String object) {
		this.uuid = uuid;
		this.number = number;
		this.object = object;
	}
	
	public Version(String id, String uuid, Integer number, String object) {
		this.id = id;
		this.uuid = uuid;
		this.number = number;
		this.object = object;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Version other = (Version) obj;
		return Objects.equals(id, other.id);
	}
	
}
