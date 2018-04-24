package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {
   SongRepository songRepo;
   ArtistRepository artRepo;

    @RequestMapping("/index")
    public String showIndex (Model model){
        model.addAttribute("songinventory", songRepo.findAll());
        return"index"  ;
    }
    @RequestMapping("/addsong")
    public  String addSong(Model model){
        model.addAttribute( "aSong", new Song());
        return"addsong" ;
    }
    @RequestMapping("/savesong")
    public  String saveSong(@Valid @ModelAttribute("aSong") Song toSave, BindingResult result){
        if (result.hasErrors()){
            return"addsong";
        }
        return"index" ;
    }

    @RequestMapping("/addartist")
    public  String addArtist(Model model){
        model.addAttribute( "aArtist", new Artist());
        return"addartist" ;
    }
    @RequestMapping("/saveartist")
    public  String saveArtist(@Valid @ModelAttribute("aArtist") Artist toSave, BindingResult result){
        if (result.hasErrors()){
            return"addartist";
        }

        if(toSave.getImage().isEmpty())
            toSave.setImage("/img/tedy.jpg");
        artRepo.save (toSave);
        return"index" ;
    }

}
