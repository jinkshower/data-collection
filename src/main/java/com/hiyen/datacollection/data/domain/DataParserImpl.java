package com.hiyen.datacollection.data.domain;

import com.hiyen.datacollection.data.service.port.DataParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DataParserImpl implements DataParser {

    private static final int HEXADECIMAL_LENGTH = 4;
    private static final int HEXADECIMAL_BASE = 16;

    @Override
    public List<Data> parse(final String serialNumber, final int interval, final String dataSet,
        final String recordedAt) {
        List<Data> datas = new ArrayList<>();

        //dataSet을 4자리 단위로 recordedAt을 기준으로 interval분씩 증가시키면서 Data 객체를 생성
        for (int i = 0; i < dataSet.length(); i += HEXADECIMAL_LENGTH) {
            String dataValue = dataSet.substring(i, i + HEXADECIMAL_LENGTH);
            int value = hexadecimalToDecimal(dataValue);
            String parsedTime = parseTime(recordedAt, interval, i);
            datas.add(new Data(serialNumber, value, parsedTime));
        }

        return datas;
    }

    private int hexadecimalToDecimal(String hexadecimal) {
        return Integer.parseInt(hexadecimal, HEXADECIMAL_BASE);
    }

    private String parseTime(final String recordedAt, final int interval, final int i) {
        int currentUnit = i / HEXADECIMAL_LENGTH + 1; //i = 0일때 1, 8일때 2, 12일때 3
        int minute = currentUnit * interval;// 30, 60, 90
        // 2013-01-01 16:00:00 -> 2013-01-01 16:30:00, 2013-01-01 17:00:00, 2013-01-01 17:30:00
        return recordedAt.substring(0, 14) + String.format("%02d", minute) + recordedAt.substring(
            16);
    }

}
