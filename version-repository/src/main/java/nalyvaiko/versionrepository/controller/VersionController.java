package nalyvaiko.versionrepository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nalyvaiko.versionrepository.domain.Version;
import nalyvaiko.versionrepository.service.VersionService;

@RestController
@RequestMapping("/api")
public class VersionController {
    
    private VersionService service;
    
    @Autowired
    public VersionController(VersionService service) {
        this.service = service;
    }
    
    @GetMapping(value = "/{dataBase}/{objectType}/{odjectUuid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Version>> get(@RequestBody String dataBase, String objectType, String odjectUuid) {
        List<Version> versions = service.get(dataBase, objectType, odjectUuid);
        return new ResponseEntity<>(versions, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{dataBase}/{objectType}/{odjectUuid}/{versionNumber}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Version> getByNumber(@RequestBody String dataBase, String objectType, String odjectUuid, int versionNumber) {
        Version version = service.getByNumber(dataBase, objectType, odjectUuid, versionNumber);
        return new ResponseEntity<>(version, HttpStatus.OK);
    }
    
    @PostMapping(value = "/{dataBase}/{objectType}/{odjectUuid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody List<Version> versions) {
        service.add(versions);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PostMapping(value = "/{dataBase}/{objectType}/{odjectUuid}/{versionNumber}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody Version version) {
        service.add(version);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
