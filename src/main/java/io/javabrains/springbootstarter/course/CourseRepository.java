package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {

	public List<Course> findByName(String name);

	public List<Course> findByDescription(String description);
	
	public List<Course> findByTopicId(String id);

}
