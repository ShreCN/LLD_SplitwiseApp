package lld.design.splitwiseapp.repositories;

import lld.design.splitwiseapp.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    public List<Expense> findAllById(Long id);
}
