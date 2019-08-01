package assignment.junit.com.yash.training.model;

import java.util.List;

import assignment.junit.com.yash.training.exception.DifferentCurrenciesException;



public interface ClientBO {

	Amount getClientProductsSum(List<Product> products)
			throws DifferentCurrenciesException;

}