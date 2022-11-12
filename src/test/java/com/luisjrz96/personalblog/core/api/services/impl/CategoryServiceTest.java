package com.luisjrz96.personalblog.core.api.services.impl;

import com.luisjrz96.personalblog.core.api.data.models.Category;
import com.luisjrz96.personalblog.core.api.data.repositories.CategoryRepository;
import com.luisjrz96.personalblog.core.api.exceptions.InternalServerServiceException;
import com.luisjrz96.personalblog.core.api.exceptions.NotFoundException;
import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;


    @Test
    public void findCategoryByID_Success() {
        Integer id = 1;
        String name = "testCategory";
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setCreatedAt(new Date());

        Mockito.when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
        Category obtainedCategory = categoryService.findById(id);

        assertNotNull(obtainedCategory);
        assertEquals(obtainedCategory.getName(), name);
        Mockito.verify(categoryRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void findCategoryByID_FailNotFoundException() {
        Integer id = 1;
        String name = "testCategory";
        String errorMessage = "error";
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setCreatedAt(new Date());

        Mockito.when(categoryRepository.findById(id)).thenThrow(new NotFoundException(errorMessage));
        Exception exception = assertThrows(NotFoundException.class, () -> {
            categoryService.findById(id);
        });

        assertEquals(exception.getMessage(), errorMessage);
    }


    @Test
    public void findCategoryByID_FailInternalServerException() {
        Integer id = 1;
        String name = "testCategory";
        String errorMessage = "error";
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setCreatedAt(new Date());

        Mockito.when(categoryRepository.findById(id)).thenThrow(new RuntimeException(errorMessage));
        Exception exception = assertThrows(InternalServerServiceException.class, () -> {
            categoryService.findById(id);
        });

        assertEquals(exception.getMessage(), InternalServerServiceException.INTERNAL_SERVER_ERROR);
    }


    @Test
    public void saveCategory_Success() {
        Integer id = 1;
        String categoryName = "testCategory";
        Category category = new Category();
        category.setName(categoryName);

        Category categorySaved = new Category();
        categorySaved.setName(categoryName);
        categorySaved.setId(id);
        categorySaved.setCreatedAt(new Date());

        Mockito.when(categoryRepository.save(category)).thenReturn(categorySaved);
        Category obtainedCategory = categoryService.save(category);

        assertNotNull(obtainedCategory);
        assertEquals(obtainedCategory.getName(), categoryName);
        assertNotNull(obtainedCategory.getId());
        assertNotNull(obtainedCategory.getCreatedAt());
        Mockito.verify(categoryRepository, Mockito.times(1)).save(Mockito.any(Category.class));
    }


    @Test
    public void saveCategory_FailInternalServerException() {
        Category category = new Category();
        category.setName("categoryName");

        Mockito.when(categoryRepository.save(category)).thenThrow(new RuntimeException("error"));
        Exception exception = assertThrows(InternalServerServiceException.class, () -> {
            categoryService.save(category);
        });
        assertEquals(exception.getMessage(), InternalServerServiceException.INTERNAL_SERVER_ERROR);
        Mockito.verify(categoryRepository, Mockito.times(1)).save(Mockito.any(Category.class));
    }


    @Test
    public void findAllCategories_Success() {
        List<Category> categories = Arrays.asList(
                new Category(),
                new Category()
        );

        Mockito.when(categoryRepository.findAll()).thenReturn(categories);
        List<Category> categoriesList = categoryService.findAll();

        assertNotNull(categoriesList);
        assertEquals(categoriesList.size(), 2);
        Mockito.verify(categoryRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void findAllCategories_FailInternalServerException() {
        Mockito.when(categoryRepository.findAll()).thenThrow(new RuntimeException("error"));
        Exception exception = assertThrows(InternalServerServiceException.class, () -> {
            categoryService.findAll();
        });
        assertEquals(exception.getMessage(), InternalServerServiceException.INTERNAL_SERVER_ERROR);
    }


    @Test
    public void findAllCategoriesWithPredicate_Success() {
        List<Category> categories = Arrays.asList(
                new Category(),
                new Category()
        );

        Mockito.when(categoryRepository.findAll(Mockito.any(Predicate.class))).thenReturn(categories);
        List<Category> categoriesList = categoryService.findAll(Mockito.mock(Predicate.class));

        assertNotNull(categoriesList);
        assertEquals(categoriesList.size(), 2);
        Mockito.verify(categoryRepository, Mockito.times(1)).findAll(Mockito.any(Predicate.class));
    }

    @Test
    public void findAllCategoriesWithPredicate_FailInternalServerException() {
        Mockito.when(categoryRepository.findAll(Mockito.any(Predicate.class))).thenThrow(new RuntimeException("error"));
        Exception exception = assertThrows(InternalServerServiceException.class, () -> {
            categoryService.findAll(Mockito.mock(Predicate.class));
        });
        assertEquals(exception.getMessage(), InternalServerServiceException.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void deleteCategoryByID_Success() {
        Integer id = 1;
        Mockito.doNothing().when(categoryRepository).deleteById(id);
        categoryService.delete(id);
        Mockito.verify(categoryRepository, Mockito.times(1)).deleteById(id);
    }


    @Test
    public void deleteCategoryByID_FailNotFoundException() {
        Integer id = 1;
        Mockito.doThrow(new EmptyResultDataAccessException("error",1 )).when(categoryRepository).deleteById(id);
        Exception ex = assertThrows(NotFoundException.class, ()-> {
            categoryService.delete(id);
        });
        assertEquals(ex.getMessage(), String.format(NotFoundException.NOT_FOUND, Category.class.getSimpleName(), String.valueOf(id)));
    }

    @Test
    public void deleteCategoryByID_FailInternalServerException() {
        Integer id = 1;
        Mockito.doThrow(new RuntimeException("ex")).when(categoryRepository).deleteById(id);
        Exception ex = assertThrows(InternalServerServiceException.class, ()-> {
           categoryService.delete(id);
        });
        assertEquals(ex.getMessage(), InternalServerServiceException.INTERNAL_SERVER_ERROR);
    }
}
