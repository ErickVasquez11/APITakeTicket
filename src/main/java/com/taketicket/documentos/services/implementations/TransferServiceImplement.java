package com.taketicket.documentos.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taketicket.documentos.models.dtos.transfer.SaveTranferAllDTO;
import com.taketicket.documentos.models.dtos.transfer.UpdateTransferAllDTO;
import com.taketicket.documentos.models.entities.Transfer;
import com.taketicket.documentos.repositories.TransferRepository;
import com.taketicket.documentos.services.TransferService;

@Service
public class TransferServiceImplement implements TransferService {

	@Autowired
	private TransferRepository repository;

	@Override
	public void save(SaveTranferAllDTO transferInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UpdateTransferAllDTO transferInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOneById(String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Transfer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transfer> findFragmentUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
