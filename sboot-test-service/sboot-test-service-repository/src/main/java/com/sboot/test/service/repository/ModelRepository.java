
package com.sboot.test.service.repository;

import com.sboot.test.service.model.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface ModelRepository extends CrudRepository<Model, Long> {

    /**
     *
     * @param name
     * @return List
     */
    @Query("select c from Model c where c.name = :name")
    List<Model> findByName(@Param("name") String name);
}