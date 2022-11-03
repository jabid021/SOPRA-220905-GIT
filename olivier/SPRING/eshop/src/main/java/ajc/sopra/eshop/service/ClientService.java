package ajc.sopra.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.eshop.exception.IdException;
import ajc.sopra.eshop.model.Client;
import ajc.sopra.eshop.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepo;

	public List<Client> findAll() {
		return clientRepo.findAll();
	}

	public Client findById(Integer id) {
		return clientRepo.findById(id).orElseThrow(IdException::new);
	}

	public Client save(Client client) {
		return clientRepo.save(client);
	}
}
