/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ucan.respositories;

import edu.ucan.entities.Localidade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Isaura
 */
public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {
    
        @Query(value = "SELECT * \n"
            + "FROM localidade \n"
            + "WHERE fk_localidade_pai IS NULL\n"
            + "ORDER BY designacao", nativeQuery = true)
    public List<Localidade> findAllPaisesOrderByDesignacao();

    @Query(value = "SELECT * \n"
            + "FROM localidade \n"
            + "WHERE fk_localidade_pai = ?1\n"
            + "ORDER BY designacao", nativeQuery = true)
    public List<Localidade> findAllLocalidadesByPkLocalidadePaiOrderByDesignacao(String pkPai);
    
}
