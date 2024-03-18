package com.art.artscommunity.repo;

import com.art.artscommunity.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetail,Integer> {

}
