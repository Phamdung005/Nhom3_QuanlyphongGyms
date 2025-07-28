/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom3_quanlyphonggyms.action;

import com.mycompany.nhom3_quanlyphonggyms.entity.Invoice;
import com.mycompany.nhom3_quanlyphonggyms.entity.InvoiceXML;

import javax.xml.bind.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerInvoices {
    private List<Invoice> invoices = new ArrayList<>();
    private static final String INVOICE_FILE = "D:/laptrinhhuongdoituong/baitapjava/Nhom3_QuanlyphongGyms/Invoices.xml";

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
        saveToFile();
        
    }

    public List<Invoice> getAllInvoices() {
        return invoices;
    }

    public List<Invoice> getInvoicesByMemberId(String memberId) {
        return invoices.stream()
                .filter(inv -> inv.getMemberId().equalsIgnoreCase(memberId))
                .toList();
    }

    public void saveToFile() {
    try {
        JAXBContext context = JAXBContext.newInstance(InvoiceXML.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        InvoiceXML wrapper = new InvoiceXML();
        wrapper.setInvoices(invoices);
        marshaller.marshal(wrapper, new File(INVOICE_FILE));
        System.out.println("Đã ghi file hóa đơn vào: " + new File(INVOICE_FILE).getAbsolutePath());
    } catch (Exception e) {
        System.out.println("Lỗi khi ghi file hóa đơn:");
        e.printStackTrace();
    }
}

    public void loadFromFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(InvoiceXML.class);
            Unmarshaller um = context.createUnmarshaller();
            InvoiceXML wrapper = (InvoiceXML) um.unmarshal(new File(INVOICE_FILE));
            this.invoices = wrapper.getInvoices();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}