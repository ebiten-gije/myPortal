package himedia.myportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.myportal.repositories.vo.PhonebookVo;
import himedia.myportal.services.PhonebookService;

@RequestMapping("/phonebook")
@Controller
public class PhonebookController {
	
	@Autowired
	PhonebookService phonebookService;

	@RequestMapping({"", "/", "/list"})
	public String list (@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		if (keyword != null && !keyword.isEmpty()) {
            List<PhonebookVo> list = phonebookService.search(keyword);
            model.addAttribute("list", list);
        } else {
            List<PhonebookVo> list = phonebookService.getList();
            model.addAttribute("list", list);
        }
        return "/phonebook/list";
	}
	
	@GetMapping("/add")
	public String addForm() {
		return "/phonebook/addform";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute PhonebookVo phonebookVo) {
		phonebookService.write(phonebookVo);
		return "redirect:/phonebook/";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		phonebookService.delete(id);
		return "redirect:/phonebook/";
	}
	
//	@GetMapping("")
//	public String search(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
//	    if (keyword != null && !keyword.isEmpty()) {
//	    	List<PhonebookVo> list = phonebookService.search(keyword);
//	        model.addAttribute("list", list);
//	    }
//	    // 나머지 로직 수행
//	    return "/phonebook/list";
//	}
}
