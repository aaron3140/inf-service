package com.tisson.service.password;

import java.security.GeneralSecurityException;
import java.security.Key;

import org.springframework.stereotype.Service;

import com.bestpay.hsm.utils.Utils;

/**
 * POS密码工具类
 * @author sonsy
 *
 */
@Service
public class PosEncryService{
	private static final  String KEY_BY_LMK = "345772913265891FFFC25D5EF8D88ED7";
	
	public String genPassword(String clearPin, String ecardNo) {
		String password = "";
		try{
		Key key = Utils.getTrueTek(KEY_BY_LMK); //取出tek
		 password = Utils.getPinBlock(ecardNo, clearPin, key);
		}catch(GeneralSecurityException ex){
			ex.printStackTrace();
		}
		return password;
	}

}
