package com.graduation.demo.service;

import com.graduation.demo.Dao.LevelRepository;
import com.graduation.demo.Model.Doctor;
import com.graduation.demo.Model.Level;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelRepository repository;

    @Override
    public Level addLevel(Level level) {

        log.info("calling Add_Department service with Object " + level);
        Level existingLevel = repository.save(level);
        if (existingLevel == null)
            log.warn("Add_Level With object  is null ");
        else
            log.info("Save_Doctor With object response ");
        return existingLevel;
    }

    @Override
    public List<Level> addAllLevel(List<Level> levels) {
        log.info("calling Add_All_Level service " + levels);

        List<Level> existingLevel = repository.saveAll(levels);
        if (existingLevel == null)
            log.warn("Add_All_Level  is null ");
        else
            log.info("Add_All_Level response " + existingLevel);
        return existingLevel;
    }

    @Override
    public Level getLevelById(Long id) {
        log.info("calling GEt_LEVEL_By_Id  service with id " + id);
        Level existingLevel = repository.findById(id).orElse(null);
        if (existingLevel == null)
            log.warn("GEt_LEVEL_By_Id is null ");
        else
            log.info("GEt_LEVEL_By_Id response " + existingLevel);
        return existingLevel;
    }

    @Override
    public List<Level> getAllLevel() {
        log.info("calling get All_Level service  ");
        List<Level> existingLevels = repository.findAll();
        if (existingLevels == null)
            log.warn("get All_Level is null ");
        else
            log.info("get All_Level response " + existingLevels);

        return existingLevels;
    }

    @Override
    public Level getLevelByName(String name) {
        log.info("calling get_Level_By_Name service  " + name);
        Level existingLevel = repository.findByName(name);
        if (existingLevel == null)
            log.warn("get_Level_By_Name is null ");
        else
            log.info("get_Level_By_Name response " + existingLevel);

        return existingLevel;
    }

    @Override
    public boolean deleteLevelById(Long id) {
        log.info("calling delete_Level_By_Id service " + id);
        Level existingLevel = repository.findById(id).orElse(null);
        if (existingLevel == null) {
            log.warn("delete_Level_By_Id is null ");
            return false;
        } else {
            log.info("delete_Level_By_Id response " + existingLevel);
            repository.deleteById(id);
            return true;
        }
    }

    @Override
    public Level updateLevel(Level level) {
        log.info("calling  update_Level service " + level);
        Level existingLevel = repository.findById(level.getId()).orElse(null);
        if (existingLevel == null)
            log.warn("get Doctor By Name service is null ");
        else
            log.info("update Doctor response " + existingLevel);
        existingLevel.setName(level.getName());
        return repository.save(existingLevel);
    }


}
