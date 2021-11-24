package is.hi.hbv501g2021supportsession.Persistence.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID; //Guid?

    private String WorkoutName; //Munum við þurfa þetta?

    private  Difficulty difficulty;
    private  WorkoutType workoutType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_id")
    private List<Exercise> exercises = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name="userFitnessInfo_id", nullable=false)
    private UserFitnessInfo userFitnessInfo;


    public Workout(String workoutName , UserFitnessInfo userFitnessInfo,Difficulty difficulty, List<Exercise> exercises, WorkoutType workoutType) {
        WorkoutName = workoutName;
        this.difficulty = difficulty;
        this.userFitnessInfo = userFitnessInfo;
        this.exercises = exercises;
        this.workoutType = workoutType;
    }

    public Workout() {
    }

    public long getID() {
        return ID;
    }

    public String getWorkoutName() {
        return WorkoutName;
    }

    public UserFitnessInfo getUserFitnessInfo(){return userFitnessInfo;}

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setWorkoutName(String workoutName) {
        WorkoutName = workoutName;
    }

    public void setUserFitnessInfo(UserFitnessInfo userFitnessInfo) {this.userFitnessInfo = userFitnessInfo;}

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
    }

    }


