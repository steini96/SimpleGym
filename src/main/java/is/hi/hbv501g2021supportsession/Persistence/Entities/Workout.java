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


    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exercises = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    private UserFitnessInfo userFitnessInfo;



    public Workout(long ID, String workoutName , UserFitnessInfo userFitnessInfo) {
        this.ID = ID;
        WorkoutName = workoutName;
        this.userFitnessInfo = userFitnessInfo;
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
