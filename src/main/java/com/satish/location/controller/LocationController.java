package com.satish.location.controller;

import com.satish.location.entities.Location;
import com.satish.location.repos.LocationRepository;
import com.satish.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {
    @Autowired
    LocationService service;
    @RequestMapping("/showCreate")
    public String showCreate(){
        System.out.println("show location");
        return "createLocation";
    }
    @RequestMapping("/saveLocation")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelmap){
        Location locationSaved = service.saveLocation(location);
        String msg = "location saved with id :"+ locationSaved.getId();
        modelmap.addAttribute("msg",msg);
        return "createLocation";
    }
    @RequestMapping("/displayLocation")
    public String displayLocation(ModelMap modelmap){
        List<Location> locations = service.getAllLocation();
        modelmap.addAttribute("location",locations);
        return "displayLocation";
    }
    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelmap){
        Location location = service.getLocationById(id);
        System.out.println("update location"+location);
        modelmap.addAttribute("location",location);
        return "updateLocation";
    }

    @RequestMapping("/updateLocation")
    public String updateLocation(@ModelAttribute("location") Location location,ModelMap modelmap){
        service.updateLocation(location);
        List<Location> locations = service.getAllLocation();
        modelmap.addAttribute("location",locations);
        return "displayLocation";
    }
}
