package hieu.nv.jpa.transport.controller;

import hieu.nv.jpa.transport.dto.CarDto;
import hieu.nv.jpa.transport.entity.Car;
import hieu.nv.jpa.transport.service.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transports")
@RequiredArgsConstructor
public class TransportController {

	private final TransportService transportService;

    @PostMapping("/cars")
    public Car saveCar(@RequestBody CarDto transport) {
        return transportService.saveCar(transport);
    }

    @GetMapping("/cars/{id}")
    public Car getTransportById(@PathVariable String id) {
        return transportService.getCarById(id);
    }

}
