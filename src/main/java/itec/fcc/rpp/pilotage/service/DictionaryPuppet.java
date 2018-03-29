package itec.fcc.rpp.pilotage.service;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by gael on 29/03/2018.
 */
public class DictionaryPuppet {

    public Map<String, List<String>> computePuppetKeysByExtension(String repository, Set<String> extentions,
                                                                  String regexPattern) {
        if(isEmptyArguments(repository, extentions, regexPattern)){
            return Collections.EMPTY_MAP;
        }
        return null; //Collections.singletonMap("txt", Collections.EMPTY_LIST);
    }

    private boolean isEmptyArguments(String repository, Set<String> extentions, String regexPattern) {
        return StringUtils.isEmpty(repository) || CollectionUtils.isEmpty(extentions) || StringUtils.isEmpty(regexPattern);
    }
}
