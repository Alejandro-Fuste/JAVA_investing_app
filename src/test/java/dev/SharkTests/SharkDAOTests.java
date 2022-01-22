package dev.SharkTests;

import com.investing_app.dao.SharkDAO;
import com.investing_app.dao.SharkDAOImplemented;
import com.investing_app.entities.Shark;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SharkDAOTests {
    SharkDAO sharkDAO = new SharkDAOImplemented();

    @Test
    void sharkCreateProfile() {
        Shark shark1 = new Shark(0, "Ashton", "Kutcher", "Ashy Enterprises244",
                "ButterflyEffect54", "70sShow", "Shark");
        Shark returnedShark = sharkDAO.createSharkProfile(shark1);
        Assert.assertTrue(returnedShark.getSharkId() != 0);
    }

    @Test
    void getSharkByUsername() {
        Shark returnedShark = sharkDAO.getSharkByUsername("Spiderman");
        Assert.assertEquals(returnedShark.getUsername(), "Spiderman");
    }

    @Test
    void getAllSharks() {
        List<Shark> sharks = sharkDAO.getAllSharks();
        for (Shark s : sharks)
            System.out.println(s);
        Assert.assertTrue(sharks.size() >= 1);
    }
}
