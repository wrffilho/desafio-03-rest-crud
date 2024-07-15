package com.devsuperior.desafio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.desafio.entities.Client;
import com.devsuperior.desafio.repositories.ClientRepository;

import dto.ClientDTO;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {

		Optional<Client> optClient = repository.findById(id);
		//Client client = optClient.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

		Client client = optClient.get();
		ClientDTO dto = new ClientDTO(client);

		return dto;
	}

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {

		Page<Client> result = repository.findAll(pageable);

		Page<ClientDTO> products = result.map(ClientDTO::new);

		return products;
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		copyDtoToEntity(dto, entity);
		Client result = repository.save(entity);
		return new ClientDTO(result);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO productDTO) {
		Client entity = repository.getReferenceById(id);
		copyDtoToEntity(productDTO, entity);
		Client result = repository.save(entity);
		return new ClientDTO(result);
	}

	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}

}
