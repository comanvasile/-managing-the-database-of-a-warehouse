package bll.validators;

import model.Stoc;

public class StocCantitateValidator implements Validator<Stoc> {
	public void validate(Stoc t) {

		if (t.getCantitate()<0) {
			throw new IllegalArgumentException("Cantitate negativa");
		}

	}

}
