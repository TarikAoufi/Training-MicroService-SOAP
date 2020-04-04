package org.sid.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.sid.entity.Training;
import org.sid.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * Web service SOAP basé sur JAX-WS.
 * Permet de gérer des formations.
 *
 */
@Component
@WebService(serviceName = "TrainingWS")
public class TrainingSoapService {

	@Autowired
	private TrainingRepository trainingRepository;

	@WebMethod(operationName = "trainingList")
	public List<Training> getTrainings() {
		return trainingRepository.findAll();
	}

	@WebMethod
	public Training getTraining(@WebParam(name = "id") Long id) {
		return trainingRepository.findById(id).get();
	}

	@WebMethod
	public Training save(@WebParam(name = "training") Training training) {
		return trainingRepository.save(training);
	}

	@WebMethod
	public Training update(@WebParam(name = "id") Long id, @WebParam(name = "training") Training training) {
		training.setId(id);
		return trainingRepository.save(training);
	}

	@WebMethod
	public void delete(@WebParam(name = "id") Long id) {
		trainingRepository.deleteById(id);
	}

}
