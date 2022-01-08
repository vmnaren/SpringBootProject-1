package com.vmn.bootjpa.controller;

import com.vmn.bootjpa.repository.AlienRepo;
import com.vmn.bootjpa.entity.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class AlienController {
    @Autowired
    AlienRepo repo;

    @GetMapping("/")
    public String getHome(@RequestParam Optional<Map<String,String>> allParams){
        return "In Home Page";
    }

    //Using ModelAndView jsp and returning mv
    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid){
        ModelAndView mv = new ModelAndView("ShowAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        mv.addObject(alien);
        return mv;
    }

    //No Model View
    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
        repo.save(alien);
        repo.findById(101);
        return "In Home Page";
    }

    //No Model View
    @GetMapping(path = "/aliens",produces = {"application/json"})
    @ResponseBody
    public List<Alien> getAliensAsResource(){
        return repo.findAll();
    }

    //No Model View
    @GetMapping("/alien/{aid}")
    @ResponseBody
    public Optional<Alien> getAliensAsResourceById(@PathVariable("aid") int aid){
        return repo.findById(aid);
    }

    //No Model View
    //RequestBody is to accept as raw post body
    @PostMapping(path = "/postalien", consumes = {"application/json"})
    public Alien postAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }

    //No Model View
    //RequestBody is to accept as raw post body
    @DeleteMapping(path = "/delete")
    public String deleteAlien( @PathVariable("aid") int aid){

        Alien alien = repo.getOne(aid);
        repo.delete(alien);
       return "Deleted";
    }

    //No Model View
    //RequestBody is to accept as raw post body
    @PutMapping(path = "/putalien", consumes = "application/json")
    public Alien updateAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }
}
