package pitchtests;

import com.landeros.databaseinteraction.PitchDAO;
import com.landeros.databaseinteraction.PitchDAOImplemented;
import com.landeros.entities.Pitch;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PitchDAOTests {
    PitchDAO pitchDAO = new PitchDAOImplemented();

    @Test
    void viewPitches() {
        List<Pitch> pitches = pitchDAO.viewPitches();
        for (Pitch p : pitches) {
            System.out.println(p);
        }
        Assert.assertTrue(pitches.size() >= 1);
    }

    @Test
    void makeOffer() {
        boolean offer = pitchDAO.makeOffer(1, 100_000, 6.5);
        Assert.assertTrue(offer);
    }

    @Test
    void acceptOffer() {
        boolean accepted = pitchDAO.acceptOffer(1);
        Assert.assertTrue(accepted);
    }
}