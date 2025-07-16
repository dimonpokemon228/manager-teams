package com.example.managerteams.repository;

import com.example.managerteams.model.dto.TransferPlayerDto;
import com.example.managerteams.model.entity.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferHistoryRepository extends JpaRepository<TransferHistory,Long> {
List<TransferHistory> findTransferHistoriesByPlayerId(Long playerId);
}
