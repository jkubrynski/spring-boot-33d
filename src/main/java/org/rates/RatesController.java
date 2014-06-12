package org.rates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jakub Kubrynski
 */
@RestController
public class RatesController {

	private final RatesService ratesService;

	@Autowired
	public RatesController(RatesService ratesService) {
		this.ratesService = ratesService;
	}

	@RequestMapping(value = "/rates/{rate}", method = RequestMethod.GET)
	public String rate(@PathVariable int rate) {
		if (rate < 7 || rate > 10) {
			throw new IllegalArgumentException("No such rate acceptable");
		}
		ratesService.rate(rate);
		return "Voted for " + rate;
	}

	@RequestMapping(value = "/rates", method = RequestMethod.GET)
	public String showRates() {
		return ratesService.getRates();
	}
}
