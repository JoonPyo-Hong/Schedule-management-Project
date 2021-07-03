package com.project.common;

import java.util.HashMap;
//import java.util.List;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MainController {
	
	@Autowired
	private IMemberDAO dao;
	
	@RequestMapping(value="/main.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String mainPage (HttpServletRequest request, HttpServletRequest response, String id, String pw) {
		

		//1. 데이터 가져오기 (로그인한 사람의 id,pw) 
		//2. DB에서 가져온 데이터와 비교
		//3. DTO 반환 -> JSP 호출
		
		System.out.println(id);
		System.out.println(pw);
				
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("id", id);
		map.put("pw", pw);
		
		System.out.println("id "+map.get("id"));
		System.out.println("pw "+map.get("pw"));
		
		List<MemberDTO> result = dao.list(map);		

//		System.out.println("result: "+ result.getSeq());
		

		request.setAttribute("result", result);

		

		return "/main/main";
	}
}