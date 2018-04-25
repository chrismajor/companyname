package io.sistersdoingitforthemselves.company.dao;

import com.wordnik.client.common.ApiException;

public interface RandomWordDAO {
    String getRandomWord(String wordType) throws ApiException;
}
