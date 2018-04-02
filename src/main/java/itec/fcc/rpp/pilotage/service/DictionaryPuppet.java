package itec.fcc.rpp.pilotage.service;

import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.*;

/**
 * Created by gael on 29/03/2018.
 */
@Named
public class DictionaryPuppet {

    private final ScanFile scanFile;
    private final SearchExtension searchExtension;
    private final RepositoryService cloneRepository;

    @Inject
    public DictionaryPuppet(ScanFile scanFile, RepositoryService cloneRepository, SearchExtension searchExtension){
        this.scanFile = scanFile;
        this.searchExtension = searchExtension;
        this.cloneRepository = cloneRepository;
    }

    public Map<String, List<String>> computePuppetKeysByExtension(String repositoryPath, Set<String> extentions, String regexPattern) throws InvalidRemoteException {
        if(isEmptyArguments(repositoryPath, extentions, regexPattern)){
            return Collections.EMPTY_MAP;
        }

        String repositoryName = getRepositoryName(repositoryPath);
            cloneRepository.clone(repositoryPath);
        Map<String, List<File>> filesByExtension = computeMapFilesByExtension(extentions, repositoryName);
        final Map<String, List<String>> keysPresentInFiles = extractKeysPresentInFiles(regexPattern, filesByExtension);
        cloneRepository.deleteRepository(repositoryName);
        return keysPresentInFiles;
    }

    private Map<String, List<String>> extractKeysPresentInFiles(String regexPattern, Map<String, List<File>> filesByExtension) {
        Map<String, List<String>> keysByExtensions = new HashMap<>();
        filesByExtension.forEach((ext, files) -> {
            List<String> keysFound = scanFile.findKeysInFilesWithPattern(files, regexPattern);
            keysByExtensions.put(ext, keysFound);
        });
        return keysByExtensions;
    }

    private Map<String, List<File>> computeMapFilesByExtension(Set<String> extentions, String repositoryName) {
        Map<String, List<File>> filesByExtension = new HashMap<>();
        extentions.stream().forEach(extention -> {
            List<File> files = searchExtension.findExtension(extention, repositoryName);
            filesByExtension.put(extention, files);
        });
        return filesByExtension;
    }

    private String getRepositoryName(String repositoryPath) {
        String[] repositoryPathSplited = repositoryPath.split("/");
        return repositoryPathSplited[repositoryPathSplited.length -1];
    }

    private boolean isEmptyArguments(String repository, Set<String> extentions, String regexPattern) {
        return StringUtils.isEmpty(repository) || CollectionUtils.isEmpty(extentions) || StringUtils.isEmpty(regexPattern);
    }
}
