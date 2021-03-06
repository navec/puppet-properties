package itec.fcc.rpp.pilotage.service;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by gael on 18/02/2018.
 */
@PrepareForTest(Git.class)
public class RepositoryServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @InjectMocks
    private RepositoryService repositoryService;

    @Mock
    private Git git;

    @Mock
    private CloneCommand cloneCommand;

    @Test
    public void should_return__true_when_uri_repository_is_not_null() throws Exception {
        // Given
        String uri = "fake-uri-repository";
        repositoryService.setCloneCommand(cloneCommand);

        // When
        when(cloneCommand.setURI(anyString())).thenReturn(cloneCommand);
        when(cloneCommand.call()).thenReturn(git);
        boolean isCloned = repositoryService.clone(uri);

        // Then
        assertThat(isCloned).isTrue();
    }
}
