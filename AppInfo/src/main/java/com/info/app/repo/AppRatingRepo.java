package com.info.app.repo;

import com.info.app.model.AppRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AppRatingRepo extends CrudRepository<AppRating, Integer> {

}
