package com.example.demo.application;

import com.example.demo.domain.exception.CardNotFoundException;
import com.example.demo.domain.exception.UserNotFoundException;
import com.example.demo.domain.model.Card;
import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.CardRepository;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    private final String propertySentence;

    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Autowired
    public CardController(@Value("${demo.sentence}") String propertySentence, CardRepository cardRepository, UserRepository userRepository) {
        this.propertySentence = propertySentence;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET )
    public String helloWorld(){
        return "Success!!";
    }

    @PostMapping(value = "/card/request")
    public void requestCard(@RequestBody final Card card) {
        System.out.println(card);
        cardRepository.save(card);
    }

    @GetMapping(value = "/card/requests")
    public List<Card> findCards() { return cardRepository.findAll();}

    @GetMapping(value = "/users")
    public List<User> findUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/card/accept/{userId}/{cardId}")
    public void assignCard(@PathVariable final long userId,
                             @PathVariable final long cardId){
        User owner = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Card card = cardRepository.findById(cardId).orElseThrow(() -> new CardNotFoundException(cardId));
        //userRepository.deleteById(userId);
        //userRepository.save(owner.setCards(
        //owner.getCards().add(card);

    }
}
