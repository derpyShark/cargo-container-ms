package kpi.trspo.cargocontainerms.controller;

import javassist.NotFoundException;
import kpi.trspo.cargocontainerms.model.CargoContainer;
import kpi.trspo.cargocontainerms.service.CargoContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/cargoContainers")
public class CargoContainerController {
    private final CargoContainerService cargoContainerService;

    @Autowired
    public CargoContainerController(CargoContainerService cargoContainerService){
        this.cargoContainerService = cargoContainerService;
    }

    @GetMapping
    public List<CargoContainer> getCargoContainer(){ return  cargoContainerService.getAll();}

    @GetMapping(path = "{id}")
    public CargoContainer getCargoContainerById(@PathVariable("id") UUID id) throws NotFoundException
    {
        return cargoContainerService.getById(id);
    }

    @PostMapping
    public CargoContainer addCargoContainer(@RequestBody CargoContainer addedCargoContainer)
    {
        return cargoContainerService.create(addedCargoContainer);
    }

    @PutMapping(path = "{id}")
    public void changeCargoContainer(@PathVariable("id") UUID id, @RequestBody CargoContainer cargoContainerDetails)
            throws NotFoundException
    {
        cargoContainerService.update(id, cargoContainerDetails);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCargoContainerById(@PathVariable("id") UUID id) throws NotFoundException
    {
        cargoContainerService.delete(id);
    }
}
