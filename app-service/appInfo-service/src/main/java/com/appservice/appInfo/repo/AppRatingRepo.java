package com.appservice.appInfo.repo;

import com.appservice.appInfo.model.AppRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AppRatingRepo extends CrudRepository<AppRating, Integer> {

}
