package com.vish.agriapp.dao;

import com.vish.agriapp.dto.AgriculturDTO;

public interface AgriculturDAO {
	public void store(AgriculturDTO dto);
	public AgriculturDTO retrieveById(int aid);
	public void updateRow(String newName,int aid);
	public void deleteRowById(int aid);
}
