package net.mobilia.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mobilia.dao.MemberDAO;
import net.mobilia.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mDao;

	@Override
	public void insertMember(MemberVO m) {
		
		this.mDao.insertMember(m);
	}

	@Override
	public MemberVO loginCheck(String m_id) {
		
		return this.mDao.loginCheck(m_id);
	}

	@Override
	public MemberVO getMemData(String m_id) {
		
		return this.mDao.getMemData(m_id);
	}

	@Override
	public void updateMember(MemberVO m) {
	
		this.mDao.updateMember(m);
	}

	@Override
	public void delMemData(MemberVO m) {
		
		this.mDao.delMemData(m);
	}

	@Override
	public MemberVO idCheck(String id) {
		
		return this.mDao.idCheck(id);
	}

	@Override
	public MemberVO idMember(MemberVO m) {
		
		return this.mDao.idMember(m);
	}

	//비밀번호 찾기 이메일발송
		@Override
		public void sendEmail(MemberVO vo, String div) throws Exception{
			// Mail Server 설정
			String charSet = "utf-8";
			String hostSMTP = "smtp.naver.com";
			String hostSMTPid = "서버 이메일 주소(보내는 사람 이메일 주소)";
			String hostSMTPpwd = "서버 이메일 비번(보내는 사람 이메일 비번)";
			
			// 보내는 사람 EMail, 제목, 내용
			String fromEmail = "보내는 사람 이메일주소(받는 사람 이메일에 표시됨)";
			String fromName = "프로젝트이름 또는 보내는 사람 이름";
			String subject = "";
			String msg = "";
			
			if(div.equals("find_pwd")) {
				subject = "movilia 임시 비밀번호 입니다.";
				msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
				msg += "<h3 style='color: blue;'>";
				msg += vo.getM_id() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
				msg += "<p>임시 비밀번호 : ";
				msg += vo.getM_pwd() + "</p></div>";
			}
			String mail = vo.getEmail();
			try {
				HtmlEmail email = new HtmlEmail();
				email.setDebug(true);
				email.setCharset(charSet);
				email.setSSL(true);
				email.setHostName(hostSMTP);
				email.setSmtpPort(587); 

				email.setAuthentication(hostSMTPid, hostSMTPpwd);
				email.setTLS(true);
				email.addTo(mail, charSet);
				email.setFrom(fromEmail, fromName, charSet);
				email.setSubject(subject);
				email.setHtmlMsg(msg);
				email.send();
			} catch (Exception e) {
				System.out.println("메일발송 실패 : " + e);
			}
		}
		//비밀번호찾기
		@Override
		public void find_pwd(HttpServletResponse response, MemberVO vo) throws Exception {
			response.setContentType("text/html;charset=utf-8");
			MemberVO ck = mdao.readMember(vo.getM_id());
			PrintWriter out = response.getWriter();
			// 가입된 아이디가 없으면
			if(mdao.idCheck(vo.getM_id()) == null) {
				out.print("등록되지 않은 아이디입니다.");
				out.close();
			}
			// 가입된 이메일이 아니면
			else if(!vo.getEmail().equals(ck.getEmail())) {
				out.print("등록되지 않은 이메일입니다.");
				out.close();
			}else {
				// 임시 비밀번호 생성
				String pw = "";
				for (int i = 0; i < 12; i++) {
					pw += (char) ((Math.random() * 26) + 97);
				}
				
				pw += "";
				
				vo.setM_pwd(pw);
				// 비밀번호 변경
				mdao.updatePw(vo);
				// 비밀번호 변경 메일 발송
				sendEmail(vo, "findpw");

				out.print("이메일로 임시 비밀번호를 발송하였습니다.");
				out.close();
			}
			
	}

}
