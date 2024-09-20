package hieu.nv.jpa.transport.service;

import hieu.nv.jpa.transport.dto.CarDto;
import hieu.nv.jpa.transport.entity.Car;

public interface TransportService {

	Car saveCar(CarDto transport);

	Car getCarById(String id);
}
