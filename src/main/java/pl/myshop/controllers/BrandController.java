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

import pl.myshop.dao.BrandDao;
import pl.myshop.dao.ClientDao;
import pl.myshop.dao.OrderDao;
import pl.myshop.dao.ProductDao;
import pl.myshop.entiti.Brand;
import pl.myshop.repositories.BrandRepository;

@Controller
public class BrandController {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(method = RequestMethod.GET,value="brands/addBrand")
	public String addProduct(Model model) {
		Brand newBrand = new Brand();
		model.addAttribute("brand", newBrand);
		return "addBrand";
	}
	
//	@RequestMapping("brands/add")
//	public String addBrand(Model model, HttpSession ses) {
//		Brand newProd =Brand.genRand();
//		brandDao.saveBrand(newProd);
//		return "redirect:/brands";
//	}
	
	@Autowired
	Validator validator;
	
	@RequestMapping(value = "brands/addBrand", method = RequestMethod.POST)
	public String processRegistration(@Valid Brand brand, BindingResult result) {
	if (result.hasErrors()) {
	return "addBrand";
	}else {
	brandDao.saveBrand(brand);
	return "redirect:/brands";
	}
	}
	
	@RequestMapping("brands/delete/{id}")
	public String deleteBrand(@PathVariable("id") long id) {

		Brand newProd = brandDao.findById(id);
		brandDao.delete(newProd);
		return "redirect:/brands";
	} 
	
	@Autowired
	BrandRepository brandRepository;
	
	@RequestMapping("/brands")
	public String brandList(Model model, HttpSession ses) {
		
		
		List<Brand> brands = brandRepository.getFullList();
		model.addAttribute("brandss", brands);
		return "brands";
	}
	


}
