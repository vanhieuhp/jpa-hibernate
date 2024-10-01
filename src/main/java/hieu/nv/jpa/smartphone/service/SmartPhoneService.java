package hieu.nv.jpa.smartphone.service;

import hieu.nv.jpa.smartphone.dto.SmartPhoneDto;
import hieu.nv.jpa.smartphone.entity.Iphone;
import hieu.nv.jpa.smartphone.entity.Samsung;

import java.util.List;

public interface SmartPhoneService {
	Iphone createIphone(SmartPhoneDto smartPhone);

	Samsung createSamsung(SmartPhoneDto smartPhone);

	List<Iphone> getIphones();

	List<Samsung> getSamsungs();
}
