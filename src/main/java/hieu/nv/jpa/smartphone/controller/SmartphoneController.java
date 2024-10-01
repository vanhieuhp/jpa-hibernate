package hieu.nv.jpa.smartphone.controller;

import hieu.nv.jpa.smartphone.dto.SmartPhoneDto;
import hieu.nv.jpa.smartphone.entity.Iphone;
import hieu.nv.jpa.smartphone.entity.Samsung;
import hieu.nv.jpa.smartphone.service.SmartPhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {

	private final SmartPhoneService smartPhoneService;

	@PostMapping("/iphones")
	public Iphone createIphone(@RequestBody SmartPhoneDto smartPhone) {
		return smartPhoneService.createIphone(smartPhone);
	}

	@PostMapping("/samsungs")
	public Samsung createSamsung(@RequestBody SmartPhoneDto smartPhone) {
		return smartPhoneService.createSamsung(smartPhone);
	}

	@GetMapping("/iphones")
	public List<Iphone> getIphones() {
		return smartPhoneService.getIphones();
	}

	@GetMapping("/samsungs")
	public List<Samsung> getSamsungs() {
		return smartPhoneService.getSamsungs();
	}
}
