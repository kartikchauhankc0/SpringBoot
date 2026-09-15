package in.ask.AopDemoAdvance.aspect;

import in.ask.AopDemoAdvance.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
//
//    @Before("execution(String in.ask.AopDemoAdvance.service.StudentService.createStudent())") //point cut path
//    public void logBeforeMethod(JoinPoint joinPoint){ //joinPoint holds the all the information about the target like here StudentService class
//
//        Object[] arr=joinPoint.getArgs();
//
//        System.out.println("Student is going to be saved");
////        way to stop the service class to execute
////        boolean allowed=false;
////
////        if(!allowed){
////            throw new RuntimeException("Method is not allowed");
////        }
//    }
//
//    @AfterReturning(
//           value= "execution(" +
//                   "in.ask.AopDemoAdvance.dto.Student " +
//                   "in.ask.AopDemoAdvance.service.StudentService." +
//                   "createStudent(in.ask.AopDemoAdvance.dto.Student))",
//            returning = "result") //point cut path
//    public void logAfterReturningMethod(Student result){
//
//          result.setAge(21); // the way to modify the
//          result.setName("ankit");
//
////        System.out.println("logAfterReturningMethod called ");
//
//        System.out.println("intercepted createStudent");
//    }

//
//@AfterThrowing(
//        value= "execution(* in.ask.AopDemoAdvance.service.StudentService.createStudent(..))",
//            throwing = "exception")
//public void logAfterThrowingMethod(RuntimeException exception){
//    System.out.println("Exception type: "+exception.getClass().getName());
//    System.out.println("Exception Message: "+exception.getMessage());
//
//}

//    @After(
//            value= "execution(* in.ask.AopDemoAdvance.service.StudentService.createStudent(..))")
//    public void logAfterMethod(){
//        System.out.println("log after method called");
//    }

    @Around(
            value= "execution(* in.ask.AopDemoAdvance.service.StudentService.createStudent(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("Starting"+ joinPoint.getSignature().getName());

        try{
            Object result= joinPoint.proceed();

            System.out.println("Execution  successful");

            return result;

        } catch (Exception e) {

            System.out.println("Execution failed: "+ e.getMessage());

            throw e;
        }
        finally {

            System.out.println("Execution completed");

        }
    }
}
