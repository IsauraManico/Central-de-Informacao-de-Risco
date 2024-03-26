/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ucan.respositories;

import edu.ucan.entities.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Isaura
 * Data 11/11/2023
 */
public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {
    
    
}
