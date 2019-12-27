package com.zx.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zx.entity.Topic;
import com.zx.entity.User;
import com.zx.service.inter.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 讨论模块
 */
@Controller
@Scope("prototype")
public class TopicAction extends ActionSupport implements ModelDriven<Topic> {

    @Autowired
    TopicService topicService;
    long pageIndex = 0L;
    long maxPage; // 最大页面数
    long myMaxPage; // 我的话题页面数
    long queryCount = 10L;
    Topic topic; // 添加和修改的讨论
    private List<Topic> topics;// 获取的讨论

    public String saveTopic() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String dateS = simpleDateFormat.format(date);
        ActionContext actionContext = ActionContext.getContext();
        User user = (User) actionContext.getSession().get("user");
        topic.setWritingDate(dateS);
        topic.setWriter(user);
        topicService.save(topic);
        return toMyTopicUi();
    }

    /**
     *
     * @return
     */
    public String deleteTopic() {
        try {
            System.out.println("Topic 的ID" + topic.getId());
            topicService.deleteById(topic.getId());
        } catch (Exception e) {
        }
        return toMyTopicUi();
    }

    public String toAddTopicUi() {
        return "toAddTopicUi";
    }

    /***
     * 转到所有交流
     * @return
     */
    public String toAllTopicUi() {
        maxPage = getCount(null);
        if (pageIndex < 0) {
            pageIndex = 0L;
        }else if (pageIndex> maxPage){
            pageIndex = maxPage - 1;
        }
        topics = topicService.listPart(pageIndex * 5, queryCount);
        return "toAllTopicUi";
    }

    public String toEditorTopicUi() {
        Topic topicFormer = topicService.findTopicById(topic.getId());
        ActionContext actionContext = ActionContext.getContext();
        actionContext.getValueStack().push(topicFormer);
        return "toEditorTopicUi";
    }

    public String toMyTopicUi() {
        ActionContext actionContext = ActionContext.getContext();
        User user = (User) actionContext.getSession().get("user");
        myMaxPage = getCount(user);
        if (pageIndex < 0) {
            pageIndex = 0L;
        }else if (pageIndex> myMaxPage){
            pageIndex = myMaxPage - 1;
        }
        topics = topicService.listPart(pageIndex * 5, queryCount, user);
        actionContext.put("topics", topics);
        return "toMyTopicUi";
    }

    public String toLookTopic() {
        Topic topicFormer = topicService.findTopicById(topic.getId());
        ActionContext actionContext = ActionContext.getContext();
        actionContext.getValueStack().push(topicFormer);
        return "toLookTopic";
    }

    public String updateTopic() {
        Topic topicFormer = topicService.findTopicById(topic.getId());
        topicFormer.setContents(topic.getContents());
        topicFormer.setTitle(topic.getTitle());
        topicService.update(topicFormer);
        return toMyTopicUi();
    }

    /**
     * 获取页数
     *
     * @param user 获取 user 的交流
     * @return
     */
    private long getCount(User user) {
        long counts = topicService.getCounts(user);
        if (counts % queryCount == 0) {
            return counts / queryCount;
        } else {
            return counts / queryCount + 1;
        }
    }


    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public Long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public Topic getModel() {
        if (topic == null) {
            topic = new Topic();
        }
        return topic;
    }

    public long getMaxPage() {
        return maxPage;
    }

    public long getMyMaxPage() {
        return myMaxPage ;
    }


    public void setMyMaxPage(long myMaxPage) {
        this.myMaxPage = myMaxPage;
    }
}
