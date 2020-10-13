/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.conferencedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pluralsight.conferencedemo.models.Session;

/**
 *
 * @author elias
 */
public interface SessionRepository extends JpaRepository<Session, Long> {
    
}
