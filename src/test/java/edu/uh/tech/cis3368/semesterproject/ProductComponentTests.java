package edu.uh.tech.cis3368.semesterproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductComponentTests {

    @Test
    public void productsWithNoComponentsShouldHave0Cost(){
        Product p = new Product();
        assertEquals(BigDecimal.ZERO,p.wholesaleCost());

    }

    @Test
    public void productsWithOneComponentShouldHaveCostOfComponent(){
        Product p = new Product();
        Component component = new Component();
        component.setWholesalePrice(new BigDecimal("10.00"));
        component.setName("A component");
        p.addComponent(component,1);

        assertEquals(new BigDecimal("10.00"),p.wholesaleCost());

    }
}
