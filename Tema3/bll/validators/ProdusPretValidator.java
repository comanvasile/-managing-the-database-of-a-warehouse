package bll.validators;

import model.Produs;

public class ProdusPretValidator implements Validator<Produs> {
	public void validate(Produs t) {

		if (t.getPret()<0) {
			throw new IllegalArgumentException("Pretul este negativ");
		}

	}
}
