package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

/*	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "Science", "Science"),
			new Topic("2", "Maths", "Maths"), new Topic("3", "English", "English"), new Topic("4", "IT", "IT")));*/

	public List<Course> getAllCourses(String id) {
		return courseRepository.findByTopicId(id);
		//return topics;
	}

	public Course getCourse(String id) {
		return courseRepository.findOne(id);
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		//topics.add(topic);
	}

	public void updateCourse(Course topic) {
		courseRepository.save(topic);
/*		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
			}
		}*/
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
		//topics.removeIf(t -> t.getId().equals(id));
	}

}
