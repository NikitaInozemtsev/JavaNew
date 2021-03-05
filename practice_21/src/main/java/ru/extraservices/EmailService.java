package ru.extraservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.model.Item;
import ru.model.Order;

import javax.mail.*;
import javax.mail.internet.*;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


@Service
@Transactional
public class EmailService {



    @Autowired
    private JavaMailSender javaMailSender;


    @Async
    public void sendEmailItem(Item w) {

        SimpleMailMessage message = new SimpleMailMessage();
      //  message.setFrom("kamacringe@yandex.ru");
        message.setTo("okostya2002@yandex.ru");
        message.setSubject("ItemCreation");
        message.setText("Item created " + w.toString());
        javaMailSender.send(message);


    }

    @Async
    public void sendEmailOrder(Order w) {

        SimpleMailMessage message = new SimpleMailMessage();
        //  message.setFrom("kamacringe@yandex.ru");
        message.setTo("okostya2002@yandex.ru");
        message.setSubject("OrderCreation");
        message.setText("Order created " + w.toString());
        javaMailSender.send(message);


    }



}
