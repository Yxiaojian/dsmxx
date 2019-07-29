package com.ht.dsmxx.websocket.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ht.dsmxx.websocket.model.AlarmMail;
import com.ht.dsmxx.websocket.mapper.AlarmMailMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author zhangyang
 * @date 2019/07/25
 */
 @Service
public class AlarmMailService {

    @Resource
    private AlarmMailMapper alarmMailMapper;

    /**
     * 添加
     *
     * @param alarmMail
     * @return
     */
    public boolean insert(AlarmMail alarmMail) {
        return alarmMailMapper.insert(alarmMail) > 0;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public boolean delete(Integer id) {
        return alarmMailMapper.deleteById(id) > 0;
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    public AlarmMail get(Integer id) {
        return alarmMailMapper.selectById(id);
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    public List<AlarmMail> findAll() {
    QueryWrapper<AlarmMail> wrapper = new QueryWrapper<>();
      return alarmMailMapper.selectList(wrapper);
    }


}
