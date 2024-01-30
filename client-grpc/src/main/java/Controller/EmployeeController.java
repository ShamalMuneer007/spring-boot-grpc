package Controller;

import Service.EmployeeGrpcClientService;
import com.google.protobuf.Descriptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmployeeController {
    private final EmployeeGrpcClientService employeeGrpcClientService;
    public EmployeeController(EmployeeGrpcClientService employeeGrpcClientService) {
        this.employeeGrpcClientService = employeeGrpcClientService;
    }

    @GetMapping("/get-employee")
    public Map<Descriptors.FieldDescriptor,Object>
    getEmployee(){
        Logger logger = LoggerFactory.getLogger(EmployeeController.class);
        logger.info("In employee method");
        return employeeGrpcClientService.getEmployee(1000);
    }
}
