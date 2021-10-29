package is.hi.hbv501g2021supportsession.Persistence.Repositories;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    Workout addWorkout(Workout workout);
    void deleteWorkout(Workout workout);
    Workout changeWorkout(Workout workout);
}
