/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ucan.respositories;

import edu.ucan.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Isaura
 * Data  : 30 / 10 / 2023
 * objectivo
 */
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
}
