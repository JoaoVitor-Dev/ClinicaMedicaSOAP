package org.joaovitor.modelo;

import jakarta.xml.bind.DataBindingException;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AdaptadorDate extends XmlAdapter<XMLGregorianCalendar, Date> {
    @Override
    public Date unmarshal(XMLGregorianCalendar xmlGregorianCalendar) throws Exception {
        Date date = xmlGregorianCalendar.toGregorianCalendar().getTime();
        return date;
    }

    @Override
    public XMLGregorianCalendar marshal(Date date) throws Exception {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory
                .newInstance().newXMLGregorianCalendar(calendar);
        xmlGregorianCalendar
                .setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
        xmlGregorianCalendar
                .setTimezone(DatatypeConstants.FIELD_UNDEFINED);

        return xmlGregorianCalendar;
    }
}
