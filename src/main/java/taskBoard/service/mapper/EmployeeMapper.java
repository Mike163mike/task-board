package taskBoard.service.mapper;

import org.mapstruct.Mapper;
import taskBoard.model.Employee;
import taskBoard.service.dto.request.EmployeePostRequestDto;
import taskBoard.service.dto.request.EmployeePutRequestDto;
import taskBoard.service.dto.response.EmployeeResponseDto;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeResponseDto map(Employee employee);

    Employee map(EmployeePostRequestDto employeePostRequestDto);

    Employee update(EmployeePutRequestDto employeePutRequestDto);

    default Set<EmployeeResponseDto> toSet(Set<Employee> models) {
        return models.stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }
}

