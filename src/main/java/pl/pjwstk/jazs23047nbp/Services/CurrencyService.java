package pl.pjwstk.jazs23047nbp.Services;

import org.springframework.stereotype.Service;
import pl.pjwstk.jazs23047nbp.Models.Currency;
import pl.pjwstk.jazs23047nbp.Repositories.CurrencyRepository;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }
}
