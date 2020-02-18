package com.galvanize.gmdbmovies.repositories;

import com.galvanize.gmdbmovies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieJpaRepository extends JpaRepository<Movie, Long> {

}
