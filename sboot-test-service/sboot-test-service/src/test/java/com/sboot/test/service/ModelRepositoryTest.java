
package com.sboot.test.service;

import com.sboot.test.service.model.Model;
import com.sboot.test.service.repository.ModelRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("dev")
public class ModelRepositoryTest {

    private static final Logger LOGGER =  LoggerFactory.getLogger(ModelRepositoryTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ModelRepository repository;

    /**
     * Persist some data before testing
     */
    @Before
    public void before() {
        repository.deleteAll();

        Model model1 = new Model();
        model1.setName("model1");
        this.entityManager.persist(model1);

        Model model2 = new Model();
        model2.setName("model2");
        this.entityManager.persist(model2);
    }

    /**
     * Verify repository.findByName() returns the requested model1 entity when database has a model1 entity loaded
     * @throws Exception
     */
    @Test
    public void testFindByName() throws Exception {

        LOGGER.info("Verify repository.findByName() returns the requested model1 entity when database has a model1 entity loaded");

        List<Model> modelList = this.repository.findByName("model1");
        Assert.assertEquals(1, modelList.size());
        Assert.assertEquals("model1", modelList.get(0).getName());
    }
}