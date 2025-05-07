package com.denissudak.superinterfaceproxy.dto;

import java.math.BigDecimal;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class AccountingDTOImpl implements AccountingDTO1, AccountingDTO2, AccountingDTO3 {
    @Override
    public List<LineItem> getProfitLoss() {
        LineItem li1 = new LineItem("Revenue", BigDecimal.valueOf(250000));
        LineItem li2 = new LineItem("Opex", BigDecimal.valueOf(90000));
        return newArrayList(li1, li2);
    }

    @Override
    public List<LineItem> getBalanceSheet() {
        LineItem li1 = new LineItem("Cash and Cash Equivalents", BigDecimal.valueOf(150000));
        LineItem li2 = new LineItem("Accounts Payable", BigDecimal.valueOf(45000));

        return newArrayList(li1, li2);
    }

    @Override
    public List<Invoice> getInvoices() {
        Invoice inv1 = new Invoice("inv-1", "org-1", BigDecimal.valueOf(5000));
        Invoice inv2 = new Invoice("inv-2", "org-2", BigDecimal.valueOf(7000));

        return newArrayList(inv1, inv2);
    }

}
