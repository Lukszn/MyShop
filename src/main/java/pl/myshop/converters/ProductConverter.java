package pl.myshop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import pl.myshop.dao.ProductDao;
import pl.myshop.entiti.Product;

public class ProductConverter implements Converter<String, Product>{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product convert(String source) {
		Product product = productDao.findById(Integer.parseInt(source));
		return product;
	}
	
}