package br.com.menotti.springweight.repositories;

import br.com.menotti.springweight.model.User;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Integer> {

    public Iterable<User> findByNameContainingIgnoreCase(String splitName);

}

