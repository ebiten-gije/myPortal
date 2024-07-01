package himedia.myportal.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "c:/uploads";
	
	//	멀티파트 파일을 실제 파일로 저장하는 메서드
	public String store(MultipartFile multi) {
		//	원본 파일명 확ㅇ니
		String originalFilename = multi.getOriginalFilename();
		//	확장자 분리
		String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
		String saveFilename= getSaveFilename(extName);
		
		System.out.println("New File name: " + extName);
		
		try {
			writeFile(multi, saveFilename);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return saveFilename;
	}
	
	//	멀티 파트 파일을 전달 받아서 실제 저장소에 저장하는 함수
	private void writeFile(MultipartFile multi, String saveFilename) throws IOException {
		//	멀티 파트 파일에서 바이트 데이터 얻어오기
		byte [] fileData = multi.getBytes();
		//	출력 스트림 설정
		FileOutputStream fos = new FileOutputStream (SAVE_PATH + "/" + saveFilename);
		//	출력 스트림으로 출력
		fos.write(fileData);
		//	버퍼 지우기
		fos.flush();
		//	출력 스트림 정리
		fos.close();
	}
	
	
	//	확장자를 전달 받아서 임시 파일명을 만드는 함수..
	public String getSaveFilename(String extName) {
		//	현재 시간을 밀리초 단위로 변환하여 파일 명으로 삼음
		Calendar cal = Calendar.getInstance();
		
		return String.valueOf(cal.getTimeInMillis()) + extName.toLowerCase();
	}
	
}
