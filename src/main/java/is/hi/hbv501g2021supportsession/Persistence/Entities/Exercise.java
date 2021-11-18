package is.hi.hbv501g2021supportsession.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String exerciseName;

    public Exercise() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Workout workout;

    public Exercise(long ID, String ExerciseName) {
        this.ID = ID;
        exerciseName = ExerciseName;
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
}
