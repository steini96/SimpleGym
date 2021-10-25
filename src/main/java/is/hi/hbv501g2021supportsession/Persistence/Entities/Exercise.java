package is.hi.hbv501g2021supportsession.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String ExerciseName;

    public Exercise() {
    }

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

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setExerciseName(String exerciseName) {
        ExerciseName = exerciseName;
    }
}
