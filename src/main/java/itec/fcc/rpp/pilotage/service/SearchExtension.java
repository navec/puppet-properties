package itec.fcc.rpp.pilotage.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.inject.Named;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by gael on 10/03/2018.
 */
@Slf4j
@Named
public class SearchExtension {

    public List<File> findExtension(String extension, String folderLocation) {
        if (StringUtils.isEmpty(extension) || StringUtils.isEmpty(folderLocation)) {
            return Collections.emptyList();
        }

        List<File> files = scanFolder(folderLocation);
        return files.stream()
            .filter(file -> file.getName().endsWith(extension))
            .collect(toList());
    }

    private List<File> scanFolder(String folderLocation) {
        File file = new File(folderLocation);
        if (file.exists()) {
            return getFiles(file.listFiles());
        }
        log.info("The folder don't exist.");
        return Collections.emptyList();
    }

    private List<File> getFiles(File[] files) {
        List<File> filesFound = new ArrayList<>();
        Arrays.stream(files).forEach(file -> {
            if (file.isFile()) {
                filesFound.add(file);
            } else {
                filesFound.addAll(getFiles(file.listFiles()));
            }
        });
        return filesFound;
    }
}
