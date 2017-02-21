package emailusingdependentprotocol;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendValidateRegistration {

	
public static void send(String emailId, String token, String hostName, String scheme) throws Exception{
		
		
	

    // Sender's email ID needs to be mentioned
    String from = "noreply@edjab.com";
    final String username = "noreply@edjab.com";//change accordingly
    final String password = "Smile4yes";//change accordingly

    // Assuming you are sending email through relay.jangosmtp.net
    String host = "smtpout.secureserver.net";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "25");

    // Get the Session object.
    Session session = Session.getInstance(props,
       new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(username, password);
          }
	});

    try {
          
          Message message = new MimeMessage(session);

 	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));

	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(emailId));

	   // Set Subject: header field
	   message.setSubject("Testing Subject");

	   // Send the actual HTML message, as big as you like
	   /*message.setContent(
			   "<img src=\""+scheme+"://"+hostName+":"+port+contextPath+"/img/logo.jpg\" width=\"210\"	height=\"50\" />"+
			   "<br><h4>Dear User</h4>"+
				
            "<a style=\"color:black;decoration:none;\" href="+scheme+"://"+hostName+":"+port+contextPath+"/RegistrationValidated/?userId="+emailId+"&token="+token+">Please click this link to validate your account with edjab...</a>",
           "text/html");*/
	   
	   
	   message.setContent(   
			   
			   "<html><head>"+
			   "<link rel=\"stylesheet\""+
			   "</head>"+
			   "<body>"+
			   "<div style=\"background:#5b5b5b;\" class=\"container\">"+
			   "<div  class=\"col-lg-12 col-md-12 col-sm-12\">"+
			   "<img style=\" margin-top: 10px;margin-left: 10px;"+
			   "margin-bottom: 10px;\" src=\""+scheme+"://"+hostName+"/img/logo.jpg\""+
			   "width=\"200px\" height=\"80px\">"+
			   "</img>"+
			   "</div>"+
			   "</div>"+
			   "<br/>"+
			   "<div class=\"container\">"+
			   "<div style=\"background:#ececec;\" class=\"col-lg-12 col-md-12 col-sm-12\">"+
			   "<div style=\"padding: 5px; margin-bottom: 17px; margin-top: 17px;background: #48d1cc;\">"+		
			   "<div style=\"text-align: center;margin: 10px;padding: 3px;"+				   
			   "font-variant: small-caps;font-family: Times New Roman, Times, serif;"+
			   "background: white;"+
			   "font-size: 18px;\">"+
			   "<span style=\"color:blue\">PLEASE VALIDATE YOUR CREDENTIALS</span>"+
			   "</div>"+
			   "<p"+
			   "style=\"color:orange;font-size:22px; margin-top: 30px;font-variant:"+
			   "small-caps;font-family: Times New Roman, Times, serif;\">"+
			   "<b style=\"font:inherit;\"><p style=\"font-size: 18px;background:white;padding:10px;margin:10px;font-weight:500\">"+
			   "Hi,"+
			   "<br>"+
			   "<br>"+			   
			   "Please click this link to validate your account."+			  
			   "<br/>"+
			   "<a class=\"label\" href=\""+
			   scheme+"://"+hostName+"/RegistrationValidated/?userId="+emailId+"&token="+token+
			   "\" style=\"background:blue;color:white;text-decoration: none;padding: 3px;\">Activate</a>"+
			   "<br>"+
			   "<br>"+
			   "-Edjab.com"+
			   "<br>"+
			   "<br>"+
			   "<a href=\""+
			   scheme+"://"+hostName+"/viewProfile/?emailId="+emailId+
			   "\" style=\"border-radius: 0px;background:#ededed;text-decoration: none;padding: 7px;"+
			   "color: black;font-size: 15px;\" class=\"btn btn-default\">View Profile</a>"+
			   "<br>"+
			   "</p>"+
			   "</b></p>"+
			   "</div>"+
			   "</div>"+
			   "</div>"+
			   "<div  class=\"container\">"+
			   "<div class=\"col-lg-12 col-md-12 col-sm-12\" style=\"text-align:center;\">"+
			   "<p style=\"padding: 10px;background: mediumturquoise;font-size: 16px;color: white;\">"+
			   "<a style=\"text-decoration:none;color:white;\" href=\""+
			   scheme+"://"+hostName+"/deactivateAccount/?emailId="+emailId+
			   "\">Unsubscribe</a> | "+
			   "<a style=\"text-decoration:none;color:white;\" href=\""+
			   scheme+"://"+hostName+"/deactivateAccount/?emailId="+emailId+
			  "\">Deactivate</a>"+
			   "</p>"+
			   "</div>"+
			   "</div>"+
			   "</body></html>"
			   , "text/html; charset=utf-8"  
			   );
	   
	   

	   // Send message
	   Transport.send(message);

    } catch (MessagingException e) {
	  
	   throw new Exception(e);
    }
	
	
	
}
	
}
