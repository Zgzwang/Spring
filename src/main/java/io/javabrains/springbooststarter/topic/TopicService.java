package io.javabrains.springbooststarter.topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework ","Spring Framework Description"),
            new Topic("java", "Core Java ","Core Java description"),
            new Topic("javascript", "Core Javascript ","Core Javascript Description")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }
    public Topic getTopics(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void upDateTopic(String id, Topic topic) {
        for (int i = 0; i < topics.size(); i++  ){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteDateTopic(String id, Topic topic) {
        topics.removeIf(t -> t.getId().equals(id) );
    }
}
