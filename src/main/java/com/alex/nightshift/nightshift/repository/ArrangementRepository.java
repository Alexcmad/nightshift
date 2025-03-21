package com.alex.nightshift.nightshift.repository;

import com.alex.nightshift.nightshift.entity.Arrangement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArrangementRepository extends JpaRepository<Arrangement, Long> {
    List<Arrangement> findByGenre(String genre);

}
