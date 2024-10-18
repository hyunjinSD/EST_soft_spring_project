package com.estsoft.springproject.book.repository;

import com.estsoft.springproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Member, Long> {
}
