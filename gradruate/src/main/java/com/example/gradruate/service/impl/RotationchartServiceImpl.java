package com.example.gradruate.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.gradruate.entity.Rotationchart;
import com.example.gradruate.mapper.RotationchartMapper;
import com.example.gradruate.service.OssService;
import com.example.gradruate.service.RotationchartService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class RotationchartServiceImpl implements RotationchartService {
    @Resource
    private OssService ossService;
    @Resource
    private RotationchartService rotationchartService;
    @Resource
    private RotationchartMapper rotationchartMapper;
    //上传图片
    @Override
    public Map<String, String> uploadRation(MultipartFile file) {
        Map<String, String> map = ossService.uploadFileAvatar(file);
//        System.out.println(map.toString()+"##@@@@@@");
        Rotationchart rotationchart = new Rotationchart();
        rotationchart.setFileName(map.get("fileName"));
        rotationchart.setUrl(map.get("url"));
//        System.out.println(rotationchart.toString()+"tosjtrong");
        int i = rotationchartMapper.insertRotationchart(map.get("url"),map.get("fileName"));
//        System.out.println("i:"+i);
        return map;
    }

    @Override
    public void saveUrl(Rotationchart rotationchart) {

    }

    @Override
    public List<Rotationchart> qureyAllPicture() {
        List<Rotationchart> list=rotationchartMapper.qureyAllPicture();
        return list;
    }

    @Override
    public int del(String pictrueName) {
        return rotationchartMapper.del(pictrueName);
    }

    //    @Override
//    public boolean save(Rotationchart entity) {
//        rotationchartMapper.insertRotationchart(entity);
//        return false;
//    }

    @Override
    public boolean save(Rotationchart entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<Rotationchart> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Rotationchart> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return false;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<Rotationchart> queryWrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(Rotationchart entity) {
        return false;
    }

    @Override
    public boolean update(Rotationchart entity, Wrapper<Rotationchart> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Rotationchart> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Rotationchart entity) {
        return false;
    }

    @Override
    public Rotationchart getById(Serializable id) {
        return null;
    }

    @Override
    public Collection<Rotationchart> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public Collection<Rotationchart> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Rotationchart getOne(Wrapper<Rotationchart> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Rotationchart> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Rotationchart> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count(Wrapper<Rotationchart> queryWrapper) {
        return 0;
    }

    @Override
    public List<Rotationchart> list(Wrapper<Rotationchart> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Rotationchart> page(IPage<Rotationchart> page, Wrapper<Rotationchart> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<Rotationchart> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<Rotationchart> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<Rotationchart> page, Wrapper<Rotationchart> queryWrapper) {
        return null;
    }

    @Override
    public BaseMapper<Rotationchart> getBaseMapper() {
        return null;
    }
}
