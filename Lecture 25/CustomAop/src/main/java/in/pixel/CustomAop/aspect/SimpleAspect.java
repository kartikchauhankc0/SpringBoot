package in.pixel.CustomAop.aspect;

import in.pixel.CustomAop.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

//    @Before("execution(String " +
//            "in.pixel.CustomAop.service.StudentService.getStudent(String))")
//    public void logBeforeMethod(){
//        System.out.println("method intercepted");
//    }

//    @Around("@annotation(in.pixel.CustomAop.annotation.TrackExecutionTime)")
//    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        long startTime=System.currentTimeMillis();
//
//        try {
//            return joinPoint.proceed();
//        }
//        finally {
//            long endTime=System.currentTimeMillis();
//
//            long duration=endTime-startTime;
//
//            String methodName=joinPoint.getSignature().getName();
//            System.out.println("Time taken by : "+ methodName +"-- "+ duration);
//        }
//
//
//    }


    //binding form to connect our annotation
    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint,
                                       TrackExecutionTime trackExecutionTime)
            throws Throwable {

        long startTime = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        }
        finally {
            long endTime=System.currentTimeMillis();
            long duration=endTime-startTime;

            String operation=trackExecutionTime.operation();
            if(operation.isBlank()){
                operation=joinPoint.getSignature().getName();
            }

            long warningThreshold= trackExecutionTime.warnAfter();
            if(duration>=warningThreshold){
                System.out.println("Slow operation alert :"+ "Time taken by : "+ operation +"-- "+ duration );
            }
            else{
                System.out.println("Time taken by : "+ operation +"-- "+ duration);
            }

        }


    }


}
