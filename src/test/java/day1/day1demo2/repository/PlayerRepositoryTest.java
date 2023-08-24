package day1.day1demo2.repository;

import day1.day1demo2.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
//@SpringBootTest
//@AutoConfigureTestDatabase
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;
    boolean isInitialized = false;
    @BeforeEach
    void setUp() {
        if(!isInitialized){
            playerRepository.deleteAll();
            playerRepository.save(new Player("Cristiano Ronaldo", "Portugal", "Forward"));
            playerRepository.save(new Player("Lionel Messi", "Argentina", "Forward"));
            playerRepository.save(new Player("Antoine Griezmann", "France", "Forward"));
            playerRepository.save(new Player("Mohamed Salah", "Egypt", "Forward"));
            playerRepository.save(new Player("Neymar", "Brazil", "Forward"));
            playerRepository.save(new Player("Kevin de Bruyne", "Belgium", "Midfielder"));
            isInitialized = true;
        }
    }

    @Test
    public void testAll(){
        Long count = playerRepository.count();
        assertEquals(6,count);
    }

    @Test
    public void testFind(){
        Player player = playerRepository.findByName("Cristiano Ronaldo");
        assertEquals("Cristiano Ronaldo",player.getName());
    }

    @Test
    public void testFindByNameLike(){
        Player player = playerRepository.findByNameLike("%Cristiano%");
        assertEquals("Cristiano Ronaldo", player.getName());
    }
}