package taskBoard.service.mapper;

import org.springframework.stereotype.Component;
import taskBoard.dto.EmployeeDto;
import taskBoard.model.Employee;

@Component
public class EmployeeMapper {

    public EmployeeDto toDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());

        return employeeDto;
    }

    public Employee toEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();

        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());

        return employee;
    }

}
