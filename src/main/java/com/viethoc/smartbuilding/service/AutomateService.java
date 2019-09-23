package com.viethoc.smartbuilding.service;

import com.viethoc.smartbuilding.model.Automate;
import com.viethoc.smartbuilding.model.Sensor;
import com.viethoc.smartbuilding.repository.automate.AutomateRepository;
import com.viethoc.smartbuilding.repository.sensor.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomateService {

    @Autowired
    private AutomateRepository automateRepository;

    @Autowired
    private SensorRepository sensorRepository;

    public List<Automate> getAllAutomates() {
        return automateRepository.findAll();
    }

    public Automate addAutomate(Automate automate) {
        return automateRepository.save(automate);
    }

    public Automate updateAutomate(Long id, Automate automate) {
        automate.setId(id);
        return automateRepository.save(automate);
    }

    public void deleteAutomate(Long id) {
        automateRepository.deleteById(id);
    }

    public List<Automate> getAllAutomatesActive(){
        return automateRepository.findAllByActive(true);
    }

    public List<Sensor> getAllSensorByAutomate(Long id) {
        return sensorRepository.findAllByAutomateId(id);
    }

}

