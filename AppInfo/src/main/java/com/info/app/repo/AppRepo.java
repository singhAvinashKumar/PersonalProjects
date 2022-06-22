package com.info.app.repo;

import com.info.app.model.AppInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AppRepo extends CrudRepository<AppInfo,Integer> {

}
