package is.hi.hbv501g2021supportsession.Persistence.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UserFitnessInfo")
public class UserFitnessInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private int numWeeklyWrkOut;
    private enum Difficulty{Easy, Medium, Hard};
    private enum WorkoutType{Running, Weightlifting, Swimming};
    WorkoutType workoutType;
    Difficulty difficulty;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Workout> workouts = new ArrayList<>();

    public UserFitnessInfo() {
    }

    public UserFitnessInfo(int numWeeklyWrkOut, WorkoutType workoutType, Difficulty difficulty, List<Workout> workouts) {
        this.numWeeklyWrkOut = numWeeklyWrkOut;
        this.workoutType = workoutType;
        this.difficulty = difficulty;
        this.workouts = workouts;
    }

    public int getNumWeeklyWrkOut() {
        return numWeeklyWrkOut;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setId(Long ID) {
        this.ID = ID;
    }

    @Id
    public Long getId() {
        return ID;
    }

    public void setNumWeeklyWrkOut(int numWeeklyWrkOut) {
        this.numWeeklyWrkOut = numWeeklyWrkOut;
    }

    public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
