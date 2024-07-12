package com.rude.monthly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
      @Autowired
    ChallengeRepository challengeRepository;
    //   private List<Challenge> challenges= new ArrayList<>();

    private Long nextId = 1L;


//    public  ChallengeService(){
//        Challenge challenge1=new Challenge(1L,"jan","first");
//        challenges.add(challenge1);
//    }

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    public boolean addchallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challengeRepository.save(challenge);
            return true;
        } else return false;
    }

    public Challenge getchallenge(String month) {
        Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
        return challenge.orElse(null);

//        for (Challenge cha: challenges) {
//            if(cha.getMonth().equalsIgnoreCase(month)) return cha;
//        }
    }

    public boolean updateChallenge(Long id, Challenge updatechallenge) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent()) {
            Challenge challengeUpdate = challenge.get();
            challengeUpdate.setMonth(updatechallenge.getMonth());
            challengeUpdate.setDescription(updatechallenge.getDescription());
            challengeRepository.save(challengeUpdate);
            return true;
        }
        return false;
//        for (Challenge cha: challenges) {
//            if(cha.getId().equals(id)){
//                cha.setMonth(updatechallenge.getMonth());
//                cha.setDescription(updatechallenge.getDescription());
//                return true;
//            }
//        }
//        return false;
    }

    public boolean deleteChallenge(Long id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent()) {
            challengeRepository.deleteById(id);
            return true;
        }
        return false;
//      return  challenges.removeIf(challenge -> challenge.getId().equals(id));
    }
}