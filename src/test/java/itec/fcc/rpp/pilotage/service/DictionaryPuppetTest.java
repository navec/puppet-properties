package itec.fcc.rpp.pilotage.service;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by gael on 29/03/2018.
 */
public class DictionaryPuppetTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private ScanFile scanFile;
    @Mock
    private SearchExtension searchExtension;
    @Mock
    private RepositoryService cloneRepository;

    @Test
    public void should_contains_only_txt_extension_when_the_entension_list_contains_only_txt() throws Exception {
        // Given
        DictionaryPuppet dictionaryPuppet = new DictionaryPuppet(scanFile, cloneRepository, searchExtension);
        String extension = "txt";
        String repository = "https://fakelink/repository_test_tutu";
        String regex = "regex";

        // When
        Map<String, List<String>> keysByExtension = dictionaryPuppet
            .computePuppetKeysByExtension(repository, Collections.singleton(extension), regex);

        // Then
        assertThat(keysByExtension.keySet()).containsOnly(extension);
    }

    @Test
    public void should_contains_only_sh_extension_when_the_entension_list_contains_only_sh() throws Exception {
        // Given
        DictionaryPuppet dictionaryPuppet = new DictionaryPuppet(scanFile, cloneRepository, searchExtension);
        String extension = "sh";
        String repository = "https://fakelink/repository_test_tutu";
        String regex = "regex";

        // When
        Map<String, List<String>> keysByExtension = dictionaryPuppet
            .computePuppetKeysByExtension(repository, Collections.singleton(extension), regex);

        // Then
        assertThat(keysByExtension.keySet()).containsOnly(extension);
    }
}
