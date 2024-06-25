package himedia.myportal.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//	전역 예외 처리 컨트롤러로
@ControllerAdvice	//	@Component의 하위 어노테이션임
public class ApplicationExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException e, Model model) {
		//	1. 기록을 로그로 남기기
		System.err.println("====================================");
		System.err.println("ControllerAdvice에 의한 ErrorHandling");
		e.printStackTrace();
		
		//	2. 시스템 오류 안내 화면으로
		model.addAttribute("name", e.getClass().getSimpleName());
		model.addAttribute("message", e.getMessage());
		return "errors/exception";
	}
}
