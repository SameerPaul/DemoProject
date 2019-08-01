package assignment.junit.com.yash.training.model;

/**
 * Product Model API.
 */
public interface Product {

	long getId();

	String getName();

	ProductType getType();

	Amount getAmount();
}
