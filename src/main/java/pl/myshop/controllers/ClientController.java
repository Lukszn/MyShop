package pl.myshop.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.myshop.dao.BrandDao;
import pl.myshop.dao.ClientDao;
import pl.myshop.dao.OrderDao;
import pl.myshop.dao.ProductDao;
import pl.myshop.entiti.Client;
import pl.myshop.repositories.ClientRepository;

@Controller
public class ClientController {
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(method = RequestMethod.GET,value="clients/addClient")
	public String addClientsForm(Model model) {
		
		Client newClient = new Client();
		model.addAttribute("client", newClient);
		
		return "clientForm";
	}
	
	
//	@RequestMapping( method = RequestMethod.POST,value = "clients/addClient")
//	public String clientAdd(@ModelAttribute Client client) {
//		clientDao.saveClient(client);
//		return "redirect:/clients";
//	}
	
	

	@Autowired
	Validator validator;
	
	@RequestMapping(value = "clients/addClient", method = RequestMethod.POST)
	public String processRegistration(@Valid Client client, BindingResult result) {
	if (result.hasErrors()) {
	return "clientForm";
	}
	clientDao.saveClient(client);
	return "redirect:/clients";
	}
	

	
	@RequestMapping(method = RequestMethod.GET,value="clients/edit/{id}")
	public String updateClientsForm(Model model,@PathVariable long id) {
		
		Client newClient = clientDao.findById(id);
		model.addAttribute("client", newClient);
		
		return "clientEdit";
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "clients/edit/{id}")
	public String clientUpdate(@ModelAttribute Client client) {
		clientDao.update(client);
		return "redirect:/clients";
	}
	
	@RequestMapping("clients/delete/{id}")
	public String deleteClient(@PathVariable("id") long id) {

		Client client = clientDao.findById(id);
		clientDao.delete(client);
		return "redirect:/clients";
	} 
	
	@Autowired
	ClientRepository clientRepository;
	
	@RequestMapping("/clients")
	public String clienList(Model model, HttpSession ses) {
		
		
		List<Client> clients = clientRepository.getAllCustomers();
		
		model.addAttribute("allClients", clients);
		return "client";
	}
	

	
//	@ModelAttribute("skills")
//	public Collection<String> skills() {
//	List<String> skills = new ArrayList<String>();
//	skills.add("Java");
//	skills.add("Php");
//	skills.add("python");
//	skills.add("ruby");
//	return skills;
//	}

}
