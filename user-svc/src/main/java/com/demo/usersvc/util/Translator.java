package com.demo.usersvc.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class Translator {
    private static ResourceBundleMessageSource messageSource;

    public Translator(ResourceBundleMessageSource resourceBundleMessageSource){
        Translator.messageSource = resourceBundleMessageSource;
    }

    public static String toLocale(String msgCode){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgCode,null, locale);
    }
}
