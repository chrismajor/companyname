package io.sistersdoingitforthemselves.company.service;

import com.wordnik.client.common.ApiException;
import io.sistersdoingitforthemselves.company.dao.RandomWordDAO;
import io.sistersdoingitforthemselves.company.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechCompanyNameService implements CompanyNameService {

    @Autowired
    private RandomWordDAO randomWordDAO;

    @Override
    public String getCompanyName() {
        // here's the basic logic for stripping out the last vowel...

        try {
            String noun = randomWordDAO.getRandomWord("noun");
            int lastVowelIndex = StringUtils.lastIndexOfAny(noun, Constants.VOWELS);
            return noun.substring(0, lastVowelIndex) + noun.substring(lastVowelIndex + 1);
        }
        catch (ApiException e) {
            // TODO: proper error handling
            System.out.println("It bad :/");
            return "poop";
        }
    }
}
