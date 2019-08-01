package assignment.junit.com.yash.training;


import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import assignment.junit.com.yash.training.exception.DifferentCurrenciesException;
import assignment.junit.com.yash.training.model.Product;
import assignment.junit.com.yash.training.model.ProductType;
import assignment.junit.com.yash.training.model.Amount;
import assignment.junit.com.yash.training.model.Currency;


@RunWith(MockitoJUnitRunner.class)
public class ClientBOImplTest {
	
	@InjectMocks
    private ClientBOImpl clientboimpl;
	
	@Test(expected = DifferentCurrenciesException.class)
	public void shouldThrowExceptionWhenCurrencyIsNotSameForAllProducts() throws DifferentCurrenciesException{
		
        Product firstProduct = new ProductImpl(1001, "Saving", ProductType.BANK_GUARANTEE,
        		new AmountImpl(new BigDecimal(5000),Currency.INDIAN_RUPEE));
        Product secondProduct = new ProductImpl(1002, "Loan", ProductType.LOAN,
                new AmountImpl(new BigDecimal(10000), Currency.UNITED_STATES_DOLLAR));
        Product thirdProduct = new ProductImpl(1003, "Credit", ProductType.KREDIT,
                new AmountImpl(new BigDecimal(20000), Currency.EURO));
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(firstProduct);
		productList.add(secondProduct);
		productList.add(thirdProduct);
		
		clientboimpl.getClientProductsSum(productList);
		}
	
	
	@Test
	public void shouldReturnTotalAmountOfAllProductsWhenCurrencyIsSame() throws DifferentCurrenciesException{
		
		Product firstProduct = new ProductImpl(1001, "Saving", ProductType.BANK_GUARANTEE,
                new AmountImpl(new BigDecimal(5000), Currency.INDIAN_RUPEE));
		Product secondProduct = new ProductImpl(1002, "Loan", ProductType.LOAN,
                new AmountImpl(new BigDecimal(3000), Currency.INDIAN_RUPEE));
		Product thirdProduct = new ProductImpl(1003, "Credit", ProductType.KREDIT,
                new AmountImpl(new BigDecimal(2000), Currency.INDIAN_RUPEE));
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(firstProduct);
		productList.add(secondProduct);
		productList.add(thirdProduct);
		
		BigDecimal actualAmount = clientboimpl.getClientProductsSum(productList).getValue();
        
        assertEquals(BigDecimal.valueOf(10000), actualAmount);

	}
	
    
	@Test
    public void shouldReturnsAmountObjectWhenProductsSizeIsZero() throws DifferentCurrenciesException {
		
		Amount expectedAmountObj = new AmountImpl(BigDecimal.ZERO, Currency.EURO);
                    
        List<Product> productList = new ArrayList<Product>();
                                  
        Amount actualAmountObj = clientboimpl.getClientProductsSum(productList);
                                  
        assertEquals(expectedAmountObj.getCurrency(), actualAmountObj.getCurrency());
        assertEquals(expectedAmountObj.getValue(), actualAmountObj.getValue());
	}

  }
