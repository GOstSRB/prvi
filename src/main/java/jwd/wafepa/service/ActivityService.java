package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Activity;

public interface ActivityService {
	
	Activity findOne(Long id);
	List<Activity> findAll();
	Activity save(Activity activity);
	Activity remove(Long id);
	
	List<Activity> findByName(String name);
	void saveAll(List<Activity> activity);
	void removeAlls(List<Long> id);
}
