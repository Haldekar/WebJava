package io.project.welcome;
import org.springframework.web.bind.annotation.RestController;
import io.project.topic.Topic;
import io.project.topic.topicService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class welcomeController {
	
@Autowired
private topicService topicService;
	
@RequestMapping("/welcome")
public String sayWelcome()
{
	return "welcome to the course";
}

@RequestMapping("/topicJSON")
public List<Topic> getAllTopicJSON()
{
	return Arrays.asList(new Topic("spring","spring framewor","spring framework description"),
			new Topic("java","core java","core java description"),
			new Topic("java","web java","web java description"),
			new Topic("javascript","javascript","javascript description")
			);
}

@RequestMapping("/topics")
public List<Topic>getAllTopics()
{
	return topicService.getAllTopics();
}

@RequestMapping("/topics/{id}")
public Topic getTopic(@PathVariable String id)
{
	return topicService.getTopic(id);
}

@RequestMapping(method=RequestMethod.POST,value="/topics")
public void addTopic(@RequestBody Topic topic)
{
	topicService.addTopic(topic);
}

@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
public void updateTopic(@PathVariable String id, @RequestBody Topic topic)
{
	topicService.updateTopic(id, topic);
}
@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
public void deleteTopic(@PathVariable String id)
{
	topicService.deleteTopic(id);
}
}


