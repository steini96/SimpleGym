package is.hi.hbv501g2021supportsession.Services.Implementation;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;
import is.hi.hbv501g2021supportsession.Persistence.Repositories.WorkoutRepository;
import is.hi.hbv501g2021supportsession.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class WorkoutServiceImplementation implements WorkoutService {
    private WorkoutRepository workoutRepository; //make workout repo

    @Autowired
    public WorkoutServiceImplementation(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Workout addWorkout(Workout workout){
        return workoutRepository.save(workout);
    } //held að þetta noti innbyggt save fall í JPA repository

    @Override
    public void deleteWorkout(Workout workout) {
        workoutRepository.delete(workout);
    } //held að þetta eigi að nota innbyggt delete fall í JPA repository

    @Override
    public Workout changeWorkout(Workout workout){
        return workoutRepository.changeWorkout(workout);
    } //implementa þetta method

}
