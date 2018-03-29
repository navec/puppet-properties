package itec.fcc.rpp.pilotage.service;

import org.eclipse.jgit.api.errors.GitAPIException;

/**
 * Created by gael on 18/02/2018.
 */
public interface GitService {
    boolean clone(String uriRepository) throws GitAPIException;
}
