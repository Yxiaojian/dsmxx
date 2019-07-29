package com.ht.dsmxx.websocket.domain;

import com.ht.dsmxx.websocket.bo.AlarmMailBo;

import java.util.List;

/**
 *
 * @author zhangyang
 * @date 2019/07/24
 */
public interface AlarmMailDomain {

    /**
     * 添加
     *
     * @param alarmMailBo
     * @return
     */
    boolean insert(AlarmMailBo alarmMailBo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    AlarmMailBo get(Integer id);

    /**
     * 查询全部数据
     *
     * @return
     */
    List<AlarmMailBo> findAll();


}
