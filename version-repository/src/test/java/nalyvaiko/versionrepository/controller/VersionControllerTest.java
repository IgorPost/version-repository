package nalyvaiko.versionrepository.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import nalyvaiko.versionrepository.dto.VersionDto;
import nalyvaiko.versionrepository.service.VersionService;

@ExtendWith(MockitoExtension.class)
class VersionControllerTest {
	
	private VersionController controller;
	
	String dataBase = "MainDB";
	String metadataType = "Document";
	String objectType = "Invoice";
	String odjectUuid = "4bf85396-cc7a-11ea-9ef0-c86000245adb";
	int versionNumber = 1;
	
	VersionDto version = new VersionDto(odjectUuid, versionNumber, "");
	
	@Mock
	private VersionService service;
	
	@BeforeEach
	void init() {
		controller = new VersionController(service);
	}
	
	@Test
	void method_Get_CallOnService() {
		controller.get(dataBase, metadataType, objectType, odjectUuid);
		verify(service, times(1)).get(dataBase, metadataType, objectType, odjectUuid);
	}
	
	@Test
	void method_GetByNumber_CallOnService() {
		controller.getByNumber(dataBase, metadataType, objectType, odjectUuid, versionNumber);
		verify(service, times(1)).getByNumber(dataBase, metadataType, objectType, odjectUuid, versionNumber);
	}
	
	@Test
	void method_Add_CallOnService() {
		controller.add(version, dataBase, metadataType, objectType);
		verify(service, times(1)).add(dataBase, metadataType, objectType, version);
	}
	
}
