package com.example.RedisDemo.reponsitory;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.RedisDemo.entity.Employee;

@Repository
public class EmployeeRepository {
	private HashOperations hashOperations;
	private RedisTemplate<String,List<Employee>> redisTemplate;
	
	public EmployeeRepository(RedisTemplate redisTemplate) {
		super();
		this.hashOperations = redisTemplate.opsForHash();
		this.redisTemplate = redisTemplate;
	}


	@Cacheable(value = "employees", unless = "#result == null or #result.size() == 0")
    public List<Employee> getAllEmployees() {
        List<Employee> employeesFromCache = redisTemplate.opsForValue().get("employees");
        System.out.println(employeesFromCache);
        return employeesFromCache;
    }
	
	public void save(Employee employee) {
		hashOperations.put("EMPLOYEE", employee.getId(), employee);
	}

}
