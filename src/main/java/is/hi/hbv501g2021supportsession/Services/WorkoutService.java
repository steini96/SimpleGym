package is.hi.hbv501g2021supportsession.Services;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;

public interface WorkoutService {
    Workout addWorkout(Workout workout); //adds a workout
    void deleteWorkout(Workout workout);//deletes workout
    Workout changeWorkout(Workout workout);//changes a workout's reps for example
}
