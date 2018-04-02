package itec.fcc.rpp.pilotage.service;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static itec.fcc.rpp.pilotage.utils.SystemConstant.PROJECT_PATH;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by gael on 09/03/2018.
 */
public class SearchExtensionTest {

    private SearchExtension searchExtension = new SearchExtension();

    @Test
    public void should_return_a_list_of_txt_extension_file_when_extension_is_txt() {
        // Given
        String extension = "txt";
        String folderLocation = PROJECT_PATH + "\\src\\test\\resources\\repository_test_tutu";
        String expected1 = "toto.txt";
        String expected2 = "tata.txt";

        // When
        List<File> fileList = searchExtension.findExtension(extension, folderLocation);

        // Then
        List<String> files = fileList.stream().map(File::getName).collect(toList());
        assertThat(files).contains(expected1);
        assertThat(files).contains(expected2);
    }
}
