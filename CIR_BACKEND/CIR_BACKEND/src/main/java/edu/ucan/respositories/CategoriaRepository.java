/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ucan.respositories;

import edu.ucan.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Isaura
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
    
}
