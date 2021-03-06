package is.hi.hbv501g2021supportsession.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String exerciseName;
    private int repetitions;
    private String duration;

    public Exercise() {
    }

    @ManyToOne
    @JoinColumn(name="workout_id", insertable = false,updatable = false)
    private Workout workout;

    public Exercise(String ExerciseName, int repetitions, String duration, Workout workout) {
        exerciseName = ExerciseName;
        this.repetitions = repetitions;
        this.duration = duration;
        this.workout = workout;
    }

    public Exercise(String ExerciseName, String duration, int repetitions) {
        exerciseName = ExerciseName;
        this.repetitions = repetitions;
        this.duration = duration;
    }

    public Exercise(String ExerciseName, int repetitions) {
        exerciseName = ExerciseName;
        this.repetitions = repetitions;
    }

    public Exercise(String ExerciseName, String duration) {
        exerciseName = ExerciseName;
        this.duration = duration;
    }



    public long getID() {
        return ID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public Workout getWorkout(){return workout;}

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setExerciseName(String ExerciseName) {
        exerciseName = ExerciseName;
    }

    public void setWorkout(Workout workout){this.workout = workout;}

    public String getDuration(){return this.duration;}

    public int getRepetitions(){return this.repetitions;}
}
