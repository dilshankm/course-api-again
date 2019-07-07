package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.exceptions.TopicNotFoundException;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(method = RequestMethod.GET, value = "/topics")
	public ResponseEntity<Object> getAllTopic() {
		return new ResponseEntity<>(topicService.getAllTopics(),HttpStatus.OK);
		//return topicService.getAllTopics();
	}

/*	@RequestMapping(method = RequestMethod.GET, value = "/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}*/

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @RequestParam String id) {
		topicService.updateTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="topics/{id}")
	public ResponseEntity<Object> testTopic(@PathVariable String id){
		if(id.equals("5")) {
			throw new TopicNotFoundException();
		}
		return new ResponseEntity<>("Topic is updated successfully", HttpStatus.OK);
	}

}
