package com.ht.dsmxx.websocket.domain;

import com.ht.dsmxx.common.utils.BeanUtil;
import com.ht.dsmxx.websocket.bo.AlarmMailBo;
import com.ht.dsmxx.websocket.model.AlarmMail;
import com.ht.dsmxx.websocket.service.AlarmMailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author zhangyang
 * @date 2019/07/25
 */
@Service("alarmMailDomain")
public class AlarmMailNativeDomain implements AlarmMailDomain {

    @Resource
    private AlarmMailService alarmMailService;

    @Override
    public boolean insert(AlarmMailBo alarmMailBo) {
        return alarmMailService.insert(BeanUtil.convert(alarmMailBo, AlarmMail.class));
    }

    @Override
    public boolean delete(Integer id) {
        return alarmMailService.delete(id);
    }

    @Override
    public AlarmMailBo get(Integer id) {
        return BeanUtil.convert(alarmMailService.get(id), AlarmMailBo.class);
    }

    @Override
    public List<AlarmMailBo> findAll() {
        return BeanUtil.convertList(alarmMailService.findAll(), AlarmMailBo.class);
    }

}
