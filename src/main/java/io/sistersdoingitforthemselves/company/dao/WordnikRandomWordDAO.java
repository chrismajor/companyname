package io.sistersdoingitforthemselves.company.dao;

import com.wordnik.client.common.ApiException;
import com.wordnik.client.common.ApiInvoker;
import com.wordnik.client.model.WordObject;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class WordnikRandomWordDAO implements RandomWordDAO {

    private ApiInvoker apiInvoker = ApiInvoker.getInstance();

    @Override
    public String getRandomWord(String wordType) throws ApiException {

        // TODO: pull all of these values from properties file
        String basePath = "http://api.wordnik.com/v4";
        String path = "/words.json/randomWord";
        String apiKey = "a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";
        String excludePartOfSpeech = "null";
        String hasDictionaryDef = "false";
        Integer minCorpusCount = 0;
        Integer maxCorpusCount = -1;
        Integer minDictionaryCount = 1;
        Integer maxDictionaryCount = -1;
        Integer minLength = 4;
        Integer maxLength = 12;

        // query params
        Map<String, String> queryParams = new HashMap<>();

        this.mapQueryParam(queryParams, "hasDictionaryDef", hasDictionaryDef);
        this.mapQueryParam(queryParams, "includePartOfSpeech", wordType);
        this.mapQueryParam(queryParams, "excludePartOfSpeech", excludePartOfSpeech);
        this.mapQueryParam(queryParams, "minCorpusCount", String.valueOf(minCorpusCount));
        this.mapQueryParam(queryParams, "maxCorpusCount", String.valueOf(maxCorpusCount));
        this.mapQueryParam(queryParams, "minDictionaryCount", String.valueOf(minDictionaryCount));
        this.mapQueryParam(queryParams, "maxDictionaryCount", String.valueOf(maxDictionaryCount));
        this.mapQueryParam(queryParams, "minLength", String.valueOf(minLength));
        this.mapQueryParam(queryParams, "maxLength", String.valueOf(maxLength));

        queryParams.put("api_key", apiKey);

        // TODO: tidy up this error handling - logging, throw exception instead of null value
        try {
            String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, new HashMap<>());
            return response == null ? null : ((WordObject) ApiInvoker.deserialize(response, "", WordObject.class)).getWord();
        }
        catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }

    private void mapQueryParam(Map<String, String> map, String paramName, String paramValue) {
        if(paramValue != null && paramValue != "null") {
            map.put(paramName, paramValue);
        }
    }
}
