package taskBoard.service.mapper;

import org.mapstruct.Mapper;
import taskBoard.model.Employee;
import taskBoard.service.dto.EmployeeDto;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeDto employeeDto);
}
