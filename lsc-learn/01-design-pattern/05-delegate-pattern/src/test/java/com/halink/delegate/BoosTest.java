package com.halink.delegate;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class BoosTest {

    @Test
    public void test() {
        try {
            String fileName = "/Users/lsc/Desktop/工作簿1.csv";
            InputStreamReader is = new InputStreamReader(new FileInputStream(fileName), "utf-8");
            CSVParser csvParser = new CSVParserBuilder().withSeparator('\t').build();
            CSVReader reader = new CSVReaderBuilder(is).withCSVParser(csvParser).build();
            List<String[]> strings = reader.readAll();
            List<Sysmtom> sysmtoms = new ArrayList<>();
            Sysmtom sysmtom = null;
            for (String[] string : strings) {
                String conent = string[0];
                String[] split = conent.split(",");
                String sysmtomName = split[0];
                String propertyName = split[1];
                String option = split[2];
                String type = split[3];
                if (StringUtils.isNotEmpty(sysmtomName) && StringUtils.isEmpty(propertyName) && StringUtils.isEmpty(option) && StringUtils.isEmpty(type)) {
                    continue;
                } else if (StringUtils.isNotEmpty(sysmtomName) && StringUtils.isNotEmpty(propertyName) && StringUtils.isNotEmpty(option) && StringUtils.isNotEmpty(type)) {
                    sysmtom = new Sysmtom();
                    sysmtoms.add(sysmtom);
                    sysmtom.name = sysmtomName;
                    sysmtom.propertyList = new ArrayList<>();
                    Property property = new Property();
                    property.name = propertyName;
                    property.type = type;
                    property.optionList = Arrays.asList(option.split("、"));
                    sysmtom.propertyList.add(property);
                } else if (StringUtils.isEmpty(sysmtomName) && StringUtils.isNotEmpty(propertyName) && StringUtils.isNotEmpty(option) && StringUtils.isNotEmpty(type)) {
                    Property property = new Property();
                    property.name = propertyName;
                    property.type = type;
                    property.optionList = Arrays.asList(option.split("、"));
                    sysmtom.propertyList.add(property);
                }
            }
            Map<Integer, String> sysmtomMap = new HashMap<>();
            Map<Integer, Property> propertyMap = new HashMap<>();
            Map<Integer, Option> optionMap = new HashMap<>();
            int id1 = 0;
            int id2 = 0;
            for (int i = 0; i < sysmtoms.size(); i++) {
                Sysmtom sysmtom1 = sysmtoms.get(i);
                Integer sysmtomId = i + 1;
                sysmtomMap.put(sysmtomId, sysmtom1.name);

                List<Property> propertyList = sysmtom1.propertyList;
                for (int i1 = 0; i1 < propertyList.size(); i1++) {
                    Property property = propertyList.get(i1);
                    Integer propertyId = ++id1;
                    property.sysmtomId = sysmtomId;
                    propertyMap.put(propertyId, property);
                    List<String> optionList = property.optionList;
                    for (int i2 = 0; i2 < optionList.size(); i2++) {
                        String s = optionList.get(i2);
                        Option option = new Option();
                        option.name = s;
                        option.propertyId = propertyId;
                        Integer optionId = ++id2;
                        optionMap.put(optionId, option);
                    }
                }
            }

            StringBuilder sysmtomCsv = new StringBuilder();
            for (Map.Entry<Integer, String> integerStringEntry : sysmtomMap.entrySet()) {
                sysmtomCsv.append(integerStringEntry.getKey());
                sysmtomCsv.append(",");
                sysmtomCsv.append(integerStringEntry.getValue());
                sysmtomCsv.append("\n");
            }
            System.out.println(sysmtomCsv);
            System.out.println("---------------------------");

            StringBuilder propertyCsv = new StringBuilder();
            for (Map.Entry<Integer, Property> integerPropertyEntry : propertyMap.entrySet()) {
                propertyCsv.append(integerPropertyEntry.getKey());
                propertyCsv.append(",");
                Property value = integerPropertyEntry.getValue();
                propertyCsv.append(value.sysmtomId);
                propertyCsv.append(",");
                propertyCsv.append(value.name);
                propertyCsv.append(",");
                propertyCsv.append(value.type);
                propertyCsv.append("\n");
            }

            System.out.println(propertyCsv);
            System.out.println("---------------------------");
            StringBuilder optionCsv = new StringBuilder();
            for (Map.Entry<Integer, Option> integerOptionEntry : optionMap.entrySet()) {
                optionCsv.append(integerOptionEntry.getKey());
                optionCsv.append(",");
                Option value = integerOptionEntry.getValue();
                optionCsv.append(value.propertyId);
                optionCsv.append(",");
                optionCsv.append(value.name);
                optionCsv.append("\n");
            }
            System.out.println(optionCsv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Sysmtom {
        private String name;
        private List<Property> propertyList;
    }

    class Property {
        private Integer sysmtomId;
        private String name;
        private String type;
        private List<String> optionList;
    }

    class Option {
        private Integer propertyId;
        private String name;
    }
}