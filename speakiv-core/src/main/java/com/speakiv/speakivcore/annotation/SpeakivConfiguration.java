package com.speakiv.speakivcore.annotation;


import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@ComponentScan("com.speakiv")
public @interface SpeakivConfiguration {
}
