package com.optum.dgsproject.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import com.optum.dgsproject.contexts.EmployeeContext;
import com.optum.dgsproject.contexts.EmployeeContextBuilder;
import com.optum.dgsproject.domains.Employee;
import com.optum.dgsproject.filters.EmployeeFilter;
import com.optum.dgsproject.filters.FilterField;
import com.optum.dgsproject.repositories.EmployeeRepository;
import graphql.execution.DataFetcherResult;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.data.jpa.domain.Specification;


import java.util.List;
import java.util.Optional;

@DgsComponent
public class EmployeeFetcher {

    private EmployeeRepository repository;
    private EmployeeContextBuilder contextBuilder;

    public EmployeeFetcher(EmployeeRepository repository, EmployeeContextBuilder contextBuilder) {
        this.repository = repository;
        this.contextBuilder = contextBuilder;
    }

    @DgsData(parentType = "QueryResolver", field = "employees")
    public List<Employee> findAll(DataFetchingEnvironment dfe) {
        List<Employee> employees = (List<Employee>) repository.findAll();
        contextBuilder.withEmployees(employees).build();
        return employees;
    }

    @DgsData(parentType = "QueryResolver", field = "employee")
    public Employee findById(@InputArgument("id") Integer id, DataFetchingEnvironment dfe) {
        EmployeeContext employeeContext = DgsContext.getCustomContext(dfe);
        List<Employee> employees = employeeContext.getEmployees();
        Optional<Employee> employeeOpt = employees.stream().filter(employee -> employee.getId().equals(id))
                .findFirst();
        return employeeOpt.orElseGet(() -> repository.findById(id).orElseThrow(DgsEntityNotFoundException::new));
    }

    @DgsData(parentType = "QueryResolver", field = "employeesWithFilter")
    public Iterable<Employee> findWithFilter(@InputArgument("filter") EmployeeFilter filter) {
        Specification<Employee> spec = null;
        if (filter.getSalary() != null)
            spec = bySalary(filter.getSalary());
        if (filter.getAge() != null)
            spec = (spec == null ? byAge(filter.getAge()) : spec.and(byAge(filter.getAge())));
        if (filter.getPosition() != null)
            spec = (spec == null ? byPosition(filter.getPosition()) :
                    spec.and(byPosition(filter.getPosition())));
        if (spec != null)
            return repository.findAll(spec);
        else
            return repository.findAll();
    }

    private Specification<Employee> bySalary(FilterField filterField) {
        return (root, query, builder) -> filterField.generateCriteria(builder, root.get("salary"));
    }

    private Specification<Employee> byAge(FilterField filterField) {
        return (root, query, builder) -> filterField.generateCriteria(builder, root.get("age"));
    }

    private Specification<Employee> byPosition(FilterField filterField) {
        return (root, query, builder) -> filterField.generateCriteria(builder, root.get("position"));
    }
}
