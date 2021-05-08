package com.the.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.service.BoardListService;
import com.the.service.BoardService;
import com.the.service.BoardWriteService;


@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("URI : " + uri);
		String[] strs = uri.split("[/]");
		String key = strs[strs.length-1];
		
		String path = null;
		
		//비지니스 로직은 service를 통해서 합니다.
		BoardService boardService = null;
		
		if(key.equals("list")) {
			boardService = new BoardListService();
		} else if(key.equals("write-page")) {
			boardService = new BoardWriteService();
		}
		
		//서비스 실행
		if(boardService != null) {
			path = boardService.process(request, response);
		}
	
		//view
		if(path != null) {
			request.getRequestDispatcher(path).forward(request, response);
		}
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
