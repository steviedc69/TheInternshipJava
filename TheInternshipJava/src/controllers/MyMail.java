/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domain.Opdracht;
import domain.Status;
import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MyMail {

    private static Opdracht opdracht;

    public static void stuurMail(Status oud, Opdracht opdracht) throws UnsupportedEncodingException {
        
        
        
        if (opdracht.getStatus().getNaam().equals("Afgekeurd") && !oud.getNaam().equals(opdracht.getStatus().getNaam())) {
            MyMail.opdracht = opdracht;
            setSettings();
            afgekeurd();

        }
        else if (opdracht.getStatus().getNaam().equals("Deels-toegewezen") && !oud.getNaam().equals(opdracht.getStatus().getNaam())) {
            MyMail.opdracht = opdracht;
            setSettings();
            goedgekeurd();

        }
    }
    
    private static String from = "thomascloostermans@gmail.com";
    private static final String username = "thomascloostermans@gmail.com";
    private static final String password = "comu1365";
    private static String host = "smtp.gmail.com";
    private static Properties props = new Properties();
    private static Session session;
    private static String to;
    public static void setSettings(){
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        to = opdracht.getBedrijf().getUser().getUsername();
    }
    
    public static void afgekeurd() {
        // Recipient's email ID needs to be mentioned.
        //change accordingly


        // Assuming you are sending email through relay.jangosmtp.net
        

        
        

        // Get the Session object.
        

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Afgekeurd");

            // Now set the actual message
            message.setText("U stagevoorstel is afgkeurd");

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void goedgekeurd() {
        // Recipient's email ID needs to be mentioned.
        //change accordingly


        // Assuming you are sending email through relay.jangosmtp.net
        

        
        

        // Get the Session object.
        

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Goedgekeurd");

            // Now set the actual message
            message.setText("U stagevoorstel is goedgekeurd");

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
