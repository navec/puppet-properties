package itec.fcc.rpp.pilotage.service;

import org.springframework.util.StringUtils;

import javax.inject.Inject;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * Created by gael on 10/03/2018.
 */
public class SearchExtension {

    private final ScanFolder scanFolder;

    @Inject
    public SearchExtension (ScanFolder scanFolder){
        this.scanFolder = scanFolder;
    }

    public List<File> findExtension(String extension, String folderLocation) {
        if(StringUtils.isEmpty(extension) || StringUtils.isEmpty(folderLocation)){
            return Collections.emptyList();
        }

        List<File> files = scanFolder.scan(folderLocation);
        return files.stream()
            .filter(file -> file.getName().endsWith(extension))
            .collect(toList());
    }
}
