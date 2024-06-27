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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.myportal.repositories.vo.BoardVo;
import himedia.myportal.repositories.vo.UserVo;
import himedia.myportal.services.BoardService;
import jakarta.servlet.http.HttpSession;

	//	사용자 기반 서비스
	//	목록은 로그인 없이 접근,
	//	조회, 작성, 뭐시기는 로그인 통해 
@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		List<BoardVo> list = boardService.getList();
		model.addAttribute("list", list);
//		System.out.println("list: " + list);
		
		return "board/list";
	}
	
	@GetMapping("/{no}")
	public String view (@PathVariable ("no") Long no, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if (authUser == null) {
			//	홈화면으로 보내
			redirectAttributes.addFlashAttribute("errorMsg", "로그인할 필요가 있는 것 같아");
			return "redirect:/";
		}
		
		System.out.println("no: " + no);
		BoardVo boardVo = boardService.getContent(no);
		System.out.println(boardVo);
		model.addAttribute("boardVo", boardVo);
		
		return "board/view";
	}
	
	@GetMapping("/write")
	public String writeform(HttpSession session, RedirectAttributes redirectAttributes) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if (authUser == null) {
			//	홈화면으로 보내
			redirectAttributes.addFlashAttribute("errorMsg", "로그인을 해얗자 ");
			return "redirect:/";
		}
		
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write (@ModelAttribute BoardVo boardVo, HttpSession session, RedirectAttributes redirectAttributes) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if (authUser == null) {
			redirectAttributes.addFlashAttribute("errorMsg", "error");
			return "redirect:/";
		}
		
		boardVo.setUserNo(authUser.getNo());	//	작성자 PK
		boardService.write(boardVo);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/{no}/modify")
	public String modifyform(@PathVariable ("no") Long no, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if (authUser == null) {
			redirectAttributes.addFlashAttribute("errorMsg", "로그인 하지");
			return "redirect:/";
		}
		
		BoardVo boardVo = boardService.getContent(no);
		model.addAttribute("boardVo", boardVo);
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String modify (@ModelAttribute BoardVo updatedVo, HttpSession session, RedirectAttributes redirectAttributes) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if (authUser == null) {
			redirectAttributes.addFlashAttribute("errorMsg", "");
			return "redirect:/";
		}
		
		//	기존 게시물 받기
		BoardVo vo = boardService.getContent(updatedVo.getNo());
		vo.setTitle(updatedVo.getTitle());
		vo.setContent(updatedVo.getContent());
		
		boardService.update(vo);		
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/{no}/delete")
	public String delete (@PathVariable ("no") Long no, HttpSession	session) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if (authUser == null) {
			return "redirect:/";
		}
		
		boardService.delete(no, authUser.getNo());
		
		return "redirect:/board/";
	}
}
