package itec.fcc.rpp.pilotage.service.impl;

import itec.fcc.rpp.pilotage.service.GitService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import java.io.File;

/**
 * Created by gael on 18/02/2018.
 */
@Slf4j
public class GitCloneRepository implements GitService {

    private final CloneCommand cloneCommand;

    @Inject
    public GitCloneRepository(CloneCommand cloneCommand) {
        this.cloneCommand = cloneCommand;
    }

    @Override
    public boolean clone(String uriRepository) {
        if (!StringUtils.isEmpty(uriRepository)) {
            try {
                log.error("The repository URI is null or empty.");
                cloneCommand.setURI(uriRepository).call();
                return true;
            } catch (GitAPIException e) {
                log.error("", e);
            }
        }
        return false;
    }
}
