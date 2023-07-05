package com.taketicket.documentos.services;

import java.util.List;

import com.taketicket.documentos.models.dtos.transfer.SaveTranferAllDTO;
import com.taketicket.documentos.models.dtos.transfer.UpdateTransferAllDTO;
import com.taketicket.documentos.models.entities.Transfer;

public interface TransferService {

	void save(SaveTranferAllDTO transferInfo) throws Exception;
	void update(UpdateTransferAllDTO transferInfo) throws Exception;
	void deleteOneById(String code);
	List<Transfer> findAll();
	List<Transfer> findFragmentUser (String user);
}
