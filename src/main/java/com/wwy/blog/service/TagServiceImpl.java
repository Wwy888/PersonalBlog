package com.wwy.blog.service;

import com.wwy.blog.dao.TagRepository;
import com.wwy.blog.po.Tag;
import com.wwy.blog.po.Type;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagRepository.getOne(id);
    }

    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.getOne(id);
        if (t == null) {
            try {
                throw new NotFoundException("不存在");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        BeanUtils.copyProperties(tag, t);
        return tagRepository.save(t);
    }


    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();

    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagRepository.findAllById(converToList(ids));
    }

    private List<Long> converToList(String ids){
        List<Long>list = new ArrayList<>();
        if(ids!=null&&ids.length()!=0){
            String []idarray = ids.split(",");
            for(int i=0;i<idarray.length;i++){
                list.add(Long.valueOf(idarray[i]));
            }
        }
        return list;
    }
}
