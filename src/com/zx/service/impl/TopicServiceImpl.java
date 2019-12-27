package com.zx.service.impl;

import com.zx.dao.inter.TopicDao;
import com.zx.entity.Topic;
import com.zx.entity.User;
import com.zx.service.inter.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service("topicService")
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicDao topicDao;

    @Override
    public void delete(Topic topic) {

    }

    @Override
    public void deleteById(Long deleteId) {
        topicDao.deleteById(deleteId);
    }

    @Override
    public void update(Topic topic) {
        topicDao.update(topic);
    }

    @Override
    public List listAll() {
        return topicDao.listAll();
    }

    public List listPart(Long startIndex, Long counts , User writer) {
        return topicDao.listPart(startIndex, counts, writer);
    }

    @Override
    public List listPart(Long startIndex, Long counts) {
        return topicDao.listPart(startIndex, counts);
    }

    @Override
    public void save(Topic topic) {
        topicDao.save(topic);
    }

    @Override
    public long getCounts(User user) {
        return topicDao.getCounts(user);
    }

    @Override
    public Topic findTopicById(Long id) {
        return topicDao.getById(id);
    }
}
