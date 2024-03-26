/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ucan.respositories;

import edu.ucan.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Isaura
 * Data 12 - 11 - 2023 
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    
}
