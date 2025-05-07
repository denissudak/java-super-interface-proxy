package com.denissudak.superinterfaceproxy.dto;

import java.util.List;

public interface AccountingDTO3 {
    List<LineItem> getBalanceSheet();
    List<Invoice> getInvoices();
}
