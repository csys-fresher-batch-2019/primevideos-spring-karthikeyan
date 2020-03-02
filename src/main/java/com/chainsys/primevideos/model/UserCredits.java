package com.chainsys.primevideos.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UserCredits {
	private String customerName;
	private String gender;
	private LocalDate dob;
	private int age;
	private String mailId;
	private int userId;
	private String password;
	private Long mobileNumber;
	private LocalDate createdDate;

	public String toString() {
		return "Profile Details \n customerName=" + customerName + "\n gender=" + gender + "\n dob=" + dob + "\n age=" + age
				+ "\n mailId=" + mailId + "\n userId=" + userId + "\n password=" + password + "\n mobileNumber="
				+ mobileNumber + "\n createdDate=" + createdDate ;
	}

}
