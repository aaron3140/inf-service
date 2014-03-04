package com.tisson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisson.common.utils.exception.INFException;
import com.tisson.dao.bis.CumCustomMapper;
import com.tisson.service.AbstractInfService;
import com.tisson.webservice.rest.domain.ShortcutTraderRequert;
import com.tisson.webservice.rest.domain.ShortcutTrader;

@Service
public class ShortcutTraderService extends AbstractInfService<ShortcutTraderRequert> {

	// 业务组件
	@Autowired
	CumCustomMapper cumCustomMapper;

	public ShortcutTrader getShortcatTrader(ShortcutTraderRequert request) throws INFException
			  {
		ShortcutTrader trader = new ShortcutTrader();
		
		String custId = request.getCustCode();
//		// 插入信息到入站日志表
		this.insertInfOperInLog(request);
		//检验商户
		this.checkCustCode(request);
		//md5效验
		this.verifyByMD5(request);
		
		// 单笔交易
		String perAmount = cumCustomMapper.getSingleTrader(custId , "T22",
				"TH004");
		// 累计交易
		String allAmount = cumCustomMapper.getSingleTrader(custId, "T22",
				"TH005");
		// 当月累计消费
		String allTrade = cumCustomMapper.getAmountCount(custId);

		trader.setPerAmount(perAmount);
		trader.setAllamount(allAmount);
		trader.setAlltransaction(allTrade);
//		// 插入信息到出站日志表
		this.insertInfOperInLog(request);
		return trader;
	}

	@Override
	protected Class<?> getFeaturedClass() {
		return this.getClass();
	}

}
