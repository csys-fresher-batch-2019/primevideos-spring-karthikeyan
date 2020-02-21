package com.chainsys.primevideos.method;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class AdminInterface {
	private String adminLoginId;
	private String adminEmpId;
	private String adminName;
	private String mailId;
	private String loginKey;
	private String password;
	private int status;
}
