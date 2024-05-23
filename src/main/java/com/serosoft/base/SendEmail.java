package com.serosoft.base;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.appium.commonactionmethods.CommonMobileActions;

public class SendEmail {
	
	public static void send()  throws Exception {
		Thread.sleep(40000);
		String to = "gujratiharsh2011@gmail.com";
		String from = "harsh.gujrati@serosoft.in";
		final String username = "harsh.gujrati@serosoft.in";// change accordingly
		final String password = "**********";// change accordingly
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(from));

		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		// Set Subject: header field
		message.setSubject("Generated cucumber report after mobile automation");

		// Create the message part
		BodyPart messageBodyPart = new MimeBodyPart();

		// Now set the actual message
		messageBodyPart.setText("Please find the attached cucumber report after text execution");

		// Create a multipar message
		Multipart multipart = new MimeMultipart();

		// Set text message part
		multipart.addBodyPart(messageBodyPart);

		messageBodyPart = new MimeBodyPart();
		String filename = System.getProperty("user.dir")+"\\target\\report\\cucumber-html-reports\\cucumber-html-reports\\overview-features.html";
		System.out.println(filename);
		DataSource source = new FileDataSource(
				filename);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);
		multipart.addBodyPart(messageBodyPart);

		// Send the complete message parts
		message.setContent(multipart);

		// Send message
		Transport.send(message);

		System.out.println("Sent message successfully....");
		
	}

	public static void main(String[] args) throws Exception {

		send();
		
		/*
		String to = "gujratiharsh2011@gmail.com";
		String from = "harsh.gujrati@serosoft.in";
		final String username = "harsh.gujrati@serosoft.in";// change accordingly
		final String password = "Iluv@pple0";// change accordingly
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(from));

		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		// Set Subject: header field
		message.setSubject("Generated cucumber report after mobile automation");

		// Create the message part
		BodyPart messageBodyPart = new MimeBodyPart();

		// Now set the actual message
		messageBodyPart.setText("Please find the attached cucumber report after text execution");

		// Create a multipar message
		Multipart multipart = new MimeMultipart();

		// Set text message part
		multipart.addBodyPart(messageBodyPart);

		messageBodyPart = new MimeBodyPart();
		String filename = System.getProperty("user.dir")+"\\target\\report\\cucumber-html-reports\\cucumber-html-reports\\overview-features.html";
		System.out.println(filename);
		DataSource source = new FileDataSource(
				filename);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);
		multipart.addBodyPart(messageBodyPart);

		// Send the complete message parts
		message.setContent(multipart);

		// Send message
		Transport.send(message);

		System.out.println("Sent message successfully....");
		*/
	}
}
