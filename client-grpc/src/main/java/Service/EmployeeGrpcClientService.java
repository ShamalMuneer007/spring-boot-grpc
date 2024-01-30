package Service;


import com.google.protobuf.Descriptors;
import com.shamal.Employee;
import com.shamal.EmployeeServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import javax.management.Descriptor;
import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeGrpcClientService {
    @GrpcClient("grpc-employee-service")
    EmployeeServiceGrpc.EmployeeServiceBlockingStub synchronousClient;

    public Map<Descriptors.FieldDescriptor, Object> getEmployee(int empId){
        Employee employeeRequest = Employee
                .newBuilder()
                .setEmpId(empId)
                .build();
        Employee employeeResponse = synchronousClient.getEmployee(employeeRequest);
        return employeeResponse.getAllFields();
    }
}
