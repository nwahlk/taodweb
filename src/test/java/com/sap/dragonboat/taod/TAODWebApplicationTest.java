package com.sap.dragonboat.taod;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@ComponentScan("com.sap.taodweb")
@WebAppConfiguration
public class TAODWebApplicationTest {
	@Test
	public void f() {
	}
}
