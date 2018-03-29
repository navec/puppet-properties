package itec.fcc.rpp.pilotage.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gael on 09/03/2018.
 */
@Slf4j
public class ScanFolder {

    public List<File> scan(String folderLocation) {
        if (StringUtils.isEmpty(folderLocation)) {
            log.error("The folder path is null or empty.");
            return Collections.emptyList();
        }
        File file = new File(folderLocation);
        if (file.exists()) {
            return getFiles(file.listFiles());
        } else {
            log.info("The folder don't exist.");
            return Collections.emptyList();
        }
    }

    private List<File> getFiles(File[] files) {
        List<File> filesFound = new ArrayList<>();
        Arrays.asList(files).stream().forEach(file -> {
            if (file.isFile()) {
                filesFound.add(file);
            } else {
                filesFound.addAll(getFiles(file.listFiles()));
            }
        });
        return filesFound;
    }
}
