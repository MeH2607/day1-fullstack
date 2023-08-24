package day1.day1demo2.api;

import day1.day1demo2.entity.Player;
import day1.day1demo2.repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    PlayerRepository playerRepository;
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    @GetMapping //Husk GetMapping altid sender data som json
    List<Player> getPlayers() {
        return  playerRepository.findAll();
    }
}

