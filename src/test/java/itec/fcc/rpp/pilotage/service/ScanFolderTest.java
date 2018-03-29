package itec.fcc.rpp.pilotage.service;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static itec.fcc.rpp.pilotage.utils.SystemConstant.PROJECT_PATH;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by gael on 09/03/2018.
 */
public class ScanFolderTest {

    public static final String RESOURCE_PATH = PROJECT_PATH + "\\src\\test\\resources\\";
    private ScanFolder scanFolder = new ScanFolder();

    @Test
    public void should_return_0_when_the_folder_location_is_null() {
        // Given
        String folderLocation = null;

        // When
        List<File> locationFileList = scanFolder.scan(folderLocation);

        // Then
        assertThat(locationFileList.size()).isEqualTo(0);
    }

    @Test
    public void should_return_test_txt_when_you_scan_repository_test() {
        // Given
        String folderLocation = RESOURCE_PATH + "repository_test";
        String expected = "test.txt";

        // When
        List<File> locationFileList = scanFolder.scan(folderLocation);

        // Then
        assertThat(locationFileList.get(0).getName()).isEqualTo(expected);
    }

    @Test
    public void should_return_titi_txt_when_you_scan_repository_test_titi() {
        // Given
        String folderLocation = RESOURCE_PATH + "repository_test_titi";
        String expected = "titi.txt";

        // When
        List<File> locationFileList = scanFolder.scan(folderLocation);

        // Then
        assertThat(locationFileList.get(0).getName()).isEqualTo(expected);
    }

    @Test
    public void should_return_titi_txt_when_you_scan_repository_test_toto() {
        // Given
        String folderLocation = RESOURCE_PATH + "repository_test_toto";
        String expected = "titi.txt";

        // When
        List<File> locationFileList = scanFolder.scan(folderLocation);

        // Then
        assertThat(locationFileList.get(0).getName()).isEqualTo(expected);
    }

    @Test
    public void should_return_toto_txt_and_tata_txt_when_you_scan_repository_test_tutu() {
        // Given
        String folderLocation = RESOURCE_PATH + "repository_test_tutu";
        String expected1 = "toto.txt";
        String expected2 = "tata.txt";

        // When
        List<File> fileList = scanFolder.scan(folderLocation);

        // Then
        List<String> files = fileList.stream().map(File::getName).collect(toList());
        assertThat(files).contains(expected1);
        assertThat(files).contains(expected2);
    }
}
