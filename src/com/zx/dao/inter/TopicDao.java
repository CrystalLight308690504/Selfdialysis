package com.zx.dao.inter;

import com.zx.dao.inter.BaseDao;
import com.zx.entity.Topic;
import com.zx.entity.User;

import java.util.List;

public interface TopicDao extends BaseDao<Topic> {

    /**
     * 查询话题,
     * @param startIndex 开始查询的索引
     * @param counts 查询的个数
     * @param  writer 根据writer查询 图个writer为空就查询所有
     * @return
     */
    List listPart(Long startIndex, Long counts,User writer);
    List listPart(Long startIndex, Long counts);

    /**
     * 获取要查询的数量
     * @param user 查询该user 的话题数量 如果user为null就查询所有
     * @return
     */
    long getCounts(User user);
}
