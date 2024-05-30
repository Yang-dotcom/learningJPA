package com.example.learningjpa.repository;


import com.example.learningjpa.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByJob(String firstName);
    List<Employee> findByJobContaining(String name);
    List<Employee> findByRegistryAge(Integer age);
    List<Employee> findByRegistryRegistryName(String name);

    /**
     * Jpa queries are based on the defined classes, not on the tables
     * of the database. ?1 signifies the first parameters of the method.
     * The language used is called JPQL
     * @param job
     * @return
     */
    // this is a Jpa query, different from a sql query
    @Query("select e from Employee e where e.job = ?1")
    Employee getEmployeeByJob(String job);

    /**
     * Query in native SQL language of the DBMS used. In this case the dialect is postgres
     * @param job
     * @return
     */
    @Query(
            value="select * from employees e where e.job = ?1",
            nativeQuery=true
    )
    Employee getEmployeeByJob3(String job);

    /**
     * native query named parameters
     * @param job
     * @return
     */
    @Query(
            value="select * from employees e where e.job = :job",
            nativeQuery=true
    )
    Employee getEmployeeByJob4(@Param("job") String job);

    /**
     * Note: a modifying query is transactional. a modifying query is
     * when we insert,update, and delete. @Transaction assures that
     * operations are atomic and changes to the db are not left in an
     * inconsistent state.
     * @Modifying is needed bc this tells JPA that the query modifies the db.
     * without it the JPA will expect a read only operation and may throw an exception.
     *
     * Ideally @Transactional is used at the service layer to exceute methods atomically
     *
     * @param firstName
     * @param job
     * @return
     */
    @Transactional
    @Modifying
    @Query(
            value = "update employees set first_name = :firstName where job = :job",
            nativeQuery=true
    )
    int updateEmployeeByJob(@Param("firstName") String firstName, @Param("job") String job);






}
