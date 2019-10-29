package com.myclass.api.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.UserLogin;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class ApiLoginController {
	@Autowired
	private AuthenticationManager authenticationManager; // tìm đến @Bean bên ApiSecurityConfig để khởi tạo
	
	@PostMapping("api/login")
	public ResponseEntity<String> login(@RequestBody UserLogin userLogin){
		
		System.out.println(userLogin.getEmail());
		System.out.println(userLogin.getPassword());
		
		// Bước 1: Thực hiện đăng nhập
		
		// Tạo đối tượng chứa email, password
		Authentication authenticationToken= new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword());
		// thực hiện đăng nhập
		try {
			Authentication authentication = authenticationManager.authenticate( authenticationToken); // lấy xong chuyển lên UserDetailServiceImpl để check đăng nhập
			// Bước 2: Nếu đăng nhập thành công thì tạo ra token
			
			
			SecurityContextHolder.getContext().setAuthentication(authentication); // chứa thông tin đăng nhập
			UserDetails userDetails = (UserDetails)authentication.getPrincipal();
			Date now=new Date();
			
			// tạo token
			String token=Jwts.builder()
					.setSubject(userDetails.getUsername())
					.setIssuedAt(now)// lấy tại thời điểm này
					.setExpiration(new Date(now.getTime()+864000000L)) // thời gian tồn tại token
					.signWith(SignatureAlgorithm.HS512, "aabbccdd")
					.compact();
			return new ResponseEntity<String>(token,HttpStatus.OK); // TRẢ TOKEN VỀ FRONT END
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// Nếu thất bại thì trả về thông báo sai tên đăng nhập hoặc mật khẩu
		return new ResponseEntity<String>("Sai tên đăng nhập hoặc mật khẩu",HttpStatus.BAD_REQUEST);
		
	}

}
