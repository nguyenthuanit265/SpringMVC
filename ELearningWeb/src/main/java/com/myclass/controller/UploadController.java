package com.myclass.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/uploadfile")
public class UploadController {
	@PostMapping("")
	public String upload(@RequestParam MultipartFile file, HttpServletRequest request) {
		try {
			// lấy ra đường dẫn thư mục chứa file

			String path = request.getServletContext().getRealPath("/" + "WEB-INF/static/upload");
			System.out.println(path);

			// tạo thư mục upload
			File dir = new File(path);
			if (!dir.exists()) { // thư mục chưa tồn tại
				dir.mkdir(); // tạo mới thư mục
			}

			// lưu file dc upload xuống thư mục
			System.out.println(file.getOriginalFilename());
			File newFile = new File(path + "/" + file.getOriginalFilename());
			file.transferTo(newFile);

			// trả về file vừa upload
			return "upload/" + file.getOriginalFilename();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "";
	}
}
