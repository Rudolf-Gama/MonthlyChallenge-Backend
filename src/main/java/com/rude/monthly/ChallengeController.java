package com.rude.monthly;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping(("/challenges"))
@CrossOrigin(origins = "http://localhost:3000")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges(){
       return   new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addchallenge(@RequestBody Challenge challenge){
         boolean isadded=challengeService.addchallenge(challenge);
         if(isadded)
        return new  ResponseEntity<>("challenge added successfully",HttpStatus.OK);
        else return new  ResponseEntity<>("challenge not added successfully",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getchallenge(@PathVariable String month){
        Challenge challenge= challengeService.getchallenge(month);
        if(challenge!=null) return new ResponseEntity<>(challenge,HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatechallenge){
        boolean isupdated = challengeService.updateChallenge(id,updatechallenge);
        if(isupdated)
            return new ResponseEntity<>("Challenge Updated",HttpStatus.OK);
        else return new ResponseEntity<>("Challenge not updated",HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isdeleted = challengeService.deleteChallenge(id);
        if(isdeleted)
            return new ResponseEntity<>("Challenge deleted",HttpStatus.OK);
        else return new ResponseEntity<>("Challenge not deleted",HttpStatus.NOT_FOUND);
    }

}
