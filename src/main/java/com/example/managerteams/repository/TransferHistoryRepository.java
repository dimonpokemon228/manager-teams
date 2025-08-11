package com.example.managerteams.repository;

import com.example.managerteams.model.dto.TransferPlayerDto;
import com.example.managerteams.model.entity.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransferHistoryRepository extends JpaRepository<TransferHistory,Long> {
List<TransferHistory> findTransferHistoriesByPlayerId(Long playerId);
}
