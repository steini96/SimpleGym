package is.hi.hbv501g2021supportsession.Services;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Exercise;
import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;

import java.util.List;

public interface WorkoutService {

    Workout save(Workout workout); //adds a workout
    Exercise save(Exercise exercise);
    void delete(Workout workout);//deletes workout
    List<Workout> findAll();
    // List<Workout> findAllWorkout();
    // List<Exercise> findAll(String strengur);
    Workout findByID(long id);

    /*List<Workout> findAllByfinAllByUSER_FITNESS_INFO_ID(long USER_FITNESS_INFO_ID);
    List<Exercise> findAllByWORKOUT_ID(long WORKOUT_ID);*/

}
