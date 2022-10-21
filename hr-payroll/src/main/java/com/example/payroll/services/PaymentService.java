package com.example.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payroll.entities.Payment;
import com.example.payroll.entities.Worker;
import com.example.payroll.feignclients.WorkerFeignClient;

@Service  //Indica que é um componente do spring
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {		
		
		Worker worker = workerFeignClient.findById(workerId).getBody(); // tem que usar o getBody() para pegar o corpo da resposta que
		                                                                // é do tipo Worker
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
