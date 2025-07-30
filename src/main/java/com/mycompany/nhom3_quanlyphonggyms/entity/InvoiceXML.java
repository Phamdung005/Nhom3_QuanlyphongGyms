/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.nhom3_quanlyphonggyms.entity;

import java.util.List;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "invoices")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvoiceXML {
    @XmlElement(name = "invoice")
    private List<Invoice> invoices;

    public List<Invoice> getInvoices() { return invoices; }
    public void setInvoices(List<Invoice> invoices) { this.invoices = invoices; }
}