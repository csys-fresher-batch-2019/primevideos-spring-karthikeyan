package com.chainsys.primevideos.method;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class PaymentDetails {
	
	private int userId;
	private String password;
	private String cardCategory;
	private String nameOnCard;
	private Long cardNo;
	private LocalDate dateOfExpire;
	
	
	
}
