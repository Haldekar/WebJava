package io.project.springboot;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	public void addTopic(Topic topic)
	{
		topicRepository.save(topic);
	}
	
	public List<Topic>getAllTopics()
	{
		List<Topic>topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id)
	{
		return topicRepository.findById(id);
		 
	}
	
	public void updateTopic(Topic topic,String id)
	{
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id)
	{
		topicRepository.deleteById(id);
	}

}
