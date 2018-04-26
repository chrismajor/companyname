package io.sistersdoingitforthemselves.company.service;

import io.sistersdoingitforthemselves.company.util.Constants;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Service for generating random ASCII faces
 */
@Service
public class FaceServiceImpl implements FaceService {

    // TODO: pull this from properties file
    private final int DEFAULT_FACE_CHANCE = 40;

    /**
     * Return a random ASCII face!
     *
     * Get the default one about 40% of the time, otherwise grab one at random from the face list
     * @return a rad ASCII face
     */
    @Override
    public String getRandomFace() {
        if (getRandomNum(100) <= DEFAULT_FACE_CHANCE) {
            return Constants.DEFAULT_FACE;
        }
        else {
            int randomIndex = getRandomNum(Constants.FACES.length);
            return Constants.FACES[randomIndex];
        }
    }

    private int getRandomNum(int upperLimit) {
        return Math.abs(new Random().nextInt()) % upperLimit;
    }
}
