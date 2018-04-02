package itec.fcc.rpp.pilotage.service;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static itec.fcc.rpp.pilotage.utils.SystemConstant.PROJECT_PATH;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by gael on 09/03/2018.
 */
public class ScanFileTest {

    public static final String RESOURCE_PATH = PROJECT_PATH + "\\src\\test\\resources\\";
    private ScanFile scanFolder = new ScanFile();

    @Test
    public void should_(){
        // Given
        final String regexPattern = "{{(.*)}}";
        final List<File> files = getFiles();

        // When
        final List<String> keysInFiles = scanFolder.findKeysInFilesWithPattern(files, regexPattern);

        System.out.println(keysInFiles);
        // Then
        assertThat(keysInFiles).containsOnlyOnce("firs.line.tata.key");
        assertThat(keysInFiles).containsOnlyOnce("second.line.tata.key");
        assertThat(keysInFiles).containsOnlyOnce("last.line.tata.key");
        assertThat(keysInFiles).containsOnlyOnce("last.line.toto.key");
    }

    public List<File> getFiles() {
        List<File> files = new ArrayList<>();
        files.add(new File(RESOURCE_PATH + "repository_test_tutu\\test\\tata.txt"));
        files.add(new File(RESOURCE_PATH + "repository_test_tutu\\toto.txt"));
        return files;
    }
}
