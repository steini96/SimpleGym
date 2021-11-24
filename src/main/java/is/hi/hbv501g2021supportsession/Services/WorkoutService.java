package is.hi.hbv501g2021supportsession.Services;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Exercise;
import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;

import java.util.List;

public interface WorkoutService {

    Workout save(Workout workout); //adds a workout
    Exercise save(Exercise exercise);
    void delete(Workout workout);//deletes workout
    List<Workout> findAll();
    Workout findByID(long id);

}
