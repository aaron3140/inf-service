package com.tisson.webservice.hessian;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;



@ActiveProfiles("test")
@ContextConfiguration(locations = {"/applicationContext.xml"})
public abstract class AbstractServiceTest extends AbstractJUnit4SpringContextTests {

}
