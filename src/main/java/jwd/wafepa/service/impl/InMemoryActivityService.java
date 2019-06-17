package jwd.wafepa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

public class InMemoryActivityService implements ActivityService {

	private Map<Long, Activity> activities = new HashMap<>();
	private long nextId = 1l;
	
	@Override
	public Activity findOne(Long id) {
		return activities.get(id);
	}

	@Override
	public List<Activity> findAll() {
//		List<Activity> retVal = new ArrayList<Activity>();
//		
//		for(Activity a : activities.values()) {
//			retVal.add(a);
//		}
//		
//		return retVal;
		
		return new ArrayList<>(activities.values());
	}

	@Override
	public Activity save(Activity activity) {
		if(activity.getId() == null) {
			activity.setId(nextId);
			nextId += 1l;
		}
		activities.put(activity.getId(), activity);
		return activity;
	}

	@Override
	public Activity remove(Long id) {
		if(!activities.containsKey(id)) {
			throw new IllegalArgumentException("Tried to remove"
					+ " non-existant activity.");
		}
		
		return activities.remove(id);
	}
	
	@Override
	public List<Activity> findByName(String name) {
		List<Activity> retVal = new ArrayList<Activity>();
		
		for(Activity a : activities.values()) {
			if (a.getName().equals(name)) {
				retVal.add(a);
			}
		}
		return retVal;
	}
	@Override
	public void saveAll(List<Activity> activity) {
		for (Activity activit : activity) {
			if (activit.getId() == null) {
				activit.setId(nextId);
				nextId +=1l;
			}
			activities.put(activit.getId(), activit);
		}
	}

	@Override
	public void removeAlls(List <Long> ids) {
		for(Long it : ids ) {
			activities.remove(it);
		}
		}
		

	}

	
	


