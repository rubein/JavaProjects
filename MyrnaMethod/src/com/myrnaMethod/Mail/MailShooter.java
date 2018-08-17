package com.myrnaMethod.Mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.myrnaMethod.constants.Constants;

public class MailShooter {

	public void sendMail(String msg, Exception e) {
		
		
		
		/*String to = Constants.mailTo;
		String from = Constants.mailFrom;
		// or IP address
		
		// Get the session object
		//Properties properties = System.getProperties();
		Properties properties = new Properties();
		
		properties.put("mail.smtp.host", Constants.host);
		properties.put("mail.smtp.socketFactory.port", Constants.mailPort);
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", Constants.authPort);
		Session session = Session.getDefaultInstance(properties,
				new javax.mail.Authenticator(){
					protected PasswordAuthentication getPasswordAuthentication(){
						return new PasswordAuthentication(Constants.mailTo, Constants.password);
					}
				}
				
				);
		
		// compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			if(e == null){
				message.setSubject("Drug To Drug Evaluation Query");
				message.setText(msg);
			}else{
				message.setSubject("Drug To Drug Exception");
				message.setText(msg + e);
			}
			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}*/
	}


	public static void main(String[] args) {
		new MailShooter().sendMail("hey there", null);
	}
}
