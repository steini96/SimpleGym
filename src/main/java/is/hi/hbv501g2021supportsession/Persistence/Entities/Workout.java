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

    @OneToMany(mappedBy = "workouts", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exercises = new ArrayList<>();

    public Workout(long ID, String workoutName, List<Exercise> exercises) {
        this.ID = ID;
        WorkoutName = workoutName;
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

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setWorkoutName(String workoutName) {
        WorkoutName = workoutName;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
