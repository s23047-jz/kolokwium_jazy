package pl.pjwstk.jazs23047nbp.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjwstk.jazs23047nbp.Repositories.CurrencyRepository;

import java.util.Currency;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final RestTemplate restTemplate;

    public CurrencyService(CurrencyRepository currencyRepository, RestTemplate restTemplate) {
        this.currencyRepository = currencyRepository;
        this.restTemplate = restTemplate;
    }

    public java.util.Currency getCurrencies() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/tables/a/", String.class);
        return java.util.Currency.getInstance(response.getBody());
    }

    public java.util.Currency getGoldValue(String startDate, String endDate) {
        Currency exchange = restTemplate.getForEntity("http://api.nbp.pl/api/cenyzlota"
                +"/"+startDate+"/"+endDate+"/", Currency.class).getBody();
        return exchange;
    }
}
