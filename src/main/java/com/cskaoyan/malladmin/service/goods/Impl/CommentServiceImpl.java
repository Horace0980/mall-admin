package com.cskaoyan.malladmin.service.goods.Impl;

import com.cskaoyan.malladmin.bean.goods.Comment;
import com.cskaoyan.malladmin.bean.goods.CommentExample;
import com.cskaoyan.malladmin.mapper.goods.CommentMapper;
import com.cskaoyan.malladmin.service.goods.CommentService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author : zjf
 * @Date : 2019/5/23 上午 09:29
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public QueryVo allList(QueryIn queryIn, Integer userId, Integer valueId) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        if(userId != null){
            criteria.andUserIdEqualTo(userId);
        }else if(valueId != null){
            criteria.andValueIdEqualTo(valueId);
        }
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        PageInfo pageInfo = new PageInfo(comments);
        HashMap<String,Object> map = new HashMap<>();
        map.put("items",comments);
        map.put("total",pageInfo.getTotal());
        return new QueryVo(0,map,"成功");
    }

    @Override
    public QueryVo deleteById(Comment comment) {
        int i = commentMapper.deleteByPrimaryKey(comment.getId());
        return new QueryVo(0,"","成功");
    }

    @Override
    public QueryVo list(String valueId, String type, String showType, String page, String size) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andValueIdEqualTo(Integer.valueOf(valueId));
        criteria.andTypeEqualTo(Byte.valueOf(type));
        HashMap<Object, Object> map = new HashMap<>();
        List<Comment> comment = commentMapper.selectByExample(commentExample);
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
        List<Comment> comments = commentMapper.selectByExample(commentExample);

        map.put("count",comment.size());
        map.put("data",comments);
        map.put("currentPage",page);
        return new QueryVo(0,map,"success");
    }

    @Override
    public QueryVo count(String valueId, String type) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andValueIdEqualTo(Integer.valueOf(valueId));
        criteria.andTypeEqualTo(Byte.valueOf(type));
        HashMap<Object, Object> map = new HashMap<>();
        List<Comment> comment = commentMapper.selectByExample(commentExample);

        map.put("allCount",comment.size());

        int j =0;

        for (Comment c : comment) {
            String[] picUrls = c.getPicUrls();
            if (picUrls.length >= 2){
                j++;
            }
        }
        map.put("hasPicCount",j);

        return new QueryVo(0,map,"");

    }


}
