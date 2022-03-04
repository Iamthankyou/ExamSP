package com.codegym.test.Services;

import com.codegym.test.Entity.Promotion;

import java.util.List;


public interface PromotionServices {

    List<Promotion> findAll();
    void save(Promotion promotion);
    Promotion getById(int id);
    List<Promotion> getByTitle(String title);

    void deleteById(int id);

}
