package is.hi.hbv501g2021supportsession.Persistence.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userFitnessInfo")
public class UserFitnessInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;

    private int numWeeklyWrkOut;
    private  Difficulty difficulty;
    private  WorkoutType workoutType;


    @OneToMany(mappedBy = "userFitnessInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Workout> workouts = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID"/*, nullable = true*/)
    User user;


    public UserFitnessInfo() {
    }

    public UserFitnessInfo(int numWeeklyWrkOut, WorkoutType workoutType, Difficulty difficulty, List<Workout> workouts) {
        this.numWeeklyWrkOut = numWeeklyWrkOut;
        this.workoutType = workoutType;
        this.difficulty = difficulty;
        this.workouts = workouts;
    }
    public UserFitnessInfo(int numWeeklyWrkOut) {
        this.numWeeklyWrkOut = numWeeklyWrkOut;
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
    public void setId(Long ID) {
        this.ID = ID;
    }

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
}
