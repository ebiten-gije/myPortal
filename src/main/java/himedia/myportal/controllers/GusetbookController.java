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

import himedia.myportal.repositories.vo.GuestbookVo;
import himedia.myportal.services.GuestbookService;

@RequestMapping("/guestbook")
@Controller
public class GusetbookController {
	
	@Autowired
	GuestbookService guestbookService;

	@RequestMapping({"", "/", "/list"})
	public String list (Model model) {
		List <GuestbookVo> list = guestbookService.getMessageList();
		model.addAttribute("list", list);
		return "guestbook";
	}
	
	//	/guestbook/write (POST) -> 방명록 기록
	@PostMapping("/write")
	public String write(@ModelAttribute GuestbookVo vo) {
		System.out.println("HTML form "+vo);
		boolean success = guestbookService.writeMessage(vo);
		System.out.println("write result" + success);
		//	insert -> redirect
		return "redirect:/guestbook/list";
	}
	
	@GetMapping("/delete/{no}")
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}
	
	@PostMapping("/delete")
	public String delete(@ModelAttribute GuestbookVo vo) {
		boolean success = guestbookService.deleteMessage(vo);
		System.out.println("delete result: " + success);
		return "redirect:/guestbook/";
	}
}
