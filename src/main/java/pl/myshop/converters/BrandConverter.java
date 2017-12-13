package pl.myshop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import pl.myshop.dao.BrandDao;
import pl.myshop.entiti.Brand;

public class BrandConverter implements Converter<String, Brand> {

	@Autowired
	private BrandDao brandDao;
	
	@Override
	public Brand convert(String source) {
	Brand brand = brandDao.findById(Integer.parseInt(source));
	return brand;
	}

}