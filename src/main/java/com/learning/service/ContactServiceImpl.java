package com.learning.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.ContactMasterEntity;
import com.learning.repository.ContactsMasterRepo;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ContactServiceImpl implements ContactMasterSerivce {

	@Autowired
	private ContactsMasterRepo contactsMasterRepo;

	@Override
	public String upsert(ContactMasterEntity contactMasterEntity) {
		contactsMasterRepo.save(contactMasterEntity);
		return "Success";
	}

	@Override
	public ContactMasterEntity getById(Integer contactId) {
		Optional<ContactMasterEntity> findById = contactsMasterRepo.findById(contactId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<ContactMasterEntity> getAllContact() {
		return contactsMasterRepo.findAll();
	}

	@Override
	public String delectById(Integer cid) {
		if (contactsMasterRepo.existsById(cid)) {
			contactsMasterRepo.deleteById(cid);
			return "delet success";
		} else {
			return "no record found";
		}

	}

	@Override
	public List<ContactMasterEntity> getContactByAddress(String address,Long pinCode) {
		return contactsMasterRepo.getContactByAddress(address, pinCode);
	}
	@Override
	public void generateExcel(HttpServletResponse response) throws Exception {

		List<ContactMasterEntity> contacts = contactsMasterRepo.findAll();

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("Contact info");

		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("contactId");
		row.createCell(1).setCellValue("contactName");
		row.createCell(2).setCellValue("contactNumber");
		row.createCell(3).setCellValue("address");
		int dataRowIndex = 1;

		for (ContactMasterEntity contact : contacts) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(contact.getContactId());
			dataRow.createCell(1).setCellValue(contact.getContactName());
			dataRow.createCell(2).setCellValue(contact.getContactNumber());
			dataRow.createCell(3).setCellValue(contact.getAddress());
			dataRowIndex++;

		}
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();

	}

}
