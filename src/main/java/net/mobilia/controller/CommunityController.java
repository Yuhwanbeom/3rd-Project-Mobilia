package net.mobilia.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.mobilia.service.BoardService;
import net.mobilia.vo.BoardVO;

@Controller
public class CommunityController {

	@Autowired
	private BoardService boardService;

	//커뮤니티 메인창 이동
	@RequestMapping("/community_main")
	public ModelAndView community_main(HttpSession session, HttpServletResponse response,
			HttpServletRequest request) throws Exception{

		int page = 1;
		int maxview=10;

		String find_field = null;
		String find_name = null;

		if(request.getParameter("page") != null) {//get으로 전달된 페이지 번호가 있으면
			page = Integer.parseInt(request.getParameter("page"));//페이지 번호를 정수숫자로 변환
		}

		find_field = request.getParameter("find_field");
		if(request.getParameter("find_name") != null) {//검색어가 있다면
			find_name = request.getParameter("find_name").trim(); //양쪽 공백을 제거하고 검색어를 가져온다.
		}

		BoardVO findbvo = new BoardVO();
		findbvo.setFind_field(find_field); findbvo.setFind_name("%"+find_name+"%");//%는 sql 와일드 카드문자

		int listcount = boardService.getListCount(findbvo);

		findbvo.setStartrow((page-1)*10+1);//시작행 번호
		findbvo.setEndrow(findbvo.getStartrow()+maxview-1);//끝행 번호

		List<BoardVO> blist = boardService.getBoardList(findbvo);

		//총 페이지수
		int maxpage=(int)((double)listcount/maxview+0.95);
		//시작페이지(1,11,21 ..)
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		//현재 페이지에 보여질 마지막 페이지(10,20 ..)
		int endpage=maxpage;
		if(endpage>startpage+10-1) endpage=startpage+10-1;

		ModelAndView mv = new ModelAndView();
		mv.addObject("blist", blist);
		mv.addObject("page", page);
		mv.addObject("startpage", startpage);
		mv.addObject("endpage", endpage);
		mv.addObject("maxpage", maxpage);
		mv.addObject("listcount", listcount);
		mv.addObject("find_field", find_field);
		mv.addObject("find_name", find_name);
		mv.setViewName("community/board_main");
		return mv;
	}

	//커뮤니티 글쓰기로 이동
	@RequestMapping("/community_write")
	public ModelAndView community_main(HttpSession session, HttpServletResponse response)
			throws Exception{

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();

		String id=(String)session.getAttribute("id");

		if(id == null) {
			out.println("<script>");
			out.println("alert('로그인이 필요합니다');");
			out.println("location='member_login';");
			out.println("</script>");
		}else {

			ModelAndView mv = new ModelAndView();
			mv.setViewName("community/board_write");
			return mv;
		}
		return null;
	}

	//커뮤니티 글쓰기 성공
	@RequestMapping("/community_write_ok")
	public String community_write_ok(HttpSession session, HttpServletResponse response,
			HttpServletRequest request) throws Exception{

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();

		String id=(String)session.getAttribute("id");

		if(id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("location='login.net';");
			out.println("</script>");
		}else {

			request.setCharacterEncoding("utf-8");
			String board_state=request.getParameter("board_state");
			String board_title=request.getParameter("board_title");
			String board_cont=request.getParameter("board_cont");
			
			BoardVO bvo = new BoardVO();
			bvo.setBoard_name(id); bvo.setBoard_state(board_state);
			bvo.setBoard_title(board_title); bvo.setBoard_cont(board_cont);

			boardService.insertBoard(bvo);

			out.println("<script>");
			out.println("alert('게시물이 등록되었습니다!');");
			out.println("location='community_main';");
			out.println("</script>");
		}
		return null;
	}
}
