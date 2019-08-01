package assignment.junit.com.yash.training;

import java.math.BigDecimal;

import assignment.junit.com.yash.training.model.Amount;
import assignment.junit.com.yash.training.model.Currency;

public class AmountImpl implements Amount {

	BigDecimal value;
	Currency currency;

	public AmountImpl(BigDecimal value, Currency currency) {
		super();
		this.value = value;
		this.currency = currency;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Currency getCurrency() {
		return currency;
	}

}
