package controller;

import entity.CityEntity;
import entity.HotelEntity;
import entity.RateEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.CityRepository;
import repository.HotelRepository;
import repository.RateRepository;

@Controller
public class SortController {

    @Autowired
    CityRepository cityRepo;

    @Autowired
    HotelRepository hotelRepo;
    
    @Autowired
    RateRepository rateRepo;

    //sort
    @RequestMapping(value = "/sort-by-evaluate-high-to-low/{name}", method = RequestMethod.GET)
    public String sortHotelByRateHighToLow(@PathVariable(value = "name") String name, Model model) {
        List<HotelEntity> hotelList = (List<HotelEntity>) hotelRepo.sortHotelByEvaluateHighToLow(name);
        CityEntity city = cityRepo.findByName(name);
        model.addAttribute("hotelList", hotelList);
        model.addAttribute("city", city);
        return "view-hotel-by-city";
    }
    @RequestMapping(value = "/sort-by-evaluate-low-to-high/{name}", method = RequestMethod.GET)
    public String sortHotelByRateLowToHigh(@PathVariable(value = "name") String name, Model model) {
        List<HotelEntity> hotelList = (List<HotelEntity>) hotelRepo.sortHotelByEvaluateLowToHigh(name);
        CityEntity city = cityRepo.findByName(name);
        List<RateEntity> rateList = (List<RateEntity>) rateRepo.findAll();
        
        model.addAttribute("hotelList", hotelList);
        model.addAttribute("city", city);
        model.addAttribute("rateList", rateList);
        return "view-hotel-by-city";
    }

}
