package himedia.myportal.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import himedia.myportal.repositories.vo.UserVo;
import himedia.myportal.services.UserService;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/users")
@Controller
public class UsersController {
	@Autowired
	private UserService userService;
	
	//	가입 폼
	@GetMapping({"", "/", "join"})
	public String join() {
		return "users/joinform";
	}
	
	//	가입 처리
	@PostMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println(userVo);
		
		boolean success = userService.join(userVo);
		if (success) {	//	가입 성공
			//	성공 페이지로 리다이렉트
			System.out.println("가입 성공");
			return "redirect:/users/joinsuccess";
		} else {
			//	다시 가입 폼으로 보내
			System.err.println("실패!");
			return "redirect:/users/join";
		}
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess () {
		return "users/joinsuccess";
	}
	
	@GetMapping ("/login")
	public String loginform () {
		return "users/loginform";
	}
	
	@PostMapping("/login")
	public String loginAction(@RequestParam(value="email", required=false, defaultValue="") String email,
			@RequestParam(value="password", required=false, defaultValue="") String password,
			HttpSession session) {
		System.out.println("email: " + email);
		System.out.println("password: " + password);
		
		if (email.length() == 0 || password.length() == 0) {
			System.out.println("이메일 혹은 페스워드 입력되이 잖음");
			return "redirect:/users/login";
			
		}
		
		//	이메일과 패스워드 이용해서 사용자 정보 질의ㅏ
		UserVo authUser = userService.getUser(email, password);
		if (authUser != null) {
			//	록드인 처리 해주어야
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		} else {
			return "redirect:/users/login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	
	//	중복 이메일 체크(API) - 응답을 Json으로 
	@ResponseBody	//	메시지 컨버터 
	@RequestMapping("/checkEmail")
	public Object checkEmail(@RequestParam (value="email", required = true, defaultValue="") String email) {
		UserVo vo = userService.getUser(email);
		boolean exists = vo != null ? true : false;
		
		Map<String, Object> json = new HashMap<>();
		json.put("result", "success");
		json.put("exists", exists);
		
		return json;
	}
	
}
