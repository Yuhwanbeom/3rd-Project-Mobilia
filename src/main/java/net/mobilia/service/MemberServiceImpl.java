package net.mobilia.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import net.mobilia.dao.MemberDAO;
import net.mobilia.vo.MailVO;
import net.mobilia.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mDao;
	
	@Autowired
	private MailSender mailSender;

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
	//메일 생성, 임시비번으로 회원비번 변경
	@Override
	public MailVO createMailAndChangePassword(String memberEmail, String m_id) {
		String str = getTempPassword();
		MailVO mv = new MailVO();
		mv.setAddress(memberEmail);
		mv.setTitle("mobilia 임시비밀번호 안내 이메일 입니다.");
		mv.setMessage("안녕하세요. mobilia 임시비밀번호 안내 관련 이메일 입니다." + " 회원님의 임시 비밀번호는 "
				+ str + " 입니다." + "로그인 후에 비밀번호를 변경을 해주세요");
		updatePassword(str,m_id);
		return mv;
	}
	//임시 비밀번호로 회원 비밀번호 변경
	private void updatePassword(String str, String m_id) {
		String memberPassword = str;
        String memberId = m_id;
        MemberVO mv=new MemberVO();
        mv.setM_id(memberId);
        mv.setM_pwd(memberPassword);
        mDao.updatePassword(mv);
	}
	//메일보내기
	@Override
	public void mailSend(MailVO mv) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mv.getAddress());
        message.setSubject(mv.getTitle());
        message.setText(mv.getMessage());
        message.setFrom("@naver.com");
        message.setReplyTo("@naver.com");
        mailSender.send(message);
	}
	//랜덤함수로 임시비밀번호 구문 만들기
	public String getTempPassword(){
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

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

	@Override
	public int searchMember(MemberVO m) {
		return this.mDao.searchMember(m);
	}

	@Override
	public void find_pwd(HttpServletResponse resp, MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
