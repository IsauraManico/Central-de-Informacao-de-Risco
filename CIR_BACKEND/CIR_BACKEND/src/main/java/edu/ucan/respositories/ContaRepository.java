/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.respositories;

import edu.ucan.entities.Conta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Isaura
 * Data : 30 - 10 - 2023 
 * Objectivo : Realizar o fluxo da pessoa 
 */
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    
    
     @Query(value = "SELECT *\n"
            + "FROM conta c\n"
            + "INNER JOIN pessoa ON pessoa.pk_pessoa = c.fk_pessoa\n"
            + "ORDER BY pessoa.nome ASC\n"
            + ";", nativeQuery = true)
     
    public List<Conta> findAllConta();
    
    
    
}
