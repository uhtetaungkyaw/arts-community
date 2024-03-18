package com.art.artscommunity.repo;

import com.art.artscommunity.model.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepo extends JpaRepository<Art,Integer> {

}
