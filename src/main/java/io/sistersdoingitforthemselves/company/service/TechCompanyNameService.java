package io.sistersdoingitforthemselves.company.service;

import io.sistersdoingitforthemselves.company.client.NounClient;
import io.sistersdoingitforthemselves.company.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TechCompanyNameService implements CompanyNameService {
    @Override
    public String getCompanyName() {
        // here's the basic logic for stripping out the last vowel...
        String noun = NounClient.getRandomNoun();
        int lastVowelIndex = StringUtils.lastIndexOfAny(noun, Constants.VOWELS);
        return noun.substring(0, lastVowelIndex) + noun.substring(lastVowelIndex + 1);
    }
}
