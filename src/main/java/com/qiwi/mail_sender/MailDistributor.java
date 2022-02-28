package com.qiwi.mail_sender;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

/**
 * @author Evgeny Borisov
 */
@Service
public class MailDistributor {

    private Map<Integer, MailGenerator> mailGeneratorMap;


    public MailDistributor(List<MailGenerator> mailGenerators) {

        mailGeneratorMap = mailGenerators.stream().collect(Collectors.toMap(MailGenerator::type, identity()));
    }

    public void distributeMail(Message message) {

        Integer type = message.getType();
        MailGenerator mailGenerator = mailGeneratorMap.get(type);
        if (mailGenerator == null) {
            throw new UnsupportedOperationException(type + " not supported yet");
        }
        String mail = mailGenerator.generateMailFromTemplate(message);
        send(mail);


    }

    private void send(String mail) {
        System.out.println("mail = " + mail);
    }
}






