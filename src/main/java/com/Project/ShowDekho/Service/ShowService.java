package com.Project.ShowDekho.Service;

import com.Project.ShowDekho.DAO.Show;
import com.Project.ShowDekho.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    private final ShowRepository showRepository;

    @Autowired
    public ShowService(ShowRepository showRepository) { this.showRepository = showRepository; }

    public Show addNewShow(Show show){
        show.setCreatedAt(LocalDateTime.now());
        show.setUpdatedAt(LocalDateTime.now());
        return showRepository.save(show);
    }

    public List<Show> getShows(){
        return showRepository.findAll();
    }

    public List<Show> getShowByMovieId(Integer movieId){
        LocalDate curDate = LocalDate.now();
        return showRepository.getShowByMovieId(movieId, curDate);
    }
}
