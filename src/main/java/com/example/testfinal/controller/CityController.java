package com.example.testfinal.controller;

import com.example.testfinal.model.City;
import com.example.testfinal.model.Nation;
import com.example.testfinal.service.city.ICityService;
import com.example.testfinal.service.nation.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityService cityService;

    @Autowired
    private INationService nationService;

    @ModelAttribute("nations")
    public List<Nation> findAll(){
        return nationService.findAll();
    }

    @GetMapping("")
    public ModelAndView listCity(@PageableDefault(size = 5) Pageable pageable){
        ModelAndView modelAndView= new ModelAndView("city/list");
        Page<City> cityPage = cityService.findAll(pageable);
        modelAndView.addObject("city", cityPage);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCity(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("city/view");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView= new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@ModelAttribute City city) {
        ModelAndView modelAndView = new ModelAndView("city/create");
        cityService.save(city);
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Tạo mới thành công");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("city/edit");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    private ModelAndView editCity(@ModelAttribute City city) {
        ModelAndView modelAndView = new ModelAndView("city/edit");
        cityService.save(city);
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Sửa thành công");
        return modelAndView;
    }

    @GetMapping ("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/city");
        cityService.remove(id);
        return modelAndView;
    }

//    @PostMapping("/search")
//    public ModelAndView showSearchNameProduct(@RequestParam String name, @PageableDefault(size = 5) Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("city/list");
//        Page<City> cityPage = cityService.findCitiesByName(name, pageable);
//        modelAndView.addObject("city", cityPage);
//        return modelAndView;
//    }

}
