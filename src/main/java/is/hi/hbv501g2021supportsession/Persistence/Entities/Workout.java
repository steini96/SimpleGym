package is.hi.hbv501g2021supportsession.Persistence.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID; //Guid?

    private String WorkoutName; //Munum við þurfa þetta?
    private  Difficulty difficulty;
    private  WorkoutType workoutType;


    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exercises = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    private UserFitnessInfo userFitnessInfo;



    public Workout(String workoutName , UserFitnessInfo userFitnessInfo, List<Exercise> exercises) {
        WorkoutName = workoutName;
        this.userFitnessInfo = userFitnessInfo;
        this.exercises = exercises;
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


    }

