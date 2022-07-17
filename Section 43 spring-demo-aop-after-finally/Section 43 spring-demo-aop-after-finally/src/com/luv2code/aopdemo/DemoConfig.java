//the java config file

package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //for pure java config
@EnableAspectJAutoProxy // spring aop proxy support
@ComponentScan("com.luv2code.aopdemo") //scan for components and aspects
public class DemoConfig {

}
