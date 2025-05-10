package com.denissudak.superinterfaceproxy;

import com.denissudak.superinterfaceproxy.dto.AccountingDTO1;
import com.denissudak.superinterfaceproxy.dto.AccountingDTO2;
import com.denissudak.superinterfaceproxy.dto.AccountingDTO3;
import com.denissudak.superinterfaceproxy.dto.AccountingDTOImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final AccountingDTOImpl accountingDTO = new AccountingDTOImpl();

    private final SuperInterfaceProxyFactory<AccountingDTO1, AccountingDTOImpl> dto1InterfaceProxyFactory = new SuperInterfaceProxyFactory<>(AccountingDTO1.class);
    private final SuperInterfaceProxyFactory<AccountingDTO2, AccountingDTOImpl> dto2InterfaceProxyFactory = new SuperInterfaceProxyFactory<>(AccountingDTO2.class);
    private final SuperInterfaceProxyFactory<AccountingDTO3, AccountingDTOImpl> dto3InterfaceProxyFactory = new SuperInterfaceProxyFactory<>(AccountingDTO3.class);

    public void runUseCase1() {
        AccountingDTO1 dto = dto1InterfaceProxyFactory.newProxy(accountingDTO);
        System.out.println("===DTO1===");
        System.out.println(convertToJson(dto));
    }

    public void runUseCase2() {
        AccountingDTO2 dto = dto2InterfaceProxyFactory.newProxy(accountingDTO);
        System.out.println("===DTO2===");
        System.out.println(convertToJson(dto));
    }

    public void runUseCase3() {
        AccountingDTO3 dto = dto3InterfaceProxyFactory.newProxy(accountingDTO);
        System.out.println("===DTO3===");
        System.out.println(convertToJson(dto));
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.runUseCase1();
        main.runUseCase2();
        main.runUseCase3();
    }

    private String convertToJson(Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
