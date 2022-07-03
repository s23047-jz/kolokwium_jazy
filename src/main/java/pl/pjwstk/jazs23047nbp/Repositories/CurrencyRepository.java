package pl.pjwstk.jazs23047nbp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjwstk.jazs23047nbp.Models.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
