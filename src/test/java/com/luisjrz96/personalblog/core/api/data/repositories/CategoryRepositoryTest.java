package com.luisjrz96.personalblog.core.api.data.repositories;

import com.luisjrz96.personalblog.core.api.data.models.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@EnableJpaRepositories(basePackageClasses = CategoryRepository.class)
@EntityScan(basePackageClasses = Category.class)
public class CategoryRepositoryTest{


    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSaveAndFindByID() {
        //GIVEN
        Category category = new Category();
        category.setName("testCategory");
        category.setCreatedAt(new Date());

        //WHEN
        Category savedCategory = categoryRepository.save(category);
        //THEN
        assertNotNull(categoryRepository.findById(1).get());
        assertEquals(categoryRepository.findById(1).get(), savedCategory);
    }


    @Test
    public void testFindAll() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        assertNotNull(categories);
    }


    @Test
    public void testDeleteById() {
        categoryRepository.deleteById(2);
    }


    @Test
    public void testUpdateCategory() {
        Optional<Category> category = categoryRepository.findById(3);
        assertNotNull(category.get());

        Category newCategory = new Category();
        newCategory.setName("updatedCategory");
        Date date = Date.from(Instant.now());
        newCategory.setUpdatedAt(date);
        newCategory.setId(category.get().getId());
        newCategory.setCreatedAt(category.get().getCreatedAt());
        newCategory.setSubcategories(category.get().getSubcategories());

        Category updatedCategory = categoryRepository.save(newCategory);

        assertEquals(updatedCategory.getId(), category.get().getId());
        assertEquals(newCategory.getUpdatedAt(), date);
        assertEquals(newCategory.getName(), "updatedCategory");
    }

}
