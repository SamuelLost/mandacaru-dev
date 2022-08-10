package br.ufc.mandacaru.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.mandacaru.spring.model.Feedback;

public interface FeedbackRepository extends JpaRepository <Feedback, Integer > {
	List<Feedback> findByProductId (int id);
}
