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

    public String getCurrencies() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/tables/a/", String.class);
        return response.getBody();
    }

    public String getGoldValue(String code, String startDate, String endDate) {
        ResponseEntity<String> goldValue = restTemplate.getForEntity("http://api.nbp.pl/api/cenyzlota"
                +"/"+startDate+"/"+endDate+"/", String.class);
        ResponseEntity<String> currency = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/rates/a/" + code
                +"/"+startDate+"/"+endDate+"/", String.class);

        return " " + currency;

    }
}
