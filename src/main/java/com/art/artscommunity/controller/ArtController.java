package com.art.artscommunity.controller;

import com.art.artscommunity.model.Art;
import com.art.artscommunity.model.OrderDetail;
import com.art.artscommunity.repo.OrderRepo;
import com.art.artscommunity.service.ArtService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArtController {
    private final ArtService artService;
    @Autowired
    private OrderRepo orderRepo;
    public ArtController(ArtService artService){
        this.artService = artService;
    }
    @GetMapping("/ArtList")
    public String artshelf(Model model) {

        List<Art> artList = artService.findAll();
        model.addAttribute("artList", artList);
        return "artList";
    }

    @RequestMapping("/artDetail")
    public String artDetail(
            @PathParam("id") int id, Model model) {

        Art art = artService.findById(id);
        model.addAttribute("art", art);
        return "artDetail";
    }

    @GetMapping("/artEdit")
    public String showArtEdit(Model model) {
        model.addAttribute("art", artService.findAll());
        return "artEdit";
    }

    @GetMapping("/artEdit/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Art art = artService.findById(id);
        model.addAttribute("art", art);
        return "artUpdate";
    }

    @PostMapping("/update/{id}")
    public String updateArt(@PathVariable int id, @Valid Art art, BindingResult result) {
        if (result.hasErrors()) {
            art.setId(id);
            return "artUpdate";
        }
        artService.save(art);
        return "redirect:/artEdit";
    }

    @GetMapping("/artDelete/{id}")
    public String deleteArt(@PathVariable int id) {
        Art art = artService.findById(id);
        artService.delete(art);
        return "redirect:/artEdit";
    }

    @GetMapping("/artAdd")
    public String showArtAddForm(){
        return "artAdd";
    }

    @PostMapping("/art-add")
    public String showArtAddPost(@ModelAttribute @Valid Art art, BindingResult result){
        if (result.hasErrors()){
            return "artAdd";
        }
        artService.save(art);
        return "redirect:/artList";
    }

    @GetMapping("/orderList")
    public String showOrderArtList(Model model){
        List<OrderDetail> orderList = orderRepo.findAll();
        model.addAttribute("orderList", orderList);
        return "orderList";
    }

    @ModelAttribute("art")
    public Art art(){ return new Art();}
}
