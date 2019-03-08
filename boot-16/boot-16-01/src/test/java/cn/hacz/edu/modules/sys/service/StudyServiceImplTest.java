package cn.hacz.edu.modules.sys.service;

import cn.hacz.edu.modules.sys.dao.StudyDaoI;
import cn.hacz.edu.modules.sys.dto.StudyDto;
import cn.hacz.edu.modules.sys.entity.StudyEntity;
import cn.hacz.edu.modules.system.vo.Json;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/5 时间:18:02
 * @JDK 1.8
 * @Description 功能模块：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyServiceImplTest {
    @Autowired
    private StudyServiceI studyServiceI;
    @Autowired
    private StudyDaoI studyDaoI;

    @Test
    public void insert() {
        StudyDto studyDto = new StudyDto();
        Json insert = studyServiceI.insert(studyDto);
        System.out.println(insert);
    }

    @Test
    public void findById() {
        StudyEntity byId = studyDaoI.findById(UUID.fromString("18601273-01f2-4063-bc8e-28e28930ca5b"));
        System.out.println(byId.getName());
    }

    @Test
    public void findPage() {
        List<StudyEntity> studyEntities = studyDaoI.find(" from StudyEntity", PageRequest.of(0, 10));
        studyEntities.forEach(System.out::println);
    }

    @Test
    public void optional() {
        Optional<StudyEntity> studyEntity = studyDaoI.get(" from StudyEntity ");
        Optional<Integer> integer = studyEntity.map(StudyEntity::getAge);
        System.out.println(integer);
    }

    @Test
    public void findByName() {
        StudyEntity guo = studyDaoI.findByName("11");
        System.out.println(guo);
    }
}
