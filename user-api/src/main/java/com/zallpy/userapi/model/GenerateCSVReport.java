package com.zallpy.userapi.model;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import com.zallpy.userapi.dto.request.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.List;



public class GenerateCSVReport {
    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateCSVReport.class);

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void writeUsers(PrintWriter writer, List<UserDTO> users)  {

        try {

            ColumnPositionMappingStrategy mapStrategy
                    = new ColumnPositionMappingStrategy();

            mapStrategy.setType(UserDTO.class);


            String[] columns = new String[]{"id", "firstName", "lastName","email"};
            mapStrategy.setColumnMapping(columns);
            mapStrategy.generateHeader(columns);
            StatefulBeanToCsv btcsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(users);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void writeUser(PrintWriter writer, UserDTO user) {

        try {

            ColumnPositionMappingStrategy mapStrategy
                    = new ColumnPositionMappingStrategy();

            mapStrategy.setType(UserDTO.class);

            String[] columns = new String[]{"id", "firstName", "lastName","email"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv btcsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(user);

        } catch (CsvException ex) {

            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }
}
