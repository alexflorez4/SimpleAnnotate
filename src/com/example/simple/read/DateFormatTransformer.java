package com.example.simple.read;


import org.simpleframework.xml.transform.Transform;

import java.text.DateFormat;
import java.util.Date;

public class DateFormatTransformer implements Transform<Date>
{
    private DateFormat df;

    public DateFormatTransformer(DateFormat df)
    {
        this.df = df;
    }

    @Override
    public Date read(String s) throws Exception {
        return df.parse(s);
    }

    @Override
    public String write(Date date) throws Exception {
        return df.format(date);
    }
}
