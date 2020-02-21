package com.chainsys.primevideos.dao;

import java.util.List;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.method.PaymentDetails;

public interface PaymentDetailsDAO {
	void addPaymentDetails(PaymentDetails payments) throws DbException;

	List<PaymentDetails> getPaymentsDetails() throws DbException;

	List<PaymentDetails> getPaymentsDetails(String cardCategoty) throws DbException;

}
