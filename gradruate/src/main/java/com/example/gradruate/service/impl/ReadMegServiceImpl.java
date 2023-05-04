package com.example.gradruate.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.gradruate.entity.ReadMeg;
import com.example.gradruate.mapper.ReadMegMapper;
import com.example.gradruate.service.ReadMegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class ReadMegServiceImpl implements ReadMegService {
    @Autowired
    private ReadMegMapper readMegMapper;


    @Override
    public List<ReadMeg> queryBackReadMeg() {
        return readMegMapper.queryBackReadMeg();
    }

    @Override
    public int insertReadMeg(ReadMeg readMeg) {
        return readMegMapper.insertReadMeg(readMeg);
    }

    @Override
    public int updateReadMeg(String uid) {
        return readMegMapper.updateReadMeg(uid);
    }

    @Override
    public  List<ReadMeg> queryReadMeg(String uid) {
        return readMegMapper.queryReadMeg(uid);
    }

    @Override
    public int queryUnReadNum(String uid) {
        return readMegMapper.queryUnReadNum(uid);
    }

    @Override
    public boolean save(ReadMeg entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<ReadMeg> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<ReadMeg> entityList, int batchSize) {
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
    public boolean remove(Wrapper<ReadMeg> queryWrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(ReadMeg entity) {
        return false;
    }

    @Override
    public boolean update(ReadMeg entity, Wrapper<ReadMeg> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<ReadMeg> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(ReadMeg entity) {
        return false;
    }

    @Override
    public ReadMeg getById(Serializable id) {
        return null;
    }

    @Override
    public Collection<ReadMeg> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public Collection<ReadMeg> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public ReadMeg getOne(Wrapper<ReadMeg> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<ReadMeg> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<ReadMeg> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count(Wrapper<ReadMeg> queryWrapper) {
        return 0;
    }

    @Override
    public List<ReadMeg> list(Wrapper<ReadMeg> queryWrapper) {
        return null;
    }

    @Override
    public IPage<ReadMeg> page(IPage<ReadMeg> page, Wrapper<ReadMeg> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<ReadMeg> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<ReadMeg> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<ReadMeg> page, Wrapper<ReadMeg> queryWrapper) {
        return null;
    }

    @Override
    public BaseMapper<ReadMeg> getBaseMapper() {
        return null;
    }
}
