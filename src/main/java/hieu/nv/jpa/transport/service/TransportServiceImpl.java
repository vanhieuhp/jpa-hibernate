package hieu.nv.jpa.transport.service;

import hieu.nv.jpa.transport.dto.CarDto;
import hieu.nv.jpa.transport.entity.Car;
import hieu.nv.jpa.transport.entity.Transport;
import hieu.nv.jpa.transport.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransportServiceImpl implements TransportService {

	private final CarRepository carRepository;


	@Override
	public Car saveCar(CarDto transport) {
		Car car = new Car();
		car.setId(transport.getId());
		car.setManufacturer(transport.getManufacturer());
		car.setSeats(transport.getSeats());
		return carRepository.save(car);
	}

	@Override
	public Car getCarById(String id) {
		return carRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
}
