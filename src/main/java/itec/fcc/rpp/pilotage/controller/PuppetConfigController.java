package itec.fcc.rpp.pilotage.controller;

import itec.fcc.rpp.pilotage.service.DictionaryPuppet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by gael on 03/04/2018.
 */
@RestController
@RequestMapping("/puppet")
public class PuppetConfigController {

    private final DictionaryPuppet dictionaryPuppet;

    @Inject
    public PuppetConfigController(DictionaryPuppet dictionaryPuppet) {
        this.dictionaryPuppet = dictionaryPuppet;
    }

    @GetMapping
    public Map<String, List<String>> computePuppetConfig(@RequestParam(value = "repository") String repository,
                                                         @RequestParam(value = "extensions") Set<String> extensions, @RequestParam(value = "regex") String regex) throws Exception {
        return dictionaryPuppet.computePuppetKeysByExtension(repository, extensions, regex);
    }
}
