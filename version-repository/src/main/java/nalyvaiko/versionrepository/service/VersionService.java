package nalyvaiko.versionrepository.service;

import java.util.List;

import org.springframework.stereotype.Service;

import nalyvaiko.versionrepository.domain.Version;

@Service
public class VersionService {
    
    public void add(Version version) {
        
    }
    
    public void add(List<Version> versions) {
        
    }
    
    public List<Version> get(String dataBase, String objectType, String odjectUuid) {
        return null;
    }
    
    public Version getByNumber(String uuid, String objectType, String odjectUuid, Integer number) {
        return null;
    }
    
}
