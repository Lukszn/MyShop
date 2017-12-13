package pl.myshop.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;

import pl.myshop.dao.BrandDao;
import pl.myshop.dao.ClientDao;
import pl.myshop.dao.OrderDao;
import pl.myshop.dao.ProductDao;
import pl.myshop.entiti.Brand;
import pl.myshop.entiti.Product;
import pl.myshop.repositories.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private OrderDao orderDao;

	@RequestMapping(method = RequestMethod.GET, value = "products/addProduct")
	public String addProduct(Model model, HttpSession ses) {
		Product newProduct = new Product();
		model.addAttribute("product", newProduct);
		return "addProduct";
	}

	// @RequestMapping( method = RequestMethod.POST,value = "products/addProduct")
	// public String productAdd(@ModelAttribute Product product) {
	// productDao.saveProduct(product);
	// return "redirect:/products";
	// }
	@Autowired
	Validator validator;

	@RequestMapping(value = "products/addProduct", method = RequestMethod.POST)
	public String processRegistration(@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "addProduct";
		} else {
			productDao.saveProduct(product);
			return "redirect:/products";
		}
	}

	@RequestMapping("products/edit/{id}")

	public String upadteForm(Model model, @PathVariable long id) {

		model.addAttribute("product_id", id);

		return "edit";
	}

	@RequestMapping("products/edit")

	public String upadte(@RequestParam String name, @RequestParam String description, @RequestParam String unitsInStock,
			@RequestParam int price, @RequestParam int brand_id, @RequestParam long id) {

		Product newProd = productDao.findById(id);
		Brand brand = brandDao.findById(brand_id);
		newProd.setName(name);
		newProd.setPrice(price);
		newProd.setDescription(description);
		newProd.setUnitsInStock(unitsInStock);
		newProd.setBrand(brand);

		productDao.update(newProd);

		return "redirect:/products";
	}

	@RequestMapping("products/delete/{id}")
	public String delete(@PathVariable("id") long id) {

		Product newProd = productDao.findById(id);
		productDao.delete(newProd);
		return "redirect:/products";
	}

	@Autowired
	ProductRepository productRepository;

	@RequestMapping("/products")
	public String productList(Model model, HttpSession ses) {

		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "products";
	}

	@ModelAttribute("brands")
	public List<Brand> getBrands() {
		return brandDao.getList();
	}

	@RequestMapping("/products/product")
	public String getProductById(@RequestParam("id") long id, Model model) {
		model.addAttribute("product", productRepository.findOne(id));
		return "product";
	}

}
