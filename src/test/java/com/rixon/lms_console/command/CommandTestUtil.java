package com.rixon.lms_console.command;

import com.rixon.lms_console.command.builder.CommandBuilder;
import com.rixon.lms_console.command.validator.ValidationResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * This class provides all the util functionality while creating, validating the command objects
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class CommandTestUtil {

    @Nullable
    public static Command createCommand(String operationString, String parameters, @NotNull CommandBuilder builder) {
        String commandString = operationString + " " + parameters;
        Command command = builder.buildCommand(commandString);
        return command;
    }

    public static void assertValidationResult(@NotNull ValidationResult validationResult, boolean expectedValidity) {
        assertNotNull(validationResult);
        assertEquals("Is valid flag is not match", expectedValidity, validationResult.isValid());
        assertNotNull(validationResult.validationMessage());
        assertNotNull(validationResult.hint());
    }

    @NotNull
    public static Parameter<String> parameterWithString(@Nullable String... values) {
        List<String> texts = new ArrayList<String>();
        if (values == null) {
            return new SimpleParameter(texts);
        }
        Collections.addAll(texts, values);
        return new SimpleParameter(texts);
    }


    public static void assertCellValues(@NotNull TableModel tableModel) {

        for (int column = 0; column < tableModel.getColumnCount(); column++) {
            Object columnName = tableModel.getColumnName(column);
            assertNotNull("Column name is null at " + column, columnName);
        }

        for (int row = 0; row < tableModel.getRowCount(); row++) {
            for (int column = 0; column < tableModel.getColumnCount(); column++) {
                Object cellValue = tableModel.getValueAt(row, column);
                assertNotNull("Cell value null at row:" + row + " column:" + column, cellValue);
            }
        }
    }

}
