package pl.myshop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import pl.myshop.dao.ClientDao;
import pl.myshop.entiti.Client;

public class ClientConverter implements Converter<String, Client>{

	@Autowired
	private ClientDao clientDao;
	
	@Override
	public Client convert(String source) {
		Client client = clientDao.findById(Integer.parseInt(source));
		return client;
	}
	
}