package com.zx.service.inter;

import com.zx.service.inter.BaseService;
import com.zx.entity.Topic;
import com.zx.entity.User;

import java.util.List;

public interface TopicService extends BaseService<Topic> {
    List listPart(Long startIndex, Long counts, User writer) ;
    List listPart(Long startIndex, Long counts) ;
    void save(Topic topic);
    long getCounts(User user);
    Topic findTopicById(Long id);
}
