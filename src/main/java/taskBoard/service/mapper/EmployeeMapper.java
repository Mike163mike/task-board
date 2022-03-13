package taskBoard.service.mapper;

import org.springframework.stereotype.Component;
import taskBoard.service.dto.EmployeeDto;
import taskBoard.model.Employee;

@Component
public class EmployeeMapper {

    public EmployeeDto toDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPassword(employee.getPassword());
        employeeDto.setRole(employee.getRole());
        employeeDto.setSubscription(employee.isSubscription());
        return employeeDto;
    }

    public Employee toEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(employeeDto.getPassword());
        employee.setRole(employeeDto.getRole());
        employee.setSubscription(employeeDto.isSubscription());
        return employee;
    }

}
