package com.graduation.demo.service;


import com.graduation.demo.Model.Level;

import java.util.List;

public interface LevelService {
    public Level addLevel (Level level);
    public List<Level> addAllLevel(List<Level> levels);
    public Level getLevelById(Long id);
    public List<Level> getAllLevel();
    public Level getLevelByName(String name);
    public boolean deleteLevelById(Long id);
    public Level updateLevel(Level level);
}
