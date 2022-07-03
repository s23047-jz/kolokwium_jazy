package pl.pjwstk.jazs23047nbp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjwstk.jazs23047nbp.Services.CurrencyService;

import java.util.Currency;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public Currency getAllCurrencies() {
        return currencyService.getCurrencies();
    }

    @GetMapping("/{code}/{startDate}/{endDate}")
    public Currency getCurrency(@PathVariable String code, @PathVariable String startDate, @PathVariable String endDate) {
        return currencyService.getCurrency(code, startDate, endDate);
    }
}
