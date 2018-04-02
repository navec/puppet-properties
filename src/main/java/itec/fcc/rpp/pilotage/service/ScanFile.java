package itec.fcc.rpp.pilotage.service;

import javax.inject.Named;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gael on 02/04/2018.
 */
@Named
public class ScanFile {

    public List<String> findKeysInFilesWithPattern(List<File> files, String regexPattern) {
        List<String> keysFound = new ArrayList<>();
        files.stream().forEach(file -> {
            if (file.exists()) {
                try {
                    keysFound.addAll(getKeys(file, regexPattern));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return keysFound;
    }

    private List<String> getKeys(File file, String regexPattern) throws IOException {
        final String regexFormatted = regexPattern.replace("{", "\\{");
        try {
            List<String> keys = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile(regexFormatted);
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()){
                    keys.add(matcher.group(1));
                }
            }
            return keys;
        } catch (IOException e) {
            throw new IOException("toDoComplete");
        }
    }
}
