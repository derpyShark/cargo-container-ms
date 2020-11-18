package kpi.trspo.cargocontainerms.service;

import javassist.NotFoundException;
import kpi.trspo.cargocontainerms.model.CargoContainer;
import kpi.trspo.cargocontainerms.repository.CargoContainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CargoContainerServiceImpl implements CargoContainerService {
    private CargoContainerRepository cargoContainerRepository;

    @Override
    public List<CargoContainer> getAll() {
        return cargoContainerRepository.findAll();
    }

    @Override
    public CargoContainer getById(UUID cargoContainerId) throws NotFoundException {
        Optional<CargoContainer> cargoContainerMaybe = cargoContainerRepository.findById(cargoContainerId);
        if(cargoContainerMaybe.isPresent()){
            return cargoContainerMaybe.get();
        }
        else
            throw new NotFoundException("No cargoContainer with such an Id: " + cargoContainerId);
    }

    @Override
    public CargoContainer create(CargoContainer cargoContainerObject) {
        return cargoContainerRepository.save(cargoContainerObject);
    }

    @Override
    public CargoContainer update(UUID cargoContainerId, CargoContainer cargoContainerDetails) throws NotFoundException {
        CargoContainer oldCargoContainer = getById(cargoContainerId);
        oldCargoContainer.setCargoType(cargoContainerDetails.getCargoType());
        oldCargoContainer.setCargoWeight(cargoContainerDetails.getCargoWeight());
        oldCargoContainer.setMachineryWithContainer(cargoContainerDetails.getMachineryWithContainer());
        return cargoContainerRepository.save(oldCargoContainer);
    }

    @Override
    public void delete(UUID cargoTypeId) throws NotFoundException{
        cargoContainerRepository.delete(getById(cargoTypeId));
    }
}
