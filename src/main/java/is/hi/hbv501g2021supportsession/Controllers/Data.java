package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.*;
import is.hi.hbv501g2021supportsession.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Data {
    private WorkoutService workoutService;

    @Autowired
    public Data(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }


@GetMapping("/data")
public void workouts(){
    UserFitnessInfo userFitnessInfo1 = new UserFitnessInfo(2, WorkoutType.RUNNING, Difficulty.EASY);
    UserFitnessInfo userFitnessInfo2 = new UserFitnessInfo(2, WorkoutType.RUNNING, Difficulty.MEDIUM);
    UserFitnessInfo userFitnessInfo3 = new UserFitnessInfo(2, WorkoutType.RUNNING, Difficulty.HARD);
    UserFitnessInfo userFitnessInfo4 = new UserFitnessInfo(2, WorkoutType.SWIMMING, Difficulty.EASY);
    UserFitnessInfo userFitnessInfo5 = new UserFitnessInfo(2, WorkoutType.SWIMMING, Difficulty.MEDIUM);
    UserFitnessInfo userFitnessInfo6 = new UserFitnessInfo(2, WorkoutType.SWIMMING, Difficulty.HARD);
    UserFitnessInfo userFitnessInfo7 = new UserFitnessInfo(2, WorkoutType.WEIGHTLIFING, Difficulty.EASY);
    UserFitnessInfo userFitnessInfo8 = new UserFitnessInfo(2, WorkoutType.WEIGHTLIFING, Difficulty.MEDIUM);
    UserFitnessInfo userFitnessInfo9 = new UserFitnessInfo(2, WorkoutType.WEIGHTLIFING, Difficulty.HARD);

    Exercise e1 = new Exercise("Push ups", 5);
    Exercise e2 = new Exercise("Push ups", 10);
    Exercise e3 = new Exercise("Push ups", 20);

    Exercise e4 = new Exercise("Jog", "1 km");
    Exercise e5 = new Exercise("Jog", "5 km");
    Exercise e6 = new Exercise("Jog", "10 km");

    Exercise e7 = new Exercise("Stretches", "15 minutes");

    Exercise e8 = new Exercise("Swim", "500 m");
    Exercise e9 = new Exercise("Swim", "1 km");
    Exercise e10 = new Exercise("Swim", "5 km");

    Exercise e11 = new Exercise("Benchpress", "3x3");
    Exercise e12 = new Exercise("Benchpress", "4*4");
    Exercise e13 = new Exercise("Benchpress", "5*5");

    Exercise e14 = new Exercise("Squat", "3x3");
    Exercise e15 = new Exercise("Squat", "4*4");
    Exercise e16 = new Exercise("Squat", "5*5");




    List<Exercise> easyRunList = new ArrayList<Exercise>(){
        {add(e1); add(e4); add(e7);}
    };

    List<Exercise> mediumRunList = new ArrayList<Exercise>(){
        {add(e2); add(e5); add(e7);}
    };

    List<Exercise> hardRunList = new ArrayList<Exercise>(){
        {add(e3); add(e6); add(e7);}
    };

    List<Exercise> easySwimList = new ArrayList<Exercise>(){
        {add(e1); add(e8); add(e7);}
    };

    List<Exercise> mediumSwimList = new ArrayList<Exercise>(){
        {add(e2); add(e9); add(e7);}
    };

    List<Exercise> hardSwimList = new ArrayList<Exercise>(){
        {add(e3); add(e10); add(e7);}
    };

    List<Exercise> easyWeightliftingList = new ArrayList<Exercise>(){
        {add(e1); add(e11); add(e14); add(e7);}
    };

    List<Exercise> mediumWeightliftingList = new ArrayList<Exercise>(){
        {add(e2); add(e12); add(e15); add(e7);}
    };

    List<Exercise> hardWeightliftingList = new ArrayList<Exercise>(){
        {add(e3); add(e13); add(e16); add(e7);}
    };


    Workout easyRun = new Workout("Easy run", userFitnessInfo1, easyRunList);
    Workout mediumRun = new Workout("Medium run", userFitnessInfo2, mediumRunList);
    Workout hardRun = new Workout("Hard run", userFitnessInfo3, hardRunList);

    Workout easySwim = new Workout("Easy swim", userFitnessInfo4, easySwimList);
    Workout mediumSwim = new Workout("Medium swim", userFitnessInfo5, mediumSwimList);
    Workout hardSwim = new Workout("Hard swim", userFitnessInfo6, hardSwimList);

    Workout easyWeightlifting = new Workout("Easy weightlifting", userFitnessInfo7, easyWeightliftingList);
    Workout mediumWeightlifting = new Workout("Medium weightlifting", userFitnessInfo8, mediumWeightliftingList);
    Workout hardWeightlifting = new Workout("Hard weightlifting", userFitnessInfo9, hardWeightliftingList);

    workoutService.save(easyRun);
    workoutService.save(mediumRun);
    workoutService.save(hardRun);
    workoutService.save(easySwim);
    workoutService.save(mediumSwim);
    workoutService.save(hardSwim);
    workoutService.save(easyWeightlifting);
    workoutService.save(mediumWeightlifting);
    workoutService.save(hardWeightlifting);

}
}
