package com.dal.pharmacy.Pharmacy.management;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.dal.pharma.PharmacyApplication;
import com.dal.pharma.controller.PharmaRestController;

@SpringBootTest(classes = PharmacyApplication.class)
class PharmacyManagementApplicationTests {
	
	@InjectMocks
    private PharmaRestController pharmaRestController;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testhello() {
        String result=PharmaRestController.hello();
        assertEquals("Hi all",result);
}
}