package jwd.wafepa.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.impl.InMemoryActivityService;

public class InMemoryActivityServiceTest {

	private ActivityService activityService;
	
	@Before
	public void setUp() {
		activityService = new InMemoryActivityService();
		
		Activity swimming = new Activity("Swimming");
		Activity running = new Activity("Running");
		
		activityService.save(swimming);
		activityService.save(running);
	}
	
	@Test
	public void testFindOne() {
		Activity activity = activityService.findOne(2l);
		Assert.assertEquals("Running", activity.getName());
	}
	
	@Test
	public void testFindAll() {
		List<Activity> result = activityService.findAll();
		Assert.assertEquals(2, result.size());	
	}
	@Test
	public void testFindByNamePogresnoUnesenaVrednost() {
		List<Activity> result = activityService.findByName("Falling");
		Assert.assertEquals(0, result.size());
		
	}
	@Test
	public void testFindByName() {
		List<Activity> result = activityService.findByName("Swimming");
		Assert.assertEquals(1, result.size());
	}
	@Test
	public void testSaveAll() {
		
		Activity jumping = new Activity("Jumping");
		Activity climbing = new Activity ("Climbing");
		Activity plugin = new Activity ("Plugin");
		List<Activity> res = new ArrayList<>();
		res.add(jumping);
		res.add(climbing);
		res.add(plugin);
		activityService.saveAll(res);
		Assert.assertEquals(3, res.size());
		
		List<Activity> results = activityService.findAll();
		Assert.assertEquals(5, results.size());	
	}
	@Test
	public void remove() {
		activityService.remove(1l);
		List<Activity> result = activityService.findAll();
		Assert.assertEquals(1, result.size());
	}
	
	@Test
	public void testRemoveIds () {
//		Activity plugin = new Activity ("Plugin");
//		Activity jumping = new Activity("Jumping");
//		List<Activity> result = new ArrayList<>();
//		result.add(plugin);
//		result.add(jumping);
		
		
		List <Long> ids = new ArrayList<>();
		ids.add(10l);
		ids.add(20l);
		
//		Activity activity = activityService.findOne(2l);
//		Assert.assertEquals("Running", activity.getName());
		
		activityService.removeAlls(ids);
		Assert.assertEquals(2, ids.size());
	}
}
