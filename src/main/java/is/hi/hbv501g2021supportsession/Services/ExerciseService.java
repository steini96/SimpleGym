package is.hi.hbv501g2021supportsession.Services;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Exercise;
import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;

import java.util.List;

public interface ExerciseService {

    List<Exercise> findAll();

    /*List<Workout> findAllByfinAllByUSER_FITNESS_INFO_ID(long USER_FITNESS_INFO_ID);
    List<Exercise> findAllByWORKOUT_ID(long WORKOUT_ID);*/

}

