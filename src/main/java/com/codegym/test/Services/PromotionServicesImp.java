package com.codegym.test.Services;

import com.codegym.test.Entity.Promotion;
import com.codegym.test.Rrepository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class PromotionServicesImp implements PromotionServices {

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public List<Promotion> findAll() {

        List<Promotion> promotions = new ArrayList<>();

        for (Promotion promotion : promotionRepository.findAll()) {

            promotions.add(promotion);
        }
        return promotions;
    }

    @Override
    public void save(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    @Override
    public Promotion getById(int id) {
        Promotion promotion;

        promotion = promotionRepository.findOne(id);

        return promotion;
    }

    @Override
    public List<Promotion> getByTitle(String title) {

        List<Promotion> promotion;

        promotion = promotionRepository.findPromotionsByTitle(title);

        return promotion;
    }


    @Override
    public void deleteById(int id) {

        promotionRepository.delete(id);

    }
}
