import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class CompanyTest {

    private Company company;

    @Before
    public void setUp() throws Exception {
        Resource rsc1 = new Resource(10000, "rsc1");
        Resource rsc2 = new Resource(5000, "rsc2");
        Vector<Resource> object_pool = new Vector<Resource>();
        object_pool.add(rsc1);
        object_pool.add(rsc2);
        ResourcePool rp = new ResourcePool(object_pool,100);
        company = new Company(rp);
    }

    @Test
    public void shouldAddEmployeeWhenHireEmployeeRuns() throws Exception {
        company.hireEmployee(new Employee("malikeh"));
    }

    @Test
    public void shouldWhenFireEmployeeRuns() throws Exception {
        company.fireEmployee(new Employee("ali"));
    }

    @Test
    public void goBankruptEdgeCoverageTestPath() throws Exception {
        company.hireEmployee(new Employee("nasim"));
        int company_value = company.goBankrupt();
        assertEquals(10000, company_value);
    }

    @Test
    public void goBankruptPrimePathCoverageTestPath1() throws Exception {
        int company_value = company.goBankrupt();
        assertEquals(10000, company_value);
    }

    @Test
    public void goBankruptPrimePathCoverageTestPath2() throws Exception {
        company.hireEmployee(new Employee("akbar"));
        company.hireEmployee(new Employee("gholi"));
        int company_value = company.goBankrupt();
        assertEquals(10000, company_value);
    }

//    @Test
//    public void sellEverythingEdgeCoverageTestPath() throws Exception {
//        Resource rsc = new Resource(5000, "rsc2");
//        Vector<Resource> object_pool = new Vector<Resource>();
//        object_pool.add(rsc);
//        ResourcePool rp = new ResourcePool(object_pool,100);
//        company = new Company(rp);
//        company.hireEmployee(new Employee("nasim"));
//        int value = company.sell_everything();
//        assertEquals(10000, company_value);
//    }
//
//    @Test
//    public void sellEverythingPrimePathCoverageTestPath1() throws Exception {
//        int company_value = company.goBankrupt();
//        assertEquals(10000, company_value);
//    }
//
//    @Test
//    public void sellEverythingPrimePathCoverageTestPath2() throws Exception {
//        company.hireEmployee(new Employee("akbar"));
//        company.hireEmployee(new Employee("gholi"));
//        int company_value = company.goBankrupt();
//        assertEquals(10000, company_value);
//    }


}