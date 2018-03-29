package itec.fcc.rpp.pilotage.service;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by gael on 29/03/2018.
 */
public class DictionaryPuppetTest {

    @Test
    public void should() throws Exception {
        // Given
        DictionaryPuppet dictionaryPuppet = new DictionaryPuppet();
        String extension = "txt";
        String repository = "https://fakelink/repository_test_tutu";
        String regex = "regex";

        // When
        Map<String, List<String>> keysByExtension = dictionaryPuppet
            .computePuppetKeysByExtension(repository, Collections.singleton(extension), regex);

        // Then
        assertThat(keysByExtension.keySet()).containsOnly(extension);
    }
}
