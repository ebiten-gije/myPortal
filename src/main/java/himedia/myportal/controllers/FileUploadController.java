package himedia.myportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import himedia.myportal.services.FileUploadService;

@Controller
@RequestMapping ("/fileupload")
public class FileUploadController {
	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping ({"", "/", "/form"})
	public String form() {
		return "fileupload/form";
	}
	
	//	업로드 액션
	@PostMapping("/upload")
	public String upload(@RequestParam("file1") MultipartFile file1, Model model) {
		System.out.println("원본 파일명: " + file1.getOriginalFilename());
		System.out.println("파일 사이즈: " + file1.getSize());
		System.out.println("ㅠㅏ라미터 이르미 " + file1.getName());
		
		//	파일 업로드 서비스로 실제 파일로 저장
		String saveFilename = fileUploadService.store(file1);
		model.addAttribute("iamgeFilename", saveFilename);
		return "fileupload/result";
	}
}
