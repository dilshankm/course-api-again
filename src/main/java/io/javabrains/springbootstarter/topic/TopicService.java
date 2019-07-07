package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "Science", "Science"),
			new Topic("2", "Maths", "Maths"), new Topic("3", "English", "English"), new Topic("4", "IT", "IT")));

	public List<Topic> getAllTopics() {
		return topicRepository.findAll();
		//return topics;
	}

	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		//topics.add(topic);
	}

	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
/*		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
			}
		}*/
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		//topics.removeIf(t -> t.getId().equals(id));
	}

}
