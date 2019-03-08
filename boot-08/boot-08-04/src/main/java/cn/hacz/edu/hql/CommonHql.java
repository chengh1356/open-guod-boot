package cn.hacz.edu.hql;

import cn.hacz.edu.mapping.common.CommonEntity;
import cn.hacz.edu.mapping.common.CommonReqVo;
import cn.hacz.edu.mapping.common.CommonResVo;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/12/19 时间:8:38
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
@Transactional(rollbackFor = RuntimeException.class)
public class CommonHql {
    @PersistenceContext
    private EntityManager entityManager;

    public Session getSession() {
        return this.entityManager.unwrap(Session.class);
    }

    public void save() {
        for (int i = 0; i < 10; i++) {
            CommonEntity commonEntity = new CommonEntity();
            commonEntity.setDate01(new Date());
            commonEntity.setDate02(new java.sql.Date(System.currentTimeMillis()));
            commonEntity.setLocalDate(LocalDate.now());
            commonEntity.setLocalTime(LocalTime.now());
            commonEntity.setDateTime(LocalDateTime.now());
            commonEntity.setDateStr("2018-12");
            this.getSession().save(commonEntity);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<CommonResVo> getTime(CommonReqVo commonReqVo) {
        Query<CommonEntity> query = this.getSession().createQuery(" from CommonEntity t where t.date01>='" + commonReqVo.getDate01() + "' ", CommonEntity.class);
        List<CommonEntity> list = query.list();
        List<CommonResVo> rows = new LinkedList<>();
        for (CommonEntity commonEntity : list) {
            CommonResVo commonResVo = new CommonResVo();
            BeanUtils.copyProperties(commonEntity, commonResVo);
            rows.add(commonResVo);
        }
        return rows;
    }
}
