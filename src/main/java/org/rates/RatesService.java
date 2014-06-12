package org.rates;

import org.springframework.stereotype.Service;

import java.util.IntSummaryStatistics;

/**
 * @author Jakub Kubrynski
 */
@Service
public class RatesService {

	private IntSummaryStatistics statistics = new IntSummaryStatistics();

	public void rate(int rate) {
		statistics.accept(rate);
	}

	public String getRates() {
		return statistics.toString();
	}
}
