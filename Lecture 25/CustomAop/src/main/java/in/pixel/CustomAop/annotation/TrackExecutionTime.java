package in.pixel.CustomAop.annotation;


import java.lang.annotation.*;

// to create annotation
// if annotation is empty then - this is marker annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {

    //configuration annotation
    long warnAfter() default 2000;
    String operation() default "";
}

//
