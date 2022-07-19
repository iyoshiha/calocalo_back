package jp.co.calocalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.calocalo.entity.AdminEntity;


public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
}
