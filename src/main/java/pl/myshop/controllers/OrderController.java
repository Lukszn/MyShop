package pl.myshop.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.myshop.dao.BrandDao;
import pl.myshop.dao.ClientDao;
import pl.myshop.dao.OrderDao;
import pl.myshop.dao.ProductDao;
import pl.myshop.entiti.Client;
import pl.myshop.entiti.Order;
import pl.myshop.entiti.Product;
import pl.myshop.repositories.OrderRepository;

@Controller
public class OrderController {
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(value="orders/addOrder",method = RequestMethod.GET)
	public String addOrder(Model model) {
		Order newOrder = new Order();
		model.addAttribute("order", newOrder);
		return "addOrder";
	}
	
	@RequestMapping(value = "orders/addOrder", method = RequestMethod.POST)
	public String orderAdd(@ModelAttribute Order order) {
		orderRepository.save(order);
		return "redirect:/orders";
	}
	@RequestMapping("orders/delete/{id}")
	public String delete(@PathVariable("id") long id) {

		Order newProd = orderDao.findById(id);
		orderDao.delete(newProd);
		return "redirect:/orders";
	}
	
	@Autowired
	OrderRepository orderRepository;
	
	@RequestMapping("/orders")
	public String orderList(Model model, HttpSession ses) {
		
		//Client client = clientDao.findById(36);
		List<Order> orders = orderRepository.findAll();
		model.addAttribute("orders", orders);
		return "orders";
	}
	
	@ModelAttribute("clients")
	public List<Client> getClients(){
		return clientDao.getList();
	}
	
	@ModelAttribute("products")
	public List<Product> getProducts(){
		return productDao.getList();
	}

}
