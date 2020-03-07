package cn.tsxygfy.blog.mapper;

import cn.tsxygfy.blog.model.po.Tag;
import cn.tsxygfy.blog.model.vo.TagsVO;

import java.util.List;

public interface TagMapper {
    Long deleteByPrimaryKey(Long id);

    Long insert(Tag record);

    Tag selectByPrimaryKey(Long id);

    List<Tag> selectAll();

    Long updateByPrimaryKey(Tag record);

    /**
     * 查询对应id文章的全部标签
     * @param id
     * @return
     */
    List<Tag> selectByArticleId(Long id);

    List<TagsVO> selectAllWithArticleCount();

    Tag selectByName(String name);
}