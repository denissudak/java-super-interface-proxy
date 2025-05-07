package com.denissudak.superinterfaceproxy.dto;

import java.util.List;

public interface AccountingDTO2 {
    List<LineItem> getProfitLoss();
    List<Invoice> getInvoices();
}
