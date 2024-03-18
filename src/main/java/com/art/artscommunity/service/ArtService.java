package com.art.artscommunity.service;

import com.art.artscommunity.model.Art;
import com.art.artscommunity.repo.ArtRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtService {
    private final ArtRepo artRepo;
    public ArtService(ArtRepo artRepo) {
        this.artRepo = artRepo;
    }

    public List<Art> findAll() {
        return artRepo.findAll();
    }
    public void save(Art art){
        artRepo.save(art);
    }
    public void delete(Art art){
        artRepo.delete(art);
    }
    public Art findById(Integer id){
        return artRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("INVALID ID "+id));
    }

}
