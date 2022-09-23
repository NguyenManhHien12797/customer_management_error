package cg.wbd.grandemonstration.logger;

import cg.wbd.grandemonstration.model.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Aspect
@Component
public class Logger {

    public void error() {
        System.out.println("[CMS] ERROR!");
    }

    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.CustomerService.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
//    @Override
//    public Page<Customer> findAll(Pageable pageInfo) throws Exception{
//        if (true) throw new Exception("a dummy exception");
//    }
//    @Override
//    public Optional<Customer> findOne(Long id) throws Exception {
//        Optional<Customer> customerOptional = customerRepository.findById(id);
//        if (!customerOptional.isPresent()) {
//            throw new Exception("customer not found!");
//        }
//        return customerOptional;
//    }
}
