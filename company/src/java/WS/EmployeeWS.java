package WS;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import DAO.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author sabrina
 */
@Path("rest")
public class EmployeeWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmployeeWS
     */
    public EmployeeWS() {
    }

    /**
     * Retrieves the representation of an instance of WS.EmployeeWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("employees/all")
    public String getAllEmployees() {
        EmployeeDao dao = new EmployeeDao();
        List<Employee> employeeList = dao.getList();
        Gson gson = new Gson();
        return gson.toJson(employeeList);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("employees/{employeeNumber}")
    public String getEmployeeByNumber(@PathParam("employeeNumber") int employeeNumber) {
        EmployeeDao dao = new EmployeeDao();
        Employee employee = dao.query(employeeNumber);
        if (employee != null) {
            Gson gson = new Gson();
            return gson.toJson(employee);
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("supervisors")
    public String getSupervisors() {
        EmployeeDao dao = new EmployeeDao();
        List<Employee> employeeList = dao.getList();
        List<Employee> supervisors = new ArrayList<>();

        for (Employee employee : employeeList) {
            long employeeNumber = employee.getEmployeeNumber();
            boolean isSupervisor = false;

            // Check if the current employee is a supervisor for any other employee
            for (Employee otherEmployee : employeeList) {
                if (otherEmployee.getSupervisorNumber() == employeeNumber) {
                    isSupervisor = true;
                    break;
                }
            }

            if (isSupervisor) {
                supervisors.add(employee);
            }
        }

        Gson gson = new Gson();
        return gson.toJson(supervisors);
    }
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("employees/{employeeNumber}")
    public void deleteEmployee(@PathParam("employeeNumber") int employeeNumber) {
        EmployeeDao dao = new EmployeeDao();
        dao.delete(employeeNumber);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("employees")
    public void addEmployee(String employeeJson) {
        Gson gson = new Gson();
        Employee newEmployee = gson.fromJson(employeeJson, Employee.class);

        EmployeeDao dao = new EmployeeDao();
        dao.add(newEmployee);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("employees")
    public void updateEmployee(String employeeJson) {
        Gson gson = new Gson();
        Employee updatedEmployee = gson.fromJson(employeeJson, Employee.class);

        EmployeeDao dao = new EmployeeDao();
        dao.update(updatedEmployee);
    }
}
