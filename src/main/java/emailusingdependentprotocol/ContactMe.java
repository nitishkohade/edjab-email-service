package emailusingdependentprotocol;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactMe {


public static void contactMe(String emailId, String text) throws Exception{
		

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

    
          // Create a default MimeMessage object.
          Message message = new MimeMessage(session);

 	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress("noreply@edjab.com"));

	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse("nitish.kohade@gmail.com"));

	   // Set Subject: header field
	   message.setSubject("Testing Subject");

	   // Send the actual HTML message, as big as you like
	 //  message.setContent("<h3> From emailId:"+emailId+"</h3><br><br><b>content:</b>"+text, "text/html; charset=utf-8");
	   
	 
	   
	   message.setContent(   
			   
			   "<html><head>"+
			   "<link rel=\"stylesheet\""+
			   "href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\""+				   
			   "crossorigin=\"anonymous\">"+
			   "</head>"+
			   "<body>"+
			   "<div style=\"background:#5b5b5b;\" class=\"container\">"+
			   "<div  class=\"col-lg-12 col-md-12 col-sm-12\">"+
			   "<img style=\" margin-top: 10px;margin-left: 10px;"+
			   "margin-bottom: 10px;\" src=\"/img/logo.jpg\""+
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
			   "<span style=\"color:blue\">From emailId:"+emailId+"</span>"+
			   "</div>"+
			   text+
			   "</b></p>"+
			   "</div>"+
			   "</div>"+
			   "</div>"+
			   "<div  class=\"container\">"+
			   "<div class=\"col-lg-12 col-md-12 col-sm-12\" style=\"text-align:center;\">"+
			   "<p style=\"padding: 10px;background: mediumturquoise;font-size: 16px;color: white;\">"+
			   "<a style=\"text-decoration:none;color:white;\" href=\"\">Unsubscribe</a> | "+
			   "<a style=\"text-decoration:none;color:white;\" href=\"\">Deactivate</a>"+
			   "</p>"+
			   "</div>"+
			   "</div>"+
			   "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.0/jquery.min.js\"></script>"+
			   "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\""+
			   "crossorigin=\"anonymous\"></script>"+
			   "</body></html>"
			   , "text/html; charset=utf-8"  
			   );
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
		Transport.send(message);
	
	
	
	
	
}	
	
	
}
