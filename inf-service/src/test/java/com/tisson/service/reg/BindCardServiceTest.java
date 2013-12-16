package com.tisson.service.reg;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tisson.entity.inf.BindCard;
import com.tisson.webservice.hessian.AbstractServiceTest;

public class BindCardServiceTest extends AbstractServiceTest {
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	BindCardService bindCardService;
	
	@Test
	public void testFindListByCustCode() {
		String custcode = "13250256810";
		List<BindCard> cards = bindCardService.findListByCustCode(custcode);
		if(log.isInfoEnabled())
		{
			for(BindCard bc:cards){
				log.info(bc.toString());
			}
		}
	}
}
