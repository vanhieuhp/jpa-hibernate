package hieu.nv.jpa.smartphone.service;

import hieu.nv.jpa.smartphone.dto.SmartPhoneDto;
import hieu.nv.jpa.smartphone.entity.Iphone;
import hieu.nv.jpa.smartphone.entity.Samsung;
import hieu.nv.jpa.smartphone.repository.IphoneRepository;
import hieu.nv.jpa.smartphone.repository.SamsungRepository;
import hieu.nv.jpa.smartphone.repository.SmartPhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SmartPhoneServiceImpl implements SmartPhoneService {

	private final SmartPhoneRepository smartPhoneRepository;
	private final IphoneRepository iphoneRepository;
	private final SamsungRepository samsungRepository;

	@Override
	public Iphone createIphone(SmartPhoneDto smartPhone) {
		Iphone iphone = new Iphone();
		iphone.setColor(smartPhone.getColor());
		iphone.setPrice(smartPhone.getPrice());
		iphone.setModel(smartPhone.getModel());
		return iphoneRepository.save(iphone);
	}

	@Override
	public Samsung createSamsung(SmartPhoneDto smartPhone) {
		Samsung samsung = new Samsung();
		samsung.setColor(smartPhone.getColor());
		samsung.setPrice(smartPhone.getPrice());
		samsung.setSize(smartPhone.getSize());
		return samsungRepository.save(samsung);
	}

	@Override
	public List<Iphone> getIphones() {
		return iphoneRepository.findAll();
	}

	@Override
	public List<Samsung> getSamsungs() {
		return samsungRepository.findAll();
	}
}
