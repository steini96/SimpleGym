package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.*;
import is.hi.hbv501g2021supportsession.Services.UserService;
import is.hi.hbv501g2021supportsession.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@RestController
public class Data {
    private WorkoutService workoutService;
    private UserService userService;

    @Autowired
    public Data(WorkoutService workoutService, UserService userService) {
        this.workoutService = workoutService;
        this.userService = userService;
    }


@GetMapping("/data")
public void workouts(){

        byte[] a = {1, 2};



    LoginInfo l1 = new LoginInfo("pass");
    LoginInfo l2 = new LoginInfo("pass");
    LoginInfo l3 = new LoginInfo("pass");
    LoginInfo l4 = new LoginInfo("pass");
    LoginInfo l5 = new LoginInfo("pass");
    LoginInfo l6 = new LoginInfo("pass");
    LoginInfo l7 = new LoginInfo("pass");
    LoginInfo l8 = new LoginInfo("pass");
    LoginInfo l9 = new LoginInfo("pass");

    UserFitnessInfo userFitnessInfo1 = new UserFitnessInfo(2, WorkoutType.RUNNING, Difficulty.EASY);
    UserFitnessInfo userFitnessInfo2 = new UserFitnessInfo(2, WorkoutType.RUNNING, Difficulty.MEDIUM);
    UserFitnessInfo userFitnessInfo3 = new UserFitnessInfo(2, WorkoutType.RUNNING, Difficulty.HARD);
    UserFitnessInfo userFitnessInfo4 = new UserFitnessInfo(2, WorkoutType.SWIMMING, Difficulty.EASY);
    UserFitnessInfo userFitnessInfo5 = new UserFitnessInfo(2, WorkoutType.SWIMMING, Difficulty.MEDIUM);
    UserFitnessInfo userFitnessInfo6 = new UserFitnessInfo(2, WorkoutType.SWIMMING, Difficulty.HARD);
    UserFitnessInfo userFitnessInfo7 = new UserFitnessInfo(2, WorkoutType.WEIGHTLIFING, Difficulty.EASY);
    UserFitnessInfo userFitnessInfo8 = new UserFitnessInfo(2, WorkoutType.WEIGHTLIFING, Difficulty.MEDIUM);
    UserFitnessInfo userFitnessInfo9 = new UserFitnessInfo(2, WorkoutType.WEIGHTLIFING, Difficulty.HARD);

    userService.saveUserFitnessInfo(userFitnessInfo1);
    userService.saveUserFitnessInfo(userFitnessInfo2);
    userService.saveUserFitnessInfo(userFitnessInfo3);
    userService.saveUserFitnessInfo(userFitnessInfo4);
    userService.saveUserFitnessInfo(userFitnessInfo5);
    userService.saveUserFitnessInfo(userFitnessInfo6);
    userService.saveUserFitnessInfo(userFitnessInfo7);
    userService.saveUserFitnessInfo(userFitnessInfo8);
    userService.saveUserFitnessInfo(userFitnessInfo9);


    User u1 = new User("user 1", "tfj1@hi.is",l1, userFitnessInfo1);
    User u2 = new User("user 2", "tfj2@hi.is",l2, userFitnessInfo2);
    User u3 = new User("user 3", "tfj3@hi.is",l3, userFitnessInfo3);
    User u4 = new User("user 4", "tfj4@hi.is",l4, userFitnessInfo4);
    User u5 = new User("user 5", "tfj5@hi.is",l5, userFitnessInfo5);
    User u6 = new User("user 6", "tfj6@hi.is",l6, userFitnessInfo6);
    User u7 = new User("user 7", "tfj7@hi.is",l7, userFitnessInfo7);
    User u8 = new User("user 8", "tfj8@hi.is",l8, userFitnessInfo8);
    User u9 = new User("user 9", "tfj9@hi.is",l9, userFitnessInfo9);

    User n1 = userService.hashPassword(u1);
    User n2 = userService.hashPassword(u2);
    User n3 = userService.hashPassword(u3);
    User n4 = userService.hashPassword(u4);
    User n5 = userService.hashPassword(u5);
    User n6 = userService.hashPassword(u6);
    User n7 = userService.hashPassword(u7);
    User n8 = userService.hashPassword(u8);
    User n9 = userService.hashPassword(u9);

    userService.saveLoginInfo(l1);
    userService.saveLoginInfo(l2);
    userService.saveLoginInfo(l3);
    userService.saveLoginInfo(l4);
    userService.saveLoginInfo(l5);
    userService.saveLoginInfo(l6);
    userService.saveLoginInfo(l7);
    userService.saveLoginInfo(l8);
    userService.saveLoginInfo(l9);



    userService.saveUser(n1);
    userService.saveUser(n2);
    userService.saveUser(n3);
    userService.saveUser(n4);
    userService.saveUser(n5);
    userService.saveUser(n6);
    userService.saveUser(n7);
    userService.saveUser(n8);
    userService.saveUser(n9);


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
