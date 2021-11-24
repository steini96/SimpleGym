package is.hi.hbv501g2021supportsession.Services.Implementation;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Exercise;
import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;
import is.hi.hbv501g2021supportsession.Persistence.Repositories.ExerciseRepository;
import is.hi.hbv501g2021supportsession.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseServiceImplementation implements ExerciseService {
    private ExerciseRepository exerciseRepository; //make workout repo

    @Autowired
    public ExerciseServiceImplementation(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<Exercise> findAll(){
        return exerciseRepository.findAll();
    }


    /*@Override
    public List<Exercise> findAll(String strengur){
        return workoutRepository.findAll(strengur);
    }*/

    /*@Override
    public List<Workout> findAllByfinAllByUSER_FITNESS_INFO_ID(long USER_FITNESS_INFO_ID){
        return workoutRepository.findAllByfinAllByUSER_FITNESS_INFO_ID(USER_FITNESS_INFO_ID);
    }

    @Override
    public List<Exercise> findAllByWORKOUT_ID(long WORKOUT_ID){
        return workoutRepository.findAllByWORKOUT_ID(WORKOUT_ID);
    }*/

}