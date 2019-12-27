package com.zx.dao.Impl;

import com.zx.dao.inter.TopicDao;
import com.zx.entity.Topic;
import com.zx.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("topicDao")
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao {

    /**
     * 查询话题,
     * @param startIndex 开始查询的索引
     * @param counts 查询的个数
     * @param  writer 根据writer查询 图个writer为空就查询所有
     * @return
     */
    public List listPart(Long startIndex, Long counts, User writer) {

        Session session = getSession();
        if(writer == null) {
            String hql = "from Topic t  order by t.writingDate DESC";
            Query query = session.createQuery(hql);
            query.setFirstResult(startIndex.intValue());
            query.setMaxResults(counts.intValue());
            return query.list();
        }else {
            String hql = "from Topic t where t.writer = ? order by t.writingDate DESC";
            Query query = session.createQuery(hql);
            query.setParameter(0,writer);
            query.setFirstResult(startIndex.intValue());
            query.setMaxResults(counts.intValue());
            return query.list();
        }

    }

    public List listPart(Long startIndex, Long counts) {
        return listPart( startIndex, counts, null);
    }

    @Override
    public long getCounts(User user) {
        String hql;
        if(user == null){
            hql = "select count(*) from Topic ";
            Query query = getSession().createQuery(hql);
            return (long)query.uniqueResult();
        }else {
            hql = "select count(*) from Topic as t where t.writer = ? ";
            Query query = getSession().createQuery(hql);
            query.setParameter(0,user);
            return (long)query.uniqueResult();
        }
    }
}
