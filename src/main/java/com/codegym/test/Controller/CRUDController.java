package com.codegym.test.Controller;

import com.codegym.test.Entity.Promotion;
import com.codegym.test.Rrepository.PromotionRepository;
import com.codegym.test.Services.PromotionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CRUDController {

    @Autowired
    PromotionServices promotionServices;
    @Autowired
    PromotionRepository promotionRepository;
    @RequestMapping(value = "/promotions", method = RequestMethod.GET)
    public String getPromotion(Model model) {

        model.addAttribute("promotion", new Promotion());
        List<Promotion> promotions = promotionServices.findAll();
        model.addAttribute("promotions", promotions);

        return "promotions";
    }

    @RequestMapping(value = "/promotions", method = RequestMethod.POST)
    public String getPromotion(@ModelAttribute("promotion") Promotion promotion, BindingResult bindingResult,
                               Model model) {

        String status= promotion.getOperationType();
        List<Promotion> promotions =null;
        model.addAttribute("promotion", new Promotion());
            if(status.equals("remove") ){
               promotionServices.deleteById(promotion.getId());
            }

            if (status.equals("save") ) {
                promotionServices.save(promotion);
            }

            List <Promotion> userfor=null;

        if (status.equals("search") ) {
            Boolean isStartDay=!promotion.getStartDay().toString().isEmpty();
            Boolean isEndDay=!promotion.getEndDay().toString().isEmpty();
            Boolean isTitle=!promotion.getTitle().isEmpty();

            if (promotion.getId() != null) {
                Promotion userid;
                userid = promotionServices.getById(promotion.getId());
                model.addAttribute("promotions", userid);
                return "promotions";

            } else {

            List <Promotion> userleve1=new ArrayList<>();
            if (isTitle){
                promotions = promotionServices.getByTitle(promotion.getTitle());
            }

            model.addAttribute("promotions", promotions);
            return "promotions";
        }

    }
        return "redirect:/promotions";
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public String getEditPromotion(@RequestParam("id") int id,
                                   Model model) {

        Promotion promotion = promotionServices.getById(id);
        model.addAttribute("promotion", promotion);
        List<Promotion> promotions = promotionServices.findAll();
        model.addAttribute("promotions", promotions);

        return "promotions";

    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public String getRemovePromotion(@RequestParam("id") int id, Model model) {

         promotionServices.deleteById(id);
        List<Promotion> promotions = promotionServices.findAll();
        model.addAttribute("promotions", promotions);

        return "redirect:/promotions";
    }

}
