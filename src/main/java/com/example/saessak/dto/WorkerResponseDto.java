package com.example.saessak.dto;

import com.example.saessak.entity.User;
import com.example.saessak.entity.Worker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerResponseDto {
    private int workerId;
    private String certificate;
    private String area;
    private String agriculture;
    private String pay;
    private String crops;

    private String interestCrops;
    private String badge;
    private Long userId;

    public WorkerResponseDto(Worker worker) {
        this.workerId = worker.getWorkerId();
        this.certificate = worker.getCertificate();
        this.area = worker.getArea();
        this.agriculture = worker.getAgriculture();
        this.pay = worker.getPay();
        this.crops = worker.getCrops();
        this.interestCrops = worker.getInterestCrops();
        this.badge = worker.getBadge();
        this.userId = worker.getUser().getUserId();
    }
}
