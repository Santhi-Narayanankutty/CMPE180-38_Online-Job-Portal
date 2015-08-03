package com.sjsu.util;



import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sjsu.model.Job_Seeker;
import com.sjsu.model.Jobs;
import com.sun.mail.smtp.SMTPTransport;


public class MailSender {

	//sheetal code
	/*select * from Job_Post jp, job_skills js, job_seeker_skills jss
			where date_posted = current_date
			and jp.job_id = js.id
			and js.job_skills = jss.js_skills
			and js.experience <= jss.js_experience
	*/

	
	public void sendmail (String subject, String to, String content) throws Exception
	{
	      Properties props = System.getProperties();
	       props.put("mail.smtps.host","smtp.gmail.com");
	       props.put("mail.smtps.auth","true");
	       Session session = Session.getInstance(props, null);
	       Message msg = new MimeMessage(session);
	       msg.setFrom(new InternetAddress("ramsou15@gmail.com"));;
	       msg.setRecipients(Message.RecipientType.TO,
	       InternetAddress.parse(to, false));
	       msg.setSubject("New Job posted: "+subject);
	       msg.setText(content);
	       msg.setHeader("X-Mailer", "SJSU DB project - Team Name");
	       msg.setSentDate(new Date());
	       SMTPTransport t =
	           (SMTPTransport)session.getTransport("smtps");
	       // TODO
	       t.connect("smtp.gmail.com", "sjsudbproj", "team1234");
	       t.sendMessage(msg, msg.getAllRecipients());
	       System.out.println("Response: " + t.getLastServerResponse());
	       t.close();
	}
	
	
	

   
   
   
}