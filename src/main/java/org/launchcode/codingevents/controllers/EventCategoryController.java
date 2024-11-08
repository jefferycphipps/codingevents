package org.launchcode.codingevents.controllers;


import jakarta.validation.Valid;
import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping("/")
    public String displayAllCategories(Model model){
        model.addAttribute("title","All Categories");
        model.addAttribute("eventCategories", eventCategoryRepository.findAll());
        return "eventCategories/index";
    }

    @GetMapping("create")
    public String renderCreateEventCategoryForm(Model model){
        model.addAttribute("title","Create Category");
        model.addAttribute(new EventCategory());
        return "eventCategories/create";
    }

    @PostMapping("create")
    public String processCreateEventCategoryForm(@ModelAttribute @Valid EventCategory newCategory, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title","Create Category");
            model.addAttribute(new EventCategory());
            return "eventCategories/create";
        }
        eventCategoryRepository.save(newCategory);
        return "redirect:";
    }

    @GetMapping("delete")
    public String renderDeleteEventCategoryForm(Model model) {
        model.addAttribute("title", "Delete Event");
        model.addAttribute("eventCategories", eventCategoryRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventCategoryForm(@RequestParam(required = false) int[] eventCategoryIds) {

        if (eventCategoryIds != null) {
            for (int id : eventCategoryIds) {
                eventCategoryRepository.deleteById(id);
            }
        }

        return "redirect:";
    }


}
