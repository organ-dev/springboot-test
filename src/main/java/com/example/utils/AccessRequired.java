package com.example.utils;

import java.lang.annotation.*;

/**
 * @Auther: ld
 * @Date: 2019/6/12 15:47
 * @Param ${tags}
 * @Description:
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AccessRequired {
	String value() default "first one";
}