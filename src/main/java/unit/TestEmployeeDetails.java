package unit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by ZhangHongbin on 2017/3/9.
 */
public class TestEmployeeDetails {
    EmployeeDetails employeeDetails = new EmployeeDetails();
    EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();

    @Test
    public void testCalculateYearlySalary() {
        employeeDetails.setAge(28);
        employeeDetails.setMonthlySalary(8000);
        employeeDetails.setName("wangBaoQ");
        double salary = empBusinessLogic.calculateYearlySalary(employeeDetails);
        assertEquals(96000, salary, 0.0);

    }

    @Test
    public void testCalculateAppraisal() {
        employeeDetails.setName("Xingxing");
        employeeDetails.setAge(52);
        employeeDetails.setMonthlySalary(8000);

        double appraisal = empBusinessLogic.calculateAppraisal(employeeDetails);

        assertEquals(500, appraisal, 0.0);
    }


}
