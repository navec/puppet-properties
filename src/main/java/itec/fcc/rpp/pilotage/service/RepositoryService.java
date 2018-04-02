package itec.fcc.rpp.pilotage.service;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;

import javax.inject.Named;
import java.io.File;

/**
 * Created by gael on 18/02/2018.
 */
@Slf4j
@Named
public class RepositoryService {

    private final CloneCommand cloneCommand = Git.cloneRepository();

    public boolean clone(String uriRepository) throws InvalidRemoteException {
        try {
            cloneCommand.setURI(uriRepository).call();
            return true;
        } catch (GitAPIException e) {
            throw new InvalidRemoteException("Error occurred during the clone of the repository", e);
        }
    }

    public void deleteRepository(String repositoryName) {
        final File repo = new File(repositoryName);
        repo.delete();
    }
}
