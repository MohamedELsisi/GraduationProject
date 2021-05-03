package com.graduation.demo.controller;

import com.graduation.demo.Model.Department;
import com.graduation.demo.Model.Level;
import com.graduation.demo.service.LevelService;
import com.graduation.demo.service.LevelServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class LevelController {
    @Autowired
    private LevelServiceImpl service;

    @PostMapping("/addLevel")
    @ApiOperation(value = "insert new Level ", response = ResponseEntity.class)

    public ResponseEntity addLevel(@RequestBody Level level) {
        log.info("Add_Level_Controller ", level);
        Level existingLevel = service.addLevel(level);
        return ResponseEntity.status(HttpStatus.CREATED).body(existingLevel);
    }

    @PostMapping("/addAllLevels")
    @ApiOperation(value = "insert list of Levels ", response = ResponseEntity.class)

    public ResponseEntity<List<Level>> addAllLevels(@RequestBody List<Level> levels) {
        log.info("add_All_Levels_Controller " + levels);
        List<Level> existingLevels = service.addAllLevel(levels);

        return ResponseEntity.ok(existingLevels);
    }

    @GetMapping("/findLevelById/{id}")
    @ApiOperation(value = "search about Level by id ", response = ResponseEntity.class)

    public ResponseEntity findLevelById(@ApiParam(value = "id value for the Level u need to retrieve", required = true)
                                            @PathVariable Long id) {
        log.info("Find Level by id in controller with id = " + id);
        Level existingLevel = service.getLevelById(id);

        if (existingLevel == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(existingLevel);
    }

    @GetMapping("/getAllLevels")
    @ApiOperation(value = "show All Levels", response = ResponseEntity.class)

    public ResponseEntity<List<Level>> getAllLevels() {
        log.info("Get All Levels in controller ");
        List<Level> existingLevels = service.getAllLevel();
        if (existingLevels == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(existingLevels);
    }

    @GetMapping("/findLevelByName/{name}")
    @ApiOperation(value = "search about Level by name", response = ResponseEntity.class)

    public ResponseEntity findLevelByName(@ApiParam(value = "name value for the Level u need to retrieve", required = true)
                                              @PathVariable String name) {
        log.info("Find Level by Name in Controller with name = " + name);
        Level existingLevel = service.getLevelByName(name);
        if (existingLevel == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(existingLevel);
    }

    @DeleteMapping("/deleteLevel/{id}")
    @ApiOperation(value = "Delete Level with id", response = ResponseEntity.class)

    public ResponseEntity deleteLevel(@ApiParam(value = "id value for the Level u need to delete", required = true)
                                          @PathVariable Long id) {
        log.info("Delete Level by id in controller with id = " + id);
        boolean status = service.deleteLevelById(id);
        if (status == false)
            return ResponseEntity.notFound().build();

        else
            return ResponseEntity.status(HttpStatus.FOUND).build();
    }

    @PutMapping("/updateLevel")
    @ApiOperation(value = "Update Level  ", response = ResponseEntity.class)

    public ResponseEntity updateLevel( @RequestBody  Level Level) {
        log.info("Update  doctor  controller with object = " + Level);
        Level existingLevel = service.updateLevel(Level);
        if (existingLevel == null)
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(existingLevel);
        }
    }






















}
