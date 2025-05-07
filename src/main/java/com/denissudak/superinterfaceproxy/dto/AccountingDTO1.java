package com.denissudak.superinterfaceproxy.dto;

import java.util.List;

public interface AccountingDTO1 {
    List<LineItem> getProfitLoss();
    List<LineItem> getBalanceSheet();
}
