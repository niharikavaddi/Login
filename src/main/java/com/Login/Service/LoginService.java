package com.Login.Service;

import java.util.NoSuchElementException;

import com.Login.Model.Admin;
import com.Login.Model.Donor;
import com.Login.Model.Requestor;

public interface LoginService {

	public Admin loginAdmin(Admin admin) throws NoSuchElementException;

	public Requestor loginRequestor(Requestor requestor) throws NoSuchElementException;

	public Donor loginDonor(Donor donor) throws NoSuchElementException;

}
