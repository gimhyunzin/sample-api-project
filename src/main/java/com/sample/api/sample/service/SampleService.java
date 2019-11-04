package com.sample.api.sample.service;

import com.sample.api.sample.domain.SampleType;
import com.sample.api.sample.domain.Navigation;
import com.sample.api.sample.domain.Purchase;
import com.sample.api.sample.domain.SampleHeaders;
import com.sample.api.sample.domain.response.SampleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class SampleService {

    /**
     * 주문리스트 통합
     */
    public SampleResponse getCompositePurchase(SampleHeaders headers, Navigation navigation) {

        return null;
    }

    /**
     * New 네비게이션 생성
     */
    private Navigation createNavigation(List<Purchase> compositeList, Navigation navigation) {

        // 1) 오름차순으로 재정렬
        compositeList.sort(
                Comparator.comparing(Purchase::getPurchaseDate) // 1순위 : 구매일자 ASC
                .thenComparing(Purchase::getPurchaseNo));       // 2순위 : 구매번호 ASC

        // 2) SHIP
        long shipNo = compositeList.stream()
                .filter(i -> i.getSampleType().equals(SampleType.SHIP))
                .findFirst().orElse(new Purchase()).getPurchaseNo();

        // 3) LIVE
        long liveNo = compositeList.stream()
                .filter(i -> i.getSampleType().equals(SampleType.LIVE))
                .findFirst().orElse(new Purchase()).getPurchaseNo();

        // 4) 데이터 없으면 기존 KEY
        shipNo = shipNo > 0 ? shipNo : navigation.getShipNo();
        liveNo = liveNo > 0 ? liveNo : navigation.getLiveNo();

        navigation.setShipNo(shipNo);
        navigation.setLiveNo(liveNo);

        return navigation;
    }
}
