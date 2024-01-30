package service;

import com.shamal.Employee;
import com.shamal.EmployeeOrBuilder;
import com.shamal.EmployeeServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class EmployeeServerService extends EmployeeServiceGrpc.EmployeeServiceImplBase {
    Logger logger = LoggerFactory.getLogger(EmployeeServerService.class);

    @Override
    public void getEmployee(Employee request, StreamObserver<Employee> responseObserver) {
        try {
            Employee  responseEmployee = Employee.newBuilder()
                    .setEmpId(1001)
                    .setName("Shamal K P")
                    .setSalary(90000)
                    .build();
            logger.info("Received employee request: {}", request.getEmpId());
            responseObserver.onNext(responseEmployee);
            responseObserver.onCompleted();
        }
        catch (Exception e){
            responseObserver
                    .onError(Status
                            .INTERNAL
                            .withDescription(e.getMessage())
                            .asRuntimeException());
        }
    }
}
