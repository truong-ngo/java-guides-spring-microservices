package com.javaguide.restapi.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils implements MessageSourceAware {
    public static MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }
}
