package nalyvaiko.versionrepository.controller;

import static nalyvaiko.versionrepository.config.Swagger2Config.VERSION_TAG;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import nalyvaiko.versionrepository.dto.VersionDto;
import nalyvaiko.versionrepository.service.VersionService;

@Api(tags = {VERSION_TAG})
@RestController
@RequestMapping("/api")
public class VersionController {
    
    private VersionService service;
    
    @Autowired
    public VersionController(VersionService service) {
        this.service = service;
    }
    
    @GetMapping(value = "/collectionNames")
    @ApiOperation(value = "Get collection names", notes = "This method returns a set of collection names", response = Set.class)
	public ResponseEntity<Set<String>> getCollectionNames() {
    	Set<String> collectionNames = service.getCollectionNames();
        return new ResponseEntity<>(collectionNames, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{dataBase}/{metadataType}/{objectName}/{odjectUuid}")
    @ApiOperation(value = "Get versions by uuid", response = VersionDto.class)
	public ResponseEntity<List<VersionDto>> get(@PathVariable String dataBase,
												@PathVariable String metadataType,
												@PathVariable String objectName,
												@PathVariable String odjectUuid) {
    	List<VersionDto> versionsDto = service.get(dataBase, metadataType, objectName, odjectUuid);
        return new ResponseEntity<>(versionsDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{dataBase}/{metadataType}/{objectName}/{odjectUuid}/{versionNumber}")
    @ApiOperation(value = "Get version by uuid and version number", response = VersionDto.class)
	public ResponseEntity<VersionDto> getByNumber(@PathVariable String dataBase,
													@PathVariable String metadataType,
													@PathVariable String objectName,
													@PathVariable String odjectUuid,
													@PathVariable Integer versionNumber) {
    	VersionDto versionDto = service.getByNumber(dataBase, metadataType, objectName, odjectUuid, versionNumber);
        return new ResponseEntity<>(versionDto, HttpStatus.OK);
    }
    
    @PostMapping(value = "/{dataBase}/{metadataType}/{objectName}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add version", notes = "The method adds a new version", httpMethod = "POST")
	public ResponseEntity<?> add(@Valid @RequestBody VersionDto versionDto,
    									@PathVariable String dataBase,
    									@PathVariable String metadataType,
    									@PathVariable String objectName) {
        service.add(dataBase, metadataType, objectName, versionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
