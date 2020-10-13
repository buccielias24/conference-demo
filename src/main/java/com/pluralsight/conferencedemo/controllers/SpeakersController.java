/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import java.util.List;
import com.pluralsight.conferencedemo.models.Speaker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elias
 */
@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    
    @Autowired
    private SpeakerRepository speakerRepository;
    
    @GetMapping
    public List<Speaker> list(){
        return speakerRepository.findAll();
    }
    
    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }
    
    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }
    
    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker=speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
