package com.example.bnb.controllers.property;

import com.example.bnb.models.property.Scene;
import com.example.bnb.repositories.property.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SceneController {

    @Autowired
    SceneRepository sceneRepository;

    @GetMapping("/public/scenes")
    public ResponseEntity getAllScenes() {
        return new ResponseEntity<>(sceneRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/public/scenes/{id}")
    public ResponseEntity getScene(@PathVariable Long id) {
        return new ResponseEntity<>(sceneRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/public/scenes")
    public HttpStatus updateScene(@RequestBody Scene scene) {
        sceneRepository.save(scene);
        return (HttpStatus.CREATED);
    }

    @PutMapping("/public/scenes/{id}")
    public Scene updateScene(@RequestBody Scene newScene, @PathVariable Long id) {
        return sceneRepository.findById(id)
                .map(scene -> {
                    scene.setTitle(newScene.getTitle());
                    scene.setProperties(newScene.getProperties());
                    return sceneRepository.save(scene);
                })
                .orElseGet(() -> {
                    newScene.setId(id);
                    return sceneRepository.save(newScene);
                });
    }

    @DeleteMapping("/public/scenes/{id}")
    public ResponseEntity<Scene> deleteScene(@PathVariable Long id) {
        sceneRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
