package is.hi.hbv501g2021supportsession.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String ExerciseName;

    public Exercise() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Workout workout;

    public Exercise(long ID, String exerciseName) {
        this.ID = ID;
        ExerciseName = exerciseName;
    }

    public long getID() {
        return ID;
    }

    public String getExerciseName() {
        return ExerciseName;
    }

    public Workout getWorkout(){return workout;}

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setExerciseName(String exerciseName) {
        ExerciseName = exerciseName;
    }

    public void setWorkout(Workout workout){this.workout = workout;}
}
