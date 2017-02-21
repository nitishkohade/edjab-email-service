package emailusingdependentprotocol;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestSendingAnEmail {

	public static void main(String[] args) throws AddressException, MessagingException {


		String emailId = "nitish.kohade@gmail.com";	
		String hostName = "localhost:8080";
		String scheme = "http";
		
		
		
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
				   "<span style=\"color:blue\">PLEASE ACTIVATE YOUR ACCOUNT</span>"+
				   "</div>"+
				   "<p"+
				   "style=\"color:orange;font-size:22px; margin-top: 30px;font-variant:"+
				   "small-caps;font-family: Times New Roman, Times, serif;\">"+
				   "<b style=\"font:inherit;\"><p style=\"font-size: 18px;background:white;padding:10px;margin:10px;font-weight:500\">"+
				   "Hi,"+
				   "<br>"+
				   "<br>"+
				   "Your account has been registered with us. In order to login, you have to activate your account."+
				   "<br><br>"+
				   "Please click the below link:"+
				   "<br/>"+
				   "<a class=\"label\" href=\"#\" style=\"background:blue;color:white;text-decoration: none;padding: 3px;\">Activate</a>"+
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
		   
		  
		   
		   
		   
		   
/*		   
   message.setContent(   
				   
			
"		   <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"+
"		   <html>"+
"		     <head>"+
"		       <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"+
"		       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>"+
"		       <title>Responsive email</title>"+
"		       <style type=\"text/css\">"+
"		         body {margin: 10px 0; padding: 0 10px; background: #F9F2E7; font-size: 13px;}"+
"		         table {border-collapse: collapse;}"+
"		         td {font-family: arial, sans-serif; color: #333333;}"+

"		         @media only screen and (max-width: 480px) {"+
"		           body,table,td,p,a,li,blockquote {"+
"		             -webkit-text-size-adjust:none !important;"+
"		           }"+
"		           table {width: 100% !important;}"+
	"	           .responsive-image img {"+
	"	             height: auto !important;"+
	"	             max-width: 100% !important;"+
	"	             width: 100% !important;"+
	"	           }"+
	"	         }"+
	"	       </style>"+
	"	     </head>"+
	"	     <body>"+
	"	       <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">"+
	"	         <tr>"+
	"	           <td>"+
	"	             <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"640\" bgcolor=\"#FFFFFF\">"+
	"	               <tr>"+
	"	                 <td bgcolor=\"#00A8C6\" style=\"font-size: 0; line-height: 0; padding: 0 10px;\" height=\"140\" "+
	"align=\"center\" class=\"responsive-image\">"+
	"	                   <img src=\"logo.png\" width=\"440\" alt=\"\" />"+
	"	                 </td>"+
	"	               </tr>"+
	"	               <tr><td style=\"font-size: 0; line-height: 0;\" height=\"30\">&nbsp;</td></tr>"+
	"	               <tr>"+
	"	                 <td style=\"padding: 10px 10px 20px 10px;\">"+
	"	                   <div style=\"font-size: 20px;\">Greetings friend!</div>"+
	"	                   <br />"+
	"	                   <div>"+
	"	                     Lorem ipsum dolor sit amet, consectetur adipiscing elit."+
	"	                     Vestibulum porta sagittis ipsum, vitae suscipit ligula adipiscing ut."+
	"	                     Nunc ac velit auctor, facilisis nibh et, hendrerit neque."+
	"	                   </div>"+
	"	                 </td>"+
	"	               </tr>"+
	"	               <tr><td style=\"font-size: 0; line-height: 0;\" height=\"1\" bgcolor=\"#F9F9F9\">&nbsp;</td></tr>"+
	"	               <tr><td style=\"font-size: 0; line-height: 0;\" height=\"30\">&nbsp;</td></tr>"+
	"	               <tr>"+
	"	                 <td>"+
	"	                   <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" width=\"49%\">"+
		                    " <tr>"+
		                   "    <td style=\"padding: 0 10px 0 10px;\" align=\"center\" class=\"responsive-image\">"+
		                  "       <img src=\"ph1.png\" width=\"290\" alt=\"\" />"+
		                 "      </td>"+
		                "     </tr>"+
		               "      <tr><td style=\"font-size: 0; line-height: 0;\" height=\"20\">&nbsp;</td></tr>"+
		              "       <tr>"+
		             "          <td style=\"padding: 0 10px 0 10px;\">"+
		            "             <div style=\"\font-weight: bold; font-size: 16px;\">Lorem ipsum</div>"+
		           "              <div>"+
		                          " Lorem ipsum dolor sit amet, consectetur adipiscing elit."+
		                         "  Vestibulum porta sagittis ipsum, vitae suscipit ligula adipiscing ut."+
		                        "   Nunc ac velit auctor, facilisis nibh et, hendrerit neque."+
		                       "  </div>"+
		                      " </td>"+
		                     "</tr>"+
		                    " <tr><td style=\"font-size: 0; line-height: 0;\" height=\"20\">&nbsp;</td></tr>"+
		                   "</table>"+
		                  " <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"right\" width=\"49%\">"+
		                     "<tr>"+
		                       "<td style=\"padding: 0 10px 0 10px;\" align=\"center\" class=\"responsive-image\">"+
		                        " <img src=\"ph2.png\" width=\"290\" alt=\"\" />"+
		                       "</td>"+
		                     "</tr>"+
		                     "<tr><td style=\"font-size: 0; line-height: 0;\" height=\"20\">&nbsp;</td></tr>"+
		                     "<tr>"+
		                       "<td style=\"padding: 0 10px 0 10px;\">"+
		                         "<div style=\"font-weight: bold; font-size: 16px;\">Lorem ipsum</div>"+
		                         "<div>"+
		                           "Lorem ipsum dolor sit amet, consectetur adipiscing elit."+
		                       "    Vestibulum porta sagittis ipsum, vitae suscipit ligula adipiscing ut."+
		                      "     Nunc ac velit auctor, facilisis nibh et, hendrerit neque."+
		                     "    </div>"+
		                    "   </td>"+
		                   "  </tr>"+
		                  "   <tr><td style=\"font-size: 0; line-height: 0;\" height=\"20\">&nbsp;</td></tr>"+
		                 "  </table>"+
		                " </td>"+
		               "</tr>"+
		               "<tr><td style=\"font-size: 0; line-height: 0;\" height=\"20\">&nbsp;</td></tr>"+
		               "<tr>"+
		                 "<td bgcolor=\"#485465\">"+
		                   "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">"+
		                  "   <tr><td style=\"font-size: 0; line-height: 0;\" height=\"15\">&nbsp;</td></tr>"+
		                 "    <tr>"+
		                "       <td style=\"padding: 0 10px; color: #FFFFFF;\">"+
		               "          Copernica BV"+
		              "         </td>"+
		             "        </tr>"+
		            "         <tr><td style=\"font-size: 0; line-height: 0;\" height=\"15\">&nbsp;</td></tr>"+
		           "        </table>"+
		          "       </td>"+
		         "      </tr>"+
		        "     </table>"+
		       "    </td>"+
		      "   </tr>"+
		     "  </table>"+
		    " </body>"+
		   "</html>"
		   
		   
		   
		   
		   
		   
		   
		   
		   
				   , "text/html; charset=utf-8"  
				   );
		   
		   */
		   
		   
		   
		   
		   
		   
		   
		   
			Transport.send(message);
		

	}

}
