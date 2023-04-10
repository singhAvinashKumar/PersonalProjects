package com.appservice.appInfo.repo;

import com.appservice.appInfo.model.AppInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AppRepo extends CrudRepository<AppInfo,Integer> {

}
